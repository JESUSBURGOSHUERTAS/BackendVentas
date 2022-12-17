package com.proyectoventa.softcaribbean.mgr;


import com.proyectoventa.softcaribbean.dto.Vendedor;
import com.proyectoventa.softcaribbean.exception.DaoException;

import java.util.List;

public interface IntVendedorMgr {
    public void Save(Vendedor v) throws DaoException;
    public void Delete(Vendedor v)throws DaoException;
    public List<Vendedor> SelectAll()throws DaoException;
}
