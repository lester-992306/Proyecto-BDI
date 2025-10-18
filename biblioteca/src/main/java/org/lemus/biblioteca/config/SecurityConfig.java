/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.lemus.biblioteca.config;


import org.lemus.biblioteca.security.DbUserDetailsService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder; // contraseña en texto plano
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import javax.sql.DataSource;

@Configuration
public class SecurityConfig {


  @Bean
  public PasswordEncoder passwordEncoder() {
    // Por requerimiento: contraseña en texto claro
    return NoOpPasswordEncoder.getInstance();
  }

  @Bean
  public DaoAuthenticationProvider authProvider(UserDetailsService uds, PasswordEncoder pe) {
    DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
    provider.setUserDetailsService(uds);
    provider.setPasswordEncoder(pe);
    return provider;
  }

  @Bean
  public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
    http
      .csrf(csrf -> csrf.disable())
      .authorizeHttpRequests(auth -> auth
        .requestMatchers("/login", "/css/**", "/js/**", "/health").permitAll()
        .requestMatchers("/api/**").authenticated()
        // ejemplo: restringir creación/edición solo a bibliotecarios
        .requestMatchers("/api/admin/**").hasRole("BIBLIOTECARIO")
        .anyRequest().authenticated()
      )
      .formLogin(form -> form
        .loginPage("/login").permitAll()
        .defaultSuccessUrl("/dashboard", true)
      )
      .logout(logout -> logout.logoutUrl("/logout").logoutSuccessUrl("/login?out").permitAll());
      System.out.println("Se llamo al filtro");
    return http.build();
  }
}