package semesterProject;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import static gui.Paa.usernames;

public class AddingTask implements EventHandler {

    Stage stage;
    Stage stage1;
    Scene addscn;
    Scene scn;
    TextField task = new TextField();
    DatePicker date;
    VBox vb1;

    static ArrayList<HashMap<String,String>> tasks = new ArrayList<>();
    static HashMap<String,String> taskName = new HashMap<>();
    static ArrayList<String> description = new ArrayList<>();
    static ArrayList<LocalDate> dat = new ArrayList<>();

    TextArea des = new TextArea();
    int count=0;


    public AddingTask(Stage stage1,Scene scn, TextArea des ,TextField task, DatePicker date, VBox vb1){

        this.stage1 = stage1;
        this.scn = scn;
        this.task = task;
        this.date = date;
        this.des = des;
        this.vb1 = vb1;

    }


    @Override
    public void handle(Event event) {
        try {
            FileWriter fw = new FileWriter("src/gui/TaskName.txt");
            taskName.put("task",task.getText());
            taskName.put("description",des.getText());

            tasks.add(taskName);
            System.out.println(usernames);
            taskName = new HashMap<>();

            for(HashMap<String,String> l : tasks) {

                    count++;
                    fw.write(l.get("task") + "_" + l.get("description") + "\n");
                    String a = "" + count;
                    
                    Button task1 = new Button(a);
                    if (count % 2 == 0) {
                        task1.setStyle("-fx-background-color: linear-gradient(to bottom left, #3333ff 0%, #66ff99 100%);");
                    } else {
                        task1.setStyle("-fx-background-color: linear-gradient(to top left, #33cc33 0%, #ffff00 100%);");
                    }
                    task1.setMinHeight(30);
                    task1.setMinWidth(150);
                    task1.setShape(new Rectangle(7, 10));
                    vb1.getChildren().add(task1);
                }

            fw.close();
            System.out.println(tasks);
        }
        catch (IOException e)
        {

        }
        stage1.close();
    }


    public void forme()
    {
        System.out.println(tasks);
        System.out.println(description);
        System.out.println(dat);
    }

}
