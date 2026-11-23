/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package nutricionalappfx.controlador;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import nutricionalappfx.NutricionalAppFX;
import nutricionalappfx.dominio.pojo.Colaborador;

/**
 * FXML Controller class
 *
 * @author cinth
 */
public class FXMLPrincipalController implements Initializable {
    
    private Colaborador colaborador;
    private int idNutriologo;
    @FXML
    private Label lbNombre;
    @FXML
    private Label lbRol;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
    
    public void recibirInformacion(int idNutriologo){
        this.idNutriologo = idNutriologo;
    }

    private void mostrarInfoPantalla() {
        if (colaborador != null) {
            lbNombre.setText("Bienvenido(a) " + colaborador.toString());
            lbRol.setText("Rol: " + colaborador.getRol());
        }
    }

    public void inicializarInformacion(Colaborador colaborador) {
        this.colaborador = colaborador;
    }

    @FXML
    private void handleAdminColaboradores(ActionEvent event) {
    }

    @FXML
    private void handleAdminPacientes(ActionEvent event) {
        try {
            Stage escenario = (Stage) lbNombre.getScene().getWindow();
            FXMLLoader loader = new FXMLLoader(NutricionalAppFX.class.getResource("vista/FXMLAdministradorPaciente.fxml"));
            Parent vista = loader.load();

            FXMLAdministradorPacienteController controlador = loader.getController();
            controlador.recibirInformacion(colaborador.getIdColaborador());

            Scene escena = new Scene(vista);
            escenario.setScene(escena);
            escenario.setTitle("Administrador de Pacientes");
            escenario.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
