package aed.gestion_fct.data;

import java.sql.Date;
import java.time.LocalDate;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author danie
 */
public class Practica {
    private final IntegerProperty id;
    private final ObjectProperty<Date> fecha_inicio;
    private final ObjectProperty<Date> fecha_fin;
    private final StringProperty estado;
    private final IntegerProperty idAlumno;
    
    // Constructor
    public Practica(int id, Date fecha_inicio, Date fecha_fin,
                    String estado, int idAlumno) {
        this.id = new SimpleIntegerProperty(id);
        this.estado = new SimpleStringProperty(estado);
        this.fecha_inicio = new SimpleObjectProperty<>(fecha_inicio);
        this.fecha_fin = new SimpleObjectProperty<>(fecha_fin);
        this.idAlumno = new SimpleIntegerProperty(idAlumno);
    }

    //Getters

    public IntegerProperty getId() {
        return id;
    }

    public ObjectProperty<Date> getFecha_inicio() {
        return fecha_inicio;
    }

    public ObjectProperty<Date> getFecha_fin() {
        return fecha_fin;
    }

    public StringProperty getEstado() {
        return estado;
    }

    public IntegerProperty getIdAlumno() {
        return idAlumno;
    }
    
    
}
