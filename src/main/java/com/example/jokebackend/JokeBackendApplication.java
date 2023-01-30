package com.example.jokebackend;

import com.example.jokebackend.joke.JokeDTO;
import com.example.jokebackend.joke.JokeService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@SpringBootApplication
public class JokeBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(JokeBackendApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(JokeService jokeService) {
        return args -> {
            JokeDTO joke1 = new JokeDTO("How many programmers does it take to change a light bulb?",
                    "None, it's a hardware problem.",
                    "Will",
                    LocalDateTime.now());

            JokeDTO joke2 = new JokeDTO("There are only 10 kinds of people in this world.",
                    "Those who know binary and those who don't.",
                    "Samantha",
                    LocalDateTime.now());

            JokeDTO joke3 = new JokeDTO("Where is a Programmer's favourite hangout place?",
                    "Foo Bar",
                    "Dottie",
                    LocalDateTime.now());

            JokeDTO joke4 = new JokeDTO("What do you call a Russian that enjoys programming?",
                    "Computin",
                    "Jane",
                    LocalDateTime.now());

            List<JokeDTO> jokes = List.of(joke1, joke2, joke3, joke4);

            Collection<JokeDTO> collection = jokes.stream().map(jokeService::createJoke).collect(Collectors.toList());
            System.out.println(collection);
        };
    }

}
