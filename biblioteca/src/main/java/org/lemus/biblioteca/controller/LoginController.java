/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.lemus.biblioteca.controller;

/**
 *
 * @author emanu
 */

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class LoginController {
  @GetMapping("/login")
  public String login(@RequestParam(value = "error", required = false) String error,
                      @RequestParam(value = "logout", required = false) String logout,
                      @RequestParam(value = "out", required = false) String out,
                      Model model) {
System.out.print("Se llamo a login");
    if (error != null)  model.addAttribute("msgError", "Usuario o contraseña inválidos.");
    if (logout != null) model.addAttribute("msgOk", "Sesión cerrada correctamente.");
    if (out != null)    model.addAttribute("msgOk", "Has salido de la aplicación.");

    return "login"; // templates/login.html
  }
}