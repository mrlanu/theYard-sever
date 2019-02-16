package com.lanu.the_yard.entities;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
public class Trailer {

    @Id
    private Long id;

    private Long year;
}
