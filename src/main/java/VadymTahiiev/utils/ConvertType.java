package VadymTahiiev.utils;

import VadymTahiiev.model.*;
import VadymTahiiev.tasks.TopEntityTask;
import VadymTahiiev.tasks.TopTrafficConsumersTask;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ConvertType {
    private List<Application> result1;
    private List<Protocol> result2;
    private List<Receiver> result3;
    private List<Transmitter> result4;
    private Set<String> keySet;


    public List<? extends Model> convert(TopEntityTask topEntityTask, Operation operation) {
        if (operation.equals(Operation.TOP_APP)){
            return convertationApplication(topEntityTask.getTask());
        } else {
            return convertationProtocol(topEntityTask.getTask());
        }
    }

    public List<? extends Model> convert(TopTrafficConsumersTask topTrafficConsumersTask, Operation operation) {
        if (operation.equals(Operation.TOP_RECEIVERS)){
            return convertationReceiver(topTrafficConsumersTask.getTask());
        } else {
            return convertationTransmitter(topTrafficConsumersTask.getTask());
        }

    }

    private List<Application> convertationApplication(Map<String, Long> map) {
        result1 = new ArrayList<Application>();
        keySet = map.keySet();
        for (String key : keySet) {
            Application app = new Application(key, map.get(key));
            result1.add(app);
        }
        return result1;
    }

    private List<Protocol> convertationProtocol(Map<String, Long> map) {
        result2 = new ArrayList<Protocol>();
        keySet = map.keySet();
        for (String key : keySet) {
            Protocol protocol = new Protocol(key, map.get(key));
            result2.add(protocol);
        }
        return result2;
    }

    private List<Receiver> convertationReceiver(Map<String, Long> map) {
        result3 = new ArrayList<Receiver>();
        Set<String> keySet = map.keySet();
        for (String key : keySet) {
            Receiver receiver = new Receiver(key, map.get(key));
            result3.add(receiver);
        }
        return result3;
    }

    private List<Transmitter> convertationTransmitter(Map<String, Long> map) {
        result4 = new ArrayList<Transmitter>();
        Set<String> keySet = map.keySet();
        for (String key : keySet) {
            Transmitter transmitter = new Transmitter(key, map.get(key));
            result4.add(transmitter);
        }
        return result4;
    }
}