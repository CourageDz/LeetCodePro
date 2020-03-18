package simulation0803.testInstance;

public class Testconert {
    public static void main(String[] args) {
        Animal a = new Animal("monkey");
        Cat c = new Cat("mimi", "white");
        Dog d = new Dog("beibei", "black");

        System.out.println(a instanceof Animal);
        System.out.println(c instanceof Animal);
        System.out.println(d instanceof Animal);
        System.out.println(a instanceof Dog);

        a = new Dog("xiaohei", "yellow");//狗也是animal 所以a能直接新建dog对象 但是不能调用dog的方法
        System.out.println(a instanceof Animal);
        System.out.println(a instanceof Dog);
        System.out.println(a.name);
//System.out.println(a.furclor);
        Dog d1 = (Dog) a;
        System.out.println(d1.furclor);
        System.out.println(d1.name);
    }

    static class Animal {
        String name;

        Animal(String name) {
            this.name = name;
        }
    }


    static class Cat extends Animal {
        String eyeclor;

        Cat(String name, String eyeclor) {
            super(name);
            this.eyeclor = eyeclor;
        }
    }

    static class Dog extends Animal {
        String furclor;

        Dog(String name, String furclor) {
            super(name);
            this.furclor = furclor;
        }
    }
}