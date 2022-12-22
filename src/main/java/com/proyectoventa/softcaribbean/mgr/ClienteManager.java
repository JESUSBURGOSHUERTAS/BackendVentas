package com.proyectoventa.softcaribbean.mgr;


import com.proyectoventa.softcaribbean.dao.IntClienteDao;
import com.proyectoventa.softcaribbean.dto.Cliente;

import com.proyectoventa.softcaribbean.exception.DaoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ClienteManager implements IntClienteMgr {

    @Autowired
    private IntClienteDao dao;
    public void Save(Cliente c) throws DaoException {
        Cliente tp = dao.SelectById(c);
        try {
            if (tp == null) {
                dao.Insert(c);
            } else {
                dao.Update(c);
            }
        } catch (Exception e) {
            throw new DaoException(e);
        }

    }

    public void Delete(Cliente c) throws DaoException {

        try{
            dao.Delete(c);

        } catch (Exception e) {
            throw new DaoException(e);
        }
    }

    public List<Cliente> SelectAll()throws DaoException{
        try {
            return dao.SelectAll();
        }catch (Exception e){
            throw new DaoException(e);
        }
    }

}
