package com.proyectoventa.softcaribbean.mgr;

import com.proyectoventa.softcaribbean.dao.IntPrecioDao;
import com.proyectoventa.softcaribbean.dto.Precio;

import com.proyectoventa.softcaribbean.exception.DaoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PrecioManager implements IntPrecioMgr {
    @Autowired
    private IntPrecioDao dao;

    public void Save(Precio m) throws DaoException {
        Precio tp = dao.SelectById(m);
        try {
            if (tp == null) {
                dao.Insert(m);
            } else {
                dao.Update(m);
            }
        } catch (Exception e) {
            throw new DaoException(e);
        }

    }

    public void Delete(Precio m) throws DaoException {

        try{
            dao.Delete(m);

        } catch (Exception e) {
            throw new DaoException(e);
        }
    }

    public List<Precio> SelectAll()throws DaoException{
        try {
            return dao.SelectAll();
        }catch (Exception e){
            throw new DaoException(e);
        }
    }
}
