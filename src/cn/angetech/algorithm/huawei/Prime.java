package cn.angetech.algorithm.huawei;

public class Prime {
    public static String isPrime(int n){
        if (n<=1){
            return "No";
        }
        for (int i = 2; i < n; i++) {
            if (n % i == 0 ){
                return "No";
            }
        }
        return "Yes";
    }

    public static void main(String[] args) {
        for (int i = 0; i < 20; i++) {
            System.out.println(i + " is prime: "+ isPrime(i));
        }
    }

}
