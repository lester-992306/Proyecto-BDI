/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.lemus.biblioteca.repository;


import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import java.util.List;
import org.lemus.biblioteca.model.Titulo;

@Repository
public class TituloRepository {

    private final JdbcTemplate jdbc;

    public TituloRepository(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    public List<Titulo> findAll() {
        return jdbc.query("SELECT * FROM TITULO", new BeanPropertyRowMapper<>(Titulo.class));
    }

    public Titulo findById(Long id) {
        return jdbc.queryForObject("SELECT * FROM TITULO WHERE TITULO_ID = ?", new BeanPropertyRowMapper<>(Titulo.class), id);
    }

    public void create(Titulo t) {
        String sql = "INSERT INTO TITULO (NOMBRE, , ISBN, ANIO, EDITORIAL, CATEGORIA) VALUES (?, ?, ?, ?, ?, ?)";
        jdbc.update(sql, t.getNombre(), t.getIsbn(), t.getAnio(), t.getEditorial(), t.getCategoria());
    }

    public void update(Long id, Titulo t) {
        String sql = "UPDATE TITULO SET NOMBRE=?, AUTOR_ID=?, ISBN=?, ANIO=?, EDITORIAL=?, CATEGORIA=? WHERE TITULO_ID=?";
        jdbc.update(sql, t.getNombre(), t.getAutorId(), t.getIsbn(), t.getAnio(), t.getEditorial(), t.getCategoria(), id);
    }

    public void delete(Long id) {
        jdbc.update("DELETE FROM TITULO WHERE TITULO_ID = ?", id);
    }
}

