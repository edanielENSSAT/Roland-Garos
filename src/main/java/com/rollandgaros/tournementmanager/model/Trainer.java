package com.rollandgaros.tournementmanager.model;

import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.io.Serializable;

@Component
@Entity
public class Trainer  implements Serializable{
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
    private boolean wasPlayer;
    @Column(updatable = false)
    private Long playerID;
    private Long trainee;

    public Trainer() {}


    public Trainer(String name, String firstname, String gender, String birthdate, String birthplace, String nationality, boolean wasPlayer, Long playerID,Long trainee) {
        this.name = name;
        this.firstname = firstname;
        this.gender = gender;
        this.birthdate = birthdate;
        this.birthplace = birthplace;
        this.nationality = nationality;
        this.wasPlayer=wasPlayer;
        this.playerID=playerID;
        this.trainee=trainee;
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

    public void setNationality(boolean wasPlayer) {
        this.wasPlayer = wasPlayer;
    }
    public boolean getWasPlayer() {
        return wasPlayer;
    }

    public long getPlayerID() {
        return playerID;
    }
    public void setPlayerID(Long playerID) {
        this.playerID = playerID;
    }

    public Long getTrainee(){
        return trainee;
    }
    public void setTrainee(Long trainee) {
        this.trainee = trainee;
    }

    @Override
    public String toString() {
        return "Trainer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", firstname='" + firstname + '\'' +
                ", gender='" + gender + '\'' +
                ", birthdate='" + birthdate + '\'' +
                ", birthplace='" + birthplace + '\'' +
                ", nationality='" + nationality + '\'' +
                ", wasPlayer=" + wasPlayer +
                ", playerID=" + playerID +
                ", trainee=" + trainee +
                '}';
    }
}
