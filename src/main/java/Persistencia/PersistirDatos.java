package Persistencia;

import Mail.Email;
import clasesDeConcurso.Concurso;
import clasesDeConcurso.Inscripcion;
import clasesDeConcurso.Participante;

import java.io.IOException;

public interface PersistirDatos {
  void guardarDatosDeConcurso(Integer idConcuro, Integer idParticipante, Email email, String fechaDeInscripcion, String destinatario) throws IOException;



}
