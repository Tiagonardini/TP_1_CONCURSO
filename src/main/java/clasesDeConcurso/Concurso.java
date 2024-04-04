package clasesDeConcurso;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Concurso {
    private final Integer ID;
    private final String nombre;
    private List<Inscripcion> inscriptos;
    private LocalDate fechaInicioDeInscripcion;
    private LocalDate fechaFinDeInscripcion;

    public Concurso(Integer id, String nombre, LocalDate fechaInicio, LocalDate fechaFin) {
        this.ID = id;
        this.nombre = nombre;
        this.inscriptos = new ArrayList<>();
        this.fechaInicioDeInscripcion = fechaInicio;
        this.fechaFinDeInscripcion = fechaFin;
    }
    public boolean participanteInscripto(Participante participante) {
        for (Inscripcion inscripcion : this.inscriptos) {
            if (inscripcion.estaInscripto(participante)) {
                return true;
            }
        }
        return false;
    }
    public void nuevaInscripcion(Inscripcion inscripcion) {
        this.inscriptos.add(inscripcion);
    }
    public int cantidadInscriptos() {
        return this.inscriptos.size();
    }
    public LocalDate getFechaInicioDeInscripcion() {
        return fechaInicioDeInscripcion;
    }
    public void setFechaInicioDeInscripcion(LocalDate fechaInicioDeInscripcion) {
        this.fechaInicioDeInscripcion = fechaInicioDeInscripcion;
    }
    public LocalDate getFechaFinDeInscripcion() {
        return fechaFinDeInscripcion;
    }

    public Integer id() {
        return this.ID;
    }
}