/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.lemus.biblioteca.security;


import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.util.List;

@Service
public class DbUserDetailsService implements UserDetailsService {

  private final JdbcTemplate jdbc;

  public DbUserDetailsService(DataSource ds) {
    this.jdbc = new JdbcTemplate(ds);
  }

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    // username = email
    var sqlUser = """
      SELECT u.usuario_id, u.email, u.contrasena, u.activo, r.nombre AS rol
      FROM USUARIO u
      JOIN ROL r ON r.rol_id = u.rol_id
      WHERE LOWER(u.email) = LOWER(?)
    """;

    List<UserRow> rows = jdbc.query(sqlUser, (rs, i) -> {
      var row = new UserRow();
      row.usuarioId = rs.getLong("usuario_id");
      row.email = rs.getString("email");
      row.password = rs.getString("contrasena");
      row.activo = "S".equalsIgnoreCase(rs.getString("activo"));
      row.rol = rs.getString("rol");
      return row;
    }, username);

    if (rows.isEmpty()) throw new UsernameNotFoundException("Usuario no encontrado: " + username);

    UserRow u = rows.get(0);
    GrantedAuthority auth = new SimpleGrantedAuthority("ROLE_" + u.rol); // ROLE_BIBLIOTECARIO / ROLE_LECTOR

    return User.withUsername(u.email)
               .password(u.password)   // en texto claro
               .authorities(auth)
               .accountLocked(!u.activo)
               .disabled(!u.activo)
               .build();
  }

  static class UserRow {
    long usuarioId;
    String email;
    String password;
    boolean activo;
    String rol;
  }
}