package ru.streamer.file_system;

import java.util.Set;

public interface FileSystemSearch {

    Set<String> searchFiles(String dir, int depth);


}
