package com.rollandgaros.tournementmanager.model;

import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.io.Serializable;

@Component
@Entity
public class Training implements Serializable {
    //id = primary key, cannot be null or updated
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false)
    private Long id;
    private String date;
    private String startingHour;
    private String nameCourt;
    private int duration;
    private Long player;

    public Training(String date, String startingHour, String nameCourt, int duration, Long player) {

        this.date = date;
        this.startingHour = startingHour;
        this.nameCourt = nameCourt;
        this.duration = duration;
        this.player = player;
    }

    public Training() {}



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getnameCourt() {
        return nameCourt;
    }

    public void setnameCourt(String nameCourt) {
        this.nameCourt = nameCourt;
    }

    public int getDuration() {
        return duration;
    }

    public String getStartingHour() {
        return startingHour;
    }

    public void setStartingHour(String startingHour) {
        this.startingHour = startingHour;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public Long getPlayer() {
        return player;
    }

    public void setgetPlayer(Long player) {
        this.player = player;
    }

    @Override
    public String toString() {
        return "Training{" +
                "id=" + id +
                ", date='" + date + '\'' +
                ", startingHour='" + startingHour + '\'' +
                ", nameCourt='" + nameCourt + '\'' +
                ", duration=" + duration +
                ", player=" + player +
                '}';
    }
}