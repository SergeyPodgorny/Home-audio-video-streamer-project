package ru.streamer.file_system.impl;

import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import ru.streamer.exceptions.ReadFileSystemException;
import ru.streamer.file_system.FileSystemSearch;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;
@Component
@Slf4j
public class StreamFileSystemSearch implements FileSystemSearch {

    private final String startDirectory = System.getProperty("user.dir");

    @PostConstruct
    @Override
    public Map<String, String> searchFileRoutes() {
        log.info("Current jar dir: "+ startDirectory);
        try(Stream<Path> stream = Files.walk(Paths.get(startDirectory), Integer.MAX_VALUE)){
            return stream.filter(file -> !Files.isDirectory(file))
                    .map(Path::toFile)
                    .collect(Collectors.toMap(
                            File::getName,
                            File::getAbsolutePath,
                            (s1,s2)-> s1+","+s2));
        } catch (IOException e) {
            throw new ReadFileSystemException(e);
        }
    }
}
