package org.example;
/**
 * Comment
 */
public class App {
    public static void main(String[] args) {
        System.out.println("Hello Studis from IntelliJ + Git!");
        sayHello("Team");
        greetStudent_dany("Susi", "Software Engineering");
    }

    public static void sayHello(String name) {
        System.out.println("Hello, " + name);
    }


    public static void greetStudent_dany(String name, String course) {
        System.out.println("Welcome " + name + " to the course " + course + "!");
    }

    public void newMethod() {
        System.out.println("New Method");
    }
}

