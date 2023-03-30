package com.example.demo.anomaly;

import com.example.demo.cell.Cell;
import com.example.demo.classification.Classification;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
public class Anomaly {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "anomalyId")
    private Long anomalyId;

    // connects it to other tables (one to one)
    @JsonIgnore
    @ManyToMany(mappedBy = "containAnomalies")
    private Set<Cell> cells = new HashSet<>();

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "classid", referencedColumnName = "classificationId")
    private Classification classification;

    // columns
    private String anomalyName;
    @Column(length = 100000)
    private String anomalyDescription;


    // default constructor
    public Anomaly() {
    }

    public Anomaly(Long anomalyId, String anomalyName, String anomalyDescription) {
        this.anomalyId = anomalyId;
        this.anomalyName = anomalyName;
        this.anomalyDescription = anomalyDescription;
    }

    public Anomaly( String anomalyName, String anomalyDescription) {
        this.anomalyName = anomalyName;
        this.anomalyDescription = anomalyDescription;
    }

    // get id
    public Long getAnomalyId() {
        return anomalyId;
    }

    //get and set name
    public String getAnomalyName() {
        return anomalyName;
    }
    public void setAnomalyName(String anomalyName) {
        this.anomalyName = anomalyName;
    }

    // desc getter and setter
    public String getAnomalyDescription() {
        return anomalyDescription;
    }
    public void setAnomalyDescription(String anomalyDescription) {
        this.anomalyDescription = anomalyDescription;
    }

    // get linked cells
    public Set<Cell> getCells() {
        return cells;
    }

    public Classification getClassification() {
        return classification;
    }

    public void assignClassification(Classification classification) {
        this.classification = classification;
    }

    public void setClassification(Classification classification) {
        this.classification = classification;
    }
}
