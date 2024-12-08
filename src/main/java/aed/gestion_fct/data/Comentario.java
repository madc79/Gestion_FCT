package aed.gestion_fct.data;

import java.sql.Date;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Comentario {
    
    private final IntegerProperty id;
    private final ObjectProperty<Date> fecha;
    private final StringProperty detalle;
    private final IntegerProperty id_tutorempresa;
    private final IntegerProperty id_alumno;
    
    // Constructor
    public Comentario(int id, Date fecha, String detalle, int id_tutorempresa, int id_alumno) {
        
        this.id = new SimpleIntegerProperty(id);
        this.fecha = new SimpleObjectProperty<>(fecha);
        this.detalle = new SimpleStringProperty(detalle);
        this.id_tutorempresa = new SimpleIntegerProperty(id_tutorempresa);
        this.id_alumno = new SimpleIntegerProperty(id_alumno);
        
    }
    
    // Getters

    public IntegerProperty getId() {
        return id;
    }

    public ObjectProperty<Date> getFecha() {
        return fecha;
    }

    public StringProperty getDetalle() {
        return detalle;
    }

    public IntegerProperty getId_tutorempresa() {
        return id_tutorempresa;
    }

    public IntegerProperty getId_alumno() {
        return id_alumno;
    }

    
    
    
    
}
