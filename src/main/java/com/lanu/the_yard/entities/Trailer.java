package com.lanu.the_yard.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.lanu.the_yard.security.User;
import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Trailer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long companyId;

    private String number;

    @Enumerated(EnumType.STRING)
    private TrailerType type;

    private enum TrailerType{
        DRY, REF
    }

    private String location;

    private Boolean broken;

    private Boolean available;

    private Boolean railroad;

    @OneToOne
   // @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private User user;
}
