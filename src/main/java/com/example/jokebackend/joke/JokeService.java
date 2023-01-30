package com.example.jokebackend.joke;

import com.example.jokebackend.mapping.Mapping;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Service class for Joke class. Contains business logic.
 * @author Will Richter
 * @version 1.0 (27/09/2022)
 */

@Service
public class JokeService {

    private final JokeRepository jokeRepository;

    public JokeService(JokeRepository jokeRepository) {
        this.jokeRepository = jokeRepository;
    }

    /**
     * Retrieves all jokes from the database and maps them to JokeDTOs.
     * @return list of all Jokes as data transfer objects
     */
    public List<JokeDTO> getAllJokes() {
        return jokeRepository.findAll().stream().map(Mapping::jokeToJokeDTO).collect(Collectors.toList());
    }

    /**
     * Creates a new Joke object from the passed in jokeDTO, saves it to the database and then
     * returns it back to the REST Controller.
     * @param jokeDTO jokeDTO object which was supplied by the user.
     * @return Returns the joke after being added to the database.
     */
    public JokeDTO createJoke(JokeDTO jokeDTO) {
        if(jokeDTO.getSetup() != null && jokeDTO.getPunchline() != null && jokeDTO.getAuthor() != null) {
            Joke joke = new Joke(jokeDTO.getSetup(), jokeDTO.getPunchline(), jokeDTO.getAuthor());
            return Mapping.jokeToJokeDTO(jokeRepository.save(joke));
        } else {
            throw new IllegalStateException("joke must not have any empty fields");
        }
    }

    /**
     * Searches database for joke using the provided id and returns as DTO.
     * @param jokeID JokeID provided by user
     * @return Returns JokeDTO object from the database using provided id.
     */
    public JokeDTO getJokeById(Long jokeID) {
        return Mapping.jokeToJokeDTO(jokeRepository.findById(jokeID).orElseThrow(()-> new IllegalStateException("Joke with id " + jokeID + " does not exist")));
    }

    /**
     * Deletes a joke from the database by using the id provided by the user
     * @param jokeID JokeID provided by the user
     */
    public void deleteJoke(Long jokeID) {
        Joke joke = jokeRepository.findById(jokeID).orElseThrow(() -> new IllegalStateException("Joke with id " + jokeID + " does not exist"));
        jokeRepository.delete(joke);
    }


}
