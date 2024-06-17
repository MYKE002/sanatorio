package Modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Seguro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;

    @OneToMany(mappedBy = "seguro")
    private List<Paciente> pacientes = new ArrayList<>();

    public Seguro() {
    }

    public Seguro(String nombre) {
        this.nombre = nombre;
    }

    // Getters y setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Paciente> getPacientes() {
        return pacientes;
    }

    public void setPacientes(List<Paciente> pacientes) {
        this.pacientes = pacientes;
    }

    // Método para agregar paciente a la lista de pacientes
    public void agregarPaciente(Paciente paciente) {
        pacientes.add(paciente);
        paciente.setSeguro(this); // Establecer la relación inversa
    }

    // Método para eliminar paciente de la lista de pacientes
    public void eliminarPaciente(Paciente paciente) {
        pacientes.remove(paciente);
        paciente.setSeguro(null); // Anular la relación inversa
    }

    // toString() opcional para facilitar la visualización
    @Override
    public String toString() {
        return nombre;
    }
}
