package test;
import clasesDeConcurso.Concurso;
import clasesDeConcurso.Inscripcion;
import clasesDeConcurso.Participante;
import org.junit.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;
public class ConcursoTest {
    @Test
    public void test01 (){
        var tiago = new Participante("44664727", "Tiago Nardini");
        Concurso unConcurso = new Concurso("Concurso Camiseta de Boca", LocalDate.of(2024,3,16), LocalDate.of(2024, 3, 30));
        Inscripcion.inscribirAEnUnConcurso(unConcurso, tiago);
        assertTrue(unConcurso.participanteInscripto(tiago));
        assertEquals(1, unConcurso.cantidadInscriptos());
    }

    @Test
    public void test02(){
        var tiago = new Participante("44664727", "Tiago Nardini");
        Concurso unConcurso = new Concurso("Concurso Camiseta de Boca", LocalDate.of(2024,3,17), LocalDate.of(2024, 3, 30));
        Inscripcion.inscribirAEnUnConcurso(unConcurso, tiago);
        assertTrue(unConcurso.participanteInscripto(tiago));
        assertEquals(1, unConcurso.cantidadInscriptos());
    }
    @Test
    public void test03(){
        var tiago = new Participante("44664727", "Tiago Nardini");
        Concurso unConcurso = new Concurso("Concurso Camiseta de Boca", LocalDate.of(2024,3,20), LocalDate.of(2024, 3, 30));
        Inscripcion.inscribirAEnUnConcurso(unConcurso, tiago);
        assertFalse(unConcurso.participanteInscripto(tiago));
        assertEquals(0, unConcurso.cantidadInscriptos());
    }
}
