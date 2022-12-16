package com.proyectoventa.softcaribbean.database;

import com.proyectoventa.softcaribbean.exception.MgrException;
//faltan excepciones

public class ManagerConexion extends MgrException {
    private static ManagerConexion Instance;
    private Conexion   conexion;
    private ManagerConexion(){
        conexion = new Conexion();
    }
    public static ManagerConexion getInstance(){
        if (Instance == null){
            Instance = new ManagerConexion();
        }
        return Instance;
    }

    public void Open(){
        conexion.Conect();
    }
    public void Commit()throws MgrException{
        try{
            conexion.getCon().commit();
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }
    public void RollBack(){
        try{
            conexion.getCon().rollback();
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }
    public void Close(){
        try{
            conexion.getCon().close();
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }
    public Conexion getConexion(){
        return conexion;
    }
}
