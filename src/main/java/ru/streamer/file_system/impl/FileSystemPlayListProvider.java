package ru.streamer.file_system.impl;

import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.streamer.file_system.PlayListCreation;
import ru.streamer.file_system.PlayListPresence;
import ru.streamer.file_system.PlayListProvider;

import java.util.Collections;
import java.util.Map;

import static ru.streamer.constants.PathConstants.CURRENT_DIRECTORY;

@Component
@Slf4j
public class FileSystemPlayListProvider implements PlayListProvider {


    private final PlayListCreation playListCreation;

    private final PlayListPresence playListPresence;

    @Autowired
    public FileSystemPlayListProvider(PlayListCreation playListCreation, PlayListPresence playListPresence) {
        this.playListCreation = playListCreation;
        this.playListPresence = playListPresence;
    }
    @PostConstruct
    @Override
    public Map<String, String> providePlayList() {
        log.info("Current file system scan start location: "+ CURRENT_DIRECTORY);
        if(playListPresence.isPlayListPresent()){
            log.info("Play list found");
            return Collections.emptyMap();
        } else {
            log.info("Play list not found. Creating a new one");
            playListCreation.createPlayList();
            return Collections.emptyMap();
        }
    }






}
