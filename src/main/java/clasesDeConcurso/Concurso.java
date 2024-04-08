package clasesDeConcurso;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Concurso {
    private final Integer ID;
    private final String nombre;
    private List<Participante> inscriptos;
    private LocalDate fechaInicioDeInscripcion;
    private LocalDate fechaFinDeInscripcion;

    private static final Integer PUNTOS_A_SUMAR = 10;

    public Concurso(Integer id, String nombre, LocalDate fechaInicio, LocalDate fechaFin) {
        this.ID = id;
        this.nombre = nombre;
        this.inscriptos = new ArrayList<>();
        this.fechaInicioDeInscripcion = fechaInicio;
        this.fechaFinDeInscripcion = fechaFin;
    }
    public boolean participanteInscripto(Participante participante) {
        for (Participante inscripto : this.inscriptos) {
            if (inscripto.estaInscripto(participante)) {
                return true;
            }
        }
        return false;
    }
    public void nuevaInscripcion(Participante participanteInscripto) {
        this.inscriptos.add(participanteInscripto);
    }
    public int cantidadInscriptos() {
        return this.inscriptos.size();
    }
    public LocalDate getFechaInicioDeInscripcion() {
        return fechaInicioDeInscripcion;
    }
    public LocalDate getFechaFinDeInscripcion() {
        return fechaFinDeInscripcion;
    }

    public Integer id() {
        return this.ID;
    }

    public void participanteGanaPuntos(Participante participante){
        int puntosActuales = participante.puntos();
        participante.setPuntos(puntosActuales += PUNTOS_A_SUMAR);
    }
}