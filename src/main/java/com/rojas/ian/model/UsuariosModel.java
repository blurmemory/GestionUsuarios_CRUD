package com.rojas.ian.model;

import java.util.ArrayList;
import java.util.List;

public class UsuariosModel {
    private final List<Usuario> usuarios = new ArrayList<>();
    private int siguienteId = 1;

    public Usuario agregar(String nombre, String profesion) {
        Usuario usuario = new Usuario(siguienteId++, nombre, profesion);
        usuarios.add(usuario);
        return usuario;
    }

    public List<Usuario> listar() {
        return new ArrayList<>(usuarios);
    }

    public void actualizar(Usuario usuario, String nombre, String profesion) {
        usuario.setNombre(nombre);
        usuario.setProfesion(profesion);
    }

    public boolean eliminar(Usuario usuario) {
        return usuarios.remove(usuario);
    }
}
