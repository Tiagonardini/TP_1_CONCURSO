package Practica1.test;

import Mail.Email;
import Persistencia.PersistirDatos;
import clasesDeConcurso.Concurso;
import clasesDeConcurso.Inscripcion;
import clasesDeConcurso.Participante;

import java.io.IOException;

public class FakeDatos implements PersistirDatos {

    private Integer contenidoIdConcurso;
    private Integer contenidoIdParticipante;
    private String fechaDeInscripcion;
    private Email contenidoEmail;
    private String contenidoDestinario;


    public boolean confirmarIdParticipante(Integer idParticipante){
        return idParticipante.equals(this.contenidoIdParticipante);
    }

    @Override
    public void guardarDatosDeConcurso(Integer idConcurso, Integer idParticipante, Email email, String fechaDeInscripcion, String destinatario) throws IOException {
        this.contenidoIdParticipante = idParticipante;
        this.contenidoIdConcurso = idConcurso;
        this.contenidoDestinario = destinatario;
        this.contenidoEmail = email;
        this.fechaDeInscripcion = fechaDeInscripcion;
    }
}
