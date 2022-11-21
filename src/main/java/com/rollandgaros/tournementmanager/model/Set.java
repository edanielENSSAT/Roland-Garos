package com.rollandgaros.tournementmanager.model;

import org.springframework.stereotype.Component;
import javax.persistence.*;
import java.io.Serializable;

@Component
@Entity
@Table(name = "tennis_set")
public class Set implements Serializable{
    //id = primary key, cannot be null or updated
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false)
    private Long id;
    private Long winner; //id of the winning player or team
    private String score;
    private int duration;
    @Column(updatable = false)
    private Long matchId;

    public Set(){}

    public Set(Long winner, String score, int duration,Long matchId){
        this.duration = duration;
        this.score = score;
        this.winner = winner;
        this.matchId = matchId;
    }

    public Long getId(){
        return id;
    }

    public Long getWinner(){
        return winner;
    }

    public void setWinner(Long winner){
        this.winner=winner;
    }

    public String getScore(){
        return score;
    }

    public void setScore(String score){
        this.score=score;
    }

    public int getDuration(){
        return duration;
    }

    public void setDuration(int duration){
        this.duration=duration;
    }

    public Long getMatchId(){
        return matchId;
    }

    public void setMatchId(Long matchId){
        this.matchId=matchId;
    }

    @Override
    public String toString() {
        return "Set{" +
                "id=" + id +
                ", winner=" + winner +
                ", score='" + score + '\'' +
                ", duration=" + duration +
                ", matchId=" + matchId +
                '}';
    }
}
