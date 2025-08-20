package com.devjulia.dslist.services;

import com.devjulia.dslist.dto.GameDTO;
import com.devjulia.dslist.dto.GameMinDTO;
import com.devjulia.dslist.entities.Game;
import com.devjulia.dslist.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GameService {

    @Autowired //injetando
    private GameRepository gameRepository;

    @Transactional (readOnly = true) //Fica transacional ACID -> Ele garante que o dado chegue inteiro na base | (ReadOnly = true) diz que a operação vai ser apenas leitura fazendo ser mais rapido
    public GameDTO findById(Long id){
        Game result = gameRepository.findById(id).get();
        //fazer tratamento de exceções
        return new GameDTO(result);
    }
    @Transactional (readOnly = true)
    public List<GameMinDTO> findAll() {
        List<Game> result = gameRepository.findAll();
        // List<GameMinDTO> dto = result.stream().map(x -> new GameMinDTO(x)).toList(); -> pode ser feito assim
        return result.stream().map(x -> new GameMinDTO(x)).toList();
    }
}
