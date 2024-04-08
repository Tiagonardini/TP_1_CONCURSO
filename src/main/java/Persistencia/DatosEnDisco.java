package Persistencia;

import Mail.Email;
import clasesDeConcurso.Concurso;
import clasesDeConcurso.Inscripcion;
import clasesDeConcurso.Participante;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.LocalDate;

public class DatosEnDisco implements PersistirDatos {

    private String file = "/home/tiagonardini/TP2/archivo-concurso.txt";
    public void guardarDatosDeConcurso(Integer idConcuro, Integer idParticipante, Email email, String fechaDeInscripcion, String destinatario){
        try {
        String datosConcurso = fechaDeInscripcion+"||"+ idParticipante+ "||" + idConcuro + "\n";
            Files.write(Paths.get(file), datosConcurso.getBytes(), StandardOpenOption.APPEND);
             email.enviarCorreo(destinatario);
        }catch (IOException e){
            throw new RuntimeException("No se pudo guardar", e);
        }
    }
}