package com.proyectoventa.softcaribbean.controller;

import com.proyectoventa.softcaribbean.dto.Message;


import com.proyectoventa.softcaribbean.dto.Vendedor;
import com.proyectoventa.softcaribbean.exception.ControllerException;
import com.proyectoventa.softcaribbean.facade.IntVendedorFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class VendedorController {
    @Autowired
    private IntVendedorFacade PF;
        @PostMapping("vendedor/save")
    public ResponseEntity<Message> Process(@RequestBody Vendedor v) throws ControllerException {
        Message message = new Message("0", "Succesfull Save", null);
        try {
            PF.Process(v);
        } catch (Exception e) {
            message.setCodigo("1");
            message.setMessage("Error en guardar" + e.getMessage());
            throw new ControllerException(e);
        }
        return ResponseEntity.ok(message);
    }

    @PostMapping("vendedor/delete")
    public ResponseEntity<Message> Delete(@RequestBody Vendedor v)throws ControllerException{
        Message message = new Message("0", "Borrado ok", null);
        try {
            PF.Delete(v);
        } catch (Exception e) {
            message.setCodigo("1");
            message.setMessage("Error en borrar" + e.getMessage());
            throw new ControllerException(e);
        }
        return ResponseEntity.ok(message);
    }

    @GetMapping("vendedor/getall")
    public ResponseEntity<Message> SelectAll()throws ControllerException{
        Message message = new Message("0", "Succesfull All Data", null);
        try {
            List<Vendedor> list =  PF.SelectAll();
            message.setData(list);
        } catch (Exception e) {
            throw new ControllerException(e);
        }
        return ResponseEntity.ok(message);
    }
}
