package com.rojas.ian.model;

public class Usuario {
    private final int id;
    private String nombre;
    private String profesion;

    public Usuario(int id, String nombre, String profesion) {
        this.id = id;
        this.nombre = nombre;
        this.profesion = profesion;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getProfesion() {
        return profesion;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setProfesion(String profesion) {
        this.profesion = profesion;
    }
}
