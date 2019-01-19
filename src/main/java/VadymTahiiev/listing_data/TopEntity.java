package VadymTahiiev.listing_data;

import VadymTahiiev.utils.Entity;
import VadymTahiiev.utils.SortingMap;

import java.util.*;

public class TopEntity {
    private Map<String, Long> entity;

    public TopEntity() {
        entity = new HashMap<>();
    }

    public Map<String, Long> findTopUsedEntity(List<List<String>> data, Entity entityType, int topNumber) {
        long dataVolume = 0;
        String entityName;
        for(List<String> rows: data){
            if (entityType == Entity.APPLICATION){
                entityName = rows.get(5).trim();
            } else {
                entityName = rows.get(7).trim();
            }
            if (!entityName.equals("")) {
                dataVolume = (Long.valueOf(rows.get(1)) + Long.valueOf(rows.get(2)));
                if (!entity.containsKey(entityName)) {
                    entity.put(entityName, dataVolume);
                } else {
                    dataVolume = entity.get(entityName) + dataVolume;
                    entity.put(entityName, dataVolume);
                }
            }
        }
        return SortingMap.sortedMapMaker(entity, topNumber);
    }

}
