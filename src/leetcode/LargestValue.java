package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LargestValue {

    public static void main(String[] args) {
        //[5,4,3,2,1], labels = [1,1,2,2,3]
        //System.out.println(new LargestValue().largestValsFromLabels(new int[]{5,4,3,2,1}, new int[]{1,1,2,2,3}, 3,1));
        //TaskScheduler
        System.out.println(new LargestValue().leastInterval(new char[]{'A','A','A','B','B','B'},2));
    }

    class Task {
        int count;
        int lastTask;
    }

    //A3 b3
    //1+1+(2-(1-0))=1
    //ifn=4
    //A-->t=1,b-->t2-->A(2-1-1)
    public int leastInterval(char[] tasks, int n) {
        Task[] aggr=new Task[26];
        for (int i=0;i<tasks.length;i++){
            Task t ;
            if(aggr[tasks[i]-'A']==null){
                aggr[tasks[i]-'A']=new Task();
                aggr[tasks[i]-'A'].lastTask=-n;
            }

            aggr[tasks[i]-'A'].count++;

        }
        for (int i=0;i<26;i++){
            if(aggr[i]==null){
                aggr[i]=new Task();
            }
        }
        Arrays.sort(aggr,((o1, o2)->o2.count-o1.count));


        int time=0;
        int totalTasks=tasks.length;
        int i=0;
        while(totalTasks>0){
            Task t=aggr[i];
            if (t.count!=0){
                int additionalTime=(n-(time-t.lastTask));
                if (additionalTime<0){
                    additionalTime=0;
                }
                time=time+1+additionalTime;

                totalTasks--;
                t.count--;
                t.lastTask=time;
            }
            i=(i+1)%26;
        }

        return time;
    }

    public int largestValsFromLabels(int[] values, int[] labels, int numWanted, int useLimit) {

        int []score=new int[1];

        Map<Integer,Integer> map=new HashMap<>();
        getLargest(values,labels,numWanted,useLimit,0,0, score, map,0);

        return score[0];

    }

    void getLargest(int[] values, int[] labels, int numWanted, int useLimit, int idx,int count,int []score,  Map<Integer,Integer> map, int tempScore) {

        if (idx==values.length) {
            if (count<=numWanted) {
                score[0]=Math.max(tempScore, score[0]);

            }
            return;
        }
        int labelCount= map.getOrDefault(labels[idx],0);

        if (labelCount<useLimit && count<numWanted){
            map.put(labels[idx],labelCount+1);
            getLargest(values,labels,numWanted,useLimit, idx+1,count+1,score,map,   tempScore+values[idx]);
            labelCount=map.getOrDefault(labels[idx],0);
            map.put(labels[idx],labelCount-1);
        } else {
            score[0]=Math.max(tempScore, score[0]);
        }
        getLargest(values,labels,numWanted,useLimit, idx+1,count,score,map, tempScore);
    }
    public String licenseKeyFormatting(String s, int k) {

        int i=s.length()-1;
        StringBuilder sb=new StringBuilder();
        int count=0;
        while(i>=0) {

            if (k==count) {
                sb.insert(0,"-");
                count=0;
                continue;
            }
            if (Character.isLetter(s.charAt(i)) ||Character.isDigit(s.charAt(i))) {
                count++;
                sb.insert(0, Character.toUpperCase(s.charAt(i)));
            }
            i--;
        }

        sb.deleteCharAt(0);
        return sb.toString();
    }

}
