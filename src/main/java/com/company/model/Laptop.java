package com.company.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Laptop {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String model;

    @Column(name = "manufacturer")
    private String brand;

    @Column
    private String processor;

    @Column
    private int rom;

    @Column(name = "secondary_market")
    private boolean secondaryMarket;

    @Column(name = "case_type")
    private String caseType;

    @Column
    private int price;

    @Column(name = "release_date")
    @DateTimeFormat(pattern = "dd.MM.yyyy")
    private LocalDate date;
}
