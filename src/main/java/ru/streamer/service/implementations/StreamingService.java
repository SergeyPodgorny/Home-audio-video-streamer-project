package ru.streamer.service.implementations;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;
import ru.streamer.service.VideoProvider;

@Service
public class StreamingService implements VideoProvider {

    private static final String FORMAT="classpath:videos/%s.mp4";

    private final ResourceLoader resourceLoader;

    @Autowired
    public StreamingService(ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;
    }


    public Mono<Resource> getVideo(String title){
        return Mono.fromSupplier(()-> resourceLoader.getResource(String.format(FORMAT,title)));
    }


}
