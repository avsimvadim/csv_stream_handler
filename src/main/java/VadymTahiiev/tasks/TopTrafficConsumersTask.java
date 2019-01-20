package VadymTahiiev.tasks;

import VadymTahiiev.listing_data.TopStreams;
import VadymTahiiev.utils.Stream;

import java.util.List;
import java.util.Map;

public class TopTrafficConsumersTask implements Runnable{
    private Map<String, Long> task;
    private List<List<String>> data;
    private Stream streamType;
    private int topNumber;

    public TopTrafficConsumersTask(List<List<String>> data, Stream streamType, int topNumber) {
        this.data = data;
        this.streamType = streamType;
        this.topNumber = topNumber;
    }

    @Override
    public void run(){
        task = new TopStreams().getTopStreams(data, streamType, topNumber);
    }

    public Map<String, Long> getTask(){
        return task;
    }
}
