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

public class Libro {

    /**
     * @return the libroId
     */
    public Long getLibroId() {
        return libroId;
    }

    /**
     * @param libroId the libroId to set
     */
    public void setLibroId(Long libroId) {
        this.libroId = libroId;
    }

    /**
     * @return the tituloId
     */
    public Long getTituloId() {
        return tituloId;
    }

    /**
     * @param tituloId the tituloId to set
     */
    public void setTituloId(Long tituloId) {
        this.tituloId = tituloId;
    }

    /**
     * @return the codigoBarra
     */
    public String getCodigoBarra() {
        return codigoBarra;
    }

    /**
     * @param codigoBarra the codigoBarra to set
     */
    public void setCodigoBarra(String codigoBarra) {
        this.codigoBarra = codigoBarra;
    }

    /**
     * @return the ubicacion
     */
    public String getUbicacion() {
        return ubicacion;
    }

    /**
     * @param ubicacion the ubicacion to set
     */
    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    /**
     * @return the estado
     */
    public String getEstado() {
        return estado;
    }

    /**
     * @param estado the estado to set
     */
    public void setEstado(String estado) {
        this.estado = estado;
    }
  private Long libroId;
  private Long tituloId;
  private String codigoBarra;
  private String ubicacion;
  private String estado;
}