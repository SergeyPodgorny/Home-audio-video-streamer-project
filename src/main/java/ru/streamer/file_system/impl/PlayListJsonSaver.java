package ru.streamer.file_system.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.streamer.file_system.JsonManager;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Map;
@Component
public class PlayListJsonSaver implements JsonManager {

    private final ObjectMapper objectMapper;

    @Autowired
    public PlayListJsonSaver(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    @Override
    public void deletePlayList() {

    }

    @Override
    public void savePlayList(Map<String, String> playList) throws IOException {
        File tempFile = File.createTempFile("student", "");
        try (FileOutputStream fileOutput = new FileOutputStream(tempFile)) {
            objectMapper.writeValue(fileOutput, playList);
        }
    }
}
