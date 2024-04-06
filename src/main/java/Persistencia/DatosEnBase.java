package Persistencia;

import clasesDeConcurso.Concurso;
import clasesDeConcurso.Inscripcion;
import clasesDeConcurso.Participante;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DatosEnBase implements PersistirDatos{
    private final static String conexion = "jdbc:mysql://localhost:3306/BDconcursoRestaurante";
    private final static String usuario = "TIAGO";
    private final static String password = "TN_44664727";


    @Override
    public void guardar(Concurso concurso, Participante participante, Inscripcion inscripcion) throws IOException {
        try (Connection myConnection = DriverManager.getConnection(conexion, usuario, password)){
            String consulta = "INSERT INTO Inscripcion (ID_CONCURSO, ID_PARTICIPANTE, FECHA_INSCRIPCION) VALUES (?,?,?)";
            try (PreparedStatement sentencia = myConnection.prepareStatement(consulta)) {
                sentencia.setInt(1, concurso.id());
                sentencia.setInt(2, participante.id());
                sentencia.setString(3, inscripcion.diaEnQueSeInscribio());
                sentencia.executeUpdate();
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
