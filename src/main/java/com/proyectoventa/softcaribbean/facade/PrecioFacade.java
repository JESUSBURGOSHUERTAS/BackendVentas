package com.proyectoventa.softcaribbean.facade;

import com.proyectoventa.softcaribbean.database.ManagerConexion;
import com.proyectoventa.softcaribbean.dto.Precio;

import com.proyectoventa.softcaribbean.exception.FacadeException;
import com.proyectoventa.softcaribbean.mgr.IntPrecioMgr;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PrecioFacade implements IntPrecioFacade {

@Autowired
    private IntPrecioMgr PM;

    public void Process(Precio m) throws FacadeException {

        try {
            ManagerConexion.getInstance().Open();
            PM.Save(m);
            ManagerConexion.getInstance().Commit();
        } catch (Exception e) {
            ManagerConexion.getInstance().RollBack();
            throw new FacadeException(e);
        }finally {
            ManagerConexion.getInstance().Close();
        }
    }

    public void Delete(Precio m) throws FacadeException {

        try {
            ManagerConexion.getInstance().Open();
            PM.Delete(m);
            ManagerConexion.getInstance().Commit();
        } catch (Exception e) {

            throw new FacadeException(e);
        }finally {
            ManagerConexion.getInstance().Close();
        }
    }

    public List<Precio> SelectAll() throws FacadeException {
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
