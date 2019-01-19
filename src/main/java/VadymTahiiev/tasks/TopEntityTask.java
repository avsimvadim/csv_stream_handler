package VadymTahiiev.tasks;

import VadymTahiiev.listing_data.TopEntity;
import VadymTahiiev.utils.Entity;

import java.util.List;
import java.util.Map;

public class TopEntityTask implements Runnable{
    private Map<String, Long> task;
    private List<List<String>> data;
    private Entity entity;
    private int topNumber;

    public TopEntityTask(List<List<String>> data, Entity entity, int topNumber) {
        this.data = data;
        this.entity = entity;
        this.topNumber = topNumber;
    }

    @Override
    public void run(){
        task = new TopEntity().findTopUsedEntity(data, entity, topNumber);
    }

    public Map<String, Long> getTask(){
        return task;
    }
}
