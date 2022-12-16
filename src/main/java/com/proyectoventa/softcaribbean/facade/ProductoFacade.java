package com.proyectoventa.softcaribbean.facade;

import com.proyectoventa.softcaribbean.database.ManagerConexion;
import com.proyectoventa.softcaribbean.dto.Productos;
import com.proyectoventa.softcaribbean.exception.FacadeException;
import com.proyectoventa.softcaribbean.mgr.IntMgr;
import com.proyectoventa.softcaribbean.mgr.ProductoManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class ProductoFacade implements IntFacade{
    @Autowired
    private IntMgr PM;
    public void Process(Productos p) throws FacadeException {
        ManagerConexion.getInstance().Open();
        try {
            PM.Save(p);
            ManagerConexion.getInstance().Commit();
        } catch (Exception e) {
            ManagerConexion.getInstance().RollBack();
            throw new FacadeException(e);
        }finally {
            ManagerConexion.getInstance().Close();
        }
    }
    public void Delete(Productos p) throws FacadeException {

        try {
            ManagerConexion.getInstance().Open();
            PM.Delete(p);
            ManagerConexion.getInstance().Commit();
        } catch (Exception e) {

            throw new FacadeException(e);
        }finally {
            ManagerConexion.getInstance().Close();
        }
    }
    public List<Productos> SelectAll() throws FacadeException {
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
