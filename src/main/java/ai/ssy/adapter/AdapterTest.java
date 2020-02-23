package ai.ssy.adapter;

/**
 * 适配器模式
 */
public class AdapterTest {
    public static void main(String[] args) {
        Adaptee adaptee = new Adaptee();
        //对象适配器；代码
        Target target = new Adapter(adaptee);
        int i = target.output12V();
        System.out.println("最终的值称为="+i);
    }

}
//要配置的类
class Adaptee{
    public int output220V(){
        System.out.println("输出220V");
        return 220;
    }
}
interface Target{
    int output12V();
}
class Adapter implements Target{

    private Adaptee adaptee;

    public Adapter( Adaptee adaptee){
        this.adaptee=adaptee;
    }
    @Override
    public int output12V() {
        int i = adaptee.output220V();
        System.out.println("做一些处理");
        return 12;
    }
}