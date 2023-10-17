public class Calculation {
    /*
    Написать класс Калькулятор (необобщенный), который содержит обобщенные статические методы:
    sum(), multiply(), divide(), subtract().
    Параметры этих методов – два числа разного типа (но необязательно разного между собой),
    над которыми должна быть произведена операция.
     */
    static <T extends Number, N extends Number> double sum(T a, N b){

        return a.doubleValue() + b.doubleValue();
    }
    static <T extends Number, N extends Number> double multiply(T a, N b){

        return a.doubleValue() * b.doubleValue();
    }
    static <T extends Number, N extends Number> double divide(T a, N b){

        return a.doubleValue() / b.doubleValue();
    }
    static <T extends Number, N extends Number> double substract(T a, N b){

        return a.doubleValue() - b.doubleValue();
    }

}
