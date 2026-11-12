/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package nutricionalappfx.modelo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import nutricionalappfx.dominio.contrato.IAutenticacionRepository;
import nutricionalappfx.dominio.pojo.Colaborador;
import nutricionalappfx.dominio.pojo.ColaboradorEstatus;
import nutricionalappfx.modelo.ConexionBD;

/**
 *
 * @author cinth
 */
public class AutenticacionDAO implements IAutenticacionRepository{

    @Override
    public int verificarCredenciales(String noPersonal, String contrasenia) throws RuntimeException {
        int idColaborador = 0;
        String consulta = "SELECT idColaborador FROM colaboradores WHERE noPersonal = ? AND password = ?";
        try(Connection conexion = ConexionBD.obtenerConexion(); 
                PreparedStatement ps = conexion.prepareStatement(consulta)){
            ps.setString(1, noPersonal);
            ps.setString(2, contrasenia);
            ResultSet resultado = ps.executeQuery();
            if(resultado.next()){
                idColaborador = resultado.getInt("idColaborador");
            }else{
                idColaborador = -1;
            }
            resultado.close();
            return idColaborador;
        }catch (SQLException e){
            throw new RuntimeException("Error de conexión con el almacenamiento. ");
        }
    }

    @Override
    public ColaboradorEstatus verificarEstatusColaborador(int idColaborador) throws RuntimeException {
        ColaboradorEstatus estatus = new ColaboradorEstatus();
        String consulta = "SELECT c.idEstatus, e.estatus "
                + "FROM colaboradores c "
                + "INNER JOIN colaboradoresEstatus e "
                + "ON e.idEstatus = c.idEstatus "
                + "WHERE idColaborador = ?";
        try(Connection conexion = ConexionBD.obtenerConexion();
                PreparedStatement ps = conexion.prepareStatement(consulta)){
            ps.setInt(1,idColaborador);
            try(ResultSet resultado = ps.executeQuery()){
                if(resultado.next()){
                   estatus.setIdEstatus(resultado.getInt("idEstatus"));
                   estatus.setEstatus(resultado.getString("estatus"));
                   return estatus;         
                }else{
                    throw new RuntimeException("Error en la integridad de los datos, inténtelo mas tarde.");
                }
            }
            
        }catch(SQLException e){
            throw new RuntimeException("Error de conexión con el almacenamiento");
        }
    }
    
    @Override
    public Colaborador obtenerInformacionColaborador(int idColaborador) throws RuntimeException {
        Colaborador colaborador = new Colaborador();
        String consulta = "SELECT idColaborador, noPersonal, nombre, apellidoPaterno, "
                + "apellidoMaterno, fechaContratacion, c.idRol, r.rol, c.idEstatus, e.estatus "
                + "FROM colaboradores c "
                + "INNER JOIN roles r ON r.idRol = c.idRol "
                + "INNER JOIN colaboradoresEstatus e ON c.idEstatus = e.idEstatus "
                + "WHERE idColaborador = ? ";
        try(Connection conexion = ConexionBD.obtenerConexion();
                PreparedStatement ps = conexion.prepareStatement(consulta)){
            ps.setInt(1,idColaborador);
            try(ResultSet resultado = ps.executeQuery()){
                if(resultado.next()){
                   colaborador.setIdColaborador(resultado.getInt("idColaborador"));
                   colaborador.setNoPersonal(resultado.getString("noPersonal"));
                   colaborador.setNombre(resultado.getString("nombre"));
                   colaborador.setApellidoPaterno((resultado.getString("apellidoPaterno") != null) ? resultado.getString("apellidoMaterno") : "");
                   colaborador.setApellidoMaterno(resultado.getString("apellidoMaterno"));
                   colaborador.setFechaContratacion(resultado.getString("fechaContratacion"));
                   colaborador.setIdRol(resultado.getInt("idRol"));
                   colaborador.setRol(resultado.getString("rol"));
                   colaborador.setIdEstatus(resultado.getInt("idEstatus"));
                   colaborador.setEstatus(resultado.getString("estatus"));
                   return colaborador;         
                }else{
                    throw new RuntimeException("Error en la integridad de los datos, inténtelo mas tarde.");
                }
            }
            
        }catch(SQLException e){
            throw new RuntimeException("Error de conexión con el almacenamiento");
        }
    }
    
}
