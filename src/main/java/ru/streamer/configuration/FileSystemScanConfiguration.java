package ru.streamer.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResourceLoader;

@Configuration
public class FileSystemScanConfiguration {


    @Bean
    public FileSystemResourceLoader fileSystemResourceLoader(){
        return new FileSystemResourceLoader();
    }

}
