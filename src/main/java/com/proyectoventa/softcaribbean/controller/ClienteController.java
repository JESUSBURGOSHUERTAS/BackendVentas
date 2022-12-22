package com.proyectoventa.softcaribbean.controller;

import com.proyectoventa.softcaribbean.dto.Cliente;
import com.proyectoventa.softcaribbean.dto.Message;

import com.proyectoventa.softcaribbean.exception.ControllerException;
import com.proyectoventa.softcaribbean.facade.IntClienteFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ClienteController {
    @Autowired
    private IntClienteFacade PF;

    @PostMapping("cliente/save")
    public ResponseEntity<Message> Process(@RequestBody Cliente c) throws ControllerException {
        Message message = new Message("0", "Succesfull Save", null);
        try {
            PF.Process(c);
        } catch (Exception e) {
            message.setCodigo("1");
            message.setMessage("Error en guardar" + e.getMessage());
            throw new ControllerException(e);
        }
        return ResponseEntity.ok(message);
    }

    @PostMapping("cliente/delete")
    public ResponseEntity<Message> Delete(@RequestBody Cliente c)throws ControllerException{
        Message message = new Message("0", "Borrado ok", null);
        try {
            PF.Delete(c);
        } catch (Exception e) {
            message.setCodigo("1");
            message.setMessage("Error en borrar" + e.getMessage());
            throw new ControllerException(e);
        }
        return ResponseEntity.ok(message);
    }

    @GetMapping("cliente/getall")
    public ResponseEntity<Message> SelectAll()throws ControllerException{
        Message message = new Message("0", "Succesfull All Data", null);
        try {
            List<Cliente> list =  PF.SelectAll();
            message.setData(list);
        } catch (Exception e) {
            throw new ControllerException(e);
        }
        return ResponseEntity.ok(message);
    }
}
