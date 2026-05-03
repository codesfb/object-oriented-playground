package FunctionalPrograming.Imperative.functionalInterface;

import java.util.List;
import java.util.function.Supplier;

public class _Supplier {
    static void main() {
        System.out.println(getDBConnectionUrl());
        System.out.println(getDBConnectionUrlSupplier.get() );
        System.out.println(getDBConnectionUrlSupplierList.get());

    }

    static Supplier<String> getDBConnectionUrlSupplier=
            ()-> "jdbc://localhost:5432/users";
    static Supplier<List<String>> getDBConnectionUrlSupplierList=
            ()-> List.of("jdbc://localhost:5432/users","jdbc://localhost:5432/costumers");

    static String getDBConnectionUrl () {
        return "jdbc://localhost:5432/users";
    }
}
