package com.example.jokebackend.joke;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;

/**
 * Data transfer object class for Joke. Used to create and update information
 * in the database without needing multiple calls to it.
 * @author Will Richter
 * @version 1.0 (27/09/2022)
 */
public class JokeDTO {

    private Long id;
    private String setup;
    private String punchline;
    private String author;
    @JsonFormat(pattern = "dd/MM/yyy HH:mm")
    private LocalDateTime dateCreated;

    public JokeDTO() {
    }

    public JokeDTO(String setup, String punchline, String author) {
        this.setup = setup;
        this.punchline = punchline;
        this.author = author;
    }

    public JokeDTO(String setup, String punchline, String author, LocalDateTime dateCreated) {
        this.setup = setup;
        this.punchline = punchline;
        this.author = author;
        this.dateCreated = dateCreated;
    }

    public JokeDTO(Long id, String setup, String punchline, String author, LocalDateTime dateCreated) {
        this.id = id;
        this.setup = setup;
        this.punchline = punchline;
        this.author = author;
        this.dateCreated = dateCreated;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSetup() {
        return setup;
    }

    public void setSetup(String setup) {
        this.setup = setup;
    }

    public String getPunchline() {
        return punchline;
    }

    public void setPunchline(String punchline) {
        this.punchline = punchline;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public LocalDateTime getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(LocalDateTime dateCreated) {
        this.dateCreated = dateCreated;
    }

    @Override
    public String toString() {
        return "JokeDTO{" +
                "id=" + id +
                ", setup='" + setup + '\'' +
                ", punchline='" + punchline + '\'' +
                ", author='" + author + '\'' +
                ", dateCreated=" + dateCreated +
                '}';
    }
}
