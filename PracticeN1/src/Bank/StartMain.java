package Bank;

public class StartMain {
    public static void main(String args[]){
        BankAccount vadimAccount=new BankAccount("Vadim");
        BankAccount olgaAccount=new BankAccount("Olga");
        
        System.out.println(vadimAccount);
        System.out.println("\n");
        System.out.println(olgaAccount);
        System.out.println("\n Deposit");
        vadimAccount.Deposit(777420);
        System.out.println(vadimAccount);
        System.out.println("\n Withdraw");
        vadimAccount.Withdraw(450232);
        System.out.println(vadimAccount);
        System.out.println("\n Transfer");
        vadimAccount.Transfer(olgaAccount,3562);
        System.out.println(vadimAccount);
        System.out.println("\n");
        System.out.println(olgaAccount);
        System.out.println("\n");

        System.out.println("Тестирование метода equals()");

        BankAccount anotherVadimAccount = new BankAccount("Vadim");

        System.out.println("Первый счёт Вадима:");
        System.out.println(vadimAccount);
        System.out.println("\n");
        System.out.println("Второй, новый счёт Вадима:");
        System.out.println(anotherVadimAccount);

        System.out.println("\n1. Сравнение ДВУХ РАЗНЫХ объектов с помощью '=='");
        System.out.println("Результат: " + (vadimAccount == anotherVadimAccount)); //false потому что два разных объекта в памяти

        System.out.println("\n2. Сравнение ДВУХ РАЗНЫХ объектов с помощью '.equals()'");
        System.out.println("Результат: " + vadimAccount.equals(anotherVadimAccount)); //false потому метод equals видит, что номера счетов разные


        BankAccount sameVadimAccount = vadimAccount; // создадим просто ещё одну ссылку на первый счёт Вадима

        System.out.println("\n3. Сравнение ОДНОГО И ТОГО ЖЕ объекта (через разные переменные) с помощью '.equals()'");
        System.out.println("Результат: " + vadimAccount.equals(sameVadimAccount));// true потому что это один и тот же объект

        System.out.println("\n4. Сравнение счёта с объектом другого класса (со строкой)");
        System.out.println("Результат: " + vadimAccount.equals("просто строка")); //false потому что сработала проверка getClass










    }
}
