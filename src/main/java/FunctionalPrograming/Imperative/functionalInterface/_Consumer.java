package FunctionalPrograming.Imperative.functionalInterface;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class _Consumer {
    static void main() {
        Customer maria = new Customer("Maria", "99999999");
        greetCustomer(maria);
        //Consumer Functional Interface
        greetCustomerConsumer.accept(maria);
        greetCustomerConsumerv2.accept(maria,false);
    }

    static BiConsumer<Customer, Boolean> greetCustomerConsumerv2 =
            (customer,showPhone)  -> System.out.println("Hello "
                    + customer.customerName
                    + ", thanks for registering phone number: "
                    + (showPhone ? customer.customerPhoneNumber : "********")
            );

    static Consumer<Customer> greetCustomerConsumer =
            customer -> System.out.println("Hello "
            + customer.customerName
            + ", thanks for registering phone number: "
            + customer.customerPhoneNumber
    );

    static  void greetCustomer(Customer customer){
        System.out.println("Hello "
                + customer.customerName
                + ", thanks for registering phone number: "
                + customer.customerPhoneNumber
                );
    }


    static class Customer{
        private final String customerName;
        private final String customerPhoneNumber;

        public Customer(String customerName, String customerPhoneNumber) {
            this.customerName = customerName;
            this.customerPhoneNumber = customerPhoneNumber;
        }

        @Override
        public String toString() {
            return "Customer{" +
                    "customerName='" + customerName + '\'' +
                    ", customerPhoneNumber='" + customerPhoneNumber + '\'' +
                    '}';
        }
    }
}
