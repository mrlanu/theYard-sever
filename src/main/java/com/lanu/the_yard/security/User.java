package com.lanu.the_yard.security;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.lanu.the_yard.entities.Company;
import com.lanu.the_yard.entities.Trailer;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "users")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class User{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    @ManyToOne
    @JoinColumn(name = "company_id")
    private Company company;

    private String username;

    private String firstName;

    private String lastName;

    @Enumerated(EnumType.STRING)
    private Occupation occupation;

    private enum Occupation{
        DISPATCH, DRIVER, ACCOUNTER, MECHANIC, BOSS
    }

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;

    private boolean active;

    @ManyToMany(fetch = FetchType.EAGER)
    private List<Role> roles;

    @OneToOne
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Trailer trailer;
}
