package com.proyectoventa.softcaribbean.controller;

import com.proyectoventa.softcaribbean.dto.Message;

import com.proyectoventa.softcaribbean.dto.Precio;

import com.proyectoventa.softcaribbean.exception.ControllerException;
import com.proyectoventa.softcaribbean.facade.IntPrecioFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class PrecioController {

    @Autowired
    private IntPrecioFacade PF;

    @PostMapping("precio/save")
    public ResponseEntity<Message> Process(@RequestBody Precio m) throws ControllerException {
        Message message = new Message("0", "Succesfull Save", null);
        try {
            PF.Process(m);
        } catch (Exception e) {
            message.setCodigo("1");
            message.setMessage("Error en guardar" + e.getMessage());
            throw new ControllerException(e);
        }
        return ResponseEntity.ok(message);
    }

    @PostMapping("precio/delete")
    public ResponseEntity<Message> Delete(@RequestBody Precio m)throws ControllerException{
        Message message = new Message("0", "Borrado ok", null);
        try {
            PF.Delete(m);
        } catch (Exception e) {
            message.setCodigo("1");
            message.setMessage("Error en borrar" + e.getMessage());
            throw new ControllerException(e);
        }
        return ResponseEntity.ok(message);
    }

    @GetMapping("precio/getall")
    public ResponseEntity<Message> SelectAll()throws ControllerException{
        Message message = new Message("0", "Succesfull All Data", null);
        try {
            List<Precio> list =  PF.SelectAll();
            message.setData(list);
        } catch (Exception e) {
            throw new ControllerException(e);
        }
        return ResponseEntity.ok(message);
    }

}
