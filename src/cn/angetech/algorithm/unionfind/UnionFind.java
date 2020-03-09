package cn.angetech.algorithm.unionfind;

import com.sun.xml.internal.bind.v2.schemagen.xmlschema.Union;

import java.util.Random;

public class UnionFind {
    private int count; // 元素数量
    private int[] rank; // 层数
    private int[] parent ; // 节点

    UnionFind(int count){
        this.count = count;
        rank = new int[count];
        parent = new  int[count];

        for (int i=0;i<count;i++){
            rank[i] = 1;
            parent[i] = i;
        }
    }

    public void Union(int p, int q){ // 合并两个元素
        int pRoot = find(p);// 定位到根节点
        int qRoot = find(q);
        if(pRoot == qRoot){
            return;
        }

        if (rank[pRoot]>rank[qRoot]){
            parent[qRoot] = pRoot;
        }else if(rank[pRoot]<rank[qRoot]){
            parent[pRoot] = qRoot;
        }else {
            parent[pRoot] = qRoot;
            rank[qRoot] = rank[qRoot]+1;
        }
    }

    public int find(int p){
        while (p!= parent[p]){
            parent[p] = parent[parent[p]]; // todo 路径压缩
            p = parent[p];
        }
        return p;
    }

    public boolean isConnected(int p,int q){
        return find(p) == find(q);
    }

    public static void main(String[] args) {
        int N = 10000;
        UnionFind uf = new UnionFind(N);
        double startTime = System.currentTimeMillis();
        int tempA;
        int tempB;
        Random random = new Random();


        // 进行N次合并操作
        for(int i=0;i<N;i++){
            tempA = random.nextInt(N)% N;
            tempB = random.nextInt(N)% N;
            uf.Union(tempA, tempB);
        }
        // 进行N次查找
        for (int i=0;i<N;i++){
            tempA = random.nextInt(N)%N;
            tempB = random.nextInt(N)%N;
            uf.isConnected(tempA,tempB);
        }

        double endTime = System.currentTimeMillis();
        System.out.println(endTime-startTime);

    }

}
