package Persistencia;

import Mail.Email;
import clasesDeConcurso.Concurso;
import clasesDeConcurso.Inscripcion;
import clasesDeConcurso.Participante;

import java.io.IOException;

public interface PersistirDatos {
  void guardar(Concurso concurso, Participante participante, Inscripcion inscripcion, Email email, String destinatario) throws IOException;

}
