package VadymTahiiev.listing_data;

import VadymTahiiev.utils.SortingMap;
import VadymTahiiev.utils.Stream;

import java.util.*;

public class TopStreams {
    private Map<String,Long> stream;

    public TopStreams() {
        stream = new HashMap<>();
    }

    public Map<String, Long> getTopStreams(List<List<String>> data, Stream streamType, int topNumber ){
        long bytesStream = 0;
        long totalBytes = 0;
        String streamName;
        for(List<String> rows: data){
            if (streamType == Stream.RECEIVER){
                bytesStream = Long.valueOf(rows.get(1).trim());
                streamName = rows.get(6);
            } else {
                bytesStream = Long.valueOf(rows.get(2).trim());
                streamName = rows.get(8);
            }
            if (!stream.containsKey(streamName)){
                stream.put(streamName,bytesStream);
            } else {
                totalBytes = stream.get(streamName) + bytesStream;
                stream.put(streamName,totalBytes);
            }
        }
        return SortingMap.sortedMapMaker(stream, topNumber);
    }

}
