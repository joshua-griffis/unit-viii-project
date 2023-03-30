package com.example.demo.cell;

import com.example.demo.anomaly.Anomaly;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
@RequestMapping("/cell")
public class CellController {
    private final CellService cellService;
    @Autowired
    CellRepository cellRepository;

    @Autowired
    public CellController(CellService cellService) {
        this.cellService = cellService;
    }

    @GetMapping
    List<Cell> getCell() {
        return cellRepository.findAll();
    }

    @GetMapping("/")
    public ModelAndView showCell() {
        ModelAndView mv = new ModelAndView("get_cells");
        List<Cell> cells = cellRepository.findAll();
        mv.addObject("cells", cells);
        return mv;
    }

    @PostMapping
    Cell createCell(@RequestBody Cell cell) {
        return cellRepository.save(cell);
    }

    // add anomaly to cell
    @PutMapping("/{cellId}/anomaly/{anomalyId}")
    public void addAnomalyToCell(
            @PathVariable Long cellId,
            @PathVariable Long anomalyId
    ) {
        cellService.addAnomalyToCell(cellId, anomalyId);
    }



    // update cell path link
    @PutMapping(path = "{id}")
    public void updateCell(
            @PathVariable(required = false) Long id,
            @RequestParam(required = false) String desc){
        cellService.updateCell(id, desc);
    }

    // delete cell path link
    @DeleteMapping(path = "{id}")
    public void deleteCell(@PathVariable("id") Long id){
        cellService.deleteCell(id);
    }
}
