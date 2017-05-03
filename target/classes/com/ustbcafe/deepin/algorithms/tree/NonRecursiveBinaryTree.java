package com.ustbcafe.deepin.algorithms.tree;

import java.util.Arrays;
import java.util.Stack;

/**
 * Created by Rudy Steiner on 2017/2/23.
 */
public class NonRecursiveBinaryTree {

    public void  preOrderTraverse(BinaryTree.BinaryNode  root){

        if(root==null)
            return ;
        BinaryTree.BinaryNode cur=null;
        Stack<BinaryTree.BinaryNode> stack=new Stack<>();
        stack.push(root);
        while(!stack.empty()){
            cur=stack.pop();
            while(cur!=null) {
                visit(cur);
                if (cur.right != null) stack.push(cur.right);
                cur = cur.left;
            }
        }
    }

    public void inOrderTraverse(BinaryTree.BinaryNode  root){
        if(root==null)
            return;
        BinaryTree.BinaryNode cur=null;
        Stack<BinaryTree.BinaryNode> stack=new Stack<>();
        stack.push(root);
        while(!stack.empty()){

            //两种情况下栈顶为null：辅助节点
            // a.表示栈顶第一个非空节点为下一个可以访问的节点
            // b.表示栈顶第一个非空节点的左子树访问完
               while( (cur=stack.peek())!=null) {
                   stack.push(cur.left);
               }

               stack.pop();
               //最左边的入栈
               //stack.push(cur);
               if(!stack.empty()) {
                   cur=stack.pop();
                   visit(cur);
                   //if (cur.right != null) stack.push(cur.right);
                   stack.push(cur.right);
               }
        }
    }
    static class StatusNode{
        BinaryTree.BinaryNode p;
        boolean canVisit;
        public StatusNode(BinaryTree.BinaryNode p,boolean canVisit){
            this.p=p;
            this.canVisit=canVisit;
        }
    }
    public void postOrderTraverse(BinaryTree.BinaryNode  root){
        if(root==null)
            return ;
        BinaryTree.BinaryNode cur=root;
        StatusNode statusNode;
        Stack<StatusNode> stack=new Stack<>();
        do{
            while(cur!=null){
                 stack.push(new StatusNode(cur,false));
                 cur=cur.left;
            }
            statusNode=stack.pop();

            cur=statusNode.p;
            if(!statusNode.canVisit){
                statusNode.canVisit=true;
                stack.push(statusNode);
                cur=cur.right;
            }else{
                visit(statusNode.p);
                cur=null;
            }

        }while(cur!=null||!stack.empty());// p=null&& stack为空，退出

    }
    public void leverOrderTraverse(BinaryTree.BinaryNode  root){}

    public void visit(BinaryTree.BinaryNode node){
        System.out.print(node.value+" ");
    }
    public static void main(String[] args) throws Exception{

        int[] pre={1,2,4,7,3,5,6,8};
        int[] inOrder={4,7,2,1,5,3,8,6};
        System.out.println("input:");
        System.out.println("前序："+ Arrays.toString(pre));
        System.out.println("中序："+ Arrays.toString(inOrder));
        BinaryTree binaryTree=new BinaryTree();
        BinaryTree.BinaryNode root=binaryTree.constructCore(pre,0,pre.length-1,inOrder,0,inOrder.length);
        System.out.println("output:");
        System.out.println("前序非递归遍历：");
        new NonRecursiveBinaryTree().preOrderTraverse(root);
        System.out.println(" ");
        System.out.println("中序非递归遍历：");
        new NonRecursiveBinaryTree().inOrderTraverse(root);
        System.out.println(" ");
        System.out.println("后序非递归遍历：");
        new NonRecursiveBinaryTree().postOrderTraverse(root);
    }

}
