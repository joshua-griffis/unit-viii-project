package com.example.demo.classification;

import com.example.demo.anomaly.Anomaly;
import com.example.demo.cell.Cell;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;


@Entity
public class Classification {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long classificationId;

    @JsonIgnore
    @OneToMany(mappedBy = "classification")
    private Set<Anomaly> assignAnomaly = new HashSet<>();

    private String classificationName;

    public Classification() {
    }

    public Classification(Long classificationId, String classificationName) {
        this.classificationId = classificationId;
        this.classificationName = classificationName;
    }

    public Classification(String classificationName) {
        this.classificationName = classificationName;
    }

    public Long getClassificationId() {return classificationId;}

    //get and set name
    public String getClassificationName() {
        return classificationName;
    }
    public void setClassificationName(String name) {
        this.classificationName = name;
    }



    // get linked class
    public String getCellClass() {
        return this.classificationName;
    }


}
