/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package nutricionalappfx.dominio.contrato;

import java.util.List;
import nutricionalappfx.dominio.pojo.OperacionResultado;
import nutricionalappfx.dominio.pojo.Paciente;

/**
 *
 * @author cinth
 */
public interface IPacienteRepository {
    
    public List<Paciente> obtenerPacientesNutriologo(int idNutriologo);
    
    public OperacionResultado registrarPaciente(Paciente paciente);
    
    public OperacionResultado editarPaciente(Paciente paciente);
    
    public OperacionResultado eliminarPaciente(int idPaciente);
}
