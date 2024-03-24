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

    public Integer obtenerPuntos (){
        return this.puntosObtenidos;
    }





    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Participante that)) return false;
        return Objects.equals(dni, that.dni);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dni);
    }
}