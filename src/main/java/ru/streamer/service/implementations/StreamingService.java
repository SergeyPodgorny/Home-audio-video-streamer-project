package ru.streamer.service.implementations;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;
import ru.streamer.playlist.PlayListInitialization;
import ru.streamer.service.VideoProvider;

@Service
@Slf4j
public class StreamingService implements VideoProvider {

//    private final PlayListInitialization playList;
//    private final FileSystemResourceLoader resourceLoader;
//
//    @Autowired
//    public StreamingService(PlayListInitialization playList, FileSystemResourceLoader resourceLoader) {
//        this.playList = playList;
//        this.resourceLoader = resourceLoader;
//    }
//
//
//    public Mono<Resource> getVideo(String title){
//        log.info(title);
//        log.info(playList.getPlayList().get(title));
//        return Mono.fromSupplier(()-> resourceLoader.getResource(playList.getPlayList().get(title)));
//    }


    private static final String FORMAT="classpath:video/%s";
    @Autowired
    private FileSystemResourceLoader resourceLoader;
//    @Autowired
//    private ResourceLoader resourceLoader;


    public Mono<Resource> getVideo(String title){
        log.info(title);
        return Mono.fromSupplier(()->resourceLoader.getResource(String.format(FORMAT,title)));
    }


}
