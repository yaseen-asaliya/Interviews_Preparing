package OOP;


class Outer {
    private int a = 1;
    public int b = 2;
    protected int c = 3;
    int d = 2;
    public void print(){
        System.out.println("Hi from outer");
    }

    public class publicInner {
        int number = 2;

        public void print(){
            System.out.println("Hi from public inner");
            System.out.println(a);
            System.out.println(b);
            System.out.println(c);
            System.out.println(d);
        }

        void complex(){
            int x=2;
            class test{     // private class that can user here
                String text = "Hi";
            }

            test t = new test();
            System.out.println(t.text + "  " + x);
        }
    }

    public static class staticInner {
        public void print(){
            System.out.println("Hi from static inner");
        }
    }
}

public class InnerClass {
    public static void main(String[] args) {
        Outer outer = new Outer();
        Outer.publicInner inner = outer.new publicInner();

        inner.print();
        outer.print();

        Outer.staticInner st = new Outer.staticInner();
        st.print();
    }
}
