package VadymTahiiev.data;

import VadymTahiiev.model.Application;
import VadymTahiiev.model.Model;
import VadymTahiiev.model.Receiver;
import VadymTahiiev.utils.Operation;
import com.google.gson.Gson;

import java.io.*;
import java.util.List;

public class PutToFile<T extends Model> {

    public void putToFile(List<T> receiverList, Operation operationType){
        Gson gson = new Gson();

        File file = new File("\\Users\\avsim\\IdeaProjects\\csv_stream_handler" +
                "\\src\\main\\java\\VadymTahiiev\\data\\" + operationType.toString() + ".txt");

        try(FileWriter fw = new FileWriter(file, false)){
            if (operationType.equals(Operation.TOP_APP)) {
                for (T t: receiverList){
                    String string = gson.toJson(t);
                    fw.write(string + "\n");
                }
            } else if (operationType.equals(Operation.TOP_PROTOCOLS)) {
                for (T t: receiverList){
                    String string = gson.toJson(t);
                    fw.write(string + "\n");
                }
            } else if (operationType.equals(Operation.TOP_RECEIVERS)) {
                for (T t: receiverList){
                    String string = gson.toJson(t);
                    fw.write(string + "\n");
                }
            } else {
                for (T t: receiverList){
                    String string = gson.toJson(t);
                    fw.write(string + "\n");
                }
            }
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
