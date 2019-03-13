package com.lanu.the_yard.entities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Trailer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long companyId;

    private Long number;

    @Enumerated(EnumType.STRING)
    private TrailerType type;

    private enum TrailerType{
        DRY, REEFER
    }

    private String location;

    private Boolean broken;

    private Boolean available;

    private Boolean railroad;
}
