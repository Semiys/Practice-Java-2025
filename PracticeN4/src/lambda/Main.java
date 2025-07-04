package lambda;

import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class Main {
    public static void main(String args[]){
        Printable myPrinter=()->System.out.println("Первое лямбда-выражение");
        myPrinter.print();

        Predicate<String> isNotNull=s-> s != null;

        System.out.println("Проверка на null для 'BMW': " + isNotNull.test("BMW")); // true
        System.out.println("Проверка на null для null: " + isNotNull.test(null));   // false
        System.out.println();

        Predicate<String> isNotEmpty= s-> !s.isEmpty();

        System.out.println("Проверка на null для 'BMW': " + isNotEmpty.test("BMW")); // true
        System.out.println("Проверка на null для empty: " + isNotEmpty.test(""));   // false
        System.out.println();

        Predicate<String> isNotNullAndNotEmpty= isNotNull.and(isNotEmpty);

        System.out.println("Проверка на null для 'BMW': " + isNotNullAndNotEmpty.test("BMW")); // true
        System.out.println("Проверка на null для null: " + isNotNullAndNotEmpty.test(null)); //false
        System.out.println("Проверка на null для empty: " + isNotNullAndNotEmpty.test(""));// false
        System.out.println();

        Predicate<String> isFirstOneIndex= s-> s.startsWith("J");
        Predicate<String> isFirstTwoIndex=s-> s.startsWith("N");
        Predicate<String> isLastIndex=s->s.endsWith("A");

        Predicate<String> FirstAndLastIndex=isLastIndex.and(isFirstOneIndex.or(isFirstTwoIndex));

        System.out.println("Проверка на N: "+ FirstAndLastIndex.test("Need for speed Most Wanted 2005 A"));
        System.out.println("Проверка на J: "+ FirstAndLastIndex.test("Joker"));
        System.out.println("Проверка на A: "+ FirstAndLastIndex.test("Need Joke A"));
        System.out.println("Проверка на false: "+ FirstAndLastIndex.test("b1t rush A"));
        System.out.println("Проверка на false: "+ FirstAndLastIndex.test("Need for speed Most Wanted 2005"));
        System.out.println("Проверка на false: "+ FirstAndLastIndex.test("J Need for speed Most Wanted 2005"));
        System.out.println();

        HeavyBox box=new HeavyBox(152);
        Consumer<HeavyBox> shipConsumer= b-> System.out.println("Отгрузили ящик с весом: "+ b.getWeight()+" кг");
        Consumer<HeavyBox> sendConsumer= b-> System.out.println("Отправлен ящик с весом: "+ b.getWeight()+ " кг");
        Consumer<HeavyBox> combinedConsumer= shipConsumer.andThen(sendConsumer);

        combinedConsumer.accept(box);

        HeavyBox smallBox= new HeavyBox(52);

        combinedConsumer.accept(smallBox);

        System.out.println();

        Function<Integer,String> numberPolNegZero=number->{
            if (number > 0){
                return "Положительное число";
            }
            else if(number<0){
                return "Отрицательное число";
            }
            else{
                return "Ноль";
            }
        };

        int num1=21;
        int num2=-7;
        int num3=0;
        System.out.println("Число: "+ num1+ " это: "+ numberPolNegZero.apply(num1));
        System.out.println("Число: "+ num2+ " это: "+ numberPolNegZero.apply(num2));
        System.out.println("Число: "+ num3+ " это: "+ numberPolNegZero.apply(num3));

        Supplier<Integer> randomNumberSupplier=()->(int)(Math.random()*11);

        System.out.println("Случайное число 1: "+ randomNumberSupplier.get());
        System.out.println("Случайное число 2: "+ randomNumberSupplier.get());
        System.out.println("Случайное число 3: "+ randomNumberSupplier.get());
    }


}
