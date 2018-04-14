package principal;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.text.Text;

public class Controller {
    @FXML
    private Button botonPrueba;

    @FXML
    private TextArea textoPrueba;


    @FXML
    private void clickEnBotonPrueba(ActionEvent actionEvent) {
        System.out.print("Hizo click en el fucking button!");
    }
}
