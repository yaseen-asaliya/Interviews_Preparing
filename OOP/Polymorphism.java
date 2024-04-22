package OOP;

// It's concept of behave in different ways based on the situation (Many behaviour)
// Runtime Polymorphism (Override) -> late binding
// Compile time Polymorphism (Overload) -> early binding        (not supported in java)

class Animal {
    public void sound(){
        System.out.println("Noisy...");
    }

}

class Dog extends Animal{
    @Override
    public void sound(){
        System.out.println("hwe...");
    }

    public void fun1(int x){
        System.out.println("int");
    }
    // Overloading is not support in java in this way
    public void fun1(float x){
        System.out.println("float");
    }
    // but here is allowed
    public void fun1(int x, int y){
        System.out.println("int");
    }
}

public class Polymorphism {
    public static void main(String[] args) {
        Animal animal = new Animal();
        animal.sound(); // Noisy..

        Animal dog = new Dog(); // can access override methods in dog class only
        Dog dog1 = new Dog(); // can access everything
        dog.sound(); // hwe...
        dog1.sound(); // hwe...

        dog1.fun1(1);
    }
}
