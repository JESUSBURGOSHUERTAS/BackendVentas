package com.proyectoventa.softcaribbean.dao;

import com.proyectoventa.softcaribbean.dto.Productos;
import com.proyectoventa.softcaribbean.exception.DaoException;

import java.util.List;

public interface IntDao {
    public void Insert(Productos p)throws DaoException;
    public void Update(Productos p)throws DaoException;
    public void Delete(Productos p)throws DaoException;
    public List<Productos> SelectAll()throws DaoException;
    public Productos SelectById (Productos p) throws DaoException;
}
