package ru.streamer.dto;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Getter
@Setter
@NoArgsConstructor
public class PlayListDTO {




    private List<String> fileNames;

    private List<String> fileRoutes;


    public PlayListDTO(Map<String,String> playList) {

        fileNames = new ArrayList<>(playList.keySet());

        fileRoutes = new ArrayList<>(playList.values());
    }

}
