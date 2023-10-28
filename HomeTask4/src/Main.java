import java.util.ArrayList;
import java.util.List;



/*
Создать справочник сотрудников
Необходимо:
Создать класс справочник сотрудников, который содержит внутри коллекцию сотрудников - каждый сотрудник должен иметь следующие атрибуты:
Табельный номер
Номер телефона
Имя
Стаж
Добавить метод, который ищет сотрудника по стажу (может быть список)
Добавить метод, который выводит номер телефона сотрудника по имени (может быть список)
Добавить метод, который ищет сотрудника по табельному номеру
Добавить метод добавление нового сотрудника в справочник
 */

public class Main {
    public static void main(String[] args) {

        ArrayList<Worker> listsOfWorkers = new ArrayList<>();
        Worker worker1 = new Worker(1, 2345, "Tom", 1);
        Worker worker2 = new Worker(2, 3800, "Bob", 1);
        Worker worker3 = new Worker(3, 3719, "Ann", 8);
        Worker worker4 = new Worker(4, 4410, "Ann", 10);


        Empl.addNewWorkers(listsOfWorkers, worker1);
        Empl.addNewWorkers(listsOfWorkers, worker2);
        Empl.addNewWorkers(listsOfWorkers, worker3);
        Empl.addNewWorkers(listsOfWorkers, worker4);

        
        ArrayList<String> getNames = new ArrayList<>();
        getNames = Empl.getNameWorkerOnExperience(listsOfWorkers, 1);
       for (String s : getNames) {
           System.out.printf("%s, ", s);
            }
        System.out.println();
            ArrayList<Integer> getNumbers = new ArrayList<>();
            getNumbers = Empl.getPhoneNumberOnName(listsOfWorkers, "Ann");
            for (Integer n : getNumbers) {
                System.out.printf("%d, ", n);
            }
        System.out.println();
            System.out.println(Empl.getWorkerOnPersonnelNumber(listsOfWorkers, 4));





        }
    }