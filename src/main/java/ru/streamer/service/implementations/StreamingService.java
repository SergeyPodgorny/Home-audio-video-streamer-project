package ru.streamer.service.implementations;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;
import ru.streamer.playlist.PlayListInitialization;
import ru.streamer.service.VideoProvider;

@Service
@Slf4j
public class StreamingService implements VideoProvider {

    private final PlayListInitialization playList;
    private final ResourceLoader resourceLoader;
    private final static String routeFormat ="file:/%s";


    @Autowired
    public StreamingService(PlayListInitialization playList, ResourceLoader resourceLoader) {
        this.playList = playList;
        this.resourceLoader = resourceLoader;
    }


    public Mono<Resource> getVideo(String title){
        var currentRoute = String.format(routeFormat,playList.getPlayList().get(title));
        return Mono.fromSupplier(()-> resourceLoader.getResource(currentRoute));
    }

}
