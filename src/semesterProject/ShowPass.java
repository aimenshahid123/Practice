package semesterProject;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.CheckBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class ShowPass implements EventHandler {

    CheckBox check;
    PasswordField tf1;
    TextField tf2;
    GridPane gd;



    public ShowPass(GridPane gd,CheckBox check, PasswordField tf1, TextField tf2) {
        this.check = check;
        this.tf1 = tf1;
        this.tf2 = tf2;
        this.gd = gd;
    }


    @Override
    public void handle(Event event) {
        if (check.isSelected()) {


            gd.getChildren().remove(tf1);
            gd.add(tf2,0,5);
            tf2.setStyle("-fx-border-color:#7522d7;-fx-background-radius: 20px;-fx-border-radius: 18px;");
            tf2.setText(tf1.getText());
            tf2.setVisible(true);
            tf1.setVisible(false);

            return;
        } else if(!check.isSelected()) {
            gd.getChildren().remove(tf2);
            gd.add(tf1,0,5);
            tf1.setStyle("-fx-border-color:#7522d7;-fx-background-radius: 20px;-fx-border-radius: 18px;");
            tf1.setText(tf2.getText());
            tf1.setVisible(true);
            tf2.setVisible(false);
        }
    }
}
