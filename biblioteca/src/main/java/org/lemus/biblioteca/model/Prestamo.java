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
class Prestamo {
  private Long prestamoId;
  private Long usuarioId;
  private Long libroId;
  private java.sql.Timestamp fechaPrestamo;
  private java.sql.Date fechaVencimiento;
  private java.sql.Timestamp fechaDevolucion; // null abierto
  private String observaciones;
}
