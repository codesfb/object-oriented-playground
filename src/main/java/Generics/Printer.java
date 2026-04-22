package Generics;

public class Printer <T>{
    final private T value;

    //generic method
     public static <T> void  shout (T thingToshout){
        System.out.println( thingToshout + "!!!!");
    }


    public static <T, V> void  shout (T thingToshout, V OtherThing ){
        System.out.println( thingToshout +   "!!!!");
        System.out.println( OtherThing +   "!!!!");
    }

    @Override
    public String
    toString() {
        return "value = " + value;
    }

    public Printer(T value) {
        this.value = value;
    }

    public void print(){
        System.out.println(value);
    }

}
