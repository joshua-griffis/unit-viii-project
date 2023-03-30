package com.example.demo.anomaly;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Controller
@RequestMapping("/anomaly")
public class AnomalyController {
    private final AnomalyService anomalyService;

    @Autowired
    AnomalyRepository anomalyRepository;
    @Autowired
    public AnomalyController(AnomalyService anomalyService) {
        this.anomalyService = anomalyService;
    }

    // get and post anomaly
    @GetMapping("/")
    public ModelAndView showAnomalies() {
        ModelAndView mv = new ModelAndView("get_anomalies");
        List<Anomaly> anomalies = anomalyRepository.findAll();
        mv.addObject("anomalies", anomalies);
        return mv;
    }
//    gets single
    @GetMapping("/{id}")
    public ModelAndView showOne(@PathVariable Long id) {
        ModelAndView mv = new ModelAndView("get_anomalies");
        List<Anomaly> anomalies = anomalyRepository.findAllById(Collections.singleton(id));
        mv.addObject("anomalies", anomalies);
        return mv;
    }

    @PostMapping
    Anomaly createAnomaly(@RequestBody Anomaly anomaly) {
        return anomalyRepository.save(anomaly);
    }

    // update anomaly path link
    @PutMapping(path = "{id}")
    public void updateAnomaly(
            @PathVariable(required = false) Long id,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String description){
        anomalyService.updateAnomaly(id, name, description);
    }


    // delete anomaly path link
    @DeleteMapping(path = "{id}")
    public void deleteAnomaly(@PathVariable("id") Long id){
        anomalyService.deleteAnomaly(id);
    }
}
