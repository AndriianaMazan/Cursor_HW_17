package com.company.model;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.time.LocalDate;

@Component
@Entity
@Table
@Data
public class Laptop {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "laptop_id")
    private Integer id;

    @Column
    private String model;

    @Column(name = "manufacturer")
    private String brand;

    @Column
    private String processor;

    @Column
    private int ram;

    @Column(name = "secondary_market")
    private boolean secondaryMarket;

    @Column(name = "case_type")
    private String caseType;

    @Column
    private float price;

    @Column(name = "release_date")
    @DateTimeFormat(pattern = "dd.MM.yyyy")
    private LocalDate date;
}
