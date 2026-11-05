/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.uth.appsqlite;

import com.uth.appsqlite.config.Conexion;
import javax.swing.*;
import views.*;

/**
 *
 * @author Dev01
 */
public class AppSQLite {

    public static void main(String[] args) {

        Conexion.createTable();

        SwingUtilities.invokeLater(()
        ->
        {
            FrmPrincipal frm = new FrmPrincipal();
            frm.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
            frm.setVisible(true);
        }
        );
        
    }
}
