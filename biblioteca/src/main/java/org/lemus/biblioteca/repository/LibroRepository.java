/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.lemus.biblioteca.repository;



import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import java.util.List;
import org.lemus.biblioteca.model.Libro;

@Repository
public class LibroRepository {

    private final JdbcTemplate jdbc;

    public LibroRepository(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    public List<Libro> findAll() {
        return jdbc.query("SELECT * FROM LIBRO", new BeanPropertyRowMapper<>(Libro.class));
    }

    public Libro findById(Long id) {
        return jdbc.queryForObject("SELECT * FROM LIBRO WHERE LIBRO_ID = ?", new BeanPropertyRowMapper<>(Libro.class), id);
    }

    public void create(Libro l) {
        String sql = "INSERT INTO LIBRO (TITULO_ID, CODIGO_BARRA, UBICACION, ESTADO) VALUES (?, ?, ?, ?)";
        jdbc.update(sql, l.getTituloId(), l.getCodigoBarra(), l.getUbicacion(), l.getEstado());
    }

    public void update(Long id, Libro l) {
        String sql = "UPDATE LIBRO SET TITULO_ID=?, CODIGO_BARRA=?, UBICACION=?, ESTADO=? WHERE LIBRO_ID=?";
        jdbc.update(sql, l.getTituloId(), l.getCodigoBarra(), l.getUbicacion(), l.getEstado(), id);
    }

    public void delete(Long id) {
        jdbc.update("DELETE FROM LIBRO WHERE LIBRO_ID = ?", id);
    }
}
