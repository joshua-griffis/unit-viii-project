package com.example.demo.anomaly;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnomalyRepository extends JpaRepository<Anomaly, Long> {}
