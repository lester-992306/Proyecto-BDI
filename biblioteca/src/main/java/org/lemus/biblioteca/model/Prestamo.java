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

public class Prestamo {

    /**
     * @return the prestamoId
     */
    public Long getPrestamoId() {
        return prestamoId;
    }

    /**
     * @param prestamoId the prestamoId to set
     */
    public void setPrestamoId(Long prestamoId) {
        this.prestamoId = prestamoId;
    }

    /**
     * @return the usuarioId
     */
    public Long getUsuarioId() {
        return usuarioId;
    }

    /**
     * @param usuarioId the usuarioId to set
     */
    public void setUsuarioId(Long usuarioId) {
        this.usuarioId = usuarioId;
    }

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
     * @return the fechaPrestamo
     */
    public java.sql.Timestamp getFechaPrestamo() {
        return fechaPrestamo;
    }

    /**
     * @param fechaPrestamo the fechaPrestamo to set
     */
    public void setFechaPrestamo(java.sql.Timestamp fechaPrestamo) {
        this.fechaPrestamo = fechaPrestamo;
    }

    /**
     * @return the fechaVencimiento
     */
    public java.sql.Date getFechaVencimiento() {
        return fechaVencimiento;
    }

    /**
     * @param fechaVencimiento the fechaVencimiento to set
     */
    public void setFechaVencimiento(java.sql.Date fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    /**
     * @return the fechaDevolucion
     */
    public java.sql.Timestamp getFechaDevolucion() {
        return fechaDevolucion;
    }

    /**
     * @param fechaDevolucion the fechaDevolucion to set
     */
    public void setFechaDevolucion(java.sql.Timestamp fechaDevolucion) {
        this.fechaDevolucion = fechaDevolucion;
    }

    /**
     * @return the observaciones
     */
    public String getObservaciones() {
        return observaciones;
    }

    /**
     * @param observaciones the observaciones to set
     */
    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }
  private Long prestamoId;
  private Long usuarioId;
  private Long libroId;
  private java.sql.Timestamp fechaPrestamo;
  private java.sql.Date fechaVencimiento;
  private java.sql.Timestamp fechaDevolucion; // null abierto
  private String observaciones;
}
