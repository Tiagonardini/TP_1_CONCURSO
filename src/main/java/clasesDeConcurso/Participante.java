package clasesDeConcurso;

import java.util.Objects;

public class Participante {

    private String dni;
    private String nombre;
    private Integer puntosObtenidos;

    public Participante(String dni, String nombre) {
        this.dni = dni;
        this.nombre = nombre;
        this.puntosObtenidos = 0;
    }
    public Integer modificarPuntaje(){
       return this.puntosObtenidos +=10;
    }


}