package Practica1.test;

import Persistencia.PersistirDatos;
import clasesDeConcurso.Concurso;
import clasesDeConcurso.Inscripcion;
import clasesDeConcurso.Participante;

import java.io.IOException;

public class FakeDatos implements PersistirDatos {

    private Concurso contenidoConcurso;
    private Participante contenidoParticipante;
    private Inscripcion contenidoInscripcion;
    @Override
    public void guardar(Concurso concurso, Participante participante, Inscripcion inscripcion) throws IOException {
        this.contenidoConcurso = concurso;
        this.contenidoInscripcion = inscripcion;
        this.contenidoParticipante = participante;
    }

    public boolean confirmaNombreParticipante(String nombre){
        return contenidoParticipante.nombre().startsWith(nombre);
    }
}
