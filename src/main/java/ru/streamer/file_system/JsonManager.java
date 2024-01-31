package ru.streamer.file_system;

import java.io.IOException;
import java.util.Map;

public interface JsonManager {


    void deletePlayList();

    void savePlayList(Map<String,String> playList) throws IOException;

}
