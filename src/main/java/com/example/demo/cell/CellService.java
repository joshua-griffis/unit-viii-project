package com.example.demo.cell;

import com.example.demo.anomaly.Anomaly;
import com.example.demo.anomaly.AnomalyRepository;
import com.example.demo.classification.Classification;
import com.example.demo.classification.ClassificationRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.Objects;

@Service
public class CellService {
    private final CellRepository cellRepository;
    private final AnomalyRepository anomalyRepository;

    private final ClassificationRepository classificationRepository;

    public CellService(CellRepository cellRepository, AnomalyRepository anomalyRepository, ClassificationRepository classificationRepository) {
        this.cellRepository = cellRepository;
        this.anomalyRepository = anomalyRepository;
        this.classificationRepository = classificationRepository;
    }

    @Transactional
    public void updateCell(Long id, String description) {
        Cell cell = cellRepository.findById(id).orElseThrow(()-> new IllegalStateException("Cell with id " + id + "does not exist"));

        if (description != null && description.length() > 0 && !Objects.equals(cell.getCellDescription(), description)) {
            cell.setCellDescription(description);
        }
    }

    public void deleteCell(Long id) {
        boolean exists = cellRepository.existsById(id);
        if(!exists){
            throw new IllegalStateException("Cell with Id " + id + " does not exists");
        }
        cellRepository.deleteById(id);
    }

    public void addAnomalyToCell(Long cellId, Long anomalyId) {
        Cell cell = cellRepository.findById(cellId).get();
        Anomaly anomaly = anomalyRepository.findById(anomalyId).get();
        cell.getContainAnomalies().add(anomaly);
        cellRepository.save(cell);
    }



}
