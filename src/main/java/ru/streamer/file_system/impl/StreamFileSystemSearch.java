package ru.streamer.file_system.impl;

import ru.streamer.file_system.FileSystemSearch;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamFileSystemSearch implements FileSystemSearch {


    @Override
    public Set<String> searchFiles(String dir, int depth) {
        try(Stream<Path> stream = Files.walk(Paths.get(dir), depth)){
            return stream.filter(file -> !Files.isDirectory(file))
                    .map(Path::getFileName)
                    .map(Path::toString)
                    .collect(Collectors.toSet());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
