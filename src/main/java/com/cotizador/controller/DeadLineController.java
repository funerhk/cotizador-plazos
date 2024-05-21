package com.cotizador.controller;

import com.cotizador.entity.dto.DeadLineDto;
import com.cotizador.service.interfaces.DeadLineService;
import com.cotizador.utils.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/deadline")
public class DeadLineController {
    @Autowired
    private DeadLineService service;

    @GetMapping("/all")
    public ResponseEntity<List<DeadLineDto>> getAll() {
        return ResponseEntity.ok(service.findAllDeadLines());
    }

    @GetMapping("/{deadLineId}")
    public ResponseEntity<DeadLineDto> getDeadLineById(@PathVariable(name = "deadLineId") String deadLineId) {
        return ResponseEntity.ok(service.findById(deadLineId));
    }

    @PostMapping("/create")
    public ResponseEntity<ApiResponse> createDeadLine(@RequestBody DeadLineDto deadLineDto) {
        return ResponseEntity.ok(service.save(deadLineDto));
    }

    @DeleteMapping("/delete/{deadLineId}")
    public ResponseEntity<ApiResponse> deleteDeadLine(@PathVariable(name = "deadLineId") String deadLineId) {
        return ResponseEntity.ok(service.delete(deadLineId));
    }

    @PutMapping("/update/{deadLineId}")
    public ResponseEntity<ApiResponse> updateDeadLine(@PathVariable(name = "deadLineId") String deadLineId, @RequestBody DeadLineDto deadLineDto) {
        return ResponseEntity.ok(service.update(deadLineId, deadLineDto));
    }

}
