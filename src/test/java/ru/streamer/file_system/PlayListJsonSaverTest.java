package ru.streamer.file_system;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ru.streamer.StreamerApplication;
import ru.streamer.file_system.impl.PlayListJsonSaver;

import java.io.IOException;
import java.nio.file.Files;
import java.util.Collections;

import static ru.streamer.constants.PathConstants.CURRENT_PATH;

@SpringBootTest(classes = StreamerApplication.class)
public class PlayListJsonSaverTest {


    private final PlayListJsonSaver playListJsonSaver;



    @Autowired
    public PlayListJsonSaverTest(PlayListJsonSaver playListJsonSaver) {
        this.playListJsonSaver = playListJsonSaver;
    }

    @Test
    void savePlayList_ShouldWriteFile(){

    }


    @BeforeEach
    void createPlayListFile() throws IOException {
        playListJsonSaver.savePlayList(Collections.emptyMap());
    }


    @AfterEach
    void afterTestCleanUp() throws IOException {
        Files.deleteIfExists(CURRENT_PATH);
    }


}
