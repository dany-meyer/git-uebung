package org.example;

public class App {
    public static void main(String[] args) {
        System.out.println("Hello from IntelliJ + Git!");
        sayHello("Team");
        greetStudent("Alice", " git");
    }

    public static void sayHello(String name) {
        System.out.println("Hello, " + name);
    }
    public static void greetStudent(String name, String course) {
        System.out.println("Welcome " + name + " to the course " + course + "!");
    }
}

