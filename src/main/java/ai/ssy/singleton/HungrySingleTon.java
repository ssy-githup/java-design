package ai.ssy.singleton;


import java.io.*;
import java.lang.reflect.Constructor;

/**
 * 饿汉模式
 */
public class HungrySingleTon implements Serializable {

    public static final long serialVersionUID = 1L;

    public static HungrySingleTon hungrySingleTon = new HungrySingleTon();

    private HungrySingleTon(){}

    public static HungrySingleTon getHungrySingleTon(){
        return hungrySingleTon;
    }

    /**
     *  利用反射获取到实例是否和通过静态 方法获取的实例是同一个
     */
//    public static void main(String[] args) throws Exception {
//        Constructor<HungrySingleTon> constructor = HungrySingleTon.class.getDeclaredConstructor();
//        constructor.setAccessible(true);
//        HungrySingleTon hungrySingleTon = constructor.newInstance();
//        HungrySingleTon hungrySingleTon1 = HungrySingleTon.getHungrySingleTon();
//
//        System.out.println(hungrySingleTon==hungrySingleTon1);
//
//    }


    public static void main(String[] args) {
        HungrySingleTon instance=HungrySingleTon.getHungrySingleTon();
//        try(ObjectOutputStream oos=new ObjectOutputStream( new FileOutputStream( "instance" ) )) {
//            oos.writeObject( instance );
//        }

        try (ObjectInputStream ois=new ObjectInputStream( new FileInputStream( "instance" ) )) {
            HungrySingleTon innerClassSingleton=(HungrySingleTon) ois.readObject();

            System.out.println( innerClassSingleton == instance );

        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

}
/**
 * 静态内部类的方式
 */
class InnerClassSingleTonDemo {

    //jdk类加载器，依赖类的加载机制
    private static class InnerClassSingleTon{
        public static InnerClassSingleTonDemo innerClassSingleTonDemo = new InnerClassSingleTonDemo();

    }
    private InnerClassSingleTonDemo(){}

    public static InnerClassSingleTonDemo getIntence(){

        return InnerClassSingleTon.innerClassSingleTonDemo;
    }
}
