/*
Напишите обобщенный класс Pair, который представляет собой пару значений разного типа.
Класс должен иметь методы getFirst(), getSecond() для получения значений каждого из составляющих пары,
а также переопределение метода toString(), возвращающее строковое представление пары.
 */

public class Pair<T, B> {
    static <T> T GetFirst(T one){
        return one;
    }
    static <B> B GetSecond(B two){
        return two;
    }

    public String toString(T, B){
        return  GetFirst(T) + " " + GetSecond(B);
    }
}
