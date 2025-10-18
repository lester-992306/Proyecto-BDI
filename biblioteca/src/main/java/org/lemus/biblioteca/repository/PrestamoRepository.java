/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.lemus.biblioteca.repository;



import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import java.util.List;
import org.lemus.biblioteca.model.Prestamo;

@Repository
public class PrestamoRepository {

    private final JdbcTemplate jdbc;

    public PrestamoRepository(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    public List<Prestamo> findAll() {
        return jdbc.query("SELECT * FROM PRESTAMO", new BeanPropertyRowMapper<>(Prestamo.class));
    }

    public Prestamo findById(Long id) {
        return jdbc.queryForObject("SELECT * FROM PRESTAMO WHERE PRESTAMO_ID = ?", new BeanPropertyRowMapper<>(Prestamo.class), id);
    }

    public void create(Prestamo p) {
        String sql = """
          INSERT INTO PRESTAMO (USUARIO_ID, LIBRO_ID, FECHA_PRESTAMO, FECHA_VENCIMIENTO, FECHA_DEVOLUCION, OBSERVACIONES)
          VALUES (?, ?, ?, ?, ?, ?)
        """;
        jdbc.update(sql, p.getUsuarioId(), p.getLibroId(), p.getFechaPrestamo(), p.getFechaVencimiento(), p.getFechaDevolucion(), p.getObservaciones());
    }

    public void update(Long id, Prestamo p) {
        String sql = """
          UPDATE PRESTAMO SET USUARIO_ID=?, LIBRO_ID=?, FECHA_PRESTAMO=?, FECHA_VENCIMIENTO=?, FECHA_DEVOLUCION=?, OBSERVACIONES=?
          WHERE PRESTAMO_ID=?
        """;
        jdbc.update(sql, p.getUsuarioId(), p.getLibroId(), p.getFechaPrestamo(), p.getFechaVencimiento(), p.getFechaDevolucion(), p.getObservaciones(), id);
    }

    public void delete(Long id) {
        jdbc.update("DELETE FROM PRESTAMO WHERE PRESTAMO_ID = ?", id);
    }
}
