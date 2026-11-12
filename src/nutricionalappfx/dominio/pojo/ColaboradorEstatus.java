/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package nutricionalappfx.dominio.pojo;

/**
 *
 * @author cinth
 */
public class ColaboradorEstatus {
    
    private int idEstatus;
    private String estatus;

    public ColaboradorEstatus() {
    }

    public ColaboradorEstatus(int idEstatus, String estatus) {
        this.idEstatus = idEstatus;
        this.estatus = estatus;
    }

    public int getIdEstatus() {
        return idEstatus;
    }

    public void setIdEstatus(int idEstatus) {
        this.idEstatus = idEstatus;
    }

    public String getEstatus() {
        return estatus;
    }

    public void setEstatus(String estatus) {
        this.estatus = estatus;
    }
    
    
    
}
