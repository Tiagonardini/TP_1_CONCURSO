package clasesDeConcurso;

import java.time.LocalDate;

public class Inscripcion {
    private Participante participante;
    private Concurso concurso;
    private final LocalDate fechaDeInscripcion;
    private Inscripcion(Participante participante, Concurso concurso, LocalDate fechaDeInscripto) {
        this.participante = participante;
        this.concurso = concurso;
        this.fechaDeInscripcion = fechaDeInscripto;

    }
    public static void inscribirAEnUnConcurso (Concurso unConcurso, Participante unParticipante, LocalDate fechaDeInscripcion){
        if (!esFechaValidaParaInscripcion(unConcurso, fechaDeInscripcion)){
            System.out.print("Se encuentra fuera del periodo de Inscripcion\n");
        } else{
            if (seInscribioElPrimerDia(unConcurso, fechaDeInscripcion)) {
                unParticipante.modificarPuntaje();
                System.out.print("Haz ganado 10 puntos\n");
            }
            var nuevaInscripcion = new Inscripcion(unParticipante, unConcurso, fechaDeInscripcion);
            unConcurso.nuevaInscripcion(nuevaInscripcion);
            System.out.print("La inscripcion se ha realizado con exito\n");
        }
    }
    private static boolean esFechaValidaParaInscripcion(Concurso unConcurso, LocalDate fechaDeInscripcion) {
        return (!fechaDeInscripcion.isBefore(unConcurso.getFechaInicioDeInscripcion())) && (!fechaDeInscripcion.isAfter(unConcurso.getFechaFinDeInscripcion()));
    }

    private static boolean seInscribioElPrimerDia(Concurso unConcurso, LocalDate fechaDeInscripcion){
        return fechaDeInscripcion.isEqual(unConcurso.getFechaInicioDeInscripcion());
    }
    public boolean estaInscripto(Participante participante) {
        return this.participante.equals(participante);
    }
}
