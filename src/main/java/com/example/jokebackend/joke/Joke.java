package com.example.jokebackend.joke;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * Joke class which contains the details of each joke
 * including the setup, punchline and the author and date created.
 * @author Will Richter
 * @version 1.0 (27/09/2022)
 */

@Entity
@Table(name = "joke_table")
public class Joke {

    @Id
    @SequenceGenerator(name = "joke_sequence", sequenceName = "joke_sequence", allocationSize = 1)
    @GeneratedValue(generator = "joke_sequence", strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "setup", nullable = false)
    private String setup;

    @Column(name = "punchline", nullable = false)
    private String punchline;

    @Column(name = "author", nullable = false)
    private String author;

    @Column(name = "date_created", nullable = false)
    @JsonFormat(pattern = "dd/MM/yyy HH:mm")
    private LocalDateTime dateCreated;

    public Joke() {

    }

    public Joke(String setup, String punchline, String author) {
        this.setup = setup;
        this.punchline = punchline;
        this.author = author;
        this.dateCreated = LocalDateTime.now();
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

    public LocalDateTime getDateCreated() {
        return dateCreated;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "Joke{" +
                "id=" + id +
                ", setup='" + setup + '\'' +
                ", punchline='" + punchline + '\'' +
                ", author='" + author + '\'' +
                ", dateCreated=" + dateCreated +
                '}';
    }
}
