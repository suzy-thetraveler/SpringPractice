package hello.core.singleton;

public class StatefulService {
    private int price; //상태를 유지하는 필드

    public int order(String name, int price){
        System.out.println("name = " + name + ", price = " + price);
        //this.price=price; //여기가 문제!
        return price;
        //singleton thread문제를 해결하기위해 공유되지않는 지역변수를 리턴값으로 지정해주는 것으로 해결함함

        }
}
