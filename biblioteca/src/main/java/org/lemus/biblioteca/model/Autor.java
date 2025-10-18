/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.lemus.biblioteca.model;

import lombok.Data;

/**
 *
 * @author emanu
 */
@Data
class Autor {
  private Long autorId;
  private String nombres;
  private String apellidos;
  private java.sql.Date fechaNacimiento;
  private String nacionalidad;
}
