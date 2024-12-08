/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package aed.gestion_fct.controller;

import aed.gestion_fct.Alumno;
import aed.gestion_fct.model.AlumnoCRUD;
import java.awt.Button;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;


/**
 *
 * @author danie
 */
public class Controller {
    
    @FXML
    private TableColumn<Alumno, String> AlumnoApellido;

    @FXML
    private TableColumn<Alumno, String> AlumnoCorreo;

    @FXML
    private TableColumn<Alumno, Integer> AlumnoEmpresa;

    @FXML
    private TableColumn<Alumno, Integer> AlumnoIdAlumno;

    @FXML
    private TableColumn<Alumno, String> AlumnoNombre;

    @FXML
    private TableColumn<Alumno, Integer> AlumnoPractica;

    @FXML
    private TableColumn<Alumno, Integer> AlumnoPrograma;

    @FXML
    private TableView<Alumno> AlumnoTableView;

    @FXML
    private TableColumn<Alumno, String> AlumnoTelefono;

    @FXML
    private TableColumn<Alumno, Integer> AlumnoTutorDocente;

    @FXML
    private TableColumn<Alumno, Integer> AlumnoTutorEmpresa;

    @FXML
    private Button BuscarAlumno;

    @FXML
    private Button BuscarComentario;

    @FXML
    private Button BuscarEmpresa;

    @FXML
    private Button BuscarPractica;

    @FXML
    private Button BuscarPrograma;

    @FXML
    private Button BuscarTutorDocente;

    @FXML
    private Button BuscarTutorEmpresa;

    @FXML
    private Button BuscarVisita;

    @FXML
    private TableColumn ComentarioAlumno;

    @FXML
    private TableColumn ComentarioDetalle;

    @FXML
    private TableColumn ComentarioFecha;

    @FXML
    private TableColumn ComentarioIdComentario;

    @FXML
    private TableView ComentarioTableView;

    @FXML
    private TableColumn ComentarioTutorEmpresa;

    @FXML
    private Button CrearAlumno;

    @FXML
    private Button CrearComentario;

    @FXML
    private Button CrearEmpresa;

    @FXML
    private Button CrearPractica;

    @FXML
    private Button CrearPrograma;

    @FXML
    private Button CrearTutorDocente;

    @FXML
    private Button CrearTutorEmpresa;

    @FXML
    private Button CrearVisita;

    @FXML
    private Button EliminarAlumno;

    @FXML
    private Button EliminarComentario;

    @FXML
    private Button EliminarEmpresa;

    @FXML
    private Button EliminarPractica;

    @FXML
    private Button EliminarPrograma;

    @FXML
    private Button EliminarTutorDocente;

    @FXML
    private Button EliminarTutorEmpresa;

    @FXML
    private Button EliminarVisita;

    @FXML
    private TableColumn EmpresaCorreo;

    @FXML
    private TableColumn EmpresaDireccion;

    @FXML
    private TableColumn EmpresaIdEmpresa;

    @FXML
    private TableColumn EmpresaNombre;

    @FXML
    private TableColumn EmpresaPlazas;

    @FXML
    private TableView EmpresaTableView;

    @FXML
    private TableColumn EmpresaTelefono;

    @FXML
    private Button ModificarAlumno;

    @FXML
    private Button ModificarComentario;

    @FXML
    private Button ModificarEmpresa;

    @FXML
    private Button ModificarPractica;

    @FXML
    private Button ModificarPrograma;

    @FXML
    private Button ModificarTutorDocente;

    @FXML
    private Button ModificarTutorEmpresa;

    @FXML
    private Button ModificarVisita;

    @FXML
    private TableColumn PracticaAlumno;

    @FXML
    private TableColumn PracticaEstado;

    @FXML
    private TableColumn PracticaFechaFin;

    @FXML
    private TableColumn PracticaFechaInicio;

    @FXML
    private TableColumn PracticaIdPractica;

    @FXML
    private TableView PracticaTableView;

    @FXML
    private TableColumn ProgramaIdPrograma;

