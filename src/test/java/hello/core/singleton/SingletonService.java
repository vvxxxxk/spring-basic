package hello.core.singleton;

public class SingletonService {

    private static final SingletonService instance = new SingletonService();

    private SingletonService() {
        // private 생성자를 통해 다른 곳에서 new를 통해 인스턴스를 생성할 수 없도록 함
    }

    public static SingletonService getInstance() {
        return instance;
    }

    public void logic() {
        System.out.println("싱글톤 객체 로직 호출");
    }
}
