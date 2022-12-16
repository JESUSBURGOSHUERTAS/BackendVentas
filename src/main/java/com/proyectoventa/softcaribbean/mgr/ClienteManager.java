package com.proyectoventa.softcaribbean.mgr;

import com.proyectoventa.softcaribbean.dao.ClienteDao;

public class ClienteManager {
    private ClienteDao dao;

    public ClienteManager() {
        this.dao = new ClienteDao();
    }
}
