package Practica1.test;
import Persistencia.DatosEnBase;
import Persistencia.DatosEnDisco;
import clasesDeConcurso.Concurso;
import clasesDeConcurso.Inscripcion;
import clasesDeConcurso.Participante;
import org.junit.Test;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;
public class ConcursoTest {
    @Test
    public void test01 () throws IOException {
        var memoriaEnDisco = new DatosEnDisco();
        var tiago = new Participante(1 ,44664727, "Tiago Nardini");
        var unConcurso = new Concurso(1,"Concurso Camiseta de Boca", LocalDate.of(2024,3,16), LocalDate.of(2024, 3, 30));
        var inscripcion = new Inscripcion(tiago, unConcurso,LocalDate.of(2024,3, 16), memoriaEnDisco);

        inscripcion.inscribirAEnUnConcurso(unConcurso, tiago);

        assertTrue(unConcurso.participanteInscripto(tiago));
        assertEquals(1, unConcurso.cantidadInscriptos());
    }

    @Test
    public void test02() throws IOException {
        var memoriaEnDisco = new DatosEnDisco();
        var participante2 = new Participante(2 ,44664727, "Julian Alvarez");
        var unConcurso = new Concurso(2,"Concurso Camiseta de Boca", LocalDate.of(2024,3,17), LocalDate.of(2024, 4, 30));
        var inscripcion = new Inscripcion(participante2, unConcurso,LocalDate.now(), memoriaEnDisco);

        inscripcion.inscribirAEnUnConcurso(unConcurso, participante2);
        assertTrue(unConcurso.participanteInscripto(participante2));
        assertEquals(1, unConcurso.cantidadInscriptos());
    }
    @Test
    public void test03() throws IOException {
        var memoriaEnDisco = new DatosEnDisco();
        var tiago = new Participante(3 ,44664727, "Tiago Nardini");
        var unConcurso = new Concurso(3,"Concurso Camiseta de Boca", LocalDate.of(2024,3,20), LocalDate.of(2024, 3, 30));
        var inscripcion = new Inscripcion(tiago, unConcurso, LocalDate.of(2024, 1, 2), memoriaEnDisco);
        inscripcion.inscribirAEnUnConcurso(unConcurso, tiago);
        assertFalse(unConcurso.participanteInscripto(tiago));
        assertEquals(0, unConcurso.cantidadInscriptos());
    }
    @Test
    public  void testConBase01() throws IOException {
        var memoriaEnBase = new DatosEnBase();
        var participante1 = new Participante(4, 24098732, "Juan Rodriguez");
        var concurso1 = new Concurso(4, "Camiseta de Independiente", LocalDate.of(2024, 4, 1), LocalDate.of(2024, 4, 30));
        var inscripcion = new Inscripcion(participante1, concurso1, LocalDate.now(), memoriaEnBase);
        inscripcion.inscribirAEnUnConcurso(concurso1, participante1);

        assertTrue(concurso1.participanteInscripto(participante1));
        assertEquals(1, concurso1.cantidadInscriptos());
    }
}
