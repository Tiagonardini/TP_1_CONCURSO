package clasesDeConcurso;

public class Participante {
    private final Integer ID;
    private Integer dni;
    private String nombre;
    private Integer puntosObtenidos;

    public Participante(Integer id, int dni, String nombre) {
        this.ID = id;
        this.dni = dni;
        this.nombre = nombre;
        this.puntosObtenidos = 0;
    }
    public Integer modificarPuntaje(){
       return this.puntosObtenidos +=10;
    }


    public Integer id() {
        return this.ID;
    }
}