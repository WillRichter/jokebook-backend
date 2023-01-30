package com.example.jokebackend.joke;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repository interface for the Joke class to retrieve and update information
 * in the database.
 * @author Will Richter
 * @version 1.0 (27/09/2022)
 */
public interface JokeRepository extends JpaRepository<Joke, Long> {
}
