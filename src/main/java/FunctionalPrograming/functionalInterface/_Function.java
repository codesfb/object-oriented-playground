package FunctionalPrograming.functionalInterface;

import java.util.function.BiFunction;
import java.util.function.Function;

public class _Function {
    static void main() {
        int increment = incrementByOne(1);
        System.out.println(increment);
        int increment2 = incrementByOneFunction.apply(1);
        System.out.println(increment2);
        int multiply = multiplyBy10Function.apply(increment2);
        System.out.println(multiply);

        Function<Integer, Integer> addBy1andThenMultiplyBy10 =
                incrementByOneFunction.andThen(multiplyBy10Function);//chained method
        System.out.println(addBy1andThenMultiplyBy10.apply(2));

        System.out.println(incrementByOneAndMultiply(4,100));
        System.out.println(incrementByOneAndMultiplyBifunc.apply(4,100));
    }

    static Function<Integer, Integer> incrementByOneFunction =
            n ->n+1;
    static Function<Integer, Integer> multiplyBy10Function =
            n ->n*10;

    static BiFunction<Integer,Integer,Integer> incrementByOneAndMultiplyBifunc =
            (numberToIncremet, numToMultiply ) -> (numberToIncremet+1) * numToMultiply;

    static int incrementByOne(int number){
        return number + 1;
    }

    static int incrementByOneAndMultiply(int numberToIncremet, int numToMultiply){
        return (numberToIncremet + 1) * numToMultiply;
    }
}
