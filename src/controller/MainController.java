package controller;

import java.io.IOException;
import java.net.URL;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class MainController {

        @FXML
    private AnchorPane root;

       @FXML
    void btnCustomerOnAction(ActionEvent event) throws IOException {
        System.out.println("Customer button clicked");
       // URL resource = this.getClass().getResource("./view/Customer.fxml");
       // Parent root = FXMLLoader.load(this.getClass().getResource("/view/Customer.fxml"));
       // Stage stage = new Stage();
       // stage.setScene(new Scene(root));
       // stage.show();
       // stage.setTitle("Customer Form");
       this.root.getChildren().clear();
       Parent node = FXMLLoader.load(this.getClass().getResource("/view/Customer.fxml"));
        this.root.getChildren().add(node);
    }  

    @FXML
    void btnItemOnAction(ActionEvent event) {
        System.out.println("Item button clicked");
    }

    @FXML
    void btnOrdersOnAction(ActionEvent event) {
        System.out.println("Orders button clicked");
    }

    
}
