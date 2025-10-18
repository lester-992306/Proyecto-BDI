/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.lemus.biblioteca.repository;

import org.lemus.biblioteca.model.Autor;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class AutorRepository {

    private final JdbcTemplate jdbc;

    public AutorRepository(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    public List<Autor> findAll() {
        String sql = "SELECT * FROM AUTOR";
        return jdbc.query(sql, new BeanPropertyRowMapper<>(Autor.class));
    }

    public Autor findById(Long id) {
        String sql = "SELECT * FROM AUTOR WHERE AUTOR_ID = ?";
        return jdbc.queryForObject(sql, new BeanPropertyRowMapper<>(Autor.class), id);
    }

    public void create(Autor a) {
        String sql = "INSERT INTO AUTOR (NOMBRES, APELLIDOS, FECHA_NACIMIENTO, NACIONALIDAD) VALUES (?, ?, ?, ?)";
        jdbc.update(sql, a.getNombres(), a.getApellidos(), a.getFechaNacimiento(), a.getNacionalidad());
    }

    public void update(Long id, Autor a) {
        String sql = "UPDATE AUTOR SET NOMBRES=?, APELLIDOS=?, FECHA_NACIMIENTO=?, NACIONALIDAD=? WHERE AUTOR_ID=?";
        jdbc.update(sql, a.getNombres(), a.getApellidos(), a.getFechaNacimiento(), a.getNacionalidad(), id);
    }

    public void delete(Long id) {
        String sql = "DELETE FROM AUTOR WHERE AUTOR_ID = ?";
        jdbc.update(sql, id);
    }
}

