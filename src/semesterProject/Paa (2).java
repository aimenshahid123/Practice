package semesterProject;



import javafx.animation.FadeTransition;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;

import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.StrokeLineCap;
import javafx.scene.shape.StrokeLineJoin;
import javafx.scene.shape.StrokeType;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import javafx.util.Duration;


import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class Paa extends Application{

    public static void main(String[] args) {
        launch(args);
    }    //MAIN METHOD

    //Declaring the objects and arrays


    //arrays
    static int height = 410;
    static int width = 650;
    static String username[] = {"abduvert","ibraheem"};
    static String pass[] = {"vlogger","coder"};
    //static ArrayList<String> sr = new ArrayList<>();
    static ArrayList<HashMap<String,String>> usernames = new ArrayList<>();


    //adding image
    Image img = new Image(getClass().getResourceAsStream("bck.jpg"));
    ImageView imageView = new ImageView(img);

    Image im = new Image(getClass().getResourceAsStream("icon.jpg"));



    //stage types
    Rectangle rect = new Rectangle(300,300, Color.rgb(0,0,0,0.3));
    GridPane gd = new GridPane();
    StackPane stack = new StackPane();
    Label top = new Label("Welcome");
    BorderPane bd = new BorderPane();
    HBox hb = new HBox(top);
    Scene scn;


    //functional components(buttons,textfields,checkboxes etc)
    CheckBox check = new CheckBox("Show Password");
    Button login = new Button("Sign in");
    Button signup = new Button("Sign up");
    //Button forget = new Button("Forgot password?");
    Text txt = new Text("Username");
    Text txt1 = new Text("Password");
    TextField tf = new TextField();
    PasswordField tf1;
    TextField tf2 = new TextField();




    //Start method
    @Override
    public void start(Stage stage){


        Files fil = new Files();
        fil.filess();
        stage.setTitle("Use an Account");              //set the title of the stage

        //font properties

        //rectangle prop
        rect.setStroke(Color.rgb(117,34,215));
        rect.setStrokeLineCap(StrokeLineCap.ROUND);
        rect.setStrokeLineJoin(StrokeLineJoin.BEVEL);
        rect.setStrokeType(StrokeType.OUTSIDE);
        rect.setStrokeWidth(2);
        rect.setWidth(370);

        //label prop
        top.setFont(Font.font("Gill Sans", FontWeight.BOLD,30));
        top.setTextFill(Color.rgb(255,255,255));

        //text prop
        txt.setFill(Color.WHITE);
        txt.setFont(Font.font("Gill Sans", FontWeight.BOLD,15));
        txt.setLayoutX(80);
        txt.setLayoutY(345);
        txt.prefHeight(35);
        txt.prefWidth(345);
        txt1.setFont(Font.font("Gill Sans", FontWeight.BOLD,15));
        txt1.setFill(Color.WHITE);
        txt.setStyle("-fx-border-color: yellow;");
        txt1.setStyle("-fx-border-color: yellow;");

        //checkbox and button
        check.setTextFill(Color.WHITE);
        login.setStyle("-fx-background-color: #3677BB;-fx-background-radius: 20px;");
        login.setTextFill(Color.WHITE);
        login.setMinHeight(10);
        login.setMinWidth(250);
        signup.setStyle("-fx-background-color:#7522d7;-fx-background-radius: 20px;-fx-border-radius: 18px;-fx-border-color:gray;");
        signup.setTextFill(Color.WHITE);
        signup.setMinHeight(10);
        signup.setMinWidth(250);
        signup.setFont(Font.font("Gill Sans",FontWeight.SEMI_BOLD,12));
        login.setFont(Font.font("Gill Sans",FontWeight.SEMI_BOLD,12));
        imageView.setFitHeight(height);


        //fields prop
        tf1=new PasswordField();                  //password field
        tf.setStyle("-fx-border-color:#7522d7;-fx-background-radius: 20px;-fx-border-radius: 18px;");
        tf.setPromptText("Enter your username");
        tf1.setPromptText("Enter your password");
        tf1.setStyle("-fx-border-color:#7522d7;-fx-background-radius: 20px;-fx-border-radius: 18px;");






        //adding components to grid, stack and borders
        stack.getChildren().add(imageView);
        stack.getChildren().add(rect);
        stack.getChildren().add(bd);
        gd.add(txt,0,2);
        gd.add(tf,0,3);
        gd.add(txt1,0,4);
        gd.add(tf1,0,5);
        gd.add(check,0,6);
        gd.add(login,0,8);
        gd.add(signup,0,10);
        gd.setHgap(3);
        gd.setVgap(2);
        gd.setAlignment(Pos.CENTER);             //alignment of the grid
        gd.setFocusTraversable(true);            //focus of the screen
        gd.autosize();
        hb.setAlignment(Pos.TOP_CENTER);
        bd.setCenter(gd);
        bd.setTop(hb);
        stage.getIcons().add(im);



        //fading property for rectangle
        FadeTransition fade = new FadeTransition();
        fade.setDuration(Duration.millis(5000));
        fade.setFromValue(10);
        fade.setToValue(0.1);
        fade.setCycleCount(1000);
        fade.setAutoReverse(true);
        fade.setNode(rect);
        fade.play();

        scn = new Scene(stack,width,height);

        //checkbox and login working

        check.setOnAction(new ShowPass(gd,check,tf1,tf2));
        login.setOnAction(new login(stage,scn,tf,tf1));
        signup.setOnAction(new signup(stage,scn,rect));






        stage.setScene(scn);
//        stage.addEventHandler(WindowEvent.WINDOW_CLOSE_REQUEST, new EventHandler<WindowEvent>() {
//            @Override
//            public void handle(WindowEvent windowEvent) {
//              try {
//                  FileWriter fw = new FileWriter("src/gui/Usernames.txt");
//                    for (HashMap<String, String> l: usernames)
//                    {
//                        fw.write(l.get("username")+"_"+l.get("password"));
//
//                    }
//                        fw.close();
//                    System.out.println(usernames);
//                }
//                catch (IOException e)
//                {
//
//                }
//            }
//        });
        stage.show();



    }



}




//        pass.add(new Password("vlogger"));
//        pass.add(new Password("coder"));
//        pass.add(new Password("intelligent"));
//        pass.add(new Password("slowmo"));
//        Image image = new Image(getClass().getResourceAsStream("image.jpg"));
//        BackgroundSize size = new BackgroundSize(100,100,true,true,true,true);
//
//        ImageView imageView = new ImageView(image);

//        BackgroundImage bi = new BackgroundImage(image, BackgroundRepeat.REPEAT,BackgroundRepeat.NO_REPEAT,BackgroundPosition.CENTER,size);
//        Background bg = new Background(bi);

//        username.add(new Username("abduvert"));
//        username.add(new Username("ibraheem"));
//        username.add(new Username("ridaabid"));
//        username.add(new Username("musaraza"));

























































