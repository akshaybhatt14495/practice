package hackerrank;

//https://leetcode.com/discuss/interview-question/algorithms/125518/airbnb-phone-screen-paginate-listings
//https://www.careercup.com/question?id=5642631987068928
import java.util.*;

public class CityPaginationWithPQ {

    public static void main(String[] args) {
        int p = 6;
        String input[] = new String[] {
                // 1, 4,20,23, 16

                "1,28,300.1,San Francisco",
                "4,5,209.1,San Francisco",
                "20,7,208.1,San Francisco",
                "23,8,207.1,San Francisco",
                "16,10,206.1,Oakland",
                "1,16,205.1,San Francisco",
                "1,31,204.6,San Francisco",
                "6,29,204.1,San Francisco",
                "7,20,203.1,San Francisco",
                "8,21,202.1,San Francisco",
                "2,18,201.1,San Francisco",
                "2,30,200.1,San Francisco",
                "15,27,109.1,Oakland",
                "10,13,108.1,Oakland",
                "11,26,107.1,Oakland",
                "12,9,106.1,Oakland",
                "13,1,105.1,Oakland",
                "22,17,104.1,Oakland",
                "1,2,103.1,Oakland",
                "28,24,102.1,Oakland",
                "18,14,11.1,San Jose",
                "6,25,10.1,Oakland",
                "19,15,9.1,San Jose",
                "3,19,8.1,San Jose",
                "3,11,7.1,Oakland",
                "27,12,6.1,Oakland",
                "1,3,5.1,Oakland",
                "25,4,4.1,San Jose",
                "5,6,3.1,San Jose",
                "29,22,2.1,San Jose",
                "30,23,1.1,San Jose"
        };

        System.out.println(listing(input, p));
    }


    private static boolean listing(String[] input, int pageSize) {

        //get into List
        //create list of arraylist
        PriorityQueue<HostWithPQ> dataSet = new PriorityQueue<>((a, b) -> (int) (b.entries.peek().score - a.entries.peek().score));
        Map<Integer, HostWithPQ> map = new HashMap<>();
        for (String entryStr : input) {
            String split[] = entryStr.split(",");
            Entry e = new Entry();
            e.data = entryStr;
            e.hostId = Integer.parseInt(split[0]);
            e.score = Double.parseDouble(split[2]);
            HostWithPQ host;
            if (map.containsKey(e.hostId)) {
                host = map.get(e.hostId);
                host.entries.add(e);
            } else {
                host = new HostWithPQ();
                host.hostId = e.hostId;
                host.entries = new PriorityQueue<>((a,b) -> (int) (b.score - a.score));
                map.put(e.hostId, host);
                host.entries.add(e);
                dataSet.add(host);
            }

        }
        List<String> output = new ArrayList<>();
        int counter = 0;
        Set<Integer> exist = new HashSet<>();
        List<Entry> unused = new ArrayList<>();

        while (!dataSet.isEmpty()) {
            HostWithPQ host = dataSet.remove();
            if (exist.contains(host.hostId)) {
                unused.add(host.entries.remove());
            } else  {
                Entry e = host.entries.remove();
                counter++;
                output.add(e.data);
                exist.add(e.hostId);
            }
            if (!host.entries.isEmpty()) {
                dataSet.add(host);
            } else {
                map.remove(host.hostId);
            }

            if (counter == pageSize) {
                for (Entry e : unused) {
                    HostWithPQ unusedHostWithPQ;
                    if (map.containsKey(e.hostId)) {
                        unusedHostWithPQ = map.get(e.hostId);
                        unusedHostWithPQ.entries.add(e);
                    } else {
                        unusedHostWithPQ = new HostWithPQ();
                        unusedHostWithPQ.hostId = e.hostId;
                        unusedHostWithPQ.entries = new PriorityQueue<>((a,b) -> (int) (b.score - a.score));
                        map.put(e.hostId, host);
                        unusedHostWithPQ.entries.add(e);
                        dataSet.add(host);
                    }
                    counter=0;
                }
                unused.clear();
                exist.clear();
            }
        }

        System.out.println(output);
        return false;

    }
}



class HostWithPQ {
    PriorityQueue<Entry> entries;
    int hostId;
}