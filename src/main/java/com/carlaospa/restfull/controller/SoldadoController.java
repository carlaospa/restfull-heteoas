package com.carlaospa.restfull.controller;

import com.carlaospa.restfull.controller.request.SoldadoEditRequest;
import com.carlaospa.restfull.controller.response.SoldadoListResponse;
import com.carlaospa.restfull.controller.response.SoldadoResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.carlaospa.restfull.dto.Soldado;
import com.carlaospa.restfull.service.SoldadoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.hateoas.Resources;

@RestController
@RequestMapping("/v1/soldado")
public class SoldadoController {

    private SoldadoService soldadoService;
    private ObjectMapper objectMapper;

    public SoldadoController(SoldadoService soldadoService, ObjectMapper objectMapper) {
        this.soldadoService = soldadoService;
        this.objectMapper = objectMapper;
    }

    @GetMapping("/{id}")
    public ResponseEntity<SoldadoResponse> buscarSoldado(@PathVariable() Long id) {
        SoldadoResponse soldadoResponse = soldadoService.buscarSoldado(id);
        return ResponseEntity.status(HttpStatus.OK).body(soldadoResponse);
    }

    @PostMapping
    public ResponseEntity criarSoldado(@RequestBody Soldado soldado) {
        soldadoService.criarSoldado(soldado);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity editarSoldado(@PathVariable() Long id,
                                        @RequestBody SoldadoEditRequest soldadoEditRequest) {
        soldadoService.alterarSoldado(id, soldadoEditRequest);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deletarSoldado(@PathVariable Long id) {
        soldadoService.deletarSoldado(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/frente-castelo/{id}")
    public ResponseEntity frenteCastelo(@PathVariable Long id) {
        // fazer algo
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<Resources<SoldadoListResponse>> buscarSoldados() {
        Resources<SoldadoListResponse> soldadoListResponses = soldadoService.buscarSoldados();
        return ResponseEntity.status(HttpStatus.OK).body(soldadoListResponses);
    }
}
