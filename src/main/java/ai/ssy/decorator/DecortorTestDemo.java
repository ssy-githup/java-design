package ai.ssy.decorator;

/**
 * 装饰者模式
 * 模式定义：在不改变原有对象的基础上，将功能附加到对象上
 * 开闭原则
 * 应用场景：扩展一个类的功能或给一个类添加职责
 *
 */
public class DecortorTestDemo {

    public static void main(String[] args) {
        Shape shape = new Circle();
        shape.draw();
        System.out.println("=================第一次=======================");
        Shape redShapeDecorator = new RedShapeDecorator(shape);
        redShapeDecorator.draw();
        System.out.println("=================第二次=======================");

        Shape yellowShapeDecorator = new YellowShapeDecorator(redShapeDecorator);
        yellowShapeDecorator.draw();
    }
}

//1:
interface Shape {
    void draw();
}

class Circle implements Shape {

    @Override
    public void draw() {
        System.out.println("原始的图形");
    }
}
abstract class ShapeDecorator implements Shape{

    protected Shape decoratedShape;

    public ShapeDecorator(Shape decoratedShape) {
        this.decoratedShape = decoratedShape;
    }

}
//创建扩展了 ShapeDecorator 类的实体装饰类。
class RedShapeDecorator extends ShapeDecorator {

    public RedShapeDecorator(Shape decoratedShape) {
        super(decoratedShape);
    }

    @Override
    public void draw() {
        decoratedShape.draw();
        setRedBorder(decoratedShape);
    }

    private void setRedBorder(Shape decoratedShape){
        System.out.println("使用红色进行增强");
    }
}

class YellowShapeDecorator extends ShapeDecorator {

    public YellowShapeDecorator(Shape decoratedShape) {
        super(decoratedShape);
    }

    @Override
    public void draw() {
        decoratedShape.draw();
        setRedBorder(decoratedShape);
    }

    private void setRedBorder(Shape decoratedShape){
        System.out.println("使用黄色进行增强");
    }
}