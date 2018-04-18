package principal;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import com.ucenfotec.ac.cr.proyecto1.capalogica.ClienteLogica;
import com.ucenfotec.ac.cr.proyecto1.capalogica.ContactoLogica;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("principal.fxml"));
        primaryStage.setTitle("Software Celestial S.A.");
        primaryStage.setScene(new Scene(root, 1024, 500));
        primaryStage.show();
    }

    public static void main(String[] args) {
//        ClienteLogica micliente=new ClienteLogica();
//        System.out.println(micliente.getAllClientes().toString());
        launch(args);
    }
}
