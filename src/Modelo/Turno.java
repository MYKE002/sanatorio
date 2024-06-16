package Modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.util.Date;

@Entity
public class Turno {

    @Id
    @GeneratedValue
    private long id;
    @ManyToOne
    private Paciente paciente;
    @ManyToOne
    private Medico medico;
    @ManyToOne
    private Procedimiento procedimiento;
    @ManyToOne
    private Seguro seguro;
    private Date fecha;
    private boolean pagado;
    private double monto;

    public Turno() {
    }

    public Turno(Paciente paciente, Medico medico, Procedimiento procedimiento, Seguro seguro, Date fecha, boolean pagado, double monto) {
        this.paciente = paciente;
        this.medico = medico;
        this.procedimiento = procedimiento;
        this.seguro = seguro;
        this.fecha = fecha;
        this.pagado = pagado;
        this.monto = monto;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    public Procedimiento getProcedimiento() {
        return procedimiento;
    }

    public void setProcedimiento(Procedimiento procedimiento) {
        this.procedimiento = procedimiento;
    }

    public Seguro getSeguro() {
        return seguro;
    }

    public void setSeguro(Seguro seguro) {
        this.seguro = seguro;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public boolean isPagado() {
        return pagado;
    }

    public void setPagado(boolean pagado) {
        this.pagado = pagado;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }
}
