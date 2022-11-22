package com.rollandgaros.tournementmanager.model;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "roles")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false)
    private Integer id;

    @Enumerated(EnumType.STRING)
    @Column(length = 20)
    private Roles name;

    @OneToMany(mappedBy = "role")
    private Collection<User> users;

    public Role() {

    }

    public Integer getId() {
        return id;
    }

    public Roles getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Role{" +
                "id=" + id +
                ", name=" + name +
                '}';
    }
}
