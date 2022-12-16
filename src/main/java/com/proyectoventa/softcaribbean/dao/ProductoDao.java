package com.proyectoventa.softcaribbean.dao;

import com.proyectoventa.softcaribbean.database.Conexion;
import com.proyectoventa.softcaribbean.database.ManagerConexion;
import com.proyectoventa.softcaribbean.dto.Productos;
import com.proyectoventa.softcaribbean.exception.DaoException;
import org.springframework.stereotype.Controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


@Controller

public class ProductoDao implements IntDao{
    Conexion con= ManagerConexion.getInstance().getConexion();
    public void Insert(Productos p)throws DaoException {
        String INSERT = "INSERT INTO productos (sku,dsproducto) VALUES (?,?)";
        PreparedStatement statement = null;
        Connection connection = con.getCon();
        try {
            statement=connection.prepareStatement(INSERT);
            statement.setString(1,p.getSku());
            statement.setString(2,p.getDsproducto());
            statement.executeUpdate();

        }catch (Exception E){
            throw new DaoException(E);
        }finally {
            try{
                statement.close();
            }catch (SQLException ex){
                ex.printStackTrace();
            }
        }
    }
    public void Update(Productos p)throws DaoException{
        String UPDATE = "UPDATE  productos\n" +
                "SET  dsproducto=?\n" +
                "WHERE sku=?";
        PreparedStatement statement = null;
        //Obtengo la conexión
        Connection connection=ManagerConexion.getInstance().getConexion().getCon();
        try {
            statement=connection.prepareStatement(UPDATE);
            statement.setString(1,p.getDsproducto());
            statement.setString(2,p.getSku());
            statement.executeUpdate();
        }catch (Exception E){
            throw new DaoException(E);

        }finally {
            try{
                statement.close();
            }catch (SQLException ex){
                ex.printStackTrace();
            }
        }
    }
    public void Delete(Productos p) throws DaoException {
        String DELETE = "DELETE FROM productos where sku=?";
        PreparedStatement statement = null;
        Connection connection=ManagerConexion.getInstance().getConexion().getCon();
        try {
            statement = connection.prepareStatement(DELETE);
            statement.setString(1, p.getSku());
            statement.executeUpdate();
        } catch (Exception ex) {
            throw new DaoException(ex);
        } finally {
            try {
                statement.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

    public List<Productos> SelectAll()throws DaoException{
        Connection connection=ManagerConexion.getInstance().getConexion().getCon();
        String SQL = "SELECT sku, dsproducto FROM productos order by sku";
        PreparedStatement statement = null;
        ResultSet resultSet=null;
        List<Productos> lista= new ArrayList<>();

        try {
            statement = connection.prepareStatement(SQL);
            resultSet= statement.executeQuery();
            Productos p = null;

            while(resultSet.next()){
                p = new Productos();
                p.setSku(resultSet.getString( "sku"));
                p.setDsproducto(resultSet.getString("dsproducto"));
                lista.add(p);
            }
        }catch (Exception e){
            throw new DaoException(e);
        }
        return lista;
    }
    public Productos SelectById (Productos p) throws DaoException{
        Productos _result=null;
        String SELECT = "SELECT sku,dsproducto\n" +
                "FROM productos\n" +
                "WHERE sku=?";
        PreparedStatement statement = null;
        ResultSet resultSet=null;
        //Obtengo la conexión
        Connection connection=ManagerConexion.getInstance().getConexion().getCon();
        System.out.println(connection);
        try {
            statement = connection.prepareStatement(SELECT);
            statement.setString(1,p.getSku());

            resultSet = statement.executeQuery();
            while (resultSet.next()){
                _result= new Productos();
                _result.setSku(resultSet.getString("sku"));
                _result.setDsproducto(resultSet.getString("dsproducto"));

            }
        }catch (Exception E){
            throw new DaoException(E);

        }finally {
            try{
                resultSet.close();
                statement.close();
            }catch (SQLException ex){
                ex.printStackTrace();
            }
        }
        return _result;
    }
}
