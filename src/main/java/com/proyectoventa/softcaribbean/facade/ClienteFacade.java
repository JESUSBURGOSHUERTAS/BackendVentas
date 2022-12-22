package com.proyectoventa.softcaribbean.facade;

import com.proyectoventa.softcaribbean.database.ManagerConexion;
import com.proyectoventa.softcaribbean.dto.Cliente;

import com.proyectoventa.softcaribbean.exception.FacadeException;
import com.proyectoventa.softcaribbean.mgr.IntClienteMgr;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ClienteFacade implements IntClienteFacade{
    @Autowired
    private IntClienteMgr PM;

    public void Process(Cliente c) throws FacadeException {

        try {
            ManagerConexion.getInstance().Open();
            PM.Save(c);
            ManagerConexion.getInstance().Commit();
        } catch (Exception e) {
            ManagerConexion.getInstance().RollBack();
            throw new FacadeException(e);
        }finally {
            ManagerConexion.getInstance().Close();
        }
    }

    public void Delete(Cliente c) throws FacadeException {

        try {
            ManagerConexion.getInstance().Open();
            PM.Delete(c);
            ManagerConexion.getInstance().Commit();
        } catch (Exception e) {

            throw new FacadeException(e);
        }finally {
            ManagerConexion.getInstance().Close();
        }
    }

    public List<Cliente> SelectAll() throws FacadeException {
        ManagerConexion.getInstance().Open();
        try {
            return PM.SelectAll();
        } catch (Exception e) {
            throw new FacadeException(e);
        }finally {
            ManagerConexion.getInstance().Close();
        }

    }

}
