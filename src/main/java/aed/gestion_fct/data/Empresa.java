package aed.gestion_fct.data;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Empresa {
    
    private final IntegerProperty id_empresa;
    private final StringProperty nombre;
    private final StringProperty correo;
    private final StringProperty direccion;
    private final StringProperty telefono;
    private final IntegerProperty plazas;
    
    
    public Empresa(int id_empresa, String nombre, String correo, String direccion, String telefono, int plazas) {
        
        this.id_empresa = new SimpleIntegerProperty(id_empresa);
        this.nombre = new SimpleStringProperty(nombre);
        this.correo = new SimpleStringProperty(correo);
        this.direccion = new SimpleStringProperty(direccion);
        this.telefono = new SimpleStringProperty(telefono);
        this.plazas = new SimpleIntegerProperty(plazas);
        
        
    }
    
    // Getters

    public IntegerProperty getId_empresa() {
        return id_empresa;
    }

    public StringProperty getNombre() {
        return nombre;
    }

    public StringProperty getCorreo() {
        return correo;
    }

    public StringProperty getDireccion() {
        return direccion;
    }

    public StringProperty getTelefono() {
        return telefono;
    }

    public IntegerProperty getPlazas() {
        return plazas;
    }

    
    
    
}
