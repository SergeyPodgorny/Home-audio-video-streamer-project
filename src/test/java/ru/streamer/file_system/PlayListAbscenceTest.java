package ru.streamer.file_system;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ru.streamer.StreamerApplication;
import ru.streamer.file_system.impl.PlayListPresenceCheck;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(classes = StreamerApplication.class)
public class PlayListAbscenceTest {


    PlayListPresenceCheck playListChecker;

    @Autowired
    public PlayListAbscenceTest(PlayListPresenceCheck playListChecker) {
        this.playListChecker = playListChecker;
    }


    @Test
    void isPlayListPresent_ShouldReturnFalseWithoutPlayList(){
        assertThat(playListChecker.isPlayListPresent()).isFalse();
    }

}
