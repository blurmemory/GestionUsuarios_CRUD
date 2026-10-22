package com.rojas.ian.dao;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class UsuarioDao {
    public static final String NOMBRE_ARCHIVO = "usuarios.json";

    private Path ruta;

    public UsuarioDao(){
        this.ruta = Path.of(System.getProperty("user.dir"),NOMBRE_ARCHIVO);
    }

    public void guardarNombre(String nombre){
        try {
            Files.writeString(this.ruta, nombre);
        } catch (IOException e) {
            System.out.println("Error al guardar:" + e.getMessage());
        }
    }

    public String leerNombre(){
        String resultado = "";
        try {
            resultado = Files.readString(this.ruta);
        } catch (IOException e) {
            System.out.println("Error al leer:" + e.getMessage());
        }
        return resultado;
    }
}
