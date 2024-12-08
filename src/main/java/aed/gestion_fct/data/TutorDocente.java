package aed.gestion_fct.data;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class TutorDocente {
    private final IntegerProperty id;
    private final StringProperty nombre;
    private final StringProperty apellidos;
    private final StringProperty telefono;
    private final StringProperty correo;
    
    public TutorDocente(int id, String nombre, String apellidos, String telefono, String correo) {
        this.id = new SimpleIntegerProperty(id);
        this.nombre = new SimpleStringProperty(nombre);
        this.apellidos = new SimpleStringProperty(apellidos);
        this.telefono = new SimpleStringProperty(telefono);
        this.correo = new SimpleStringProperty(correo);
    }
    
    // Getters

    public IntegerProperty getId() {
        return id;
    }

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
    
    
}
