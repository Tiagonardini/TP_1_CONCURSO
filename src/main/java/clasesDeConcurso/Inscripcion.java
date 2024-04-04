package clasesDeConcurso;

import Persistencia.PersistirDatos;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Inscripcion {
    private Participante participante;
    private Concurso concurso;
    private final LocalDate fechaDeInscripcion;
    private PersistirDatos memoria;
    public Inscripcion(Participante participante, Concurso concurso, LocalDate fechaDeInscripto, PersistirDatos memoria) {
        this.participante = participante;
        this.concurso = concurso;
        this.fechaDeInscripcion = fechaDeInscripto;
        this.memoria = memoria;

    }
    public void inscribirAEnUnConcurso (Concurso unConcurso, Participante unParticipante) throws IOException {
        if (!esFechaValidaParaInscripcion(unConcurso, fechaDeInscripcion)){
            throw new RuntimeException("Se encuentra fuera del periodo de Inscripcion");
        }
        if (seInscribioElPrimerDia(unConcurso, fechaDeInscripcion)) {
            unParticipante.modificarPuntaje();
            System.out.print("Haz ganado 10 puntos\n");
        }
        unConcurso.nuevaInscripcion(this);
        System.out.print("La inscripcion se ha realizado con exito\n");

        memoria.guardar(unConcurso, unParticipante, this);
    }
    private boolean esFechaValidaParaInscripcion (Concurso unConcurso, LocalDate fechaDeInscripcion){
            return (!fechaDeInscripcion.isBefore(unConcurso.getFechaInicioDeInscripcion())) && (!fechaDeInscripcion.isAfter(unConcurso.getFechaFinDeInscripcion()));
    }
    private boolean seInscribioElPrimerDia(Concurso unConcurso, LocalDate fechaDeInscripcion){
        return fechaDeInscripcion.isEqual(unConcurso.getFechaInicioDeInscripcion());
    }
    public boolean estaInscripto(Participante participante) {
        return this.participante.equals(participante);
    }

    public String diaEnQueSeInscribio() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return this.fechaDeInscripcion.format(formatter);

    }
}
