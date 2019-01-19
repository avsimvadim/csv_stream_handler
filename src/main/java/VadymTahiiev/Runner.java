package VadymTahiiev;

import VadymTahiiev.dao.DataHandler;
import VadymTahiiev.listing_data.TopStreams;
import VadymTahiiev.tasks.TopEntityTask;
import VadymTahiiev.tasks.TopTrafficConsumersTask;
import VadymTahiiev.utils.Entity;
import VadymTahiiev.utils.Stream;

import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
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

    }
}
