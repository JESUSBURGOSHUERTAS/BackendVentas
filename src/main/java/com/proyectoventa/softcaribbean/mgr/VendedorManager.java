package com.proyectoventa.softcaribbean.mgr;

import com.proyectoventa.softcaribbean.dao.IntVendedorDao;

import com.proyectoventa.softcaribbean.dto.Vendedor;
import com.proyectoventa.softcaribbean.exception.DaoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class VendedorManager implements IntVendedorMgr {
    @Autowired
    private IntVendedorDao dao;

    public void Save(Vendedor v) throws DaoException {
        Vendedor tp = dao.SelectById(v);
        try {
            if (tp == null) {
                dao.Insert(v);
            } else {
                dao.Update(v);
            }
        } catch (Exception e) {
            throw new DaoException(e);
        }

    }

    public void Delete(Vendedor v) throws DaoException {

       try{
                dao.Delete(v);

        } catch (Exception e) {
            throw new DaoException(e);
        }
    }
    public List<Vendedor> SelectAll()throws DaoException{
        try {
            return dao.SelectAll();
        }catch (Exception e){
            throw new DaoException(e);
        }
    }
}
