package com.ustbcafe.deepin.algorithms.sort;





import java.util.Arrays;
import java.util.Stack;

import static com.ustbcafe.deepin.algorithms.sort.SortUtils.swap;

/**
 * Created by Rudy Steiner on 2017/2/23.
 */
public class Sort {
    /*
       * return -1 表明参数错误
       * return  0
       * */
    public static int partition(int array[], int low, int high){
        //
        if(array==null||array.length==0||low<0||high>array.length-1)
             throw new IllegalArgumentException("Invalid parameters");
        int i=low;
        int j=high;
        int pivot=array[low];
        while(i<j){
            while(i<j&&array[j]>pivot)j--;
                if(i<j) array[i++]=array[j];
            while(i<j&&array[i]<pivot)i++;
                if(i<j) array[j--]=array[i];
        }
        array[i]=pivot;
        return i;
    }

    /*
    *   递归快速排序  15行
    *
    * */
    public static void recursiveFastSort(int array[],int low,int high){

        //递归出口，只有一个元素，
        if(low>=high)
            return ;
        int i= partition(array,low,high);
            recursiveFastSort(array,low,i-1);
            recursiveFastSort(array,i+1,high);
    }
    public static class Node{
        int low;
        int high;
        public Node(int low,int high){
            this.low=low;
            this.high=high;
        }
    }
    /*
    *
    * 非递归快速排序
    * */
    public static void fastSort(int array[]){
        if(array==null||array.length==0)
            return ;
        Stack<Node> stack=new Stack<>();
        int low,high;
        stack.push(new Node(0,array.length-1));
        while(!stack.empty()){
            Node node=stack.pop();
            low=node.low;
            high=node.high;
            while(low<high) {
                int pivotPos = partition(array, low, high);
                if (pivotPos + 1 < high) stack.push(new Node(pivotPos + 1, node.high));
                high=pivotPos-1;
            }
        }
    }
    /*
    *  教科书式的冒泡排序
    *  reference: 数据结构 夏克俭
    * */
    public static void bubbleSort(int data[]){

        if(data==null||data.length==0)
            return;
        boolean isContinue=false;   // isContinue
        for(int i=data.length;i>=2;i--){  //最多 length-1 次
            isContinue=false;
            for(int j=0;j<i-1;j++){
                if(data[j]>data[j+1]){
                    swap(data,j,j+1);
                    isContinue=true;
                }
            }
            if(!isContinue) break;
        }
    }
    /*
     *  冒泡排序优化二
     *  reference: http://blog.csdn.net/morewindows/article/details/6657829
     *
     * */
    public static void bubbleSort2(int data[]){
        if(data==null||data.length==0)
             return ;
        int i,j;
        int flag=data.length;
        while(flag>0){
            i=flag;
            flag=0;
            for(j=1;j<i;j++){
                if(data[j-1]>data[j]) {
                    swap(data, j - 1, j);
                    flag=j;
                }
            }
            if(flag==0) break;
        }
    }



    public static void main(String[] args){

        // 非递归快速排序测试
        int[] b={50,36,66,76,12,25,95};
        System.out.println("非递归快速排序测试："+Arrays.toString(b));
        int pivotPos= new Sort().partition(b,0,b.length-1);
        System.out.println("第一次快排结果："+Arrays.toString(b));
        System.out.println("基准点所在位置："+pivotPos);
        System.out.println("----------------------------------");
        //
        int[] d=new int[]{50,36,-1,66,76,12,25,95};
        System.out.println("非递归快速排序测试："+Arrays.toString(d));
         new Sort().fastSort(d);
        System.out.println("非递归排序快排结果："+Arrays.toString(d));
        System.out.println("----------------------------------");
        //递归排序
        int[] c={50,36,66,76,12,25,95};
        System.out.println("递归快速排序测试："+Arrays.toString(c));
        new Sort().recursiveFastSort(c,0,c.length-1);
        System.out.println("递归排序快排结果："+Arrays.toString(c));


    }


}
