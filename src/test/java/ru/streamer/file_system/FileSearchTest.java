package ru.streamer.file_system;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ru.streamer.StreamerApplication;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(classes = StreamerApplication.class)
@Slf4j
public class FileSearchTest {


    PlayList searcher;

    @Autowired
    public FileSearchTest(PlayList searcher) {
        this.searcher = searcher;
    }

    @Test
    void searchFiles_shouldNotReturnNull() {
        searcher.createPlayList().entrySet().stream().forEach(System.out::println);
        assertThat(searcher.createPlayList()).isNotNull();
    }


}
