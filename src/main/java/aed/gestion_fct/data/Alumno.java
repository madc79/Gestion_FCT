package aed.gestion_fct.data;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author danie
 */
public class Alumno {

    private final StringProperty nombre;
    private final StringProperty apellidos;
    private final StringProperty telefono;
    private final StringProperty correo;
    private final IntegerProperty practica;
    private final IntegerProperty programa;
    private final IntegerProperty tutorDocente;
    private final IntegerProperty tutorEmpresa;
    private final IntegerProperty empresa;

    // Constructor
    public Alumno(String nombre, String apellidos, String telefono,
            String correo, int practica, int programa, int tutorDocente,
            int tutorEmpresa, int empresa) {
        this.nombre = new SimpleStringProperty(nombre);
        this.apellidos = new SimpleStringProperty(apellidos);
        this.telefono = new SimpleStringProperty(telefono);
        this.correo = new SimpleStringProperty(correo);
        this.practica = new SimpleIntegerProperty(practica);
        this.programa = new SimpleIntegerProperty(programa);
        this.tutorDocente = new SimpleIntegerProperty(tutorDocente);
        this.tutorEmpresa = new SimpleIntegerProperty(tutorEmpresa);
        this.empresa = new SimpleIntegerProperty(empresa);
    }

    // Getters 

    public StringProperty getNombre() {
        return nombre;
    }

    public StringProperty getApellidos() {
        return apellidos;
    }

    public StringProperty getTelefono() {
        return telefono;
    }

    public StringProperty getCorreo() {
        return correo;
    }

    public IntegerProperty getPractica() {
        return practica;
    }

    public IntegerProperty getPrograma() {
        return programa;
    }

    public IntegerProperty getTutorDocente() {
        return tutorDocente;
    }

    public IntegerProperty getTutorEmpresa() {
        return tutorEmpresa;
    }

    public IntegerProperty getEmpresa() {
        return empresa;
    }
    
    

}
