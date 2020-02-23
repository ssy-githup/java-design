package ai.ssy.factory.abstractdemo;

/**
 * 抽象工厂
 */
public class AbstractFastoryTest {
    public static void main(String[] args) {
        HaveLife animal = FactoryProducer.getFactory("animal");
        animal dog = animal.getAnimal("dog");
        dog.doSomeThing();
        HaveLife human = FactoryProducer.getFactory("human");
        Human man = human.getHuman("man");
        man.doSomeThing();
    }
}

class FactoryProducer {
    public static HaveLife getFactory(String choice){
        if(choice.equalsIgnoreCase("animal")){
            return new AnimalDemo();
        } else if(choice.equalsIgnoreCase("human")){
            return new HuManDemo();
        }
        return null;
    }
}

abstract class HaveLife{
    abstract animal getAnimal(String type);
    abstract Human getHuman(String type);
}

class AnimalDemo extends HaveLife{
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

    @Override
    Human getHuman(String type) {
        return null;
    }

}
class HuManDemo extends HaveLife{

    @Override
    animal getAnimal(String type) {

        return null;
    }

    @Override
    Human getHuman(String type) {
        if (type == null) {
            return null;
        }
        if (type.equalsIgnoreCase("Woman")) {
            return new Woman();
        } else if (type.equalsIgnoreCase("man")) {
            return new Man();
        }
        return null;
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

interface  Human{
    void doSomeThing();
}
class Woman implements Human{

    @Override
    public void doSomeThing() {
        System.out.println("woman...");
    }
}
class Man implements Human{

    @Override
    public void doSomeThing() {
        System.out.println("man...");
    }
}