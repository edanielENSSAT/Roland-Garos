package com.rollandgaros.tournementmanager.model;

import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.io.Serializable;

@Component
@Entity
@Table(name = "tennis_player")
public class Player implements Serializable{
    //id = primary key, cannot be null or updated
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false)
    private Long id;
    private String name;
    private String firstname;
    private String gender;
    private String birthdate;
    private String birthplace;
    private String nationality;
    private String domHand;
    private String beginningCareer;
    private int playTime;
    private int height;
    private int weight;
    private int wonMatches;
    private int lostMatches;
    private int currentRank;
    private int bestRank;


    public Player() {}


    public Player(String name, String firstname, String gender, String birthdate, String birthplace, String nationality, int playTime, int height,int weight, int wonMatches, int lostMatches, String domHand, String beginningCareer, int rank, int bestRank) {
        this.name = name;
        this.firstname = firstname;
        this.gender = gender;
        this.birthdate = birthdate;
        this.birthplace = birthplace;
        this.nationality = nationality;
        this.playTime = playTime;
        this.height = height;
        this.weight = weight;
        this.wonMatches = wonMatches;
        this.lostMatches=lostMatches;
        this.domHand=domHand;
        this.beginningCareer=beginningCareer;
        this.currentRank=rank;
        this.bestRank=bestRank;
    }

    public Long getId(){
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getName(){
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getFirstname(){
        return firstname;
    }
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getGender(){
        return gender;
    }
    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getBirthdate(){
        return birthdate;
    }
    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }

    public void setBirthplace(String birthplace) {
        this.birthplace = birthplace;
    }
    public String getBirthplace(){
        return birthplace;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }
    public String getNationality() {
        return nationality;
    }


    public void setPlayTime(int playTime) {
        this.playTime = playTime;
    }
    public int getPlayTime() {
        return playTime;
    }

    public void setHeight(int height) {
        this.height = height;
    }
    public int getHeight() {
        return height;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }
    public int getWeight() {
        return weight;
    }

    public void setWonMatches(int wonMatches) {
        this.wonMatches = wonMatches;
    }
    public int getWonMatches() {
        return wonMatches;
    }

    public void setLostMatches(int lostMatches) {
        this.lostMatches = lostMatches;
    }
    public int getLostMatches() {
        return lostMatches;
    }

    public void setDomHand(String domHand) {
        this.domHand = domHand;
    }
    public String getDomHand() {
        return domHand;
    }

    public void setBeginningCareer(String beginningCareer) {
        this.beginningCareer = beginningCareer;
    }
    public String getBeginningCareer() {
        return beginningCareer;
    }

    public void setRank(int rank) {
        this.currentRank = rank;
    }
    public int getRank() {
        return currentRank;
    }

    public void setBestRank(int bestRank) {
        this.bestRank = bestRank;
    }
    public int getBestRank() {
        return bestRank;
    }

    @Override
    public String toString() {
        return "Player{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", firstname='" + firstname + '\'' +
                ", gender='" + gender + '\'' +
                ", birthdate='" + birthdate + '\'' +
                ", birthplace='" + birthplace + '\'' +
                ", nationality='" + nationality + '\'' +
                ", playTime=" + playTime +
                ", height=" + height +
                ", weight=" + weight +
                ", wonMatches=" + wonMatches +
                ", lostMatches=" + lostMatches +
                ", domHand='" + domHand + '\'' +
                ", beginningCareer='" + beginningCareer + '\'' +
                ", rank=" + currentRank +
                ", bestRank=" + bestRank +
                '}';
    }
}
