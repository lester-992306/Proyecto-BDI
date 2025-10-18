/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.lemus.biblioteca.repository;

/**
 *
 * @author emanu
 */

import org.springframework.jdbc.core.*;
import org.springframework.stereotype.Repository;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.lemus.biblioteca.model.Titulo;

@Repository
public class TituloRepository {
  private final JdbcTemplate jdbc;
  public TituloRepository(JdbcTemplate jdbc) { this.jdbc = jdbc; }

  private static class RowMapperImpl implements RowMapper<Titulo> {
    @Override public Titulo mapRow(ResultSet rs, int rowNum) throws SQLException {
      Titulo t = new Titulo();
      t.setTituloId(rs.getLong("titulo_id"));
      t.setNombre(rs.getString("nombre"));
      t.setIsbn(rs.getString("isbn"));
      t.setAnio((Integer) rs.getObject("anio"));
      t.setEditorial(rs.getString("editorial"));
      t.setCategoria(rs.getString("categoria"));
      return t;
    }
  }

  public List<Titulo> findAll() {
    return jdbc.query("SELECT * FROM TITULO ORDER BY titulo_id", new RowMapperImpl());
  }

  public Titulo findById(Long id) {
    return jdbc.queryForObject("SELECT * FROM TITULO WHERE titulo_id=?", new RowMapperImpl(), id);
  }

  public int create(Titulo t) {
    String sql = """
      INSERT INTO TITULO(nombre, isbn, anio, editorial, categoria)
      VALUES(?, ?, ?, ?, ?)
    """;
    return jdbc.update(sql, t.getNombre(), t.getIsbn(), t.getAnio(), t.getEditorial(), t.getCategoria());
  }

  public int update(Long id, Titulo t) {
    String sql = """
      UPDATE TITULO SET nombre=?, isbn=?, anio=?, editorial=?, categoria=?
      WHERE titulo_id=?
    """;
    return jdbc.update(sql, t.getNombre(), t.getIsbn(), t.getAnio(), t.getEditorial(), t.getCategoria(), id);
  }

  public int delete(Long id) {
    return jdbc.update("DELETE FROM TITULO WHERE titulo_id=?", id);
  }
}
