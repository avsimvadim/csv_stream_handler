package VadymTahiiev.utils;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class SortingMap {
    private static Map<String, Long> resultMap;

    public static Map<String, Long> sortedMapMaker(Map<String, Long> stream, int topNumber) {
        resultMap = stream.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .limit(topNumber)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                        (oldValue, newValue) -> oldValue, LinkedHashMap::new));
        return resultMap;
    }
}
