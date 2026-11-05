/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.uth.appsqlite.dao;

/**
 *
 * @author Dev01
 */


import com.uth.appsqlite.config.Conexion;
import com.uth.appsqlite.models.Persona;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PersonaDAO
{
    
    // CREATE 
    public void insertar(Persona persona)
    {
        String sql = "INSERT INTO Persona(nombres, apellidos, edad) VALUES (?,?,?)";

        try(Connection con = Conexion.conectar();
                PreparedStatement ps = con.prepareStatement(sql)
                )
        {
            ps.setString(1, persona.getNombres());
            ps.setString(2, persona.getApellidos());
            ps.setInt(3, persona.getEdad());
            ps.executeUpdate();
            System.out.println("Persona creada con exito");
        }
        catch(SQLException ex)
        {
            ex.printStackTrace();
        }
    }
    
    //READ
    public List<Persona> listar()
    {
        List<Persona> personas = new ArrayList<>();
        String sql = "SELECT id, nombres, apellidos, edad FROM Persona";

        try(Connection con = Conexion.conectar();
                PreparedStatement ps = con.prepareStatement(sql);
                ResultSet rs = ps.executeQuery()
                )
        {
            while(rs.next())
            {
                Persona persona = new Persona(
                        rs.getInt("id"),
                        rs.getString("nombres"),
                        rs.getString("apellidos"),
                        rs.getInt("edad")
                );
                personas.add(persona);
            }
        }
        catch(SQLException ex)
        {
            ex.printStackTrace();
        }

        return personas;
    }

    // READ (por id)
    public Persona buscarPorId(int id)
    {
        Persona persona = null;
        String sql = "SELECT id, nombres, apellidos, edad FROM Persona WHERE id = ?";

        try(Connection con = Conexion.conectar();
                PreparedStatement ps = con.prepareStatement(sql)
                )
        {
            ps.setInt(1, id);

            try(ResultSet rs = ps.executeQuery())
            {
                if(rs.next())
                {
                    persona = new Persona(
                            rs.getInt("id"),
                            rs.getString("nombres"),
                            rs.getString("apellidos"),
                            rs.getInt("edad")
                    );
                }
            }
        }
        catch(SQLException ex)
        {
            ex.printStackTrace();
        }

        return persona;
    }

    // UPDATE
    public void actualizar(Persona persona)
    {
        String sql = "UPDATE Persona SET nombres = ?, apellidos = ?, edad = ? WHERE id = ?";

        try(Connection con = Conexion.conectar();
                PreparedStatement ps = con.prepareStatement(sql)
                )
        {
            ps.setString(1, persona.getNombres());
            ps.setString(2, persona.getApellidos());
            ps.setInt(3, persona.getEdad());
            ps.setInt(4, persona.getId());
            int filas = ps.executeUpdate();

            if(filas > 0)
            {
                System.out.println("Persona actualizada con exito");
            }
            else
            {
                System.out.println("No se encontro la persona con id " + persona.getId());
            }
        }
        catch(SQLException ex)
        {
            ex.printStackTrace();
        }
    }

    // DELETE
    public void eliminar(int id)
    {
        String sql = "DELETE FROM Persona WHERE id = ?";

        try(Connection con = Conexion.conectar();
                PreparedStatement ps = con.prepareStatement(sql)
                )
        {
            ps.setInt(1, id);
            int filas = ps.executeUpdate();

            if(filas > 0)
            {
                System.out.println("Persona eliminada con exito");
            }
            else
            {
                System.out.println("No se encontro la persona con id " + id);
            }
        }
        catch(SQLException ex)
        {
            ex.printStackTrace();
        }
    }
}
