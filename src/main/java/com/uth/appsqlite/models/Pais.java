/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.uth.appsqlite.models;

/**
 *
 * @author Dev01
 */
public class Pais
{
    private int idPais;
    private String nombre;
    // Campos de control
    private boolean estado;          // true = Activo, false = Inactivo
    private String fechaRegistro;    // la asigna la base de datos al insertar

    public Pais() {
        this.estado = true;
    }

    public Pais(int idPais, String nombre, boolean estado) {
        this.idPais = idPais;
        this.nombre = nombre;
        this.estado = estado;
    }

    public Pais(int idPais, String nombre, boolean estado, String fechaRegistro) {
        this.idPais = idPais;
        this.nombre = nombre;
        this.estado = estado;
        this.fechaRegistro = fechaRegistro;
    }

    public int getIdPais() {
        return idPais;
    }

    public void setIdPais(int idPais) {
        this.idPais = idPais;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public String getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(String fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    @Override
    public String toString() {
        return nombre;
    }
}
