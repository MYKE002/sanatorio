package Modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Seguro {

    @Id
    @GeneratedValue
    private long id;
    private String nombre;

    // Constructor vacío
    public Seguro() {
    }

    // Constructor con nombre
    public Seguro(String nombre) {
        this.nombre = nombre;
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

    // Sobrescribir el método toString
    @Override
    public String toString() {
        return nombre;
    }
}
