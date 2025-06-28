package FleetCars;

import java.util.Random;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.HashSet;
import java.util.Collections;
import java.util.LinkedHashSet;
public class ListOfCars {
    public static void main(String args[]) {
        int[] years = new int[50];
        Random random=new Random();
        int amountAge=0;

        for (int i=0; i<years.length;i++){
            years[i]=random.nextInt(2000,2026);
            if (years[i]>2015){
                System.out.print(years[i]+" ");
            }
            amountAge+=2025-years[i];
        }
        double averageAge= (double) amountAge/years.length;
        System.out.println();
        System.out.println(averageAge);

        List<String> cars= new ArrayList<>();
        cars.add("Tesla Model S");
        cars.add("Mazda RX-7");
        cars.add("Mazda RX-8");
        cars.add("Lada Vesta");
        cars.add("BMW M3 (E46)");
        cars.add("Dodge Challenger");
        cars.add("Mazda RX-8");
        cars.add("Lada Vesta");
        cars.add("Mazda RX-8");
        cars.add("Lada Vesta");

        Set<String> uniqueModelsCars=new HashSet<>(cars);
        List<String> sortedModelsCars=new ArrayList<>(uniqueModelsCars);
        Collections.sort(sortedModelsCars,Collections.reverseOrder());
        System.out.println("Отсортированные модели машин: "+sortedModelsCars);
        Set<String> saveInSet=new LinkedHashSet<>(sortedModelsCars);
        System.out.println("Проверка сохранения: "+ saveInSet);

        for (int i=0; i<sortedModelsCars.size();i++){
            String modelName=sortedModelsCars.get(i);
            if (modelName.contains("Tesla")){
                sortedModelsCars.set(i,"ELECTRO_CAR");
            }
        }

        System.out.println("Проверка изменения: "+ sortedModelsCars);






    }

}
