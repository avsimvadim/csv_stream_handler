package VadymTahiiev;

import VadymTahiiev.data.DataHandler;
import VadymTahiiev.data.PutToFile;
import VadymTahiiev.model.Application;
import VadymTahiiev.model.Protocol;
import VadymTahiiev.model.Receiver;
import VadymTahiiev.model.Transmitter;
import VadymTahiiev.tasks.TopEntityTask;
import VadymTahiiev.tasks.TopTrafficConsumersTask;
import VadymTahiiev.utils.ConvertType;
import VadymTahiiev.utils.Entity;
import VadymTahiiev.utils.Operation;
import VadymTahiiev.utils.Stream;

import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;


public class Runner {
    public static void main(String[] args) {
        DataHandler dataHandler = new DataHandler();
        String path = "\\Users\\avsim\\IdeaProjects\\csv_stream_handler\\src\\main\\resources\\data.csv";
        List<List<String>> stringData = dataHandler.toHandleData(path);

        ExecutorService service = Executors.newFixedThreadPool(4);
        TopEntityTask topAppTask = new TopEntityTask(stringData, Entity.APPLICATION, 10);
        TopEntityTask topProtocolTask = new TopEntityTask(stringData, Entity.PROTOCOL, 10);
        TopTrafficConsumersTask topTrafficReceiversTask = new TopTrafficConsumersTask(stringData, Stream.RECEIVER, 10);
        TopTrafficConsumersTask topTrafficTransmittersTask = new TopTrafficConsumersTask(stringData, Stream.TRANSMITTER, 10);
        service.submit(topAppTask);
        service.submit(topProtocolTask);
        service.submit(topTrafficReceiversTask);
        service.submit(topTrafficTransmittersTask);
        service.shutdown();
        while(!service.isTerminated()){
            try {
                service.awaitTermination(5000, TimeUnit.MILLISECONDS);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        ConvertType convertType = new ConvertType();
        List<Application> applications = (List<Application>) convertType.convert(topAppTask, Operation.TOP_APP);
        List<Protocol> protocols = (List<Protocol>) convertType.convert(topProtocolTask, Operation.TOP_PROTOCOLS);
        List<Receiver> receivers = (List<Receiver>) convertType.convert(topTrafficReceiversTask, Operation.TOP_RECEIVERS);
        List<Transmitter> transmitters = (List<Transmitter>) convertType.convert(topTrafficTransmittersTask, Operation.TOP_TRANSMITTERS);

        PutToFile putToFile = new PutToFile();
        putToFile.putToFile(applications, Operation.TOP_APP);
        putToFile.putToFile(protocols, Operation.TOP_PROTOCOLS);
        putToFile.putToFile(receivers, Operation.TOP_RECEIVERS);
        putToFile.putToFile(transmitters, Operation.TOP_TRANSMITTERS);

    }
}
