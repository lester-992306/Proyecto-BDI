/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.lemus.biblioteca.controller;

/**
 *
 * @author emanu
 */

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import org.lemus.biblioteca.model.Usuario;
import org.lemus.biblioteca.repository.UsuarioRepository;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

  private final UsuarioRepository repo;
  public UsuarioController(UsuarioRepository repo) { this.repo = repo; }

  // Solo BIBLIOTECARIO puede administrar usuarios
  @GetMapping @PreAuthorize("hasRole('BIBLIOTECARIO')")
  public List<Usuario> all(){ return repo.findAll(); }

  @GetMapping("/{id}") @PreAuthorize("hasRole('BIBLIOTECARIO')")
  public Usuario one(@PathVariable Long id){ return repo.findById(id); }

  @PostMapping @PreAuthorize("hasRole('BIBLIOTECARIO')")
  public ResponseEntity<?> create(@RequestBody Usuario u){
    repo.create(u);
    return ResponseEntity.created(URI.create("/api/usuarios")).build();
  }

  @PutMapping("/{id}") @PreAuthorize("hasRole('BIBLIOTECARIO')")
  public ResponseEntity<?> update(@PathVariable Long id, @RequestBody Usuario u){
    repo.update(id,u);
    return ResponseEntity.noContent().build();
  }

  @DeleteMapping("/{id}") @PreAuthorize("hasRole('BIBLIOTECARIO')")
  public ResponseEntity<?> delete(@PathVariable Long id){
    repo.delete(id);
    return ResponseEntity.noContent().build();
  }
}