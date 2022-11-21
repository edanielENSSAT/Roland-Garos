package com.rollandgaros.tournementmanager.model;

import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.io.Serializable;

@Component
@Entity
@Table(name = "tennis_entrainement")
public class Entrainement implements Serializable {
    //id = primary key, cannot be null or updated
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false)
    private Long id;
    private String date;
    private String heureDebut;
    private String nameCourt;
    private int duration;

    public Entrainement( String date, String heureDebut, String nameCourt, int duration) {

        this.date = date;
        this.heureDebut = heureDebut;
        this.nameCourt = nameCourt;
        this.duration = duration;
    }

    public Entrainement() {}



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

    public String getHeureDebut() {
        return heureDebut;
    }

    public void setHeureDebut(String heureDebut) {
        this.heureDebut = heureDebut;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }
    @Override
    public String toString() {
        return "Entrainement{" +
                "id=" + id +
                ", date='" + date + '\'' +
                ", heureDebut='" +  heureDebut + '\'' +
                ", nameCourt=" + nameCourt +
                ", duration=" + duration +
                '}';
    }
}
