import Generics.Printer;
void main() {
    Printer<Integer> printerInteger = new Printer<>(20);
    printerInteger.print();
    Printer<String> printerString = new Printer<>("Hello world");
    printerString.print();
    Printer<Double> printerDouble = new Printer<>(2.0);
    printerDouble.print();
    //Printer<int> printerInt = new Printer<>(2.0);//dont work
    //generic method
    Printer.shout("hello");
    Printer.shout(5);
    Printer.shout(10.000);
    Printer.shout(printerDouble);
    Printer.shout("One ", 2);
}
