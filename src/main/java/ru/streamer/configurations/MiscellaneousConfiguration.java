package ru.streamer.configurations;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MiscellaneousConfiguration {


    @Bean
    public ObjectMapper objectMapper(){
        return new ObjectMapper();
    }


}
