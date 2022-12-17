package com.proyectoventa.softcaribbean.dao;

import com.proyectoventa.softcaribbean.dto.Vendedor;
import com.proyectoventa.softcaribbean.exception.DaoException;

import java.util.List;

public interface IntVendedorDao {
    public void Insert(Vendedor v)throws DaoException;
    public void Update(Vendedor v)throws DaoException;
    public void Delete(Vendedor v) throws DaoException;
    public List<Vendedor> SelectAll()throws DaoException;
    public Vendedor SelectById (Vendedor v) throws DaoException;


}
