package Hash;

import java.util.*;

/**
 * print name of top n students having score in descending order
 * Asked in Google
 */
public class TopNbyValueHashMap {
    public static void main(String[] args) {
        Map<String,Integer> inputMap = new HashMap<>();
        inputMap.put("a",4);
        inputMap.put("b",4);
        inputMap.put("c",2);
        List<String> result=getTopByCount(inputMap,2);
        if(result==null)
            System.out.println("error message");
        System.out.println(result.toString());
    }

    private static List<String> getTopByCount(Map<String, Integer> inputMap, int n) {
        if(inputMap.isEmpty() || n==0)
            return null;
        HashMap<String, Integer> messageMap=new HashMap<>();
        for (Map.Entry<String,Integer> message: inputMap.entrySet()) {
            if(messageMap.containsKey(message.getKey())){
                messageMap.put(message.getKey(),messageMap.get(message.getKey())+message.getValue());
            }
            else {
                messageMap.put(message.getKey(),message.getValue());
            }
        }

//        return getTopNStrings(inputMap, n);
        return topNKeys(inputMap,n);
    }

    //Sorting hashmap based on values
    private static List<String> getTopNStrings(Map<String, Integer> inputMap, int n) {
        Set<String> set= inputMap.keySet();
        List<String> userList= new ArrayList<>(set);
        //Sorting in descending order
        Collections.sort(userList, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                if( inputMap.get(s1)== inputMap.get(s2))
                    return 0;
                if( inputMap.get(s1)< inputMap.get(s2))
                    return 1;
                else return -1;
            }
        });
        return userList.subList(0, n);
    }

    //Using priority queue (Min Heap) of size n
    public static List<String> topNKeys(final Map<String, Integer> map, int n) {
        PriorityQueue<String> topN = new PriorityQueue<>(n, new Comparator<String>() {
            //Natural sorting 1.2 ascending
            public int compare(String s1, String s2) {
                return Integer.compare(map.get(s1), map.get(s2));
            }
        });

        //If heap is full .. removing root (min) and adding new
        for(String key:map.keySet()){
            if (topN.size() < n)
                topN.add(key);
            else if (map.get(topN.peek()) < map.get(key)) {
                topN.poll();
                topN.add(key);
            }
        }
        return (List) Arrays.asList(topN.toArray());
    }
}
