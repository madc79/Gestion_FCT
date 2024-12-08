package aed.gestion_fct.data;

import java.sql.Date;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Visita {
    private final IntegerProperty id;
    private final ObjectProperty<Date> fecha;
    private final StringProperty observaciones;
    private final IntegerProperty id_tutordocente;
    private final IntegerProperty id_alumno;
    
    public Visita(int id, Date fecha, String observaciones, int id_tutordocente, int id_alumno) {
        
        this.id = new SimpleIntegerProperty(id);
        this.fecha = new SimpleObjectProperty<>(fecha);
        this.observaciones = new SimpleStringProperty(observaciones);
        this.id_tutordocente = new SimpleIntegerProperty(id_tutordocente);
        this.id_alumno = new SimpleIntegerProperty(id_alumno);
        
    }
    
    // Getters

    public IntegerProperty getId() {
        return id;
    }

    public ObjectProperty<Date> getFecha() {
        return fecha;
    }

    public StringProperty getObservaciones() {
        return observaciones;
    }

    public IntegerProperty getId_tutordocente() {
        return id_tutordocente;
    }

    public IntegerProperty getId_alumno() {
        return id_alumno;
    }
    
    
}
