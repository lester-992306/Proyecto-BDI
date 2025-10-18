/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.lemus.biblioteca.controller;

import java.util.Map;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author emanu
 */
@RestController
@RequestMapping("/api")
public class WhoAmIController {
  @GetMapping("/whoami")
  public Map<String, Object> who(Authentication auth){
    return Map.of(
      "user", auth.getName(),
      "authorities", auth.getAuthorities().toString()
    );
  }

  @GetMapping("/health")
  public Map<String, String> health(){ return Map.of("status","UP"); }
}