package ComapareTest;

import java.util.*;

public class SortMapByValues {
    public static void main(String[] args) {
        Map<String, Integer> studentMap= new HashMap<String, Integer>();
        studentMap.put("ram",4);
        studentMap.put("raj",5);
        studentMap.put("kishore",2);

        Set<String> nameSet= studentMap.keySet();
        List<String> names = new ArrayList<>(nameSet);
        Collections.sort(names, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return studentMap.get(o2)-studentMap.get(o1);
            }
        });

        for (int i = 0; i < 2; i++) {
            names.get(i);
        }
    }
}
