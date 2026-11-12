/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package nutricionalappfx.dominio.pojo;

/**
 *
 * @author cinth
 */
public class Autenticacion {
    private boolean credencialesCorrectas;
    private String mensaje;
    private boolean activo;
    private Colaborador colaborador;

    public Autenticacion() {
    }

    public Autenticacion(boolean credencialesCorrectas, String mensaje, 
            boolean activo, Colaborador colaborador) {
        this.credencialesCorrectas = credencialesCorrectas;
        this.mensaje = mensaje;
        this.activo = activo;
        this.colaborador = colaborador;
    }

    public boolean isCredencialesCorrectas() {
        return credencialesCorrectas;
    }

    public void setCredencialesCorrectas(boolean credencialesCorrectas) {
        this.credencialesCorrectas = credencialesCorrectas;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public Colaborador getColaborador() {
        return colaborador;
    }

    public void setColaborador(Colaborador colaborador) {
        this.colaborador = colaborador;
    }
    
    
}
