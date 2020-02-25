package cn.angetech.datastructure.tree;


import java.util.Comparator;

public class BinarySearchTree2<AnyType> {
    private static class BinaryNode<AnyType> {
        AnyType element;
        BinaryNode<AnyType> left;
        BinaryNode<AnyType> right;

        BinaryNode(AnyType theElement){
            this(theElement,null,null);
        }
        BinaryNode(AnyType theElement, BinaryNode<AnyType> lt, BinaryNode<AnyType> rt){
            element = theElement;
            left = lt;
            right= rt;
        }
    }
    private BinaryNode<AnyType> root;
    private Comparator<? super AnyType> cmp;

    public BinarySearchTree2(){
        this(null);
    }
    public BinarySearchTree2(Comparator<? super AnyType> cmp){
        root = null;
        cmp = cmp;
    }

    private int myCompare(AnyType lhs, AnyType rhs){
        if(cmp != null){
            return cmp.compare(lhs,rhs);
        }else {
            return ((Comparable)lhs).compareTo(rhs);
        }
    }
    private boolean contains(AnyType x,BinaryNode<AnyType> t){
        if(t == null){
            return false;
        }
        int compareResult = myCompare(x,t.element);
        if(compareResult<0){
            return contains(x,t.left);
        }else if(compareResult>0){
            return contains(x,t.right);
        }else {
            return true;
        }
    }



}
