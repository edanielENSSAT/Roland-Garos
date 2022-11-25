package com.rollandgaros.tournementmanager.model;


import org.springframework.stereotype.Component;
import javax.persistence.*;
import java.io.Serializable;

@Component
@Entity
public class TennisMatch implements Serializable{
    //id = primary key, cannot be null or updated
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false)
    private Long id;
    private Long player1;
    private Long player2;
    private String date;
    private Long winner; //id of the winning player or team
    private boolean type; //true=single, false=double
    private String score;
    private int duration;
    private String gender;





    public TennisMatch() {}


    public TennisMatch(String date, Long winner, boolean type, String score, int duration, String gender, Long player1, Long player2) {
        this.date = date;
        this.winner = winner;
        this.type = type;
        this.score = score;
        this.duration = duration;
        this.gender = gender;
        this.player1 = player1;
        this.player2 = player2;
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

    public String getGender(){
        return this.gender;
    }
    public void setGender(String gender){
        this.gender=gender;
    }

    public Long getPlayer1(){return player1;}
    public void setPlayer1(Long player1) {this.player1 = player1;}

    public Long getPlayer2(){return player2;}
    public void setPlayer2(Long player2) {this.player2 = player2;}

    @Override
    public String toString() {
        return "Match{" +
                "id=" + id +
                ", player1=" + player1 +
                ", player2=" + player2 +
                ", date='" + date + '\'' +
                ", winner=" + winner +
                ", type=" + type +
                ", score='" + score + '\'' +
                ", duration=" + duration +
                ", gender=" + gender +
                '}';
    }
}
