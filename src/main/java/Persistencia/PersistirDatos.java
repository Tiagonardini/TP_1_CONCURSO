package Persistencia;

import clasesDeConcurso.Concurso;
import clasesDeConcurso.Inscripcion;
import clasesDeConcurso.Participante;

import java.io.IOException;

public interface PersistirDatos {
  void guardar(Concurso concurso, Participante participante, Inscripcion inscripcion) throws IOException;
}
