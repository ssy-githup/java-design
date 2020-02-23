package ai.ssy.singleton;

/**
 * 单例模式
 *    懒加载
 *    定义:单例对象的类只能允许一个实例存在
 */
public class LazySingleTon {

    //禁止指令重排
    //使用java中的volatile关键字
    public volatile static LazySingleTon lazySingleTon;
    //1:私有的构造器
    private LazySingleTon(){
    }
    //2:提供一个静态方法可供外部调用来返回一个需要的单例对象
    public static LazySingleTon getLazySingleTon() {
        if(lazySingleTon==null){
            synchronized(LazySingleTon.class){
                //双重检查锁定
                //并发的时候只在上一个if判断了，另外的线程抢占到锁后在执行创建单例对象的时候需要在校验一次
                // ***双重检查锁定背后的理论是完美的。不幸地是，现实完全不同。
                // ***双重检查锁定的问题是：并不能保证它会在单处理器或多处理器计算机上顺利运行
                if(lazySingleTon==null){
                    lazySingleTon = new LazySingleTon();
                }
            }

        }
        return lazySingleTon;
    }
}
