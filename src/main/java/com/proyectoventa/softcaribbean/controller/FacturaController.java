package com.proyectoventa.softcaribbean.controller;

import com.proyectoventa.softcaribbean.dto.Factura;
import com.proyectoventa.softcaribbean.dto.Message;
import com.proyectoventa.softcaribbean.exception.ControllerException;
import com.proyectoventa.softcaribbean.facade.IntFacturaFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class FacturaController {
    @Autowired
    private IntFacturaFacade PF;

    @PostMapping("factura/save")
    public ResponseEntity<Message> Process(@RequestBody Factura f) throws ControllerException {
        Message message = new Message("0", "Succesfull Save", null);
        try {
            PF.Process(f);
        } catch (Exception e) {
            message.setCodigo("1");
            message.setMessage("Error en guardar" + e.getMessage());
            throw new ControllerException(e);
        }
        return ResponseEntity.ok(message);
    }

    @PostMapping("factura/delete")
    public ResponseEntity<Message> Delete(@RequestBody Factura f)throws ControllerException{
        Message message = new Message("0", "Borrado ok", null);
        try {
            PF.Delete(f);
        } catch (Exception e) {
            message.setCodigo("1");
            message.setMessage("Error en borrar" + e.getMessage());
            throw new ControllerException(e);
        }
        return ResponseEntity.ok(message);
    }

    @GetMapping("factura/getall")
    public ResponseEntity<Message> SelectAll()throws ControllerException{
        Message message = new Message("0", "Succesfull All Data", null);
        try {
            List<Factura> list =  PF.SelectAll();
            message.setData(list);
        } catch (Exception e) {
            throw new ControllerException(e);
        }
        return ResponseEntity.ok(message);
    }
}
