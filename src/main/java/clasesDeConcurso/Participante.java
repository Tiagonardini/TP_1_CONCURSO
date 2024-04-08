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


    public Integer puntos(){
       return this.puntosObtenidos;
    }
    public Integer setPuntos(Integer puntosGanados){
        return this.puntosObtenidos = puntosGanados;
    }


    public Integer id() {
        return this.ID;
    }
    public String nombre(){
        return this.nombre;
    }

    public boolean estaInscripto(Participante participante) {
        return this.equals(participante);
    }
}