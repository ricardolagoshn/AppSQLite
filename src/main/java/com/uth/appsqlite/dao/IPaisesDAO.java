/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.uth.appsqlite.dao;

import com.uth.appsqlite.models.Pais;
import java.util.List;

/**
 *
 * @author Dev01
 */
public interface IPaisesDAO
{
    // CRUD Operations
    //CREATE
    void insertar(Pais pais);
    //READ
    List<Pais> listar();
    //READ ID
    Pais buscarPorId(int idPais);
    // UPDATE
    void actualizar(Pais pais);
    //DELETE
    void eliminar(int idPais);

    void eliminar(Pais pais);
}
