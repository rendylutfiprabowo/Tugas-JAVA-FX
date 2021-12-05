//Rendy Lutfi Prabowo
//2017051053
//A

package tgs1fxml;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.stage.Window;

public class Registrasi extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Register");

        GridPane gridPane = createRegistrationFormPane();
        addUIControls(gridPane);
        Scene scene = new Scene(gridPane, 800, 400);	
        primaryStage.setScene(scene);
        
        primaryStage.show();
    }


    private GridPane createRegistrationFormPane() {
        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setPadding(new Insets(40, 40, 40, 40));
        gridPane.setHgap(10);
        gridPane.setVgap(10);

        ColumnConstraints columnOneConstraints = new ColumnConstraints(100, 100, Double.MAX_VALUE);
        columnOneConstraints.setHalignment(HPos.RIGHT);
        ColumnConstraints columnTwoConstrains = new ColumnConstraints(200,200, Double.MAX_VALUE);
        columnTwoConstrains.setHgrow(Priority.ALWAYS);

        gridPane.getColumnConstraints().addAll(columnOneConstraints, columnTwoConstrains);

        return gridPane;
    }

    private void addUIControls(GridPane gridPane) {
        Label headerLabel = new Label("Register");
        headerLabel.setFont(Font.font("Arial", FontWeight.NORMAL, 18));
        gridPane.add(headerLabel, 0,0,1,1);
        GridPane.setHalignment(headerLabel, HPos.CENTER);
        GridPane.setMargin(headerLabel, new Insets(20, 0,20,0));
        
        Label FNLabel = new Label("First Name ");
        FNLabel.setFont(Font.font("Arial", FontWeight.LIGHT,15));
        gridPane.add(FNLabel, 0,1);

        TextField FNField = new TextField();
        FNField.setFont(Font.font("Arial", FontWeight.LIGHT,15));
        FNField.setPrefHeight(40);
        gridPane.add(FNField, 1,1);

        Label LNLabel = new Label("Last Name ");
        LNLabel.setFont(Font.font("Arial", FontWeight.LIGHT,15));
        gridPane.add(LNLabel, 0, 2);

        TextField LNField = new TextField();
        LNField.setFont(Font.font("Arial", FontWeight.LIGHT,15));
        LNField.setPrefHeight(40);
        gridPane.add(LNField, 1, 2);

        Label EmLabel = new Label("E-Mail Address ");
        EmLabel.setFont(Font.font("Arial", FontWeight.LIGHT,15));
        gridPane.add(EmLabel, 0, 3);

        TextField EmField  = new TextField();
        EmField.setFont(Font.font("Arial", FontWeight.LIGHT,15));
        EmField.setPrefHeight(40);
        gridPane.add(EmField , 1, 3);
        
        Label nmbphLabel = new Label("Contact No ");
        nmbphLabel.setFont(Font.font("Arial", FontWeight.LIGHT,15));
        gridPane.add(nmbphLabel, 0, 4);
        
        TextField nmbphField  = new TextField();
        nmbphField.setFont(Font.font("Arial", FontWeight.LIGHT,15));
        nmbphField.setPrefHeight(40);
        gridPane.add(nmbphField , 1, 4);
        
        Label passwrdLabel = new Label("Password ");
        passwrdLabel.setFont(Font.font("Arial", FontWeight.LIGHT,15));
        gridPane.add(passwrdLabel, 0, 5);

        PasswordField passwrdField = new PasswordField();
        passwrdField.setFont(Font.font("Arial", FontWeight.LIGHT,15));
        passwrdField.setPrefHeight(40);
        gridPane.add(passwrdField, 1, 5);
        
        Label PasswordLabel = new Label("Confirm Password ");
        PasswordLabel.setFont(Font.font("Arial", FontWeight.LIGHT,15));
        gridPane.add(PasswordLabel, 0, 6);
        
        PasswordField ConfirmpasswrdLabel = new PasswordField();
        ConfirmpasswrdLabel.setPrefHeight(40);   //
        gridPane.add(ConfirmpasswrdLabel, 1, 6); //letak label

        //Tombol Regis
        Button registerButton = new Button("Register");
        registerButton.setPrefHeight(40);
        registerButton.setDefaultButton(true);
        registerButton.setPrefWidth(100);
//        registerButton.set
        registerButton.setAlignment(Pos.CENTER);
        gridPane.add(registerButton, 1, 7);
        GridPane.setHalignment(registerButton, HPos.CENTER);
        GridPane.setMargin(registerButton, new Insets(20, 0,20,0));

        registerButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if(FNField.getText().isEmpty()) {
                    showAlert(Alert.AlertType.ERROR, gridPane.getScene().getWindow(), "Form Error!", "Please enter your First name");
                    return;
                }
                 if(LNField.getText().isEmpty()) {
                    showAlert(Alert.AlertType.ERROR, gridPane.getScene().getWindow(), "Form Error!", "Please enter your Last name");
                    return;
                }
                if(EmField.getText().isEmpty()) {
                    showAlert(Alert.AlertType.ERROR, gridPane.getScene().getWindow(), "Form Error!", "Please enter your email id");
                    return;
                }
                 if(nmbphField.getText().isEmpty()) {
                    showAlert(Alert.AlertType.ERROR, gridPane.getScene().getWindow(), "Form Error!", "Please enter your Contact No");
                    return;
                }
                if(passwrdField.getText().isEmpty()) {
                    showAlert(Alert.AlertType.ERROR, gridPane.getScene().getWindow(), "Form Error!", "Please enter a passwrd");
                    return;
                }
       
                showAlert(Alert.AlertType.CONFIRMATION, gridPane.getScene().getWindow(), "Registration Successful!", "Welcome " + FNField.getText());
            }
        });
    }

    private void showAlert(Alert.AlertType alertType, Window owner, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.initOwner(owner);
        alert.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
