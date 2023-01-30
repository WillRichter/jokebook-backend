package com.example.jokebackend.joke;

import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Rest Controller for Joke class
 * @author Will Richter
 * @version 1.0 (27/09/2022)
 */

@CrossOrigin(origins={"https://relaxed-cajeta-06d116.netlify.app", "https://www.jokebook.uk/", "http://localhost:3000/"})
@RestController
@RequestMapping(path = "/api/v1/jokes")
public class JokeController {

    private final JokeService jokeService;

    public JokeController(JokeService jokeService) {
        this.jokeService = jokeService;
    }

    /**
     * Get mapping to retrieve all jokes from the database via the service layer
     * @return list of all Jokes as data transfer objects
     */
    @GetMapping
    public List<JokeDTO> getAllJokes() {
        return jokeService.getAllJokes();
    }

    /**
     * Takes in request from the user and creates and saves a new joke to the database
     * and returns it as JSON to the frontend.
     * @param jokeDTO jokeDTO object passed in by the user.
     * @return Returns the joke which was saved into the database
     */
    @PostMapping
    public JokeDTO createJoke(@RequestBody JokeDTO jokeDTO) {
        System.out.println(jokeDTO);
        return jokeService.createJoke(jokeDTO);
    }

    /**
     * Searches database for joke using the provided id and returns as DTO.
     * @param jokeID JokeID provided by user
     * @return Returns Joke object from the database using provided id.
     */
    @GetMapping(path = "/{jokeID}")
    public JokeDTO getJokeById(@PathVariable Long jokeID) {
        return jokeService.getJokeById(jokeID);
    }

    /**
     * Deletes a joke from the database by using the id provided by the user
     * @param jokeID JokeID provided by the user
     */
    @DeleteMapping(path = "/{jokeID}")
    public void deleteJoke(@PathVariable Long jokeID) {
        jokeService.deleteJoke(jokeID);
    }


}
