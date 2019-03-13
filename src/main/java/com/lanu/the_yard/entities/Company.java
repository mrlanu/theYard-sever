package com.lanu.the_yard.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.lanu.the_yard.security.User;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany
    @JoinColumn(name = "company_id")
    @JsonBackReference
    private List<User> userList;
}
