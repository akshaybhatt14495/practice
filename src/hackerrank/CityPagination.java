package hackerrank;

//https://leetcode.com/discuss/interview-question/algorithms/125518/airbnb-phone-screen-paginate-listings

import java.util.*;

public class CityPagination {

    public static void main(String[] args) {
        int p = 6;
        String input[] = new String[] {
                // 1, 4,20,23, 16

                "1,28,300.1,San Francisco","1,28,300.1,San Francisco","1,28,300.1,San Francisco","1,28,300.1,San Francisco","1,28,300.1,San Francisco","1,28,300.1,San Francisco","1,28,300.1,San Francisco",
                "4,5,209.1,San Francisco",
                "20,7,208.1,San Francisco",
                "23,8,207.1,San Francisco",
                "16,10,206.1,Oakland",

                "1,16,205.1,San Francisco",
                "1,31,204.6,San Francisco",

                "6,29,204.1,San Francisco",//*

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
                "30,23,1.1,San Jose",
                "30,23,1.0,San Jose",
                "30,23,0.9,San Jose",
                "30,23,0.8,San Jose",

        };

        System.out.println(listingSimple(input, p));
    }


    private static boolean listing(String[] input, int pageSize) {

        //get into List
        //create list of arraylist
        PriorityQueue<Host> dataSet = new PriorityQueue<>((a, b) -> (int) (b.entries.getFirst().score - a.entries.getFirst().score));
        Map<Integer, Host> map = new HashMap<>();
        for (String entryStr : input) {
            String split[] = entryStr.split(",");
            Entry e = new Entry();
            e.data = entryStr;
            e.hostId = Integer.parseInt(split[0]);
            e.score = Double.parseDouble(split[2]);
            Host host;
            if (map.containsKey(e.hostId)) {
                host = map.get(e.hostId);
                host.entries.add(e);
            } else {
                host = new Host();
                host.hostId = e.hostId;
                host.entries = new LinkedList<>();
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
            Host host = dataSet.poll();
            if (exist.contains(host.hostId)) {
                unused.add(host.entries.getFirst());
                host.entries.removeFirst();
            } else  {
                Entry e = host.entries.getFirst();
                host.entries.removeFirst();
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
                for (int i= unused.size()-1; i >= 0; i--) {
                    Entry e = unused.get(i);
                    Host unusedHost;
                    if (map.containsKey(e.hostId)) {
                        unusedHost = map.get(e.hostId);
                        unusedHost.entries.addFirst(e);
                    } else {
                        unusedHost = new Host();
                        unusedHost.hostId = e.hostId;
                        unusedHost.entries = new LinkedList<>();
                        map.put(e.hostId, unusedHost);
                        unusedHost.entries.addFirst(e);
                        dataSet.add(unusedHost);
                    }
                    counter=0;
                }
                unused.clear();
                exist.clear();
            }
        }
        counter = 0;
        for (String s : output) {

            System.out.println(s);
            counter++;
            if (counter == pageSize) {
                counter=0;
                System.out.println();
            }
        }

        return false;

    }

    private static boolean listingSimple(String[] input, int pageSize) {

        //get into List
        //create list of arraylist
        PriorityQueue<Entry> dataSet = new PriorityQueue<>((a, b) -> {
               int data =  (int) (b.score - a.score);
                if (b.score > a.score) {
                    return 1;
                } else  {
                    return -1;
                }
            }
        );
        Map<Integer, Host> map = new HashMap<>();
        for (int i=0; i< input.length; i++) {
            String entryStr =  input[i];
            String split[] = entryStr.split(",");
            Entry e = new Entry();
            e.data = entryStr;
            e.hostId = Integer.parseInt(split[0]);
            e.score = Double.parseDouble(split[2]);
            dataSet.add(e);

        }
        List<Entry> output = new ArrayList<>();
        int counter = 0;
        Set<Integer> exist = new HashSet<>();
        Queue<Entry> unused = new PriorityQueue<>((a, b) -> {
            int data =  (int) (b.score - a.score);
            if (b.score > a.score) {
                return 1;
            } else  {
                return -1;
            }
        }
        );

        while (!dataSet.isEmpty() || unused.size()>0) {
            Entry entry = dataSet.remove();
            if (exist.contains(entry.hostId)) {
                unused.add(entry);
            } else  {
                counter++;
                output.add(entry);
                exist.add(entry.hostId);
            }
            if (counter == pageSize) {
                while (!unused.isEmpty()) {
                    dataSet.add(unused.remove());

                }
                counter=0;
                unused.clear();
                exist.clear();
            }
        }
        int fullPages = input.length-unused.size()/pageSize;
        counter = 0;
        int i=0;
        for (i=0; i< output.size(); i++) {
            System.out.println(output.get(i).data);
            counter++;
            if (counter == pageSize) {
                counter=0;
                System.out.println();
                fullPages--;
                if (fullPages==1) {
                    break;
                }
            }
        }
        while (i < output.size()) {
            unused.add(output.get(i));
            i++;
        }
        for (Entry e : unused) {
            System.out.println(e.data);
            counter++;
            if (counter == pageSize) {
                counter=0;
                System.out.println();
            }
        }

        return false;

    }
}

class Host {
    LinkedList<Entry> entries;
    int hostId;
}
class Entry {
    int hostId;
    double score;
    String data;
}