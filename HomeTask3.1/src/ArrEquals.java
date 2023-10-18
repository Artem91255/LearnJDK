/*
Напишите обобщенный метод compareArrays(), который принимает два массива и возвращает true, если они одинаковые,
и false в противном случае.
Массивы могут быть любого типа данных, но должны иметь одинаковую длину и содержать элементы одного типа.
 */

public class ArrEquals {
static <T> boolean compareArrays(T[] arr1, T[] arr2){
    int count = 0;
    for(int i = 0; i<arr1.length; i++){

        if(!arr1[i].equals(arr2[i])){
            count++;
        }
    }
    if(count>0){
        return false;
    }
    else{
        return true;
    }

}
}
