package VadymTahiiev.utils;

import VadymTahiiev.model.Receiver;
import VadymTahiiev.tasks.TopEntityTask;
import VadymTahiiev.tasks.TopTrafficConsumersTask;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ConvertType<T> {
    private List<T> result = new ArrayList<>();
    public List<T> convertMapToString(TopEntityTask topEntityTask){
        return convertation(topEntityTask.getTask());
    }

    public List<T> convertMapToString(TopTrafficConsumersTask topTrafficConsumersTask){
        return convertation(topTrafficConsumersTask.getTask());
    }

    private List<T> convertation(Map<String, Long> map){
        Set<String> keySet = map.keySet();
        for(String key: keySet){
            Receiver receiver = new Receiver(key, map.get(key));
            result.add(receiver);
        }
        return result;
    }
}
