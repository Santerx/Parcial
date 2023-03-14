package com.example.parcial1.entidades;

public class Contactos {

    private int id;
    private String user;
    private String producto;
    private double precio;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String nombre) {
        this.user = user;
    }

    public String getProducto() {
        return producto;
    }

    public void setProducto(String telefono) {
        this.producto = producto;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
}