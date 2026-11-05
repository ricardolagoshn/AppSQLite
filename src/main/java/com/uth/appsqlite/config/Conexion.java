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
        
        try(Connection con = conectar();
                Statement stmt = con.createStatement()
                )
        {
            stmt.execute(sql);
            System.out.println("Tabla creada con exito");
        }
        catch(SQLException ex)
        {
            ex.printStackTrace();
        }
    }
}
