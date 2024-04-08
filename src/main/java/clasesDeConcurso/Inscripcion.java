package clasesDeConcurso;

import Mail.Email;
import Persistencia.PersistirDatos;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class Inscripcion {
    private PersistirDatos memoria;
    private Email email;

    public Inscripcion(PersistirDatos memoria) {
        this.memoria = memoria;
        this.email = new Email();
    }
    public void inscribirAEnUnConcurso (Concurso unConcurso, Participante unParticipante, LocalDate fechaDeInscripcion, String destinatario) throws IOException {
        if (!esFechaValidaParaInscripcion(unConcurso, fechaDeInscripcion)){
            throw new RuntimeException("Se encuentra fuera del periodo de Inscripcion");
        }
        if (seInscribioElPrimerDia(unConcurso, fechaDeInscripcion)) {
            unConcurso.participanteGanaPuntos(unParticipante);
        }
        unConcurso.nuevaInscripcion(unParticipante);
        memoria.guardarDatosDeConcurso(unConcurso.id(), unParticipante.id(), email, formateoDeFechaDeInscripcion(fechaDeInscripcion) , destinatario);
    }
    private boolean esFechaValidaParaInscripcion (Concurso unConcurso, LocalDate fechaDeInscripcion){
            return (!fechaDeInscripcion.isBefore(unConcurso.getFechaInicioDeInscripcion())) && (!fechaDeInscripcion.isAfter(unConcurso.getFechaFinDeInscripcion()));
    }
    private boolean seInscribioElPrimerDia(Concurso unConcurso, LocalDate fechaDeInscripcion){
        return fechaDeInscripcion.isEqual(unConcurso.getFechaInicioDeInscripcion());
    }
    private String formateoDeFechaDeInscripcion(LocalDate fechaDeInscripcion) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return fechaDeInscripcion.format(formatter);

    }
}
