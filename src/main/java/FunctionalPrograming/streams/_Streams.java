package FunctionalPrograming.streams;

import FunctionalPrograming.Imperative.MainImperative;

import java.util.List;
import java.util.Set;
import java.util.function.Function;
import java.util.function.IntConsumer;
import java.util.function.ToIntFunction;
import java.util.stream.Collectors;

public class _Streams {
    static void main() {
        List<Person> people = List.of(
                new Person("Jhon", Gender.MALE),
                new Person("Maria", Gender.FEMALE),
                new Person("Aisha", Gender.FEMALE),
                new Person("Alex", Gender.MALE),
                new Person("Alice", Gender.FEMALE));

        /*
        Function<Person, String> personStringFunction = person -> person.name;
        ToIntFunction<String> length = String::length;
        IntConsumer println = System.out::println;

        people.stream()
                .map(personStringFunction)
                .mapToInt(length)
                .forEach(println);
        */


        boolean containsOnlyFemale = people.stream()
                .allMatch(person -> Gender.FEMALE.equals(person.gender));
        //allMatch : it checks if all the list is female
        // AnyMatch : the oposit it checks if there is any female returning true
        //noneMatch : return true if none of them match to the predicate

        System.out.println(containsOnlyFemale);
    }


    static class Person{
        private  final String name;
        private  final Gender gender;

        public Person(String name, Gender gender) {
            this.name = name;
            this.gender = gender;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", gender=" + gender +
                    '}';
        }
    }

    enum Gender{
        MALE, FEMALE
    }

}
