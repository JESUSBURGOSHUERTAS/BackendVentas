package com.proyectoventa.softcaribbean.dto;

public class Message {
    private String codigo;
    private String message;
    private Object data;

    public Message(String codigo, String message, Object data) {
        this.codigo = codigo;
        this.message = message;
        this.data = data;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
