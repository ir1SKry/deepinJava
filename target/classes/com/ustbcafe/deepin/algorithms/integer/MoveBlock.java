package com.ustbcafe.deepin.algorithms.integer;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Rudy Steiner on 2017/3/24.
 * UVA 101
 */
public class MoveBlock {

    class Location{
        int tableIndex;
        int valueIndex;
        public Location(int tableIndex,int valueIndex){
            this.tableIndex=tableIndex;
            this.valueIndex=valueIndex;
        }
    }
    List<Integer> tables[];
    public MoveBlock(int tables){
        this.tables=new ArrayList[tables];
        init();
    }
    private void init(){
        int len=tables.length;
        for(int i=0;i<len;i++){
             if(tables[i]==null)
                 tables[i]=new ArrayList<>();
             tables[i].add(i);
        }
    }
    private Location findBlock(int block){
         int tableIndex=0;
         int  valueIndex=0;
         int  flag=0;
        for(List<Integer> list: tables){
            valueIndex=0;
            for(Integer integer:list){
                if(integer.intValue()==block){
                    flag=1;
                    break;
                }
                valueIndex++;
            }
            if(flag==1){
                break;
            }
            tableIndex++;
        }
        return new Location(tableIndex,valueIndex);
    }
    private void putBack(Location loc){
         List<Integer> tab=tables[loc.tableIndex];
         for(int i=tab.size()-1;i>loc.valueIndex;i--){
                  Integer movedVal= tab.remove(i);
                  tables[movedVal.intValue()].add(movedVal);
         }
    }
    private void pileOver(Location a,Location b){
          List<Integer> tabA=tables[a.tableIndex];
          List<Integer> tabB=tables[b.tableIndex];
         while(tabA.size()>a.valueIndex) {
                tabB.add(tabA.remove(a.valueIndex));
         }
    }
    public void executeCommand(String[] commands,Location a,Location b){
          if(commands[0].equals("move")){
              putBack(a);
              if(commands[2].equals("onto")){
                  putBack(b);
              }
              pileOver(a,b);
          }else if(commands[0].equals("pile")){
              if(commands[2].equals("onto")){
                  putBack(b);
              }
              pileOver(a,b);
          }
    }
    public void state(){
        for(int i=0;i<tables.length;i++){
            System.out.print(i+":");
            for(Integer integer:tables[i]){
                System.out.print(" ");
                System.out.print(integer.intValue());
            }
            if(i!=tables.length-1) System.out.print("\n");
        }
    }
    public boolean check(int a,int b){
        if(Math.min(a,b)>=0&&Math.max(a,b)<tables.length)
             return true;
        return false;
    }
    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        int tableSize=in.nextInt();
        MoveBlock mb=new MoveBlock(tableSize);
                      in.nextLine();
        String line;
        String[] commands;
        while( !(line=in.nextLine()).equals("quit")){
                commands=line.split(" ");
                if(!commands[1].equals(commands[3])) {
                    int aVal = Integer.parseInt(commands[1]);
                    int bVal = Integer.parseInt(commands[3]);
                    if (mb.check(aVal, bVal)) {
                        Location aLoc = mb.findBlock(aVal);
                        Location bLoc = mb.findBlock(bVal);
                        if (aLoc.tableIndex != bLoc.tableIndex) {
                            mb.executeCommand(commands, aLoc, bLoc);
                        }
                    }
                }
        }
        mb.state();
    }
}
