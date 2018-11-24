package com.crud.tasks.controller;

import com.crud.tasks.domain.TrelloBoardDto;
import com.crud.tasks.trello.client.TrelloClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1/trello")
public class TrelloController {

    @Autowired
    private TrelloClient trelloClient;

    @RequestMapping(method = RequestMethod.GET, value = "getTrelloBoards")
    public void getTrelloBoards() throws BoardNotFoundException{

        List<TrelloBoardDto> trelloBoards = trelloClient.getTrelloBoards().orElseThrow(BoardNotFoundException::new);

        trelloBoards.stream()
                .filter(n -> n.getName() != null && n.getId() != null)
                .filter(n -> n.getName().contains("Kodilla"))
                .forEach(n -> System.out.println(n.getId() + " " + n.getName()));

    }
}