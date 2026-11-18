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
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;
import nutricionalappfx.NutricionalAppFX;

/**
 * FXML Controller class
 *
 * @author cinth
 */
public class FXMLFormularioPacienteController implements Initializable {

    @FXML
    private TextField tfCodigoPaciente;
    @FXML
    private TextField tfTelefono;
    @FXML
    private TextField tfNombre;
    @FXML
    private RadioButton rbFemenino;
    @FXML
    private ToggleGroup tgSexo;
    @FXML
    private RadioButton rbMasculino;
    @FXML
    private TextField tfApellidoPaterno;
    @FXML
    private TextField tfAltura;
    @FXML
    private TextField tfApellidoMaterno;
    @FXML
    private TextField tfPesoInicial;
    @FXML
    private DatePicker dpFechaNacimiento;
    @FXML
    private TextField tfCorreo;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void handleCerrarSesion(ActionEvent event) {
        try {
            Stage ventanaModal = (Stage) tfNombre.getScene().getWindow();
            Stage stagePrincipal = (Stage) ventanaModal.getOwner();
            ventanaModal.close();

            if (stagePrincipal != null) {
                FXMLLoader loader = new FXMLLoader(NutricionalAppFX.class.getResource("vista/FXMLAutenticacion.fxml"));
                Parent vista = loader.load();
                stagePrincipal.setScene(new Scene(vista));
                stagePrincipal.setTitle("Iniciar Sesión");
                stagePrincipal.show();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void handleRegresar(ActionEvent event) {
    }

    @FXML
    private void handleGuardarPaciente(ActionEvent event) {
    }

    @FXML
    private void handleCancelar(ActionEvent event) {
    }
    
}
