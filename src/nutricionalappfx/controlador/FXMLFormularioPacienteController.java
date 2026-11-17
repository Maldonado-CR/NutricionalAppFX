/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package nutricionalappfx.controlador;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

/**
 * FXML Controller class
 *
 * @author cinth
 */
public class FXMLFormularioPacienteController implements Initializable {

    @FXML
    private Button btnRegresar;
    @FXML
    private Button btnCerrarSesion;
    @FXML
    private Button btnGuardar;
    @FXML
    private Button btnCancelar;
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
    
}
