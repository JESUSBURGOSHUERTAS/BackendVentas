package com.proyectoventa.softcaribbean.mgr;

import com.proyectoventa.softcaribbean.dao.IntDao;
import com.proyectoventa.softcaribbean.dao.ProductoDao;
import com.proyectoventa.softcaribbean.dto.Productos;
import com.proyectoventa.softcaribbean.exception.DaoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class ProductoManager implements IntMgr {
    @Autowired
    private IntDao dao;

    public void Save(Productos p) throws DaoException {
        Productos tp = dao.SelectById(p);
        try {
            if (tp == null){
                dao.Insert(p);
            }else{
                dao.Update(p);
            }
        }catch (Exception e){
            throw new DaoException(e);
        }

    }
    public void Delete(Productos p)throws DaoException{
        Productos tp = dao.SelectById(p);
        try{
            if (tp != null){
                dao.Delete(p);
            }
        }
        catch (Exception e){
            throw new DaoException(e);
        }
    }
    public List<Productos> SelectAll()throws DaoException{
        try {
            return dao.SelectAll();
        }catch (Exception e){
            throw new DaoException(e);
        }
    }
}

