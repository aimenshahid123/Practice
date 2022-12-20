package semesterProject;


import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.util.HashMap;

public class signupChecker implements EventHandler {

    TextField username;
    PasswordField pass;
    PasswordField confirm;
    TextField email;
    Stage create;
    Scene scene;

    public signupChecker(TextField username, PasswordField pass, PasswordField confirm, TextField email, Stage stage, Scene scene) {
        this.username = username;
        this.pass = pass;
        this.confirm = confirm;
        this.email = email;
        this.create = stage;
        this.scene = scene;
    }


    @Override
    public void handle(Event event) {


        for (HashMap<String, String> l : Paa.usernames) {
            if (!l.get("username").equals(username.getText())) {
                username.setStyle("-fx-backgroundr-color:#88FF59;-fx-background-radius: 20px;-fx-border-radius: 18px;");
                if (pass.getText().equals(confirm.getText())) {
                    confirm.setStyle("-fx-background-color:#88FF59;-fx-background-radius: 20px;-fx-border-radius: 18px;");
                    create creates = new create(username, pass, confirm, email, create, scene);
                    creates.handle();
                }
                if (!pass.getText().equals(confirm.getText())) {
                    confirm.setStyle("-fx-background-color:#FF4D4D;-fx-background-radius: 20px;-fx-border-radius: 18px;");

                }
            }
            if (l.get("username").equals(username.getText())) {
                username.setStyle("-fx-background-color:3FF4D4D;-fx-background-radius: 20px;-fx-border-radius: 18px;");
                if (pass.getText().equals(confirm.getText())) {
                    confirm.setStyle("-fx-background-color:#88FF59;-fx-background-radius: 20px;-fx-border-radius: 18px;");

                } if (!pass.getText().equals(confirm.getText())) {
                    confirm.setStyle("-fx-background-color:#FF4D4D;-fx-background-radius: 20px;-fx-border-radius: 18px;");

                }
            }
        }
    }
}
