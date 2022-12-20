package semesterProject;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

public class Files {

    File file = new File("src/gui/Usernames.txt");
    File ta = new File("src/gui/TaskName.txt");
    static HashMap<String, String> user= new HashMap<>();



    public void filess()
    {

            try{
                        Scanner reader = new Scanner(file);
                        Scanner Taskreader = new Scanner(ta);
//                file.createNewFile();
//                FileWriter fw = new FileWriter(file);
                if(file.exists()) {
//                        fw.write("hhrh");
//                        fw.close();
                    while (reader.hasNext()) {
                            String a[] = reader.nextLine().split("_");
                            user.put("username",a[0]);
                            user.put("password",a[1]);

                            Paa.usernames.add(user);
                            user = new HashMap<>();
                    }
                    reader.close();
                    while (Taskreader.hasNext()) {
                            String a[] = Taskreader.nextLine().split("_");

                            AddingTask.taskName.put("task",a[0]);

                            AddingTask.taskName.put("description",a[1]);


                            AddingTask.tasks.add(AddingTask.taskName);
                            AddingTask.taskName = new HashMap<>();
                    }
                    System.out.println(AddingTask.tasks);
                    Taskreader.close();
                }
                if(!file.exists()) {
                    System.out.println("BHAE");


                }
            }
            catch(IOException e)
            {
                System.out.println("Bad" + e.getMessage());
                e.printStackTrace();
            }
    }
}
