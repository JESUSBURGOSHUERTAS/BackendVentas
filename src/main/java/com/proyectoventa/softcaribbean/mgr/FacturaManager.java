package com.proyectoventa.softcaribbean.mgr;

import com.proyectoventa.softcaribbean.dao.IntFacturaDao;
import com.proyectoventa.softcaribbean.dto.Factura;
import com.proyectoventa.softcaribbean.exception.DaoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class FacturaManager implements IntFacturaMgr {
    @Autowired
    private IntFacturaDao dao;

    public void Save(Factura f) throws DaoException {
        Factura tp = dao.SelectById(f);
        try {
            if (tp == null) {
                dao.Insert(f);
            } else {
                dao.Update(f);
            }
        } catch (Exception e) {
            throw new DaoException(e);
        }
    }

    public void Delete(Factura f) throws DaoException {

        try{
            dao.Delete(f);
        } catch (Exception e) {
            throw new DaoException(e);
        }
    }

    public List<Factura> SelectAll()throws DaoException{
        try {
            return dao.SelectAll();
        }catch (Exception e){
            throw new DaoException(e);
        }
    }
}
