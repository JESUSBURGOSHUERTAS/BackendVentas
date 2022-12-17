package com.proyectoventa.softcaribbean.facade;

import com.proyectoventa.softcaribbean.database.ManagerConexion;

import com.proyectoventa.softcaribbean.dto.Vendedor;
import com.proyectoventa.softcaribbean.exception.FacadeException;
import com.proyectoventa.softcaribbean.mgr.IntVendedorMgr;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class VendedorFacade implements IntVendedorFacade {
    @Autowired
    private IntVendedorMgr PM;

    public void Process(Vendedor v) throws FacadeException {

        try {
            ManagerConexion.getInstance().Open();
            PM.Save(v);
            ManagerConexion.getInstance().Commit();
        } catch (Exception e) {
            ManagerConexion.getInstance().RollBack();
            throw new FacadeException(e);
        }finally {
            ManagerConexion.getInstance().Close();
        }
    }

    public void Delete(Vendedor v) throws FacadeException {

        try {
            ManagerConexion.getInstance().Open();
            PM.Delete(v);
            ManagerConexion.getInstance().Commit();
        } catch (Exception e) {

            throw new FacadeException(e);
        }finally {
            ManagerConexion.getInstance().Close();
        }
    }
    public List<Vendedor> SelectAll() throws FacadeException {
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
