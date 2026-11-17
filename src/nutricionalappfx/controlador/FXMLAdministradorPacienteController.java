/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package nutricionalappfx.controlador;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author cinth
 */
public class FXMLAdministradorPacienteController implements Initializable {

    @FXML
    private TextField tfBuscar;
    @FXML
    private TableView<?> tvPacientes;
    @FXML
    private TableColumn<?, ?> colCodigo;
    @FXML
    private TableColumn<?, ?> colNombreCompleto;
    @FXML
    private TableColumn<?, ?> colTelefono;
    @FXML
    private TableColumn<?, ?> colCorreo;
    @FXML
    private TableColumn<?, ?> colFechaNacimiento;
    @FXML
    private TableColumn<?, ?> colSexo;
    @FXML
    private Button btnCerrarSesion;
    @FXML
    private Button btnBuscar;
    @FXML
    private Button btnBaja;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void handleBotonAlta(ActionEvent event) {
    }

    @FXML
    private void handleBotonEditar(ActionEvent event) {
    }

    @FXML
    private void handleBotonBaja(ActionEvent event) {
    }

    @FXML
    private void handleBotonRegresar(ActionEvent event) {
    }

    @FXML
    private void handleBotonBuscar(ActionEvent event) {
    }
    
}
