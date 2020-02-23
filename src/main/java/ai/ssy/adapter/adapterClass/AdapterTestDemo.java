package ai.ssy.adapter.adapterClass;

//类的适配器
public class AdapterTestDemo {
    public static void main(String[] args) {
        Adapter adapter = new Adapter();
        //最少知道原则
        //接口污染
        //对客户端代码造成干扰
        int s = adapter.output12V();
        System.out.println(s);

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

//使用继承的关系
class Adapter extends Adaptee implements Target{

    @Override
    public int output12V() {
        int i = output220V();
        System.out.println("经过一些复杂处理");
        return 12;
    }
}