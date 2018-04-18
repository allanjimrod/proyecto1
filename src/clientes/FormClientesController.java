package clientes;

import com.ucenfotec.ac.cr.proyecto1.entidades.Cliente;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Window;
import za.co.knonchalant.builder.JavaFXComponent;

public class FormClientesController {
    @FXML
    public Button botonGuardar;
    @FXML
    private GridPane mainPane;

    public void setup(Window window) {
        Pane build = JavaFXComponent.build(new Cliente(), window);
        botonGuardar.setOnAction(actionEvent -> {
            Cliente cliente = (Cliente)JavaFXComponent.read(FormClientesController.this.mainPane, Cliente.class);
            System.out.println("Vamos a salvar al cliente: " + cliente.getNombre());
        });
        this.mainPane.getChildren().addAll(build);
    }
}
