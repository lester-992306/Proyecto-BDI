/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.lemus.biblioteca.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author emanu
 */
@Controller
public class VistaUsuarioController {
    @GetMapping("/usuarios")
    public String vistaUsuarios(){
        return "usuarios";
    }
}
