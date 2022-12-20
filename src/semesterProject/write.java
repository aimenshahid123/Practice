package semesterProject;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.TextField;
import javafx.stage.WindowEvent;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;

import static gui.Paa.usernames;

public class write{

    String user;
    String pass;

    public write(String user, String pass) {
        this.user = user;
        this.pass = pass;
    }


    public void handle() {
        try {
            FileWriter fw = new FileWriter("src/gui/Usernames.txt");
            Files.user.put("username",user);
            Files.user.put("password",pass);

            Paa.usernames.add(Files.user);
            System.out.println(usernames);
            Files.user = new HashMap<>();

            for(HashMap<String,String> l : usernames)
            {
                fw.write(l.get("username")+"_"+l.get("password")+ "\n");
                System.out.println("HOGAYAAAA");
            }
            fw.close();
            System.out.println(usernames);
        }
        catch (IOException e)
        {

        }
    }
}

