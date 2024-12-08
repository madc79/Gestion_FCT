package aed.gestion_fct.data;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Programa {
    
    private final IntegerProperty id;
    private final StringProperty nombre;

    public Programa(int id, String nombre) {
        
        this.id = new SimpleIntegerProperty(id);
        this.nombre = new SimpleStringProperty(nombre);
                
    }
    
    // Getters

    public IntegerProperty getId() {
        return id;
    }

    public StringProperty getNombre() {
        return nombre;
    }

    
    
}
