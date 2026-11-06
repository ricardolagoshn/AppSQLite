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
import com.uth.appsqlite.models.Pais;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PaisDAO implements IPaisesDAO
{

    // CREATE
    @Override
    public void insertar(Pais pais)
    {
        String sql = "INSERT INTO Pais(nombre, estado) VALUES (?,?)";

        try(Connection con = Conexion.conectar();
                PreparedStatement ps = con.prepareStatement(sql)
                )
        {
            ps.setString(1, pais.getNombre());
            ps.setInt(2, pais.isEstado() ? 1 : 0);
            ps.executeUpdate();
            System.out.println("Pais creado con exito");
        }
        catch(SQLException ex)
        {
            ex.printStackTrace();
        }
    }

    //READ
    @Override
    public List<Pais> listar()
    {
        List<Pais> paises = new ArrayList<>();
        String sql = "SELECT idPais, nombre, estado, fechaRegistro FROM Pais ORDER BY nombre";

        try(Connection con = Conexion.conectar();
                PreparedStatement ps = con.prepareStatement(sql);
                ResultSet rs = ps.executeQuery()
                )
        {
            while(rs.next())
            {
                paises.add(mapear(rs));
            }
        }
        catch(SQLException ex)
        {
            ex.printStackTrace();
        }

        return paises;
    }

    // READ (por id)
    @Override
    public Pais buscarPorId(int idPais)
    {
        Pais pais = null;
        String sql = "SELECT idPais, nombre, estado, fechaRegistro FROM Pais WHERE idPais = ?";

        try(Connection con = Conexion.conectar();
                PreparedStatement ps = con.prepareStatement(sql)
                )
        {
            ps.setInt(1, idPais);

            try(ResultSet rs = ps.executeQuery())
            {
                if(rs.next())
                {
                    pais = mapear(rs);
                }
            }
        }
        catch(SQLException ex)
        {
            ex.printStackTrace();
        }

        return pais;
    }

    // UPDATE
    @Override
    public void actualizar(Pais pais)
    {
        String sql = "UPDATE Pais SET nombre = ?, estado = ? WHERE idPais = ?";

        try(Connection con = Conexion.conectar();
                PreparedStatement ps = con.prepareStatement(sql)
                )
        {
            ps.setString(1, pais.getNombre());
            ps.setInt(2, pais.isEstado() ? 1 : 0);
            ps.setInt(3, pais.getIdPais());
            int filas = ps.executeUpdate();

            if(filas > 0)
            {
                System.out.println("Pais actualizado con exito");
            }
            else
            {
                System.out.println("No se encontro el pais con id " + pais.getIdPais());
            }
        }
        catch(SQLException ex)
        {
            ex.printStackTrace();
        }
    }

    // DELETE
    @Override
    public void eliminar(int idPais)
    {
        String sql = "DELETE FROM Pais WHERE idPais = ?";

        try(Connection con = Conexion.conectar();
                PreparedStatement ps = con.prepareStatement(sql)
                )
        {
            ps.setInt(1, idPais);
            int filas = ps.executeUpdate();

            if(filas > 0)
            {
                System.out.println("Pais eliminado con exito");
            }
            else
            {
                System.out.println("No se encontro el pais con id " + idPais);
            }
        }
        catch(SQLException ex)
        {
            ex.printStackTrace();
        }
    }

    @Override
    public void eliminar(Pais pais)
    {
        eliminar(pais.getIdPais());
    }

    // Convierte la fila actual del ResultSet en un objeto Pais
    private Pais mapear(ResultSet rs) throws SQLException
    {
        return new Pais(
                rs.getInt("idPais"),
                rs.getString("nombre"),
                rs.getInt("estado") == 1,
                rs.getString("fechaRegistro")
        );
    }
}
