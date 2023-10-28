import java.util.ArrayList;


public class Empl {



    static void addNewWorkers(ArrayList<Worker> list, Worker worker) {
        list.add(worker);
    }
    static ArrayList<String> getNameWorkerOnExperience(ArrayList<Worker> units, int exp) {

        ArrayList<String> listsOfWorkersName = new ArrayList<>();
        for (int i = 0; i<units.size(); i++) {

            if (units.get(i).experience == exp) {
                listsOfWorkersName.add(units.get(i).name);
            }
        }
        return listsOfWorkersName;
    }

    static ArrayList<Integer> getPhoneNumberOnName(ArrayList<Worker> units, String name) {
        ArrayList<Integer> listsOfWorkersNumber = new ArrayList<>();
        for (int i = 0; i<units.size(); i++){
            if(units.get(i).name.equals(name)){
                listsOfWorkersNumber.add(units.get(i).phoneNumber);
            }
        }
        return listsOfWorkersNumber;
    }
    static String getWorkerOnPersonnelNumber(ArrayList<Worker> units, int personnelNumber) {
        for (int i = 0; i<units.size(); i++){
            if(units.get(i).personnelNumber==personnelNumber){
                return units.get(i).name;
            }
        }
        return null;
    }
}
