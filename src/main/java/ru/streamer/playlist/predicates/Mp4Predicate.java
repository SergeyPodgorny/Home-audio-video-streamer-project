package ru.streamer.playlist.predicates;

import org.apache.commons.io.FilenameUtils;

import java.nio.file.Path;


public class Mp4Predicate {

    public static boolean test(Path path) {
        var extension = FilenameUtils.getExtension(String.valueOf(path.getFileName()));
        if(extension.equalsIgnoreCase("mp4")){
            return true;
        } else {
            return false;
        }

    }
}
