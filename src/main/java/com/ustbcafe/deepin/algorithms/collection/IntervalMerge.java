package com.ustbcafe.deepin.algorithms.collection;


import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class IntervalMerge {

    public List<Interval> merge(List<Interval> intervals){

        int[] starts=new int[intervals.size()];
        int[] ends=new int[intervals.size()];
        for(int i=0;i<intervals.size();i++){
            starts[i]=intervals.get(i).start;
            ends[i]=intervals.get(i).end;
        }
        Arrays.sort(starts);
        Arrays.sort(ends);
        List<Interval> mergeIntervals=new ArrayList<>();
        for(int i=0,j=0;i<intervals.size();i++){
            if(i==intervals.size()-1||starts[i+1]>ends[i]){
                mergeIntervals.add(new Interval(starts[j],ends[i]));
                j=i+1;
            }
        }
        return mergeIntervals;
    }


    public static void main(String[] args){

        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt(); //
        scanner.nextLine();
        System.out.println("please input "+n+" interval,split by `,`");
        List<Interval> intervals=new ArrayList<>();
        for(int i=0;i<n;i++){
          String interval=  scanner.nextLine();
          String[] arrs=interval.split(",");
          if(arrs.length==2){
            int start=  Integer.parseInt(arrs[0]);
            int end=  Integer.parseInt(arrs[1]);
              intervals.add(new Interval(start,end));
          }
        }
        IntervalMerge intervalMerge=new IntervalMerge();
        List<Interval> mergedIntervals=intervalMerge.merge(intervals);
        System.out.println(JSON.toJSON(mergedIntervals));

    }

}

class Interval{

    int start;
    int end;
    Interval(int start,int end){
        this.start=start;
        this.end=end;
    }
    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getEnd() {
        return end;
    }

    public void setEnd(int end) {
        this.end = end;
    }
}
