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
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;
import nutricionalappfx.NutricionalAppFX;
import nutricionalappfx.dominio.pojo.Colaborador;

/**
 * FXML Controller class
 *
 * @author cinth
 */
public class FXMLAdministradorPacienteController implements Initializable {

    private Colaborador colaborador;
    private int idNutriologo;

    @FXML
    private TextField tfBuscar;
    @FXML
    private Label lbTitulo;
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

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    public void inicializarInformacion(Colaborador colaborador) {
        this.colaborador = colaborador;
    }
    
    public void recibirInformacion(int idNutriologo){
        this.idNutriologo = idNutriologo;
    }

    @FXML
    private void handleBotonAlta(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(NutricionalAppFX.class.getResource("vista/FXMLFormularioPaciente.fxml"));
            Parent vista = loader.load();

            Stage escenarioActual = (Stage) tvPacientes.getScene().getWindow();
            Stage escenarioFormulario = new Stage();
            escenarioFormulario.setScene(new Scene(vista));
            escenarioFormulario.setTitle("Registrar Nuevo Paciente");
            escenarioFormulario.initOwner(escenarioActual); 
            escenarioFormulario.initModality(Modality.APPLICATION_MODAL);
            escenarioFormulario.showAndWait();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void handleBotonEditar(ActionEvent event) {
    }

    @FXML
    private void handleBotonBaja(ActionEvent event) {
    }

    @FXML
    private void handleBotonRegresar(ActionEvent event) {
        try {
            Stage escenario = (Stage) lbTitulo.getScene().getWindow();
            FXMLLoader loader = new FXMLLoader(NutricionalAppFX.class.getResource("vista/FXMLPrincipal.fxml"));
            Parent vista = loader.load();

            FXMLPrincipalController controlador = loader.getController();
            controlador.recibirInformacion(colaborador.getIdColaborador());

            Scene escena = new Scene(vista);
            escenario.setScene(escena);
            escenario.setTitle("Control Nutricional");
            escenario.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void handleBotonBuscar(ActionEvent event) {
    }

    @FXML
    private void handleCerrarSesion(ActionEvent event) {
        try {
            Stage escenario = (Stage) lbTitulo.getScene().getWindow();
            FXMLLoader loader = new FXMLLoader(NutricionalAppFX.class.getResource("vista/FXMLAutenticacion.fxml"));
            Parent vista = loader.load();

            Scene escena = new Scene(vista);
            escenario.setScene(escena);
            escenario.setTitle("Iniciar Sesión");
            escenario.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
