package com.example.demo.anomaly;

import com.example.demo.classification.Classification;
import com.example.demo.classification.ClassificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;

@Service
public class AnomalyService {

    // link to repo
    private final AnomalyRepository anomalyRepository;
    private final ClassificationRepository classificationRepository;
    @Autowired
    public AnomalyService(AnomalyRepository anomalyRepository, ClassificationRepository classificationRepository){
        this.anomalyRepository = anomalyRepository;
        this.classificationRepository = classificationRepository;
    }

    // update anomaly
    @Transactional
    public void updateAnomaly(Long id, String name, String description){
        Anomaly anomaly = anomalyRepository.findById(id).orElseThrow(()-> new IllegalStateException("Anomaly with id " + id + " does not exist"));

        if (name != null && name.length() > 0 && !Objects.equals(anomaly.getAnomalyName(), name)){
            anomaly.setAnomalyName(name);
        }
        if (description != null && description.length() > 0 && !Objects.equals(anomaly.getAnomalyDescription(), description)){
            anomaly.setAnomalyDescription(description);
        }
    }
    // delete anomaly
    public void deleteAnomaly(Long id) {
        boolean exists = anomalyRepository.existsById(id);
        if(!exists){
            throw new IllegalStateException("Anomaly with Id " + id + " does not exists");
        }
        anomalyRepository.deleteById(id);
    }

    public void addAnomalyToClassification(Long anomalyId, Long classificationId) {
        Anomaly anomaly = anomalyRepository.findById(anomalyId).get();
        Classification classification = classificationRepository.findById(classificationId).get();
        anomaly.assignClassification(classification);
        anomalyRepository.save(anomaly);
    }
}
