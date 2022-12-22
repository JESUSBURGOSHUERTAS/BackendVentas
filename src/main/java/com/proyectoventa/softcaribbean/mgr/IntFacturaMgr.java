package com.proyectoventa.softcaribbean.mgr;


import com.proyectoventa.softcaribbean.dto.Factura;
import com.proyectoventa.softcaribbean.exception.DaoException;

import java.util.List;

public interface IntFacturaMgr {
    public void Save(Factura f) throws DaoException;
    public void Delete(Factura f)throws DaoException;
    public List<Factura> SelectAll()throws DaoException;
}
