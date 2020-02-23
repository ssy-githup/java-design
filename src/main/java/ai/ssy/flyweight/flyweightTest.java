package ai.ssy.flyweight;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 享元测试类
 */
public class flyweightTest {
    public static void main(String[] args) {
        productFactory.getProduct("烧饼","1");
        productFactory.getProduct("烧饼","1");
        productFactory.getProduct("烧饼","2");
        productFactory.getProduct("羊肉汤","1");
        productFactory.getProduct("羊肉汤","1");
    }
}
//提供一个工厂
class productFactory{
    //线程安全
   public static Map<String,Product> map = new ConcurrentHashMap<String,Product>();

   public synchronized static Product getProduct(String name,String company){
        if(map.containsKey(name)){
            return map.get(name);
        }
        Product product = new Product(name,company);
        map.put(name,product);
        return product;
   }
}
class Product{
    String name;
    String company;

    public Product() {
    }

    public Product(String name, String company) {
        System.out.println("名称："+name+" ---被创建了");
        this.name = name;
        this.company = company;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", company='" + company + '\'' +
                '}';
    }
}
