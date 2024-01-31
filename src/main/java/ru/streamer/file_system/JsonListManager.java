package ru.streamer.file_system;

import java.util.Map;

public interface JsonListManager {


    void deletePlayList();

    void savePlayList(Map<String,String> playList);

}
