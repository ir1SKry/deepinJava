package com.ustbcafe.deepin.algorithms.tree;

/**
 * Created by Rudy Steiner on 2017/2/23.
 * 剑指offer 重建二叉树
 *
 */
public class BinaryTree {

    static class BinaryNode{
        int value;
        BinaryNode left;
        BinaryNode right;
        public BinaryNode(int value){
            this.value=value;
            this.left=null;
            this.right=null;
        }
    }
    /*
     *  依据前序和中序重建二叉树
     *
     * */
    public BinaryNode constructCore(final int[] preOrder,int preStart,int preEnd,
                                     final int[] inOrder,int inStart,int inEnd) throws  Exception{
        int rootVal=preOrder[preStart];
        BinaryNode root=new BinaryNode(rootVal);
        // 叶子节点，递归出口
        if(preStart==preEnd){
            if(inStart==inEnd&&preOrder[preStart]==inOrder[inStart])
                return root;
            else {
                throw new Exception("Invalide input");
            }
        }
        //在中序中查找子树根节点，并计算左子树节点个数
        int rootInd=inStart;
        while(rootInd<=inEnd&&inOrder[rootInd]!=rootVal){
            rootInd++;
        }
        if(rootInd>inEnd)
            throw new Exception("Invalide input");
        //左子树节点个数
        int leftLen=rootInd-inStart;
        int leftPreOrderEnd= preStart+leftLen;
        // 是否有左子树
        if(leftLen>0){
            root.left=constructCore(preOrder,preStart+1,leftPreOrderEnd,inOrder,inStart,rootInd-1);
        }
        //是否有右子树
        if(leftLen<preEnd-preStart)
            root.right=constructCore(preOrder,leftPreOrderEnd+1,preEnd,inOrder,rootInd+1,inEnd);
        return root;
    }

    public void preTraverseTree(BinaryNode root){

        if(root==null)
            return;
        //visit
         System.out.print(root.value+" ");
        if(root.left!=null) preTraverseTree(root.left);
        if(root.right!=null) preTraverseTree(root.right);
    }

    public void inOrderTraverseTree(BinaryNode root){

        if(root==null)
            return;
        //visit
        if(root.left!=null) inOrderTraverseTree(root.left);
               System.out.print(root.value+" ");
        if(root.right!=null) inOrderTraverseTree(root.right);
    }

    public void postOrderTraverseTree(BinaryNode root){

        if(root==null)
            return;

        if(root.left!=null) postOrderTraverseTree(root.left);
        if(root.right!=null) postOrderTraverseTree(root.right);
        //visit
        System.out.print(root.value+" ");
    }

    public static void main(String[] args)throws  Exception{

     int[] pre={1,2,4,7,3,5,6,8};
     int[] inOrder={4,7,2,1,5,3,8,6};
     BinaryTree binaryTree=new BinaryTree();
     BinaryNode root=binaryTree.constructCore(pre,0,pre.length-1,inOrder,0,inOrder.length);
        System.out.println("前序递归遍历：");
                binaryTree.preTraverseTree(root);
        System.out.println("");
        System.out.println("中序递归遍历：");
                binaryTree.inOrderTraverseTree(root);
        System.out.println("");
        System.out.println("后序递归遍历：");
                binaryTree.postOrderTraverseTree(root);
    }
}
