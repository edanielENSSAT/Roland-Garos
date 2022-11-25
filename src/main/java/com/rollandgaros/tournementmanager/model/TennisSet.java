package com.rollandgaros.tournementmanager.model;

import org.springframework.stereotype.Component;
import javax.persistence.*;
import java.io.Serializable;

@Component
@Entity
public class TennisSet implements Serializable{
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
    private String gender;

    public TennisSet(){}

    public TennisSet(Long winner, String score, int duration, Long matchId, String gender){
        this.duration = duration;
        this.score = score;
        this.winner = winner;
        this.matchId = matchId;
        this.gender = gender;
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

    public String getGender(){
        return gender;
    }

    public void setGender(String gender){
        this.gender=gender;
    }

    @Override
    public String toString() {
        return "Set{" +
                "id=" + id +
                ", winner=" + winner +
                ", score='" + score + '\'' +
                ", duration=" + duration +
                ", matchId=" + matchId +
                ", gender='" + gender + '\'' +
                '}';
    }

}
