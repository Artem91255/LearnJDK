import java.util.ArrayList;

import static java.util.Collections.list;

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
        Worker worker1 = new Worker(1,0042, "Tom", 1);
        Worker worker2 = new Worker(2,3800, "Bob", 5);
        Worker worker3 = new Worker(3,3719, "Ann", 8);
        Worker worker4 = new Worker(4,0441, "Pit", 10);


        addNewWorkers(listsOfWorkers, worker1);
        addNewWorkers(listsOfWorkers, worker2);
        addNewWorkers(listsOfWorkers, worker3);
        addNewWorkers(listsOfWorkers, worker4);


        System.out.println(getWorkerOnExperience(listsOfWorkers, 1));
        System.out.println(getWorkerOnName(listsOfWorkers, "Ann"));
        System.out.println(getWorkerOnNumber(listsOfWorkers, 3800));



    }
    private static void addNewWorkers(ArrayList<Worker> list, Worker worker) {
        list.add(worker);
    }
    private static String getWorkerOnExperience(ArrayList<Worker> units, int exp) {
        for (int i = 0; i<units.size(); i++){
            if(units.get(i).experience ==exp){
                return units.get(i).name;
            }
        }
        return null;
    }
    private static int getWorkerOnName(ArrayList<Worker> units, String name) {
        for (int i = 0; i<units.size(); i++){
            if(units.get(i).name.equals(name)){
                return units.get(i).phoneNumber;
            }
        }
        return -1;
    }
    private static String getWorkerOnNumber(ArrayList<Worker> units, int number) {
        for (int i = 0; i<units.size(); i++){
            if(units.get(i).number ==number){
                return units.get(i).name;
            }
        }
        return null;
    }


}