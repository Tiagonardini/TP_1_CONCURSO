package Practica1.test;
import Mail.Email;
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
    public void pruebaFakeObjects() throws IOException{
        var fakeMemoria = new FakeDatos();
        var destinatario = "tiagonardini15@gmail.com";
        var email = new Email();
        var tiago = new Participante(5 ,44664727, "Tiago Nardini");
        var unConcurso = new Concurso(5,"Concurso Camiseta de Boca", LocalDate.of(2024,4,8), LocalDate.of(2024, 4, 30));
        var inscripcion = new Inscripcion(fakeMemoria);

        inscripcion.inscribirAEnUnConcurso(unConcurso, tiago,LocalDate.of(2024, 4, 8), destinatario);

        assertTrue(fakeMemoria.confirmarIdParticipante(5));
    }

    @Test
    public void pruebaDeGuardarEnDisco() throws IOException {
        var memoriaEnDisco = new DatosEnDisco();
        String destinatario = "tiagonardini15@gmail.com";
        var participante = new Participante(20,12345678 , "Juana Garcia");
        var concurso = new Concurso(20, "Sorteo de chancho", LocalDate.of(2024,4,12), LocalDate.of(2024,5,1));
        var inscripcion = new Inscripcion(memoriaEnDisco);

        inscripcion.inscribirAEnUnConcurso(concurso, participante,LocalDate.of(2024,4,12), destinatario);
    }
    @Test
    public void pruebaDeGuardarEnBaseDeDatos() throws IOException {
        var memoriaEnBase = new DatosEnBase();
        String destinatario = "tiagonardini15@gmail.com";
        var participante = new Participante(20,12345678 , "Pepe Garcia");
        var concurso = new Concurso(20, "Sorteo de chancho", LocalDate.of(2024,4,12), LocalDate.of(2024,5,1));
        var inscripcion = new Inscripcion(memoriaEnBase);

        inscripcion.inscribirAEnUnConcurso(concurso, participante,LocalDate.of(2024,4,12), destinatario);
    }
}
