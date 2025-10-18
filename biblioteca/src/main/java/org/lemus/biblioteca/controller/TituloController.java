/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.lemus.biblioteca.controller;

import java.net.URI;
import java.util.List;
import org.lemus.biblioteca.model.Titulo;
import org.lemus.biblioteca.repository.TituloRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author emanu
 */
@RestController
@RequestMapping("/api/titulos")
public class TituloController {
  private final TituloRepository repo;
  public TituloController(TituloRepository repo) { this.repo = repo; }

  @GetMapping public List<Titulo> all(){ return repo.findAll(); }
  @GetMapping("/{id}") public Titulo one(@PathVariable Long id){ return repo.findById(id); }

  @PostMapping @PreAuthorize("hasRole('BIBLIOTECARIO')")
  public ResponseEntity<?> create(@RequestBody Titulo t){
    repo.create(t);
    return ResponseEntity.created(URI.create("/api/titulos")).build();
  }

  @PutMapping("/{id}") @PreAuthorize("hasRole('BIBLIOTECARIO')")
  public ResponseEntity<?> update(@PathVariable Long id, @RequestBody Titulo t){
    repo.update(id,t);
    return ResponseEntity.noContent().build();
  }

  @DeleteMapping("/{id}") @PreAuthorize("hasRole('BIBLIOTECARIO')")
  public ResponseEntity<?> delete(@PathVariable Long id){
    repo.delete(id);
    return ResponseEntity.noContent().build();
  }
}
