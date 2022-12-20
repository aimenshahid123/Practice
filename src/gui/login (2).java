package gui;


import javafx.animation.FadeTransition;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import javafx.util.Duration;
import jdk.jfr.TransitionFrom;

import java.awt.*;
import java.util.HashMap;

public class login implements EventHandler {
    TextField t = new TextField();
    PasswordField t1 = new PasswordField();
    Stage stage;
    Scene scn;
    int count=0;
    static String a = "";
    Button view = new Button("View tasks");
    Image plus = new Image(getClass().getResourceAsStream("plus.png"));
    Image bcd = new Image(getClass().getResourceAsStream("bck.jpg"));
    ImageView plusview = new ImageView(plus);
    ImageView bcdview = new ImageView(bcd);
    //MenuBar bar = new MenuBar();

    public login(Stage stage, Scene scn, TextField t, PasswordField t1) {
        this.t = t;
        this.t1 = t1;
        this.stage = stage;
        this.scn = scn;
    }


    @Override
    public void handle(Event event) {

        for (HashMap<String,String> l: Paa.usernames) {

            if (!l.get("username").equals(t.getText())) {

                if (l.get("password").equals(t1.getText())) {
                    stage.setTitle("Incorrect username");


                }
                if (!l.get("password").equals(t1.getText())) {
                    stage.setTitle("Incorrect pass and username");
                }

            }
            if (l.get("username").equals(t.getText())) {

                if (l.get("password").equals(t1.getText())) {

                    count++;

                    stage.setTitle(l.get("username"));
                    a = l.get("username");
                    Files files = new Files();
                    files.filess();


                    //text for spacing nothing more
                    Text text = new Text();
                    Text text1 = new Text();
                    text.setFill(Color.WHITE);
                    text.setFont(Font.font("Gill Sans", FontWeight.BOLD,20));

                    //panes
                    BorderPane bd = new BorderPane();
                    SplitPane sp = new SplitPane();
                    SplitPane sp2 = new SplitPane();
                    ScrollBar scroll = new ScrollBar();
                    scroll.setVisible(true);
                    scroll.setOrientation(Orientation.VERTICAL);

                    //buttons
                    Button back = new Button("Back");
                    Button task = new Button("+");
                    Button task1 = new Button("1");
                    Button task2 = new Button("2");
                    Button task3 = new Button("3");


                    //vboxes
                    VBox vb1 = new VBox(back);
                    StackPane vb2 = new StackPane();
                    StackPane vb3 = new StackPane();
                    DropShadow shadow = new DropShadow();

                    //additon into the boxes

                    vb1.setMaxWidth(200);
                    vb1.setMinWidth(150);
                    vb2.setMaxHeight(120);
                    bcdview.setFitHeight(120);
                    vb1.getChildren().add(text);
                    vb1.getChildren().add(task);
                    vb1.getChildren().add(text1);
                    vb1.setFillWidth(true);
//                    vb1.getChildren().add(task2);
//                    vb1.getChildren().add(task3);
                    vb2.getChildren().add(bcdview);



                    shadow.setColor(Color.PALEGREEN);

                    task.setStyle("-fx-background-color: White; -fx-background-radius:20px; -fx-border-color: purple; -fx-border-radius:18px;");
                    task.setEffect(shadow);
                    task.setMinHeight(30);
                    task.setMinWidth(150);

                    //split adding
                    sp2.getItems().addAll(vb2,vb3);
                    sp2.setOrientation(Orientation.VERTICAL);
                    sp.getItems().addAll(vb1,sp2);
                    bd.setCenter(sp);


                    back.setOnAction(new EventHandler<ActionEvent>() {
                        @Override
                        public void handle(ActionEvent actionEvent) {
                            stage.setScene(scn);
                        }
                    });



                    Scene scn1 = new Scene(bd,Paa.width+50,Paa.height+50);



                    task.setOnAction(new Task(scn1,vb1));
                    task1.setOnAction(new EventHandler<ActionEvent>() {
                        @Override
                        public void handle(ActionEvent actionEvent) {
                            Text txt = new Text("Fast");
                            Text txt1 = new Text("Due Date:");
                            vb2.getChildren().add(txt);
                            txt.setTextAlignment(TextAlignment.LEFT);
                            txt.setLayoutX(0.5);
                            txt.setLayoutY(25);

                            txt1.setTextAlignment(TextAlignment.LEFT);


                        }
                    });

                    stage.setScene(scn1);
                    stage.show();

                    break;

                }
                if (!l.get("password").equals(t1.getText())) {

                    stage.setTitle("Incorrect Pass");

                }



            }


        }


    }
}
                    //task.setGraphic(plusview);
//                    task.setTextFill(Color.WHITE);
//                    back.setStyle("-fx-background-color:green;");
//                    back.setTextFill(Color.WHITE);
                    //gd2.add(bar,0,0);
                    //back.setStyle("-fx-border-color: black;");





//                    AnchorPane gd2 = new AnchorPane();
//                    Button back = new Button("Back");
//                    VBox vb = new VBox();
//                    SplitPane sp = new SplitPane();
//
//                    Button task = new Button("+");
//                    task.setStyle("-fx-background-color: black; -fx-background-radius:30px;");
//                    task.setShape(new Rectangle(50,50));
//
//                    gd2.getChildren().add(back);
//                    back.setLayoutX(0);
//                    back.setLayoutY(0);
//
//
//                    vb.setStyle("-fx-background-color: blue;");
//                    gd2.getChildren().add(sp);
//
//
//
//                    gd2.getChildren().add(task);
//                    task.setLayoutX(320);
//                    task.setLayoutY(350);
//
