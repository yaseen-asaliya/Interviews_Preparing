package OOP;

class Parent {
    public Parent(){
        id = -1;
    }
    // private over all the package (default)
    int id;

    public int SSD;

    private int balance;

    protected String name;
    protected void print1(){ }
}

class Child extends Parent {
    Child(){
        super(); // call constructor
        super.name = "Yaseen"; // super here refer to Parent class
        this.tt(); // this refers to the current class
    }
    public void tt(){
        this.print1();
    }
}

public class Inheritance {
    public static void main(String[] args) {
        Parent xx = new Child();
        Child x = new Child();
        x.print1();
        System.out.println(x.id); // -1
    }
}
