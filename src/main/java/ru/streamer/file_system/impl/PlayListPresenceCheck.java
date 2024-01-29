package ru.streamer.file_system.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import ru.streamer.file_system.PlayListPresence;
import java.nio.file.Files;
import java.nio.file.Path;


import static ru.streamer.constants.PathConstants.CURRENT_DIRECTORY;
import static ru.streamer.constants.PathConstants.CURRENT_PATH;

@Component
@Slf4j
public class PlayListPresenceCheck implements PlayListPresence {

    @Override
    public boolean isPlayListPresent() {
        if(Files.exists(CURRENT_PATH)){
            log.info("Play list found");
            return true;
        } else {
            log.info("Play list not found");
            return false;
        }
    }
}
