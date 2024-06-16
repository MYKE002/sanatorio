package Modelo;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Especialidad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;

    @ManyToMany(mappedBy = "especialidades")
    private List<Medico> medicos = new ArrayList<>();

    // Constructores, getters y setters
    public Especialidad() {
        this.medicos = new ArrayList<>(); // Asegurar la inicialización en el constructor
    }

    public Especialidad(String nombre) {
        this.nombre = nombre;
        this.medicos = new ArrayList<>(); // Asegurar la inicialización en el constructor
    }

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

    public List<Medico> getMedicos() {
        return medicos;
    }

    public void setMedicos(List<Medico> medicos) {
        this.medicos = medicos;
    }

    @Override
    public String toString() {
        return nombre; // Devuelve el nombre de la especialidad para que se muestre en el combo box
    }
}
