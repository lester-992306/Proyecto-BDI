/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.lemus.biblioteca.controller;




import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.net.URI;
import java.util.List;
import org.lemus.biblioteca.model.Autor;
import org.lemus.biblioteca.repository.AutorRepository;

@RestController
@RequestMapping("/api/autores")
@CrossOrigin
public class AutorController {

    private final AutorRepository repo;

    public AutorController(AutorRepository repo) {
        this.repo = repo;
    }

    @GetMapping
    public List<Autor> all() {
        return repo.findAll();
    }

    @GetMapping("/{id}")
    public Autor one(@PathVariable Long id) {
        return repo.findById(id);
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody Autor a) {
        repo.create(a);
        return ResponseEntity.created(URI.create("/api/autores")).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody Autor a) {
        repo.update(id, a);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        repo.delete(id);
        return ResponseEntity.noContent().build();
    }
}
