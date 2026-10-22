package com.rojas.ian.controller;

import com.rojas.ian.dao.UsuarioDao;
import com.rojas.ian.model.Usuario;
import com.rojas.ian.model.UsuariosModel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class UsuariosController {

    private UsuarioDao usuarioDao = new UsuarioDao();
    @FXML
    private TextField txtNombre;
    @FXML
    private TextField txtProfesion;
    @FXML
    private TableView<Usuario> tablaUsuarios;
    @FXML
    private TableColumn<Usuario, Integer> colId;
    @FXML
    private TableColumn<Usuario, String> colNombre;
    @FXML
    private TableColumn<Usuario, String> colProfesion;
    private final UsuariosModel modelo = new UsuariosModel();
    private final ObservableList<Usuario> filas = FXCollections.observableArrayList();

    @FXML
    private void initialize() {
        colId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        colProfesion.setCellValueFactory(new PropertyValueFactory<>("profesion"));
        tablaUsuarios.setItems(filas);
        tablaUsuarios.getSelectionModel().selectedItemProperty().addListener((obs, anterior, actual) -> {
            if (actual != null) {
                txtNombre.setText(actual.getNombre());
                txtProfesion.setText(actual.getProfesion());
            }
        });
    }

    @FXML
    private void agregar() {
        String nombre = txtNombre.getText().trim();
        String profesion = txtProfesion.getText().trim();
        if (nombre.isEmpty() || profesion.isEmpty()) return;
        modelo.agregar(nombre, profesion);
        refrescar();
        limpiarCampos();
    }

    @FXML
    private void actualizar() {
        Usuario seleccionado = tablaUsuarios.getSelectionModel().getSelectedItem();
        if (seleccionado == null) return;
        String nombre = txtNombre.getText().trim();
        String profesion = txtProfesion.getText().trim();
        if (nombre.isEmpty() || profesion.isEmpty()) return;
        modelo.actualizar(seleccionado, nombre, profesion);
        refrescar();
        limpiarCampos();
    }

    @FXML
    private void eliminar() {
        Usuario seleccionado = tablaUsuarios.getSelectionModel().getSelectedItem();
        if (seleccionado == null) return;
        modelo.eliminar(seleccionado);
        refrescar();
        limpiarCampos();
    }

    @FXML
    private void limpiar() {
        limpiarCampos();
    }

    private void refrescar() {
        filas.setAll(modelo.listar());
    }

    private void limpiarCampos() {
        tablaUsuarios.getSelectionModel().clearSelection();
        txtNombre.clear();
        txtProfesion.clear();
    }
}
