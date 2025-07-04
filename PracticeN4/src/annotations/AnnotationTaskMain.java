package annotations;

public class AnnotationTaskMain {
    public static void main(String[] args) {
        AnnotationProcessor.process(OldService.class);

        System.out.println("\n--- Демонстрация работы методов ---");
        OldService service = new OldService();
        service.doSomething();
        service.oldAction();
        service.newAction();
    }
}
