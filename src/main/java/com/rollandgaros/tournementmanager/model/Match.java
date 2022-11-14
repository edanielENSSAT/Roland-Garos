package com.rollandgaros.tournementmanager.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.persistence.*;
import java.io.Serializable;

@Component
@Entity
@Table(name = "tennis_match")
public class Match implements Serializable{
    //id = primary key, cannot be null or updated
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false)
    private Long id;
    private String date;
    private Long winner; //id of the winning player or team
    private boolean type; //true=single, false=double
    private String score;
    private int duration;
    private boolean gender; //true=man, false=women





    public Match() {}


    public Match(String date, Long winner, boolean type, String score, int duration, boolean gender) {
        this.date = date;
        this.winner = winner;
        this.type = type;
        this.score = score;
        this.duration = duration;
        this.gender = gender;
    }

    public Long getId(){
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getDate(){
        return this.date;
    }
    public void setDate(String date){
        this.date=date;
    }

    public Long getWinner(){
        return this.winner;
    }
    public void setWinner(Long winner){
        this.winner=winner;
    }

    public boolean getType(){
        return this.type;
    }
    public void setType(boolean type){
        this.type=type;
    }

    public String getScore(){
        return this.score;
    }
    public void setScore(String score){
        this.score=score;
    }

    public int getDuration(){
        return this.duration;
    }
    public void setDuration(int duration){
        this.duration=duration;
    }

    public boolean getGender(){
        return this.gender;
    }
    public void setGender(boolean gender){
        this.gender=gender;
    }

    @Override
    public String toString() {
        return "Match{" +
                "id=" + id +
                ", date='" + date + '\'' +
                ", winner=" + winner +
                ", type=" + type +
                ", score='" + score + '\'' +
                ", duration=" + duration +
                ", gender=" + gender +
                '}';
    }
}
