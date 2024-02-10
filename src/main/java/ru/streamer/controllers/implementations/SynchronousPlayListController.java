package ru.streamer.controllers.implementations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.streamer.controllers.PlayListProvider;
import ru.streamer.dto.PlayListDTO;
import ru.streamer.playlist.PlayListInitialization;


@RestController
public class SynchronousPlayListController implements PlayListProvider {


    private final PlayListInitialization service;

    @Autowired
    public SynchronousPlayListController(PlayListInitialization service) {
        this.service = service;
    }


    @GetMapping(value= "/playlist", produces="application/json")
    @Override
    public PlayListDTO getPlayList() {
        return new PlayListDTO(service.getPlayList());
    }
}
