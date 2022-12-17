package com.proyectoventa.softcaribbean.dao;


import com.proyectoventa.softcaribbean.database.ManagerConexion;

import com.proyectoventa.softcaribbean.dto.Vendedor;
import com.proyectoventa.softcaribbean.exception.DaoException;
import org.springframework.stereotype.Controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Controller

public class VendedorDao implements IntVendedorDao{


        public void Insert(Vendedor v)throws DaoException {
            String INSERT = "INSERT INTO vendedor (nmvendedor, documento, dsnombres, desapellido, dsdireccion) VALUES (?,?,?,?,?)";
            PreparedStatement statement = null;
            Connection connection = ManagerConexion.getInstance().getConexion().getCon();
            try {
                statement=connection.prepareStatement(INSERT);
                statement.setInt(1,v.getNmvendedor());
                statement.setString(2,v.getDocumento());
                statement.setString(3,v.getDsnombres());
                statement.setString(4,v.getDesapellidos());
                statement.setString(5,v.getDsdireccion());

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
        public void Update(Vendedor v)throws DaoException{
            String UPDATE = "UPDATE  vendedor\n" +
                    "SET  documento=?\n" +
                    "SET  dsnombres=?\n" +
                    "SET  desapellido=?\n" +
                    "SET  dsdireccion=?\n" +
                    "WHERE nmvendedor=?";
            PreparedStatement statement = null;
            //Obtengo la conexión
            Connection connection=ManagerConexion.getInstance().getConexion().getCon();
            try {
                statement=connection.prepareStatement(UPDATE);

                statement.setString(1,v.getDocumento());
                statement.setString(2,v.getDsnombres());
                statement.setString(3,v.getDesapellidos());
                statement.setString(4,v.getDsdireccion());
                statement.setInt(5,v.getNmvendedor());
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
        public void Delete(Vendedor v) throws DaoException {
            String DELETE = "DELETE FROM vendedor where nmvendedor=?";
            PreparedStatement statement = null;
            Connection connection=ManagerConexion.getInstance().getConexion().getCon();
            try {
                statement = connection.prepareStatement(DELETE);
                statement.setInt(1, v.getNmvendedor());
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

        public List<Vendedor> SelectAll()throws DaoException{
            List<Vendedor> list= new ArrayList<>();
            String SQL = "SELECT * FROM vendedor";
            PreparedStatement statement = null;
            Vendedor v = null;
            ResultSet resultSet=null;

            Connection connection=ManagerConexion.getInstance().getConexion().getCon();

            try {
                statement = connection.prepareStatement(SQL);
                resultSet= statement.executeQuery();


                while(resultSet.next()){
                    v = new Vendedor();
                    v.setNmvendedor(resultSet.getInt( "nmvendedor"));
                    v.setDocumento(resultSet.getString("documento"));
                    v.setDsnombres(resultSet.getString("dsnombres"));
                    v.setDesapellidos(resultSet.getString("desapellido"));
                    v.setDsdireccion(resultSet.getString("dsdireccion"));
                    list.add(v);
                }
                return list;
            }catch (Exception e){
                throw new DaoException(e);
            }

        }
        public Vendedor SelectById (Vendedor v) throws DaoException{

            String SELECT = "SELECT * FROM vendedor WHERE nmvendedor=?";
            PreparedStatement statement = null;
            ResultSet resultSet=null;
            Vendedor _result=null;
            //Obtengo la conexión
            Connection connection=ManagerConexion.getInstance().getConexion().getCon();

            try {
                statement = connection.prepareStatement(SELECT);
                statement.setInt(1,v.getNmvendedor());

                resultSet = statement.executeQuery();

                while (resultSet.next()){
                    _result = new Vendedor();

                    _result.setDocumento(resultSet.getString("documento"));
                    _result.setDsnombres(resultSet.getString("dsnombres"));
                    _result.setDesapellidos(resultSet.getString("desapellido"));
                    _result.setDsdireccion(resultSet.getString("dsdireccion"));
                    _result.setNmvendedor(resultSet.getInt("nmvendedor"));


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


