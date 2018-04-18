package clientes;

import com.jfoenix.controls.JFXButton;
import com.ucenfotec.ac.cr.proyecto1.capalogica.ClienteLogica;
import com.ucenfotec.ac.cr.proyecto1.entidades.Cliente;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TableView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.Window;
import za.co.knonchalant.builder.JavaFXComponent;
import za.co.knonchalant.builder.TableCallback;

import java.io.IOException;
import java.util.*;

public class PrincipalClientesController {
    @FXML
    public JFXButton botonAgregarCliente;
    @FXML
    public ScrollPane listaClientes;

    public void setup(Window window) {
        ClienteLogica clienteLogica = new ClienteLogica();
        List<Cliente> clientes = clienteLogica.getAllClientes();
        TableView build = JavaFXComponent.build(clientes, Cliente.class, true, new TableCallback<Cliente>() {
            @Override
            public void handle(Cliente cliente) {
                System.out.println("llego una accion");
                // TODO: cargar la vista de un cliente.
            }

            @Override
            public String getActionName() {
                return "Detalles";
            }
        });
        this.listaClientes.setContent(build);
    }

    public void agregarCliente(ActionEvent actionEvent) throws IOException {
        // TODO: mostrar dialogo de agregar cliente
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("form_clientes.fxml"));
        Parent rootFormCliente = fxmlLoader.load();
        FormClientesController controller = fxmlLoader.getController();

        Stage stageFormCliente = new Stage();
        stageFormCliente.initOwner(botonAgregarCliente.getScene().getWindow());
        stageFormCliente.initModality(Modality.WINDOW_MODAL);
        stageFormCliente.setTitle("Agregar un Cliente");
        stageFormCliente.setScene(new Scene(rootFormCliente));
        controller.setup(stageFormCliente);
        stageFormCliente.show();
    }
}
