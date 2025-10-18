/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.lemus.biblioteca.controller;



import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.net.URI;
import java.util.List;
import org.lemus.biblioteca.model.Libro;
import org.lemus.biblioteca.repository.LibroRepository;

@RestController
@RequestMapping("/api/libros")
@CrossOrigin
public class LibroController {

    private final LibroRepository repo;

    public LibroController(LibroRepository repo) {
        this.repo = repo;
    }

    @GetMapping
    public List<Libro> all() {
        return repo.findAll();
    }

    @GetMapping("/{id}")
    public Libro one(@PathVariable Long id) {
        return repo.findById(id);
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody Libro l) {
        repo.create(l);
        return ResponseEntity.created(URI.create("/api/libros")).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody Libro l) {
        repo.update(id, l);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        repo.delete(id);
        return ResponseEntity.noContent().build();
    }
}
