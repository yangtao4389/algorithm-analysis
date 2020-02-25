package cn.angetech.datastructure.tree;

public class AvlNodeTree<AnyType> {

    /*
    * AVL树的节点声明
    * */
    private static class AvalNode<AnyType>{
        AvalNode(AnyType theElement){
            this(theElement,null,null);
        }
        AvalNode(AnyType theElement, AvalNode<AnyType> lt, AvalNode<AnyType> rt){
            element = theElement;
            left = lt;
            right = rt;
            height = 0;
        }
        AnyType element;
        AvalNode<AnyType> left;
        AvalNode<AnyType> right;
        int height;
    }

    private int height(AvalNode<AnyType> t){
        return t == null ? -1:t.height;
    }

    private int compare(AnyType x,AnyType y) {
        return -1;
    }

    private AvalNode<AnyType> insert(AnyType x, AvalNode<AnyType> t){
        if(t == null){
            return new AvalNode<AnyType>(x,null,null);
        }
        int compareResult = compare(x,t.element);
        if(compareResult<0){
            t.left = insert(x,t.left);
            if(height(t.left) - height(t.right) == 2){
                if(compare(x,t.left.element)<0){
                    t = rotateWithLeftChild(t);
                }else {
                    t = doubleWithLeftChild(t);
                }
            }
        }else if(compareResult>0){
            t.right = insert(x,t.right);
            if(height(t.right)-height(t.left) == 2){
                if(compare(x,t.right.element)>0){
                    t = rotateWithRightChild(t);
                }else {
                    t = doubleWithRightChild(t);
                }
            }
        }else ;
        t.height = Math.max(height(t.left),height(t.right)) +1;
        return t;
    }

    /*
    * 执行单旋转的例程
    * */
    private AvalNode<AnyType> rotateWithLeftChild(AvalNode<AnyType> k2){
        AvalNode<AnyType> k1 = k2.left;
        k2.left = k1.right;
        k1.right = k2;
        k2.height = Math.max(height(k2.left),height(k2.right)) +1;
        k1.height = Math.max(height(k1.left),k2.height) +1;
        return k1;
    }

    private AvalNode<AnyType> rotateWithRightChild(AvalNode<AnyType> k2){
        AvalNode<AnyType> k1 = k2.left;
        k2.right = k1.left;
        k1.left = k2;
        k2.height = Math.max(height(k2.left),height(k2.right)) +1;
        k1.height = Math.max(height(k1.right),k2.height) +1;
        return k1;
    }

    /*
    * 双旋转
    * */
    private AvalNode<AnyType> doubleWithLeftChild(AvalNode<AnyType> k3){
        k3.left = rotateWithRightChild(k3.left);
        return rotateWithLeftChild(k3);
    }
    private AvalNode<AnyType> doubleWithRightChild(AvalNode<AnyType> k3){
        k3.right = rotateWithLeftChild(k3.right);
        return rotateWithRightChild(k3);
    }
}
