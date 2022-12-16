package com.proyectoventa.softcaribbean.database;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexion {
    private Connection con;
    public Connection getCon(){
        return con;
    }
    public void Conect(){
        try {
            String URL = "jdbc:mysql://localhost:3306/ventas";
            con = DriverManager.getConnection(URL,"root","B7809297bt7.");
            con.setAutoCommit(false);
        }catch (Exception e){
            System.out.println("Ocurrió un error conectando la base de datos");
        }
    }


}
