package com.crud.tasks.mapper;

import com.crud.tasks.domain.*;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;


import java.util.ArrayList;
import java.util.List;


@RunWith(MockitoJUnitRunner.class)
public class TrelloMapperTestSuite {

    @InjectMocks
    TrelloMapper trelloMapper;

    @Test
    public void testEachMapper() {
        //Given
        TrelloCard trelloCard = new TrelloCard("testname", "testdescription", "testpos", "testlistId");
        TrelloCardDto trelloCardDto = new TrelloCardDto("testname", "testdescription", "testpos", "testlistId");

        TrelloList trelloList = new TrelloList("testid", "test", false);
        List<TrelloList> lists = new ArrayList<>();
        lists.add(trelloList);

        TrelloListDto trelloListDto = new TrelloListDto("testid", "test", false);
        List<TrelloListDto> Dtolists = new ArrayList<>();
        Dtolists.add(trelloListDto);

        TrelloBoard trelloBoard = new TrelloBoard("boardid", "boardname", lists);
        List<TrelloBoard> boardList = new ArrayList<>();
        boardList.add(trelloBoard);

        TrelloBoardDto trelloBoardDto = new TrelloBoardDto("boardid", "boardname", Dtolists);
        List<TrelloBoardDto> boardDtoList = new ArrayList<>();
        boardDtoList.add(trelloBoardDto);

        //When
        List<TrelloBoard> mappedBoardList = trelloMapper.mapToBoards(boardDtoList);
        List<TrelloBoardDto> mappedBoardDtoList = trelloMapper.mapToBoardsDto(boardList);
        List<TrelloList> mappedList = trelloMapper.mapToList(Dtolists);
        List<TrelloListDto> mappedDtoList = trelloMapper.mapToListDto(lists);
        TrelloCard mappedCard = trelloMapper.mapToCard(trelloCardDto);
        TrelloCardDto mappedDtoCard = trelloMapper.mapToCardDto(trelloCard);

        TrelloBoard testBoard =  boardList.get(0);
        TrelloBoard testMappedBoard = mappedBoardList.get(0);

        TrelloBoardDto testBoardDto = boardDtoList.get(0);
        TrelloBoardDto testMappedBoardDto = mappedBoardDtoList.get(0);


        TrelloList testBoardList = boardList.get(0).getLists().get(0);
        TrelloList testMappedBoardList = mappedBoardList.get(0).getLists().get(0);

        TrelloListDto testBoardDtoList = boardDtoList.get(0).getLists().get(0);
        TrelloListDto testMappedBoardDtoList = mappedBoardDtoList.get(0).getLists().get(0);

        TrelloList testList = lists.get(0);
        TrelloList testMappedList = mappedList.get(0);

        TrelloListDto testListDto = Dtolists.get(0);
        TrelloListDto testMappedListDto = mappedDtoList.get(0);


        //Then
        Assert.assertEquals(testBoard.getId(), testMappedBoard.getId());
        Assert.assertEquals(testBoardList.getId(), testMappedBoardList.getId());
        Assert.assertEquals(testBoardList.getName(), testMappedBoardList.getName());
        Assert.assertEquals(testBoardList.isClosed(), testMappedBoardList.isClosed());
        Assert.assertEquals(testBoard.getName(), testMappedBoard.getName());

        Assert.assertEquals(testBoardDto.getId(), testMappedBoardDto.getId());
        Assert.assertEquals(testBoardDtoList.getId(), testMappedBoardDtoList.getId());
        Assert.assertEquals(testBoardDtoList.getName(), testMappedBoardDtoList.getName());
        Assert.assertEquals(testBoardDtoList.isClosed(), testMappedBoardDtoList.isClosed());
        Assert.assertEquals(testBoardDto.getName(), testMappedBoardDto.getName());

        Assert.assertEquals(testList.getId(), testMappedList.getId());
        Assert.assertEquals(testList.getName(), testMappedList.getName());
        Assert.assertEquals(testList.isClosed(), testMappedList.isClosed());

        Assert.assertEquals(testListDto.getId(), testMappedListDto.getId());
        Assert.assertEquals(testListDto.getName(), testMappedListDto.getName());
        Assert.assertEquals(testListDto.isClosed(), testMappedListDto.isClosed());

        Assert.assertEquals(trelloCard.getName(), mappedCard.getName());
        Assert.assertEquals(trelloCard.getDescription(), mappedCard.getDescription());
        Assert.assertEquals(trelloCard.getListId(), mappedCard.getListId());
        Assert.assertEquals(trelloCard.getPos(), mappedCard.getPos());

        Assert.assertEquals(trelloCardDto.getName(), mappedDtoCard.getName());
        Assert.assertEquals(trelloCardDto.getDescription(), mappedDtoCard.getDescription());
        Assert.assertEquals(trelloCardDto.getListId(), mappedDtoCard.getListId());
        Assert.assertEquals(trelloCardDto.getPos(), mappedDtoCard.getPos());
    }
}
