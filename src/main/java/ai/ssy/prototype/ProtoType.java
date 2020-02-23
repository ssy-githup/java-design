package ai.ssy.prototype;

import java.io.*;
import java.util.Arrays;
import java.util.PropertyResourceBundle;

public class ProtoType {
    public static void main(String[] args) throws CloneNotSupportedException {

        Product product = new Product("name", new String[]{"1", "wq"},new ProductBaseInfo("213"));
        Product clone = product.clone();

        System.out.println(product);
        System.out.println(clone);
        System.out.println(product==clone);

        System.out.println();
        //验证浅拷贝
        //重写 clone方法；使得里面的ProductBaseInfo也拷贝；否则对象引用的还是原来的
        product.getProductBaseInfo().setInfo("789");
        System.out.println(product);
        System.out.println(clone);
    }
}

/**
 * 1：实现 Cloneable接口
 *:2：重写 clone方法
 */
class Product implements  Cloneable, Serializable {

    static final long serialVersionUID = 42L;

    String productName;
    String[] names;

    ProductBaseInfo productBaseInfo;

    @Override
    protected Product clone() throws CloneNotSupportedException {
       //1:重写 clone方法实现:
//        Product product = (Product) super.clone();
//        ProductBaseInfo productBaseInfo = this.productBaseInfo.clone();
//        product.setProductBaseInfo(productBaseInfo);
//        return product;

        //2: 使用流进行拷贝
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            ObjectOutputStream oos = new ObjectOutputStream(byteArrayOutputStream);
            oos.writeObject(this);
        } catch (IOException e) {
            e.printStackTrace();
        }
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
        try {
            ObjectInputStream ois = new ObjectInputStream(byteArrayInputStream);
            Product product = (Product)ois.readObject();
            return product;
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Product() {
    }

    public Product(String productName, String[] names, ProductBaseInfo productBaseInfo) {
        this.productName = productName;
        this.names = names;
        this.productBaseInfo = productBaseInfo;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productName='" + productName + '\'' +
                ", names=" + Arrays.toString(names) +
                ", productBaseInfo=" + productBaseInfo +
                '}';
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String[] getNames() {
        return names;
    }

    public void setNames(String[] names) {
        this.names = names;
    }

    public ProductBaseInfo getProductBaseInfo() {
        return productBaseInfo;
    }

    public void setProductBaseInfo(ProductBaseInfo productBaseInfo) {
        this.productBaseInfo = productBaseInfo;
    }
}
class ProductBaseInfo implements Cloneable, Serializable {

    static final long serialVersionUID = 42L;
    @Override
    protected ProductBaseInfo clone() throws CloneNotSupportedException {
        return (ProductBaseInfo)super.clone();
    }

    String info;

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public ProductBaseInfo() {
    }
    public ProductBaseInfo(String info) {
        this.info = info;
    }

    @Override
    public String toString() {
        return "{" +
                "info='" + info + '\'' +
                '}';
    }
}