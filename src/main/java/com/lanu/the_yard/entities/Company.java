package com.lanu.the_yard.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.lanu.the_yard.security.User;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
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
