package com.crud.tasks.validator;

import com.crud.tasks.domain.TrelloBoard;
import com.crud.tasks.domain.TrelloCard;
import com.crud.tasks.trello.validator.TrelloValidator;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.verify;


@RunWith(MockitoJUnitRunner.class)
public class ValidatorTestSuite {

    @InjectMocks
    @Spy
    private TrelloValidator trelloValidator;

    @Test
    public void shouldValidateVard() {
        //Given
        TrelloCard trelloCard = new TrelloCard("name", "des", "pos", "listId");
        //When
        trelloValidator.validateCard(trelloCard);
        //Then
        verify(trelloValidator).validateCard(trelloCard);
    }

    @Test
    public void shouldValidateTrelloBoards() {
        //Given
        TrelloBoard trelloBoard = new TrelloBoard("id", "name", new ArrayList<>());
        List<TrelloBoard> lists = new ArrayList<>();
        lists.add(trelloBoard);
        //When
        List<TrelloBoard> validatedTrelloBoards = trelloValidator.validateTrelloBoards(lists);
        //Then
        assertNotNull(validatedTrelloBoards);
        assertEquals(1, validatedTrelloBoards.size());
        verify(trelloValidator).validateTrelloBoards(lists);
    }



}
