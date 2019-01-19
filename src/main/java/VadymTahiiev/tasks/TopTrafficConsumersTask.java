package VadymTahiiev.tasks;

import VadymTahiiev.listing_data.TopStreams;
import VadymTahiiev.utils.Stream;

import java.util.List;

public class TopTrafficConsumersTask implements Runnable{
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
        new TopStreams().getTopStreams(data, streamType, topNumber);
    }
}
