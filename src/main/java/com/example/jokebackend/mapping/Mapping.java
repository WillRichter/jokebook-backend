package com.example.jokebackend.mapping;

import com.example.jokebackend.joke.Joke;
import com.example.jokebackend.joke.JokeDTO;

/**
 * Mapping class to map Joke to JokeDTO
 *
 * @author Will Richter
 * @version 1.0 (27.09.2022)
 */
public class Mapping {

    /**
     * Maps a Joke object to a JokeDTO object
     * @param joke object is taken as a parameter in the method
     * @return JokeDTO is returned
     */
    public static JokeDTO jokeToJokeDTO(Joke joke) {
        return new JokeDTO(
                joke.getId(),
                joke.getSetup(),
                joke.getPunchline(),
                joke.getAuthor(),
                joke.getDateCreated()
        );
    }
}
