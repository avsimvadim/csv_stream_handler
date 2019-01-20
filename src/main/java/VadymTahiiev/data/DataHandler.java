package VadymTahiiev.data;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DataHandler {
    private final static int FILESIZE = 13000;

    public List<List<String>> toHandleData(String path){
        List<List<String>> result = new ArrayList<>(FILESIZE);
        try(BufferedReader br = new BufferedReader(new FileReader(path))){
            String line;
            br.readLine();
            while((line = br.readLine()) != null){
                List<String> row = new ArrayList<>();
                for (String element: line.split(",")) {
                    row.add(element);
                }
                result.add(row);
            }
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }
        return result;
    }
}
