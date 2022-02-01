package zookeeper;

//zookeeper
import java.util.*;

/*
key
/app
/app/1
/app/2
/

app1                app2

l1 l2 l3            l12


*/

class Node {
    //initial node
    /*
        key: /app/v1/p1
        map {key: app1 --> Next Node, app2...}
        value: 
    */
    String key;
    Map<String, zookeeper.Node> map;
    String value;
}

public class Zookeeper {

    static zookeeper.Node root;
    public static void initialize() {
        //root node
        root = new zookeeper.Node();
        root.key = "/";
        root.map = new HashMap<>();
        root.value = "";
    }



    public static String add(String key, String value) {
        // /app/v1/p1
        if (key.equals("/")) {
            return "Parent Path Not Exist";
        }
        String splitString[] = key.split("/");
        zookeeper.Node p = root;
        for (int i=1;i <splitString.length-1; i++) {
            //app
            String pathKey = splitString[i];
            if (p.map.containsKey(pathKey)) {
                p = p.map.get(pathKey);
            } else {
                return "Parent Path Not Exist";
            }
        }
        String suffix = splitString[splitString.length-1];
        if (p.map.containsKey(suffix)) {
            return "Key already exist. Cannot Create";
        }
        zookeeper.Node newKey = new zookeeper.Node();
        newKey.key = suffix;
        newKey.map = new HashMap<>();
        newKey.value = value;
        p.map.put(suffix, newKey);
        return "";
    }


    public static String update(String key, String value) {
        // /app/v1/p1
        String splitString[] = key.split("/");
        zookeeper.Node p = root;
        for (int i=1;i <splitString.length; i++) {
            //app
            String pathKey = splitString[i];
            if (p.map.containsKey(pathKey)) {
                p = p.map.get(pathKey);
            } else {
                return "Path Not Exist";
            }
        }
        p.value = value;
        return "";
    }

    public static String read(String key) {
        // /app/v1/p1
        String splitString[] = key.split("/");
        zookeeper.Node p = root;
        for (int i=1;i<splitString.length; i++) {
            //app
            String pathKey = splitString[i];
            if (p.map.containsKey(pathKey)) {
                p = p.map.get(pathKey);
            } else {
                return "Error: Path Not Exist";
            }
        }
        return p.value;
    }


    public static void main(String[] args) {

        initialize();
        System.out.println("Add: " + add("/", "app"));
        System.out.println("Add: " + add("/app", "app invalid"));

        System.out.println(add("/app/v1", "v1"));
        System.out.println(add("/app/v2", "v2"));

        System.out.println(update("/app", "appUpdated"));
        System.out.println(update("/app/v3", "v3"));
        System.out.println(read("/app"));

        System.out.println(read("/app/v2"));

    }
}


