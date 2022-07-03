package classroomSix;

import com.github.javafaker.Faker;

public class Example {
    public static void main(String[] args) {
        Faker faker = new Faker();
        String animalName = faker.animal().name();
        for (int i = 0;  i<5; i++) {
            System.out.println(faker.animal().name());
        }

        Employee employee1 = new Employee("Juris", "Kreilis", 31);
        String name = faker.name().firstName();
        String lastName = faker.name().lastName();
        int age = faker.number().numberBetween(1,100);
        Employee employee2 = new Employee(name,lastName,age);
        Employee employee3 = new Employee(faker.name().firstName(), faker.name().lastName(), faker.number().numberBetween(1, 100));
        System.out.println(employee1.toString());
        System.out.println(employee2.toString());
        System.out.println(employee3.toString());
        System.out.println(faker.letterify("123????23455677asdfgh"));
    }
}
