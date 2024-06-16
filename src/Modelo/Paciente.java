package Modelo;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Paciente extends Persona {

    @OneToMany(mappedBy = "paciente")
    private List<Turno> turnos = new ArrayList<>();

    public Paciente() {}

    public Paciente(String nombre, String cedula) {
        super(nombre, cedula);
    }

    // Otros métodos relacionados con la gestión del paciente y turnos

    public List<Turno> getTurnos() {
        return turnos;
    }

    public void setTurnos(List<Turno> turnos) {
        this.turnos = turnos;
    }
}
