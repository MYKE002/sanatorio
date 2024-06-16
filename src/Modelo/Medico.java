package Modelo;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Medico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String cedula;

    @ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    @JoinTable(
        name = "medico_especialidad",
        joinColumns = @JoinColumn(name = "medico_id"),
        inverseJoinColumns = @JoinColumn(name = "especialidad_id")
    )
    private List<Especialidad> especialidades = new ArrayList<>();

    // Constructores, getters y setters

    public Medico() {
    }

    public Medico(String nombre, String cedula) {
        this.nombre = nombre;
        this.cedula = cedula;
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

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public List<Especialidad> getEspecialidades() {
        return especialidades;
    }

    // No se necesita el método setEspecialidades(), la lista se gestiona mediante los métodos add/remove de la lista.

    // Método para añadir una especialidad a la lista de especialidades del médico
    public void agregarEspecialidad(Especialidad especialidad) {
        if (especialidad.getMedicos() == null) {
            especialidad.setMedicos(new ArrayList<>()); // Inicializar si es nula
        }
        especialidades.add(especialidad);
        especialidad.getMedicos().add(this);
    }

    // Método para eliminar una especialidad de la lista de especialidades del médico
    public void eliminarEspecialidad(Especialidad especialidad) {
        especialidades.remove(especialidad);
        especialidad.getMedicos().remove(this);
    }
}
