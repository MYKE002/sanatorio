package Modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Paciente extends Persona {

    @ManyToOne
    private Seguro seguro;

    public Paciente() {
        super();
    }

    public Paciente(String nombre, String cedula, Seguro seguro) {
        super(nombre, cedula);
        this.seguro = seguro;
    }

    // Getters y setters

    public Seguro getSeguro() {
        return seguro;
    }

    public void setSeguro(Seguro seguro) {
        this.seguro = seguro;
    }
}
