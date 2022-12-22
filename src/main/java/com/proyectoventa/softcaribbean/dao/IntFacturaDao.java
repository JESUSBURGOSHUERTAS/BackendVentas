package com.proyectoventa.softcaribbean.dao;

import com.proyectoventa.softcaribbean.dto.Factura;

import com.proyectoventa.softcaribbean.exception.DaoException;

import java.util.List;

public interface IntFacturaDao {
    public void Insert(Factura f)throws DaoException;
    public void Update(Factura f)throws DaoException;
    public void Delete(Factura f) throws DaoException;
    public List<Factura> SelectAll()throws DaoException;
    public Factura SelectById (Factura f) throws DaoException;
}
