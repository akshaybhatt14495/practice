package nyka;


import java.util.*;

class Edge {
    boolean visited;
    String hash;

    public Edge( String hash) {
        this.visited = false;
        this.hash = hash;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Edge edge = (Edge) o;
        return visited == edge.visited && Objects.equals(hash, edge.hash);
    }

    @Override
    public int hashCode() {
        return Objects.hash(hash);
    }
}

class Tile{
    Set<Edge> sides;
    int id;

    Tile(int id, int[][] pixels) {
        sides=new HashSet<>();
        String hashTop="", hashBottom="",hashLeft="",hashRight="";
        for (int i=0;i<pixels.length;i++){
                hashLeft+=pixels[i][0];
                hashRight+=pixels[i][pixels[i].length-1];
        }
        for (int i=0;i<pixels[0].length;i++){
            hashTop+=pixels[0][i];
            hashRight+=pixels[pixels.length-1][i];
        }
        sides.add(new Edge(hashBottom));
        sides.add(new Edge(hashRight));
        sides.add(new Edge(hashLeft));
        sides.add(new Edge(hashTop));
        this.id=id;
    }
}

public class JigSaw {

    public static void main(String[] args) {
        Tile image[][]=new Tile[3][3];

        Tile []tiles=new Tile[9];
        Map<String, List<Tile>> sideHash=new HashMap<>();
        for (int i=0; i<tiles.length;i++) {
            for (Edge e: tiles[i].sides) {
                List<Tile> t =sideHash.getOrDefault(e.hash, new ArrayList<>());
                t.add(tiles[i]);
                sideHash.put(e.hash,t);
            }
        }








    }
}
