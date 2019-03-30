package com.lanu.the_yard.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BreakingReport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime dateTime;

    private boolean fixed;

    private String userLastName;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "breaking_report_id")
    private List<BreakingDetail> breakingDetails;
}
