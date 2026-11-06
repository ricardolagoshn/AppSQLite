/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.uth.appsqlite.config;

import java.sql.*;

/**
 *
 * @author Dev01
 */
public class Conexion 
{
    private static final String URL = "jdbc:sqlite:personas.db";
    
    public static Connection conectar()
            throws SQLException
    {
        return DriverManager.getConnection(URL);
    }
    
    
    public static void createTable()
    {
        String sql = "CREATE TABLE IF NOT EXISTS Persona"
                + "( id INTEGER PRIMARY KEY AUTOINCREMENT, " 
                + " nombres TEXT NOT NULL, "
                + " apellidos TEXT NOT NULL, "
                + " edad INTEGER NOT NULL )";

        // Tabla Pais con campos de control: estado (1 = activo, 0 = inactivo)
        // y fechaRegistro (se llena automaticamente al insertar)
        String sqlPais = "CREATE TABLE IF NOT EXISTS Pais"
                + "( idPais INTEGER PRIMARY KEY AUTOINCREMENT, "
                + " nombre TEXT NOT NULL UNIQUE, "
                + " estado INTEGER NOT NULL DEFAULT 1 CHECK (estado IN (0,1)), "
                + " fechaRegistro TEXT NOT NULL DEFAULT (datetime('now','localtime')) )";

        try(Connection con = conectar();
                Statement stmt = con.createStatement()
                )
        {
            stmt.execute(sql);
            stmt.execute(sqlPais);
            System.out.println("Tablas creadas con exito");
        }
        catch(SQLException ex)
        {
            ex.printStackTrace();
        }
    }
}
