package ru.streamer.file_system.impl;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;
import ru.streamer.file_system.FileSystemSearch;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;
@Component
public class StreamFileSystemSearch implements FileSystemSearch {

    private final String dir = System.getProperty("user.dir");

    @PostConstruct
    @Override
    public Set<String> searchFiles() {
        final int depth = 1;
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
