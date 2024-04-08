package Persistencia;

import Mail.Email;
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
    public void guardarDatosDeConcurso(Integer idConcuro, Integer idParticipante, Email email, String fechaDeInscripcion, String destinatario) throws IOException {
        try (Connection myConnection = DriverManager.getConnection(conexion, usuario, password)){
            String consulta = "INSERT INTO Inscripcion (ID_CONCURSO, ID_PARTICIPANTE, FECHA_INSCRIPCION) VALUES (?,?,?)";
            try (PreparedStatement sentencia = myConnection.prepareStatement(consulta)) {
                sentencia.setInt(1, idConcuro);
                sentencia.setInt(2, idParticipante);
                sentencia.setString(3, fechaDeInscripcion);
                sentencia.executeUpdate();
                email.enviarCorreo(destinatario);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
