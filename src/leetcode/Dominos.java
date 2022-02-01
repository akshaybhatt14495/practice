package leetcode;

class Dominos {
    public static void main(String[] args) {
        //2,1,2,4,2,2
        System.out.println(new Dominos().minDominoRotations(new int[]{2,1,2,4,2,2}, new int[]{5,2,6,2,3,2}));
    }
    public int minDominoRotations(int[] tops, int[] bottoms) {
        int minSwaps=Integer.MAX_VALUE;

        //making top dominos
        for (int target=1; target<=6;target++) {
            int swaps=0;
            for (int i=0; i<tops.length;i++) {
                if (tops[i]!=target && bottoms[i]!=target) {
                    swaps=Integer.MAX_VALUE;
                    break;
                } else if (tops[i]!=target && bottoms[i]==target) {
                    swaps++;
                }
            }
            minSwaps=Math.min(minSwaps, swaps);

            swaps=0;
            for (int i=0; i<tops.length;i++) {
                if (bottoms[i]!=target && tops[i]!=target) {
                    swaps=Integer.MAX_VALUE;
                    break;
                } else if (bottoms[i]!=target && tops[i]==target) {
                    swaps++;
                }
            }
            minSwaps=Math.min(minSwaps, swaps);

        }

        return minSwaps==Integer.MAX_VALUE ? -1 :minSwaps;

    }
}