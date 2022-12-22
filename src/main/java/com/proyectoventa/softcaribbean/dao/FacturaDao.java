package com.proyectoventa.softcaribbean.dao;

import com.proyectoventa.softcaribbean.database.ManagerConexion;

import com.proyectoventa.softcaribbean.dto.Cliente;
import com.proyectoventa.softcaribbean.dto.Factura;
import com.proyectoventa.softcaribbean.dto.Vendedor;
import com.proyectoventa.softcaribbean.exception.DaoException;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Component
public class FacturaDao implements IntFacturaDao {
    public void Insert(Factura f)throws DaoException {
        String INSERT = "INSERT INTO factura (nmfactura, cdfactura, nmvendedor, nmcliente, fefactura) VALUES (?,?,?,?,?)";
        PreparedStatement statement = null;
        Connection connection = ManagerConexion.getInstance().getConexion().getCon();
        try {
            statement=connection.prepareStatement(INSERT);
            statement.setInt(1,f.getNmfactura());
            statement.setString(2,f.getCdfactura());
            statement.setInt(3,f.getVendedorDTO().getNmvendedor());
            statement.setInt(4,f.getClienteDTO().getNmcliente());
            statement.setDate(5,f.getFefactura());

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

    public void Update(Factura f)throws DaoException{
        String UPDATE = "UPDATE  factura\n" +
                "SET  cdfactura=?,\n" +
                "nmvendedor=?,\n" +
                "nmcliente=?,\n" +
                "fefactura=?\n" +
                "WHERE nmfactura=?";
        PreparedStatement statement = null;
        //Obtengo la conexión
        Connection connection=ManagerConexion.getInstance().getConexion().getCon();
        try {
            statement=connection.prepareStatement(UPDATE);
            statement.setString(1,f.getCdfactura());
            statement.setInt(2,f.getVendedorDTO().getNmvendedor());
            statement.setInt(3,f.getClienteDTO().getNmcliente());
            statement.setDate(4,f.getFefactura());
            statement.setInt(5,f.getNmfactura());
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

    public void Delete(Factura f) throws DaoException {
        String DELETE = "DELETE FROM factura where nmfactura=?";
        PreparedStatement statement = null;
        Connection connection=ManagerConexion.getInstance().getConexion().getCon();
        try {
            statement = connection.prepareStatement(DELETE);
            statement.setInt(1, f.getNmfactura());
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

    public List<Factura> SelectAll()throws DaoException{
        List<Factura> list= new ArrayList<>();
        String SQL = "SELECT A.nmfactura, A.cdfactura, A.nmvendedor, B.documento, B.dsnombres, B.desapellido, B.dsdireccion,\n" +
                "A.nmcliente, C.documento, C.dsnombres, C.dsapellidos, C.dsdireccion, A.fefactura\n" +
                "FROM factura A INNER JOIN vendedor B ON A.nmvendedor=B.nmvendedor\n" +
                "INNER JOIN cliente C ON A.nmcliente=C.nmcliente ";
        PreparedStatement statement = null;
        Factura f = null;
        ResultSet resultSet=null;

        Connection connection=ManagerConexion.getInstance().getConexion().getCon();

        try {
            statement = connection.prepareStatement(SQL);
            resultSet= statement.executeQuery();


            while(resultSet.next()){
               Factura result = new Factura();
                result.setNmfactura(resultSet.getInt("nmfactura"));
                result.setCdfactura(resultSet.getString("cdfactura"));

                Vendedor vendedorDTO = new Vendedor();
                vendedorDTO.setNmvendedor(resultSet.getInt("nmvendedor"));
                vendedorDTO.setDocumento(resultSet.getString("documento"));
                vendedorDTO.setDsnombres(resultSet.getString("dsnombres"));
                vendedorDTO.setDesapellidos(resultSet.getString("desapellido"));
                vendedorDTO.setDsdireccion(resultSet.getString("dsdireccion"));
                result.setVendedorDTO(vendedorDTO);

                Cliente clienteDTO = new Cliente();
                clienteDTO.setNmcliente(resultSet.getInt("nmcliente"));
                clienteDTO.setDocumento(resultSet.getString("documento"));
                clienteDTO.setDsnombres(resultSet.getString("dsnombres"));
                clienteDTO.setDsapellidos(resultSet.getString("dsapellidos"));
                clienteDTO.setDsdireccion(resultSet.getString("dsdireccion"));
                result.setClienteDTO(clienteDTO);

                result.setFefactura(resultSet.getDate("fefactura"));
                list.add(result);
            }

        }catch (Exception e){
            throw new DaoException(e);
        } finally {
            try {
                statement.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return list;
    }

    public Factura SelectById (Factura f) throws DaoException{

        String SELECT = "SELECT A.nmfactura, A.cdfactura, A.nmvendedor, B.documento, B.dsnombres, B.desapellido, B.dsdireccion,\n" +
                "A.nmcliente, C.documento, C.dsnombres, C.dsapellidos, C.dsdireccion, A.fefactura\n" +
                "FROM factura A INNER JOIN vendedor B ON A.nmvendedor=B.nmvendedor\n" +
                "INNER JOIN cliente C ON A.nmcliente=C.nmcliente\n" +
                "WHERE A.nmfactura=?";
        PreparedStatement statement = null;
        ResultSet resultSet=null;
        Factura result = null;
        //Obtengo la conexión
        Connection connection=ManagerConexion.getInstance().getConexion().getCon();

        try {
            statement = connection.prepareStatement(SELECT);
            statement.setInt(1,f.getNmfactura());

            resultSet = statement.executeQuery();

            while (resultSet.next()){
                result = new Factura();
                result.setNmfactura(resultSet.getInt("nmfactura"));
                result.setCdfactura(resultSet.getString("cdfactura"));

                Vendedor vendedorDTO = new Vendedor();
                vendedorDTO.setNmvendedor(resultSet.getInt("nmvendedor"));
                vendedorDTO.setDocumento(resultSet.getString("documento"));
                vendedorDTO.setDsnombres(resultSet.getString("dsnombres"));
                vendedorDTO.setDesapellidos(resultSet.getString("desapellido"));
                vendedorDTO.setDsdireccion(resultSet.getString("dsdireccion"));
                result.setVendedorDTO(vendedorDTO);

                Cliente clienteDTO = new Cliente();
                clienteDTO.setNmcliente(resultSet.getInt("nmcliente"));
                clienteDTO.setDocumento(resultSet.getString("documento"));
                clienteDTO.setDsnombres(resultSet.getString("dsnombres"));
                clienteDTO.setDsapellidos(resultSet.getString("dsapellidos"));
                clienteDTO.setDsdireccion(resultSet.getString("dsdireccion"));
                result.setClienteDTO(clienteDTO);

                result.setFefactura(resultSet.getDate("fefactura"));
            }

        }catch (Exception E){
            throw new DaoException(E);
        }finally {
            try{
                statement.close();
            }catch (SQLException ex){
                ex.printStackTrace();
            }
        }
        return result;
    }

}
