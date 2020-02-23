package ai.ssy.templateMethod;

/**
 * 模板方法类
 */
public class TemplateMethodDemo {
    public static void main(String[] args) {
        Game game  = new Football();
        game.play();
    }
}
//1:定义一个抽象类；
abstract class Game {
    abstract void initialize();
    abstract void startPlay();
    abstract void endPlay();

    //模板方法；使用final修饰
    public final void play(){

        //初始化游戏
        initialize();

        //开始游戏
        startPlay();

        //结束游戏
        endPlay();
    }
}
//2：继承模板类
class Football extends Game {

    @Override
    void endPlay() {
        System.out.println("Football Game Finished!");
    }

    @Override
    void initialize() {
        System.out.println("Football Game Initialized! Start playing.");
    }

    @Override
    void startPlay() {
        System.out.println("Football Game Started. Enjoy the game!");
    }
}
