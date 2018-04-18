package principal;

import clientes.FormClientesController;
import clientes.PrincipalClientesController;
import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Controller {
    @FXML
    public JFXButton botonInstalaciones;
    @FXML
    private Button botonClientes;
    @FXML
    private Button botonProductos;

    @FXML
    private Pane contenedorPrincipal;

    @FXML
    private void openProductos(ActionEvent actionEvent) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../clientes/principal_clientes.fxml"));
        Parent root = fxmlLoader.load();
        PrincipalClientesController controller = fxmlLoader.getController();

        Stage stage = (Stage) contenedorPrincipal.getScene().getWindow();
        controller.setup(stage);
        contenedorPrincipal.getChildren().addAll(root);
    }

    @FXML
    private void openClientes(ActionEvent actionEvent) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../clientes/principal_clientes.fxml"));
        Parent root = fxmlLoader.load();
        PrincipalClientesController controller = fxmlLoader.getController();

        Stage stage = (Stage) contenedorPrincipal.getScene().getWindow();
        controller.setup(stage);
        contenedorPrincipal.getChildren().addAll(root);
    }


}
