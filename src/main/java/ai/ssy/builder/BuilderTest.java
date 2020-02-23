package ai.ssy.builder;

public class BuilderTest {
    public static void main(String[] args) {

        ProductBuiler productBuiler = new ContrProductBuilder();
        Director director = new Director(productBuiler);
        Product builder = director.createBuilder("productName", "companyName", "part1", "part2");
        System.out.println(builder);


    }
}
class Director{
    private ProductBuiler productBuiler;

    public Director(ProductBuiler productBuiler){
        this.productBuiler=productBuiler;
    }
    public Product createBuilder(String productName, String companyName, String part1, String part2){
        productBuiler.builderProductName(productName);
        productBuiler.builderCompanyName(companyName);
        productBuiler.builderPart1(part1);
        productBuiler.builderPart2(part2);

        Product builder = productBuiler.builder();
        return  builder;
    }
}


// 具体 builder 类
class ContrProductBuilder implements ProductBuiler{
    String productName;
    String companyName;

    String part1;
    String part2;

    @Override
    public void builderProductName(String productName) {
        this.productName=productName;
    }

    @Override
    public void builderCompanyName(String companyName) {
        this.companyName=companyName;
    }

    @Override
    public void builderPart1(String part1) {
        this.part1=part1;
    }

    @Override
    public void builderPart2(String part2) {
        this.part2=part2;
    }

    @Override
    public Product builder() {
        return new Product(productName,companyName,part1,part2);
    }
}


interface ProductBuiler{
     void builderProductName(String productName);
     void builderCompanyName(String companyName);
     void builderPart1(String part1);
     void builderPart2(String part2);

     Product builder();
}

class Product{
    String productName;
    String companyName;

    String part1;
    String part2;

    public Product(){}

    public Product(String productName, String companyName, String part1, String part2) {
        this.productName = productName;
        this.companyName = companyName;
        this.part1 = part1;
        this.part2 = part2;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getPart1() {
        return part1;
    }

    public void setPart1(String part1) {
        this.part1 = part1;
    }

    public String getPart2() {
        return part2;
    }

    public void setPart2(String part2) {
        this.part2 = part2;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productName='" + productName + '\'' +
                ", companyName='" + companyName + '\'' +
                ", part1='" + part1 + '\'' +
                ", part2='" + part2 + '\'' +
                '}';
    }
}