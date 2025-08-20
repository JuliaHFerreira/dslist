package com.devjulia.dslist.services;

import com.devjulia.dslist.dto.GameMinDTO;
import com.devjulia.dslist.entities.Game;
import com.devjulia.dslist.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameService {

    @Autowired //injetando
    private GameRepository gameRepository;

    public List<GameMinDTO> findAll() {
        List<Game> result = gameRepository.findAll();
        // List<GameMinDTO> dto = result.stream().map(x -> new GameMinDTO(x)).toList(); -> pode ser feito assim
        return result.stream().map(x -> new GameMinDTO(x)).toList();
    }
}
