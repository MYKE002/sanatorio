package Modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Procedimiento {
    @Id
    @GeneratedValue
    private long id;
    private String nombre;
    private double costo;

    public Procedimiento() {}

    public Procedimiento(String nombre, double costo) {
        this.nombre = nombre;
        this.costo = costo;
    }
 //constructor
    public Procedimiento(long id, String nombre, double costo) {
        this.id = id;
        this.nombre = nombre;
        this.costo = costo;
    }
// Getters y setters
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }
}