    @FXML
    private TableColumn ProgramaNombre;

    @FXML
    private TableView ProgramaTableView;

    @FXML
    private TableColumn TutorDocenteApellidos;

    @FXML
    private TableColumn TutorDocenteCorreo;

    @FXML
    private TableColumn TutorDocenteIdTutorDocente;

    @FXML
    private TableColumn TutorDocenteNombre;

    @FXML
    private TableView TutorDocenteTableView;

    @FXML
    private TableColumn TutorDocenteTelefono;

    @FXML
    private TableColumn TutorEmpresaApellidos;

    @FXML
    private TableColumn TutorEmpresaCorreo;

    @FXML
    private TableColumn TutorEmpresaEmpresa;

    @FXML
    private TableColumn TutorEmpresaIdTutorEmpresa;

    @FXML
    private TableColumn TutorEmpresaNombre;

    @FXML
    private TableView TutorEmpresaTableView;

    @FXML
    private TableColumn TutorEmpresaTelefono;

    @FXML
    private TableColumn VisitaAsignacion;

    @FXML
    private TableColumn VisitaFecha;

    @FXML
    private TableColumn VisitaIdAlumno;

    @FXML
    private TableColumn VisitaIdVisita;

    @FXML
    private TableColumn VisitaObservaciones;

    @FXML
    private TableView VisitaTableView;

    @FXML
    private TabPane root;
    
    @FXML
    public void initialize() {
        
        // Tabla alumno
        AlumnoIdAlumno.setCellValueFactory(cellData -> cellData.getValue().getId().asObject());
        AlumnoNombre.setCellValueFactory(cellData -> cellData.getValue().getNombre());
        AlumnoApellido.setCellValueFactory(cellData -> cellData.getValue().getApellidos());
        AlumnoTelefono.setCellValueFactory(cellData -> cellData.getValue().getTelefono());
        AlumnoCorreo.setCellValueFactory(cellData -> cellData.getValue().getCorreo());
        AlumnoPractica.setCellValueFactory(cellData -> cellData.getValue().getId().asObject());
        AlumnoPrograma.setCellValueFactory(cellData -> cellData.getValue().getId().asObject());
        AlumnoTutorDocente.setCellValueFactory(cellData -> cellData.getValue().getId().asObject());
        AlumnoTutorEmpresa.setCellValueFactory(cellData -> cellData.getValue().getId().asObject());
        AlumnoEmpresa.setCellValueFactory(cellData -> cellData.getValue().getId().asObject());
        
        ObservableList<Alumno> listaAlumnos = AlumnoCRUD.leerAlumno();
        AlumnoTableView.setItems(listaAlumnos);
        
        // Tabla practica

        
        
    }
    
    @FXML
    private void agregarAlumno() {
        String nombre = AlumnoNombre.getText();
        String apellidos = AlumnoApellido.getText();
        String telefono = AlumnoTelefono.getText();
        String correo = AlumnoCorreo.getText();
        int practica = Integer.parseInt(AlumnoPractica.getText());
        int programa = Integer.parseInt(AlumnoPrograma.getText());
        int tutorDocente = Integer.parseInt(AlumnoTutorDocente.getText());
        int tutorEmpresa = Integer.parseInt(AlumnoTutorEmpresa.getText());
        int empresa = Integer.parseInt(AlumnoEmpresa.getText());
        
        AlumnoCRUD.crearAlumno(nombre, apellidos, telefono, correo, practica, programa, 
                tutorDocente, tutorEmpresa, empresa);
    }
    
    @FXML
    private void eliminarAlumno() {
        Alumno alumnoSeleccionado = AlumnoTableView.getSelectionModel().getSelectedItem();
        if (alumnoSeleccionado != null) {
            int id = alumnoSeleccionado.getId();
            AlumnoCRUD.borrarAlumno(id);
            actualizarTabla();
        }
    }
    
    private void actualizarTabla() {
        ObservableList<Alumno> listaAlumnos = AlumnoCRUD.leerAlumno();
        AlumnoTableView.setItems(listaAlumnos);
    }
    
}
