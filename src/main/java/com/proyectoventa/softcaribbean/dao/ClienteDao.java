package com.proyectoventa.softcaribbean.dao;
import com.proyectoventa.softcaribbean.database.ManagerConexion;
import com.proyectoventa.softcaribbean.dto.Cliente;

import com.proyectoventa.softcaribbean.exception.DaoException;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


@Component
public class ClienteDao implements IntClienteDao {
    public void Insert(Cliente c)throws DaoException {
        String INSERT = "INSERT INTO cliente (nmcliente, documento, dsnombres, dsapellidos, dsdireccion) VALUES (?,?,?,?,?)";
        PreparedStatement statement = null;
        Connection connection = ManagerConexion.getInstance().getConexion().getCon();
        try {
            statement=connection.prepareStatement(INSERT);
            statement.setInt(1,c.getNmcliente());
            statement.setString(2,c.getDocumento());
            statement.setString(3,c.getDsnombres());
            statement.setString(4,c.getDsapellidos());
            statement.setString(5,c.getDsdireccion());

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

    public void Update(Cliente c)throws DaoException{
        String UPDATE = "UPDATE  cliente\n" +
                "SET  documento=?,\n" +
                "dsnombres=?,\n" +
                "dsapellidos=?,\n" +
                "dsdireccion=?\n" +
                "WHERE nmcliente=?";
        PreparedStatement statement = null;
        //Obtengo la conexión
        Connection connection=ManagerConexion.getInstance().getConexion().getCon();
        try {
            statement=connection.prepareStatement(UPDATE);
            statement.setString(1,c.getDocumento());
            statement.setString(2,c.getDsnombres());
            statement.setString(3,c.getDsapellidos());
            statement.setString(4,c.getDsdireccion());
            statement.setInt(5,c.getNmcliente());
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

    public void Delete(Cliente c) throws DaoException {
        String DELETE = "DELETE FROM cliente where nmcliente=?";
        PreparedStatement statement = null;
        Connection connection=ManagerConexion.getInstance().getConexion().getCon();
        try {
            statement = connection.prepareStatement(DELETE);
            statement.setInt(1, c.getNmcliente());
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

    public List<Cliente> SelectAll()throws DaoException{
        List<Cliente> list= new ArrayList<>();
        String SQL = "SELECT * FROM cliente";
        PreparedStatement statement = null;
        Cliente c = null;
        ResultSet resultSet=null;

        Connection connection=ManagerConexion.getInstance().getConexion().getCon();

        try {
            statement = connection.prepareStatement(SQL);
            resultSet= statement.executeQuery();


            while(resultSet.next()){
                c = new Cliente();
                c.setNmcliente(resultSet.getInt( "nmcliente"));
                c.setDocumento(resultSet.getString("documento"));
                c.setDsnombres(resultSet.getString("dsnombres"));
                c.setDsapellidos(resultSet.getString("dsapellidos"));
                c.setDsdireccion(resultSet.getString("dsdireccion"));
                list.add(c);
            }
            return list;
        }catch (Exception e){
            throw new DaoException(e);
        }

    }

    public Cliente SelectById (Cliente c) throws DaoException{

        String SELECT = "SELECT * FROM cliente WHERE nmcliente=?";
        PreparedStatement statement = null;
        ResultSet resultSet=null;
        Cliente _result=null;
        //Obtengo la conexión
        Connection connection=ManagerConexion.getInstance().getConexion().getCon();

        try {
            statement = connection.prepareStatement(SELECT);
            statement.setInt(1,c.getNmcliente());

            resultSet = statement.executeQuery();

            while (resultSet.next()){
                _result = new Cliente();

                _result.setDocumento(resultSet.getString("documento"));
                _result.setDsnombres(resultSet.getString("dsnombres"));
                _result.setDsapellidos(resultSet.getString("dsapellidos"));
                _result.setDsdireccion(resultSet.getString("dsdireccion"));
                _result.setNmcliente(resultSet.getInt("nmcliente"));


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
