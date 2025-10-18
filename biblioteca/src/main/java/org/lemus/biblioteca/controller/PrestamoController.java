/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.lemus.biblioteca.controller;



import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.net.URI;
import java.util.List;
import org.lemus.biblioteca.model.Prestamo;
import org.lemus.biblioteca.repository.PrestamoRepository;

@RestController
@RequestMapping("/api/prestamos")
@CrossOrigin
public class PrestamoController {

    private final PrestamoRepository repo;

    public PrestamoController(PrestamoRepository repo) {
        this.repo = repo;
    }

    @GetMapping("")
    public List<Prestamo> all() {
        return repo.findAll();
    }

    @GetMapping("/{id}")
    public Prestamo one(@PathVariable Long id) {
        return repo.findById(id);
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody Prestamo p) {
        repo.create(p);
        return ResponseEntity.created(URI.create("/api/prestamos")).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody Prestamo p) {
        repo.update(id, p);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        repo.delete(id);
        return ResponseEntity.noContent().build();
    }
}
