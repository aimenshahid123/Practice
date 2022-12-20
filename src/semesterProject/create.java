package semesterProject;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class create {
    TextField user;
    TextField email;
    Stage stage;
    Scene scene;
    Scene orig;
    PasswordField pass;
    PasswordField confirm;

    public create(TextField user, PasswordField pass,PasswordField confirm,TextField email,Stage stage, Scene orig) {
        this.user = user;
        this.stage = stage;
        this.orig = orig;
        this.pass=pass;
    }


    public void handle() {

            //Paa.usernames.add(tes.getText());

        write w = new write(user.getText(),pass.getText());
        w.handle();
        System.out.println(user.getText());
        System.out.println(pass.getText());
        Text text = new Text("Your account has been created!");
            text.setFont(Font.font("Gill Sans", FontWeight.BOLD,30));
            text.setFill(Color.BLACK);
            Button conf = new Button("Ok");
            conf.setStyle("-fx-background-color: #3677BB;-fx-background-radius: 20px;");
            conf.setTextFill(Color.WHITE);
            conf.setMinHeight(10);
            conf.setMinWidth(250);

            GridPane grid = new GridPane();
            grid.add(conf,0,1);
            grid.add(text,0,0);
            grid.setAlignment(Pos.CENTER);
            scene = new Scene(grid,Paa.width,Paa.height);
            stage.setScene(scene);

            conf.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent actionEvent) {
                    stage.setScene(orig);
                }
            });


    }
}


