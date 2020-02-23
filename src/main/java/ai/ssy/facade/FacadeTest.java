package ai.ssy.facade;

public class FacadeTest {
    public static void main(String[] args) {
        /**
         * Facade类其实相当于A、B、C模块的外观界面，有了这个Facade类，
         * 那么客户端就不需要亲自调用子系统中的A、B、C模块了，也不需要知道系统内部的实现细节，
         * 甚至都不需要知道A、B、C模块的存在，客户端只需要跟Facade类交互就好了，
         * 从而更好地实现了客户端和子系统中A、B、C模块的解耦，
         * 让客户端更容易地使用系统。
         */
        Facade facade = new Facade();
        facade.test();
    }
}
/**
 * 门面角色类：
 */
class Facade {
    //示意方法，满足客户端需要的功能
    public void test(){
        ModuleA a = new ModuleA();
        a.testA();
        ModuleB b = new ModuleB();
        b.testB();
        ModuleC c = new ModuleC();
        c.testC();
    }
}

/**
 * 子系统角色中的类：A B C
 */
class ModuleA {
    //示意方法
    public void testA(){
        System.out.println("调用ModuleA中的testA方法");
    }
}
class ModuleB {
    //示意方法
    public void testB(){
        System.out.println("调用ModuleB中的testB方法");
    }
}
class ModuleC {
    //示意方法
    public void testC(){
        System.out.println("调用ModuleC中的testC方法");
    }
}