package impertative;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        List<Person> people = List.of(new Person("John", Gender.MALE),
                new Person("Alex", Gender.FEMALE),
                new Person("Riya", Gender.FEMALE),
                new Person("Carl", Gender.MALE),
                new Person("Mark", Gender.MALE));

        //imperative approach
        List<Person> females = new ArrayList<>();
        for (Person p : people) {
            if (Gender.FEMALE.equals(p.gender)) {
                females.add(p);
            }
        }
//        for (Person p : females) {
//            System.out.println(p);
//        }

        //declarative approach - functional
        people.stream().filter(person -> Gender.FEMALE.equals(person.gender)).toList()
                .forEach(System.out::println);


    }

    static class Person {
        private final String name;
        private final Gender gender;

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

    enum Gender {
        MALE,FEMALE
    }
}