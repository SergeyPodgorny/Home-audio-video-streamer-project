package ru.streamer.file_system;


import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ru.streamer.StreamerApplication;
import ru.streamer.file_system.impl.PlayListPresenceCheck;


import java.io.IOException;
import java.nio.file.Files;

import static org.assertj.core.api.Assertions.assertThat;
import static ru.streamer.constants.PathConstants.CURRENT_PATH;

@SpringBootTest(classes = StreamerApplication.class)
public class PlayListPresenceTest {

    private final PlayListPresenceCheck playListChecker;

    @Autowired
    public PlayListPresenceTest(PlayListPresenceCheck playListChecker) {
        this.playListChecker = playListChecker;
    }


    @Test
    void isPlayListPresent_ShouldReturnFalseWithoutPlayList(){
        assertThat(playListChecker.isPlayListPresent()).isTrue();
    }


    @BeforeEach
    void createPlayListFile() throws IOException {
        Files.createFile(CURRENT_PATH);
    }

    @AfterEach
    void afterTestCleanUp() throws IOException {
        Files.deleteIfExists(CURRENT_PATH);
    }






}
