



public class Main {

    public static void main(String[] args) {
//        double answer;
//        answer = Calculation.sum(5,2);
//        System.out.println(answer);
//        answer = Calculation.multiply(5,2);
//        System.out.println(answer);
//        answer = Calculation.divide(5,2);
//        System.out.println(answer);
//        answer = Calculation.substract(5,2);
//        System.out.println(answer);

        //вторая задача
        Integer[] array1 = {1,2,3,4,5};
        Integer[] array2 = {1,2,3,4,5};
        Character[] array3 = {'q','w','e','r','t'};
        Double[] array4 = {1.0, 2.0, 3.0, 4.0, 5.0};



        boolean isEqual1, isEqual2, isEqual3;
        isEqual1 = ArrEquals.compareArrays(array1, array2);// true
        isEqual2 = ArrEquals.compareArrays(array1, array3);// false
        isEqual3 = ArrEquals.compareArrays(array1, array4);// false
        System.out.println(isEqual1);
        System.out.println(isEqual2);
        System.out.println(isEqual3);

    }
}