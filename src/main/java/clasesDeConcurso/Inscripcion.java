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
    public static void inscribirAEnUnConcurso (Concurso unConcurso, Participante unParticipante){
        if (!esFechaValidaParaInscripcion(unConcurso)){
            System.out.print("Se encuentra fuera del periodo de Inscripcion\n");
        } else{
            if (seInscribioElPrimerDia(unConcurso)) {
                unParticipante.modificarPuntaje();
                System.out.print("Haz ganado 10 puntos\n");
            }
            var nuevaInscripcion = new Inscripcion(unParticipante, unConcurso, LocalDate.now());
            unConcurso.nuevaInscripcion(nuevaInscripcion);
            System.out.print("La inscripcion se ha realizado con exito\n");
        }
    }
    public static boolean esFechaValidaParaInscripcion(Concurso unConcurso) {
        LocalDate fechaActual = LocalDate.now();
        return (!fechaActual.isBefore(unConcurso.getFechaInicioDeInscripcion())) && (!fechaActual.isAfter(unConcurso.getFechaFinDeInscripcion()));
    }

    public static boolean seInscribioElPrimerDia(Concurso unConcurso){
        LocalDate fechaActual = LocalDate.now();
        return fechaActual.isEqual(unConcurso.getFechaInicioDeInscripcion());
    }
    public boolean estaInscripto(Participante participante) {
        return this.participante.equals(participante);
    }
}
