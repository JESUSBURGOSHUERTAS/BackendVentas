package com.proyectoventa.softcaribbean.dao;

import com.proyectoventa.softcaribbean.dto.Cliente;

import com.proyectoventa.softcaribbean.exception.DaoException;

import java.util.List;

public interface IntClienteDao {
    public void Insert(Cliente c)throws DaoException;
    public void Update(Cliente c)throws DaoException;
    public void Delete(Cliente c) throws DaoException;
    public List<Cliente> SelectAll()throws DaoException;
    public Cliente SelectById (Cliente c) throws DaoException;

}
