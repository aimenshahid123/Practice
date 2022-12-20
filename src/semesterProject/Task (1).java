package semesterProject;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Task implements EventHandler {

        //Task managing
        Scene scn2;
        Stage stage;
        VBox vb1;

        //constructor
        public Task(Scene scn, VBox vb1) {

        this.scn2 = scn;
        this.vb1 = vb1;
        }

        @Override
        public void handle(Event event) {


        Text taskname = new Text("Task Name:");
        TextField task = new TextField();
         TextArea des = new TextArea();
        Text dateText = new Text("Due Date:");
        Stage stage1 = new Stage();
        Scene scn3;
        Button backk =  new Button("Back");


        //objects
        DatePicker date = new DatePicker();
        GridPane gd3 = new GridPane();
        Button add = new Button("Add");
        Button cancel = new Button("Cancel");

        BorderPane b = new BorderPane();

//            HBox hBox = new HBox(backk);
//            hBox.setAlignment(Pos.TOP_LEFT);
            task.setStyle("-fx-border: remove;");
            //adding to grid and border
            gd3.add(taskname,1,1);
            gd3.add(task,1,3);
            gd3.add(des,1,5);
            gd3.add(dateText,1,7);
            gd3.add(date,1,9);
            gd3.add(add,1,11);
            gd3.add(cancel,2,11);
            //b.setTop(hBox);
            gd3.setAlignment(Pos.CENTER);
            b.setCenter(gd3);

    //        backk.setStyle("-fx-background-color:green;");
    //        backk.setTextFill(Color.WHITE);
    //

            add.setOnAction(new AddingTask(stage1,scn2,des,task,date,vb1));

            //back button
            cancel.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent actionEvent) {
                    stage.close();
                }
            });

            scn3 = new Scene(b,Paa.width,Paa.height);
            stage1.setScene(scn3);
            stage1.show();

        }
    }
