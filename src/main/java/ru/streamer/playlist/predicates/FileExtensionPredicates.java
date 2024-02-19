package ru.streamer.playlist.predicates;

import org.apache.commons.io.FilenameUtils;

import java.nio.file.Path;


public class FileExtensionPredicates {

    public static boolean mp4Test(Path path) {
        var extension = FilenameUtils.getExtension(String.valueOf(path.getFileName()));
        if(extension.equalsIgnoreCase("mp4")){
            return true;
        } else {
            return false;
        }

    }

    public static boolean mkvTest(Path path) {
        var extension = FilenameUtils.getExtension(String.valueOf(path.getFileName()));
        if(extension.equalsIgnoreCase("mkv")){
            return true;
        } else {
            return false;
        }

    }


    public static boolean aviTest(Path path) {
        var extension = FilenameUtils.getExtension(String.valueOf(path.getFileName()));
        if(extension.equalsIgnoreCase("avi")){
            return true;
        } else {
            return false;
        }

    }


}
