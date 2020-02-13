package cn.angetech.datastructure.linklist;


/*
* 解决一元多项式
* */
public class polynomialCase {
    class link{
        private link next;
        private Object data1;
        private Object data2;
        link(Object it, Object it1, link nextval){
            data1 = it;
            data2 = it1;
            next = nextval;
        }
        link(link nextval){
            next = nextval;
        }
        link next(){
            return next;
        }
        link setnext(link nextval){
            return next = nextval;
        }
        Object getData1(){
            return data1;
        }
        Object getData2(){
            return data2;
        }
        Object setData1(Object it){
            return data1 = it;
        }
        Object setData2(Object it){
            return data2 = it;
        }

    }

    private void setup(){
       link tail = new link(null);
       link head = new link(null);
       link curr = new link(null);;
    }

    /* 对多项式 进行 求和 */
    public void expadd(link A,link B) throws Exception{
        link pa = A;
        link pb = B;
        int x = Integer.parseInt(pa.next().data1.toString()) ;
        int y = Integer.parseInt(pb.next().data1.toString()) ;

//        while ((pa!=null) && (pb!=null)){
//            if(x<y){
//                link curr.setnext()
//            }
//        }
//



    }




}
