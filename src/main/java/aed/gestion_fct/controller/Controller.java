package aed.gestion_fct.controller;

import aed.gestion_fct.data.*;
import aed.gestion_fct.model.*;
import java.awt.Button;
import java.sql.Date;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

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
    private TableColumn<Comentario, Integer> ComentarioAlumno;

    @FXML
    private TableColumn<Comentario, String> ComentarioDetalle;

    @FXML
    private TableColumn<Comentario, Date> ComentarioFecha;

    @FXML
    private TableColumn<Comentario, Integer> ComentarioIdComentario;

    @FXML
    private TableView<Comentario> ComentarioTableView;

    @FXML
    private TableColumn<Comentario, Integer> ComentarioTutorEmpresa;

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
    private TableColumn<Empresa, String> EmpresaCorreo;

    @FXML
    private TableColumn<Empresa, String> EmpresaDireccion;

    @FXML
    private TableColumn<Empresa, Integer> EmpresaIdEmpresa;

    @FXML
    private TableColumn<Empresa, String> EmpresaNombre;

    @FXML
    private TableColumn<Empresa, Integer> EmpresaPlazas;

    @FXML
    private TableView<Empresa> EmpresaTableView;

    @FXML
    private TableColumn<Empresa, String> EmpresaTelefono;

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
    private TableColumn<Practica, Integer> PracticaAlumno;

    @FXML
    private TableColumn<Practica, String> PracticaEstado;

    @FXML
    private TableColumn<Practica, Date> PracticaFechaFin;

    @FXML
    private TableColumn<Practica, Date> PracticaFechaInicio;

    @FXML
    private TableColumn<Practica, Integer> PracticaIdPractica;

    @FXML
    private TableView<Practica> PracticaTableView;

    @FXML
    private TableColumn<Programa, Integer> ProgramaIdPrograma;

    @FXML
    private TableColumn<Programa, String> ProgramaNombre;

    @FXML
    private TableView<Programa> ProgramaTableView;

    @FXML
    private TableColumn<TutorDocente, String> TutorDocenteApellidos;

    @FXML
    private TableColumn<TutorDocente, String> TutorDocenteCorreo;

    @FXML
    private TableColumn<TutorDocente, Integer> TutorDocenteIdTutorDocente;

    @FXML
    private TableColumn<TutorDocente, String> TutorDocenteNombre;

    @FXML
    private TableView<TutorDocente> TutorDocenteTableView;

    @FXML
    private TableColumn<TutorDocente, String> TutorDocenteTelefono;

    @FXML
    private TableColumn<TutorEmpresa, String> TutorEmpresaApellidos;

    @FXML
    private TableColumn<TutorEmpresa, String> TutorEmpresaCorreo;

    @FXML
    private TableColumn<TutorEmpresa, Integer> TutorEmpresaEmpresa;

    @FXML
    private TableColumn<TutorEmpresa, Integer> TutorEmpresaIdTutorEmpresa;

    @FXML
    private TableColumn<TutorEmpresa, String> TutorEmpresaNombre;

    @FXML
    private TableView<TutorEmpresa> TutorEmpresaTableView;

    @FXML
    private TableColumn<TutorEmpresa, String> TutorEmpresaTelefono;

    @FXML
    private TableColumn<Visita, Integer> VisitaAsignacion; // Mal nombre, debería ser VisitTutorDocente

    @FXML
    private TableColumn<Visita, Date> VisitaFecha;

    @FXML
    private TableColumn<Visita, Integer> VisitaIdAlumno;

    @FXML
    private TableColumn<Visita, Integer> VisitaIdVisita;

    @FXML
    private TableColumn<Visita, String> VisitaObservaciones;

    @FXML
    private TableView<Visita> VisitaTableView;

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
        PracticaIdPractica.setCellValueFactory(cellData -> cellData.getValue().getId().asObject());
        PracticaFechaInicio.setCellValueFactory(cellData -> cellData.getValue().getFecha_inicio());
        PracticaFechaFin.setCellValueFactory(cellData -> cellData.getValue().getFecha_fin());
        PracticaEstado.setCellValueFactory(cellData -> cellData.getValue().getEstado());
        PracticaAlumno.setCellValueFactory(cellData -> cellData.getValue().getIdAlumno().asObject());
        
        ObservableList<Practica> listaPracticas = PracticaCRUD.leerPractica();
        PracticaTableView.setItems(listaPracticas);
        
        // Tabla empresa
        EmpresaIdEmpresa.setCellValueFactory(cellData -> cellData.getValue().getId_empresa().asObject());
        EmpresaNombre.setCellValueFactory(cellData -> cellData.getValue().getNombre());
        EmpresaCorreo.setCellValueFactory(cellData -> cellData.getValue().getCorreo());
        EmpresaDireccion.setCellValueFactory(cellData -> cellData.getValue().getDireccion());
        EmpresaTelefono.setCellValueFactory(cellData -> cellData.getValue().getTelefono());
        EmpresaPlazas.setCellValueFactory(cellData -> cellData.getValue().getPlazas().asObject());
        
        ObservableList<Empresa> listaEmpresas = EmpresaCRUD.leerEmpresa();
        EmpresaTableView.setItems(listaEmpresas);
        
        // Tabla tutordocente
       TutorDocenteIdTutorDocente.setCellValueFactory(cellData -> cellData.getValue().getId().asObject());
       TutorDocenteNombre.setCellValueFactory(cellData -> cellData.getValue().getNombre());
       TutorDocenteApellidos.setCellValueFactory(cellData -> cellData.getValue().getApellidos());
       TutorDocenteTelefono.setCellValueFactory(cellData -> cellData.getValue().getTelefono());
       TutorDocenteCorreo.setCellValueFactory(cellData -> cellData.getValue().getCorreo());
       
       ObservableList<TutorDocente> listaTutoresDocentes = TutorDocenteCRUD.leerTutorDocente();
       TutorDocenteTableView.setItems(listaTutoresDocentes);
       
       //Tabla tutorempresa
       TutorEmpresaIdTutorEmpresa.setCellValueFactory(cellData -> cellData.getValue().getId().asObject());
       TutorEmpresaNombre.setCellValueFactory(cellData -> cellData.getValue().getNombre());
       TutorEmpresaApellidos.setCellValueFactory(cellData -> cellData.getValue().getApellidos());
       TutorEmpresaTelefono.setCellValueFactory(cellData -> cellData.getValue().getTelefono());
       TutorEmpresaCorreo.setCellValueFactory(cellData -> cellData.getValue().getCorreo());
       TutorEmpresaEmpresa.setCellValueFactory(cellData -> cellData.getValue().getId_empresa().asObject());
       
       ObservableList<TutorEmpresa> listaTutoresEmpresa = TutorEmpresaCRUD.leerTutorEmpresa();
       TutorEmpresaTableView.setItems(listaTutoresEmpresa);
       
       //Tabla programa
       ProgramaIdPrograma.setCellValueFactory(cellData -> cellData.getValue().getId().asObject());
       ProgramaNombre.setCellValueFactory(cellData -> cellData.getValue().getNombre());
       
       ObservableList<Programa> listaProgramas = ProgramaCRUD.leerPrograma();
       ProgramaTableView.setItems(listaProgramas);
       
       //Tabla visita
       VisitaIdVisita.setCellValueFactory(cellData -> cellData.getValue().getId().asObject());
       VisitaFecha.setCellValueFactory(cellData -> cellData.getValue().getFecha());
       VisitaObservaciones.setCellValueFactory(cellData -> cellData.getValue().getObservaciones());
       VisitaAsignacion.setCellValueFactory(cellData -> cellData.getValue().getId_tutordocente().asObject());
       VisitaIdAlumno.setCellValueFactory(cellData -> cellData.getValue().getId_alumno().asObject());
       
       ObservableList<Visita> listaVisitas = VisitaCRUD.leerVisita();
       VisitaTableView.setItems(listaVisitas);
       
       //Tabla comentario
       ComentarioIdComentario.setCellValueFactory(cellData -> cellData.getValue().getId().asObject());
       ComentarioFecha.setCellValueFactory(cellData -> cellData.getValue().getFecha());
       ComentarioDetalle.setCellValueFactory(cellData -> cellData.getValue().getDetalle());
       ComentarioTutorEmpresa.setCellValueFactory(cellData -> cellData.getValue().getId_tutorempresa().asObject());
       ComentarioAlumno.setCellValueFactory(cellData -> cellData.getValue().getId_alumno().asObject());
       
       ObservableList<Comentario> listaComentarios = ComentarioCRUD.leerComentario();
       ComentarioTableView.setItems(listaComentarios);
    }
    
    @FXML
    private void onCrearAlumno() {
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
    private void onEliminarAlumno() {
        Alumno alumnoSeleccionado = AlumnoTableView.getSelectionModel().getSelectedItem();
        if (alumnoSeleccionado != null) {
            int id = alumnoSeleccionado.getId().get();
            AlumnoCRUD.borrarAlumno(id);
            actualizarTabla();
        }
    }
    
    private void actualizarTabla() {
        ObservableList<Alumno> listaAlumnos = AlumnoCRUD.leerAlumno();
        AlumnoTableView.setItems(listaAlumnos);
    }
    
    @FXML
    private void agregarPractica() {
        
    }
    
}
