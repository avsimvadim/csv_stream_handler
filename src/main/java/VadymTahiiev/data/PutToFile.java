package VadymTahiiev.data;

import VadymTahiiev.model.Receiver;
import VadymTahiiev.utils.Operation;
import com.google.gson.Gson;

import java.io.*;
import java.util.List;

public class PutToFile<T> {

    public void putToFile(List<T> receiverList, Operation operationType){
        Gson gson = new Gson();
        String g1 = gson.toJson(receiverList.get(0));
        String g2 = gson.toJson(receiverList.get(1));

        File file = new File("Users\\avsim\\IdeaProjects\\csv_stream_handler" +
                "\\src\\main\\java\\VadymTahiiev\\data\\" + operationType.toString() + ".txt");

        try(FileWriter fw = new FileWriter(file)){
            fw.write(g1 + "\n");
            fw.write(g2);
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
