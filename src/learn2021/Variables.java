package learn;
public class Variables {

    static void variableAdd() {
        int a = 5;
        String txt = "Joe";
        System.out.println(txt + a);
    }

    void nonStaticVariableAdd() {
        int a = 5;
        String txt = "Joe";
        System.out.println(txt + a);
    }

    static void primitiveNotDefined() {
        //int num; // This will fail
        int num=1;
        Integer nonPrim=null;
        System.out.println(num);
        System.out.println(nonPrim);
    }

    static int methodOverloading(int a, int b) {
        return a+b;
    }

    static int methodOverloading(int a) {
        return methodOverloading(a, 1); // b default to 1
    }

//    Can't have same params since java uses that to identify which methods to call
//    static double methodOverloading(int a, int b) {
//        return (double) a+b;
//    }

    static class Foo {
        private final String a;
        private final Integer b;

        Foo(String a, Integer b) {
            this.a = a;
            this.b = b;
        }

        //...
    }

    static class FooBuilder {
        private String a = "";
        private Integer b = 0;

        FooBuilder setA(String a) {
            this.a = a;
            return this;
        }

        FooBuilder setB(Integer b) {
            this.b = b;
            return this;
        }

        Foo build() {
            return new Foo(a, b);
        }
    }



    public static void main(String[] args) {
        variableAdd();
        new Variables().nonStaticVariableAdd();
        primitiveNotDefined();
        System.out.println(methodOverloading(1,2));
        //System.out.println("Double return = "+ methodOverloading(1,2));
        System.out.println(methodOverloading(2));

        //Default params
        Variables.Foo foo = new Variables.FooBuilder().setA("a").build();
        System.out.println(foo);

    }
}



