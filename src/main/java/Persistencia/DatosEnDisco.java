package Persistencia;

import Mail.Email;
import clasesDeConcurso.Concurso;
import clasesDeConcurso.Inscripcion;
import clasesDeConcurso.Participante;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class DatosEnDisco implements PersistirDatos {
    public void guardar(Concurso concurso, Participante participante, Inscripcion inscripcion, Email email, String destinatario){
        try {
        String fechaIdParIdCon = inscripcion.diaEnQueSeInscribio() +"||"+ participante.id() + "||" + concurso.id() + "\n";
            Files.write(Paths.get("/home/tiagonardini/TP2/archivo-concurso.txt"), fechaIdParIdCon.getBytes(), StandardOpenOption.APPEND);
             email.enviarCorreo(destinatario);
        }catch (IOException e){
            throw new RuntimeException("No se pudo guardar", e);
        }
    }
}