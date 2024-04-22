package OOP;

// Class abstraction
abstract class C1 {
    void print() {
        System.out.println("Hi");
    }

    abstract void behaviour(); // it can't have body
}

class C2 extends C1 {

    @Override
    void behaviour() {
        // must me override
        System.out.println(11);
    }
}
///////////////////////////////////////////////////////////////////////////

// Interface abstraction
interface IUser {
    void print(); // public & static by default
    int x = 2; // it has to be initialized
    default void bef(){
        System.out.println("Some code...");
    }
}

class myClass implements IUser{

    @Override
    public void print() {
        // implementation
        this.bef();
        System.out.println(this.x);
    }
}



public class Abstraction {
    public static void main(String[] args) {
        // C1 c1 = new C1();  // you can't create an object form abstract class
        C1 c1 = new C2(); // Good
        C2 c2 = new C2(); // Good
        c1.print();
        c1.behaviour();

        // IUser user = new IUser();  u can't create an object from interface
        System.out.println(IUser.x); // u can access interface variables (only), cuz they are static
        IUser user = new myClass(); // Good
        user.bef();
        myClass c = new myClass(); // Good
        c.print();
        c.bef();

    }
}
