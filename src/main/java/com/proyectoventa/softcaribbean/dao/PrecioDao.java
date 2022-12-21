package com.proyectoventa.softcaribbean.dao;

import com.proyectoventa.softcaribbean.database.ManagerConexion;
import com.proyectoventa.softcaribbean.dto.Precio;


import com.proyectoventa.softcaribbean.exception.DaoException;
import org.springframework.stereotype.Controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Controller
public class PrecioDao implements IntPrecioDao{

    public void Insert(Precio m)throws DaoException {
        String INSERT = "INSERT INTO precio (nmprecio, sku, precio, fedesde, fehasta) VALUES (?,?,?,?,?)";
        PreparedStatement statement = null;
        Connection connection = ManagerConexion.getInstance().getConexion().getCon();
        try {
            statement=connection.prepareStatement(INSERT);
            statement.setInt(1,m.getNmprecio());
            statement.setString(2,m.getSku());
            statement.setInt(3,m.getPrecio());
            statement.setDate(4,m.getFedesde());
            statement.setDate(5,m.getFehasta());

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

    public void Update(Precio m)throws DaoException{
        String UPDATE = "UPDATE  precio\n" +
                "SET  sku=?,\n" +
                "precio=?,\n" +
                "fedesde=?,\n" +
                "fehasta=?\n" +
                "WHERE nmprecio=?";
        PreparedStatement statement = null;
        //Obtengo la conexión
        Connection connection=ManagerConexion.getInstance().getConexion().getCon();
        try {
            statement=connection.prepareStatement(UPDATE);

            statement.setString(1,m.getSku());
            statement.setInt(2,m.getPrecio());
            statement.setDate(3,m.getFedesde());
            statement.setDate(4,m.getFehasta());
            statement.setInt(5,m.getNmprecio());
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

    public void Delete(Precio m) throws DaoException {
        String DELETE = "DELETE FROM precio where nmprecio=?";
        PreparedStatement statement = null;
        Connection connection=ManagerConexion.getInstance().getConexion().getCon();
        try {
            statement = connection.prepareStatement(DELETE);
            statement.setInt(1, m.getNmprecio());
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

    public List<Precio> SelectAll()throws DaoException{
        List<Precio> list= new ArrayList<>();
        String SQL = "SELECT * FROM precio";
        PreparedStatement statement = null;
        Precio m = null;
        ResultSet resultSet=null;

        Connection connection=ManagerConexion.getInstance().getConexion().getCon();

        try {
            statement = connection.prepareStatement(SQL);
            resultSet= statement.executeQuery();


            while(resultSet.next()){
                m = new Precio();
                m.setNmprecio(resultSet.getInt( "nmprecio"));
                m.setSku(resultSet.getString("sku"));
                m.setPrecio(resultSet.getInt("precio"));
                m.setFedesde(resultSet.getDate("fedesde"));
                m.setFehasta(resultSet.getDate("fehasta"));
                list.add(m);
            }
            return list;
        }catch (Exception e){
            throw new DaoException(e);
        }

    }

    public Precio SelectById (Precio m) throws DaoException{

        String SELECT = "SELECT * FROM precio WHERE nmprecio=?";
        PreparedStatement statement = null;
        ResultSet resultSet=null;
        Precio _result=null;
        //Obtengo la conexión
        Connection connection=ManagerConexion.getInstance().getConexion().getCon();

        try {
            statement = connection.prepareStatement(SELECT);
            statement.setInt(1,m.getNmprecio());

            resultSet = statement.executeQuery();

            while (resultSet.next()){
                _result = new Precio();

                _result.setSku(resultSet.getString("sku"));
                _result.setPrecio(resultSet.getInt("precio"));
                _result.setFedesde(resultSet.getDate("fedesde"));
                _result.setFehasta(resultSet.getDate("fehasta"));
                _result.setNmprecio(resultSet.getInt("nmprecio"));


            }
            return _result;

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

    }

}
