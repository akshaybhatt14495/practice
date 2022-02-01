package microsoft;

public class PlaneSeat {
    public static void main(String[] args) {
        System.out.println(new PlaneSeat().solution(1, ""));
    }
    public int solution(int N, String S) {
        // write your code in Java SE 8
        int seats[][] = new int[N][10];

        int rowReserved[] = new int[N];
        String []reserved = S.split(" ");
        for (String s : reserved) {
            if (s.isEmpty()) continue;
            char col = s.charAt(s.length()-1);
            int row = Integer.parseInt(s.substring(0, s.length()-1))-1;
            if (col>='A' && col<='H') {
                seats[row][col-'A']=-1;
            } else {
                seats[row][col-'A'-1]=-1;
            }
            rowReserved[row]=1;
        }

        int family=0;
        for (int i=0; i<N;i++) {
            if (rowReserved[i]==0) {
                family=family+2;
                continue;
            }
            int personCount=0;

            int j=1;
            while(j < 10) {
                if (seats[i][j] == 0) {
                    personCount++;
                    if (personCount==4) {
                        personCount=0;
                        family++;
                    }
                    j++;
                } else { //-1
                    //012 3456 789
                    //*00 0000 000
                    if (j==1) {
                        j=3;
                    } else if (j==3) {
                        j=5;
                    } else if (j>=5) {
                        break;
                    } else {
                        j++;
                    }
                    personCount=0;
                }
            }
        }

        return family;
    }
}
