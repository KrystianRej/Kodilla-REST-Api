package com.crud.tasks.domain;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TrelloBadgesTestSuite {

    @Test
    public void testBadgesElements () {
        //Given
        Trello trello = new  Trello(5,6);
        AttachmentByType attachmentByType = new AttachmentByType(trello);
        TrelloBadges trelloBadges = new TrelloBadges(1, attachmentByType);
        //When
        //Then
        assertEquals(1, trelloBadges.getVotes());
        assertEquals(attachmentByType, trelloBadges.getAttachmentsByType());
        assertEquals(trello, attachmentByType.getTrello());
        assertEquals(5, trello.getBoard());
        assertEquals(6, trello.getCard());
    }
}
