package ai.ssy.factory;

/**
 * 设计模式 – 工厂模式
 */
public class FactoryDemo {
    //使用 getShape 方法获取形状类型的对象
    public animal getAnimal(String type) {
        if (type == null) {
            return null;
        }
        if (type.equalsIgnoreCase("dog")) {
            return new Dog();
        } else if (type.equalsIgnoreCase("cat")) {
            return new Cat();
        }
        return null;
    }

    public static void main(String[] args) {
        FactoryDemo factoryDemo = new FactoryDemo();

        //获取animal对象
        animal animal = factoryDemo.getAnimal("dog");
        animal.doSomeThing();

        animal animal1 = factoryDemo.getAnimal("cat");
        animal1.doSomeThing();
    }

}
interface animal{
    void doSomeThing();
}
class Dog implements animal{

    @Override
    public void doSomeThing() {
        System.out.println("wang  wang.....");
    }
}
class Cat implements animal{

    @Override
    public void doSomeThing() {
        System.out.println("miao miao .....");
    }
}
