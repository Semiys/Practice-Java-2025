package annotations;

@DeprecatedEx(message = "Используйте новый класс NewService")
public class OldService {
    public void doSomething(){
        System.out.println("OldService: выполнение что-то полезное");
    }

    @DeprecatedEx(message="Используйте метод newAction()")
    public void oldAction(){
        System.out.println("OldService: выполняю старое действие");
    }

    public void newAction(){
        System.out.println("OldService: выполняю НОВОЕ действие");
    }
}
