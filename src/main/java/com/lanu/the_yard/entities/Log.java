package com.lanu.the_yard.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Log {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime date;

    private String location;

    @Enumerated(EnumType.STRING)
    private LogAction logAction;

    public enum LogAction{
        PICKUP, DROP, BREAKING, FIXED
    }

    private Long trailerId;

    private String userLastName;
}
