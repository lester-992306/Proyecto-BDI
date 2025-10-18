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
class Libro {
  private Long libroId;
  private Long tituloId;
  private String codigoBarra;
  private String ubicacion;
  private String estado;
}