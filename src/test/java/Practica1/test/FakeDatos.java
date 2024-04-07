package Practica1.test;

import Mail.Email;
import Persistencia.PersistirDatos;
import clasesDeConcurso.Concurso;
import clasesDeConcurso.Inscripcion;
import clasesDeConcurso.Participante;

import java.io.IOException;

public class FakeDatos implements PersistirDatos {

    private Concurso contenidoConcurso;
    private Participante contenidoParticipante;
    private Inscripcion contenidoInscripcion;
    private  Email contenidoEmail;

    private String contenidoDestinario;
    @Override
    public void guardar(Concurso concurso, Participante participante, Inscripcion inscripcion, Email email, String destinatario) throws IOException {
        this.contenidoConcurso = concurso;
        this.contenidoInscripcion = inscripcion;
        this.contenidoParticipante = participante;
        this.contenidoEmail = email;
        this.contenidoDestinario = destinatario;
    }

    public boolean confirmaNombreParticipante(String nombre){
        return contenidoParticipante.nombre().startsWith(nombre);
    }
}
