package com.example.demo.cell;


import com.example.demo.anomaly.Anomaly;
import com.example.demo.classification.Classification;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name = "cell")
public class Cell {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "anomaly_id")
    private Long cellId;
    private String cellDescription;
    private String cellLevel;
    private String cellClassification;

    @ManyToMany
    @JoinTable(
            name = "containAnomalies",
            joinColumns = @JoinColumn(name = "cellId"),
            inverseJoinColumns = @JoinColumn(name = "anomalyId")
    )
    private Set<Anomaly> containAnomalies = new HashSet<>();

    public Cell() {
    }
    public Cell(String cellDescription, String cellLevel, String cellClassification) {
    }


    // get id
    public Long getCellId() {return cellId;}

    // get and set desc
    public String getCellDescription() {
        return cellDescription;
    }
    public void setCellDescription(String cellDescription) {
        this.cellDescription = cellDescription;
    }

    // get and set level
    public String getCellLevel() {
        return cellLevel;
    }
    public void setCellLevel(String cellLevel) {
        this.cellLevel = cellLevel;
    }

    // get and set class
    public String getCellClassification() {
        return cellClassification;
    }
    public void setCellClassification(String cellClassification) {
        this.cellClassification = cellClassification;
    }

    // get linked anomalies
    public Set<Anomaly> getContainAnomalies() {
        return this.containAnomalies;
    }



}
