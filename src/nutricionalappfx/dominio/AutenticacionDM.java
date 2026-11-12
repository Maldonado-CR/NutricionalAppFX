/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package nutricionalappfx.dominio;

import nutricionalappfx.dominio.contrato.IAutenticacionRepository;
import nutricionalappfx.dominio.pojo.Autenticacion;
import nutricionalappfx.dominio.pojo.Colaborador;
import nutricionalappfx.dominio.pojo.ColaboradorEstatus;
import nutricionalappfx.utilidades.Utilidades;

/**
 *
 * @author cinth
 */
public class AutenticacionDM {
    
    private final IAutenticacionRepository contrato;
    private final int CREDENCIALES_INCORRECTAS = -1;
    private final int ESTATUS_COLABORADOR_ACTIVO = 1;
    private final int ESTATUS_COLABORADOR_SUSPENDIDO = 3;
    
    public AutenticacionDM(IAutenticacionRepository contrato){
        this.contrato = contrato;
    }
    
    public Autenticacion verificarCredencialesColaborador(String noPersonal, String password)throws RuntimeException{
        Autenticacion respuesta = new Autenticacion();
        if(noPersonal.isEmpty() || password.isEmpty()){
            respuesta.setCredencialesCorrectas(false);
            respuesta.setMensaje("Los campos estan vacios. ");
            return respuesta;
        }
        String passwordCifrado = Utilidades.generarCifradoSHA256(password);
        int idColaborador = contrato.verificarCredenciales(noPersonal, passwordCifrado);
        if(idColaborador == CREDENCIALES_INCORRECTAS){
            respuesta.setCredencialesCorrectas(false);
            respuesta.setMensaje("No. de personal y/o contraseña incorrectos.\nFavor de verificar la información. ");
            return respuesta;
        }
        ColaboradorEstatus estatus = contrato.verificarEstatusColaborador(idColaborador);
        
        if(estatus.getIdEstatus() == ESTATUS_COLABORADOR_ACTIVO){
            respuesta.setCredencialesCorrectas(true);
            respuesta.setActivo(true);
            Colaborador info = contrato.obtenerInformacionColaborador(idColaborador);
            respuesta.setColaborador(info);
            respuesta.setMensaje("Bienvenido(a) "+info.getNombre() + " a tu sistema de gestión de pacientes. ");
            return respuesta;
        }
        respuesta.setCredencialesCorrectas(true);
        respuesta.setActivo(false);
        if(estatus.getIdEstatus() == ESTATUS_COLABORADOR_SUSPENDIDO){
            respuesta.setMensaje("Lo sentimos, tu cuenta ha sido suspendida indefindamente."
                    + "\nContacta a un administrador al correo: soporte@nutriapp.com");
        }else{
            respuesta.setMensaje("No. de personal y/o contraseña incorrectos.\nFavor de verificar la información.");
        }
        return respuesta;
    }
}
