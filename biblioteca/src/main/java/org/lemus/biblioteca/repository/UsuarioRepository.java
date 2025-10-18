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
import org.lemus.biblioteca.model.Usuario;

@Repository
public class UsuarioRepository {

  private final JdbcTemplate jdbc;

  public UsuarioRepository(JdbcTemplate jdbc) { this.jdbc = jdbc; }

  private static class RowMapperImpl implements RowMapper<Usuario> {
    @Override public Usuario mapRow(ResultSet rs, int rowNum) throws SQLException {
      Usuario u = new Usuario();
      u.setUsuarioId(rs.getLong("usuario_id"));
      u.setNombre(rs.getString("nombre"));
      u.setEmail(rs.getString("email"));
      u.setContrasena(rs.getString("contrasena"));
      u.setRolId(rs.getLong("rol_id"));
      u.setActivo(rs.getString("activo"));
      u.setFechaAlta(rs.getDate("fecha_alta"));
      return u;
    }
  }

  public List<Usuario> findAll() {
    return jdbc.query("SELECT * FROM USUARIO ORDER BY usuario_id", new RowMapperImpl());
    }

  public Usuario findById(Long id) {
    return jdbc.queryForObject("SELECT * FROM USUARIO WHERE usuario_id=?", new RowMapperImpl(), id);
  }

  public int create(Usuario u) {
    String sql = """
      INSERT INTO USUARIO(nombre, email, contrasena, rol_id, activo)
      VALUES(?, ?, ?, ?, ?)
    """;
    return jdbc.update(sql, u.getNombre(), u.getEmail(), u.getContrasena(), u.getRolId(),
        (u.getActivo() == null ? "S" : u.getActivo()));
  }

  public int update(Long id, Usuario u) {
    String sql = """
      UPDATE USUARIO SET nombre=?, email=?, contrasena=?, rol_id=?, activo=?
      WHERE usuario_id=?
    """;
    return jdbc.update(sql, u.getNombre(), u.getEmail(), u.getContrasena(),
        u.getRolId(), u.getActivo(), id);
  }

  public int delete(Long id) {
    return jdbc.update("DELETE FROM USUARIO WHERE usuario_id=?", id);
  }
}