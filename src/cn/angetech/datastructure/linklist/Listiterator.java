package cn.angetech.datastructure.linklist;

import java.util.Iterator;

/* 实现一个 双向 迭代器 */
public interface Listiterator extends Iterator {
   public void add(Object object);
   public boolean hasnext();
   public boolean hasprevious();
   public Object next();
   public int nextindex();
   public Object previous();
   public int previousindex();
   public void remove();
   public void set(Object object);
}
