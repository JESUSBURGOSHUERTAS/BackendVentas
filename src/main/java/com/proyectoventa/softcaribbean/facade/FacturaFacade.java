package com.proyectoventa.softcaribbean.facade;

import com.proyectoventa.softcaribbean.database.ManagerConexion;

import com.proyectoventa.softcaribbean.dto.Factura;
import com.proyectoventa.softcaribbean.exception.FacadeException;
import com.proyectoventa.softcaribbean.mgr.IntFacturaMgr;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class FacturaFacade implements IntFacturaFacade{
    @Autowired
    private IntFacturaMgr PM;

    public void Process(Factura f) throws FacadeException {

        try {
            ManagerConexion.getInstance().Open();
            PM.Save(f);
            ManagerConexion.getInstance().Commit();
        } catch (Exception e) {
            ManagerConexion.getInstance().RollBack();
            throw new FacadeException(e);
        }finally {
            ManagerConexion.getInstance().Close();
        }
    }

    public void Delete(Factura f) throws FacadeException {

        try {
            ManagerConexion.getInstance().Open();
            PM.Delete(f);
            ManagerConexion.getInstance().Commit();
        } catch (Exception e) {

            throw new FacadeException(e);
        }finally {
            ManagerConexion.getInstance().Close();
        }
    }

    public List<Factura> SelectAll() throws FacadeException {
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
