package cn.angetech.datastructure.tree;


import java.nio.BufferUnderflowException;

/*
*
* 二叉查找树
*extends Comparable<?super AnyType> 实现了 compareTo方法
* */
public class BinarySearchTree<AnyType extends Comparable<?super AnyType>>{


    private static class BinaryNode<AnyType> {
        AnyType element;
        BinaryNode<AnyType> left;
        BinaryNode<AnyType> right;

        BinaryNode(AnyType theElement){
            this(theElement,null,null);
        }
        BinaryNode(AnyType theElement, BinaryNode<AnyType> lt,BinaryNode<AnyType> rt){
            element = theElement;
            left = lt;
            right= rt;
        }
    }

    private BinaryNode<AnyType> root;

    public BinarySearchTree(){
        root = null;
    }

    public void makeEmpty(){
        root = null;
    }
    public boolean isEmpty(){
        return root == null;
    }

    public boolean contains(AnyType x){
        return contains(x,root);
    }
    public AnyType findMin(){
        if( isEmpty()) throw new BufferUnderflowException();
        return findMin(root).element;
    }
    public AnyType findMax(){
        if( isEmpty()) throw new BufferUnderflowException();
        return findMax(root).element;
    }

    public void insert(AnyType x){
        root = insert(x,root);
    }
    public void remove(AnyType x){
        root = remove(x,root);
    }
    public void printTree(){

    }

    /*
    * 如果树T中存在含有X的节点，那么返回true 不存在，返回false
    * */
    private boolean contains(AnyType x,BinaryNode<AnyType> t) {

        // 如果t为null，则表明不存在
        if(t == null){
            return false;
        }

        int compareResult = x.compareTo(t.element);
        if(compareResult<0){
            return contains(x,t.left);
        }else if(compareResult>0){
            return contains(x,t.right);
        }else {
            return true; // Match
        }


    }

    /*
    * 递归编写
    * 一直向左 就能找到最小值
    *
    * */
    private BinaryNode<AnyType> findMin(BinaryNode<AnyType> t){
        if(t == null){
            return null;
        } else if(t.left == null){
            return t;
        }
        return findMin(t.left);
    }


    /*
    * 非递归编写
    * 一直向右，就能找到最大值
    * */
    private BinaryNode<AnyType> findMax(BinaryNode<AnyType> t){
        if(t!=null){
            while (t.right != null){
                t = t.right;
            }
        }
        return t;
    }

    /*
    * t引用该树的根，而根又在第一次插入时变化，因此insert被写成一个返回对新根的引用的方法
    *
    * */
    private BinaryNode<AnyType> insert(AnyType x,BinaryNode<AnyType> t){
        if(t == null){
            return new BinaryNode<AnyType>(x,null,null);
        }
        int compareResult = x.compareTo(t.element);

        if(compareResult<0){
            t.left = insert(x,t.left);
        }else if(compareResult>0){
            t.right = insert(x,t.right);
        }else ;// do nothing
        return t;


    }

    /*
    * 当为树叶 或者  只有一个儿子的情况时， 直接替换
    * 当有两个儿子的时候，就会出现递归调用
    * */
    private BinaryNode<AnyType> remove(AnyType x,BinaryNode<AnyType> t){
        if(t == null){
            return  t;
        }
        int compareResult = x.compareTo(t.element);

        if(compareResult<0){
            t.left = remove(x,t.left);
        }else if(compareResult>0){
            t.right = remove(x,t.right);
        }else if(t.left != null && t.right != null) {  // two children
          t.element = findMin(t.right).element;
          t.right = remove(t.element,t.right);
        }else {
            t = (t.left != null)? t.left:t.right;
        }
        return t;


    }
    private void printTree(BinaryNode<AnyType> t){

    }


}
