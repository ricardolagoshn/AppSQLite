/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.uth.appsqlite.dao;

import com.uth.appsqlite.models.Persona;
import java.util.List;

/**
 *
 * @author Dev01
 */
public interface IPersonasDAO 
{
    // CRUD Operations
    //CREATE
    void insertar(Persona persona);
    //READ
    List<Persona> listar();
    //READ ID
    Persona buscarPorId(int id);
    // UPDATE
    void actualizar(Persona persona);
    //DELETE
    void eliminar(int id);
    
    void eliminar(Persona persona);
}
