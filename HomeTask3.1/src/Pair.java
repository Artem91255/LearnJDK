/*
Напишите обобщенный класс Pair, который представляет собой пару значений разного типа.
Класс должен иметь методы getFirst(), getSecond() для получения значений каждого из составляющих пары,
а также переопределение метода toString(), возвращающее строковое представление пары.
 */

public class Pair<T, B> {
    public T firstValue;
    public B secondValue;
    public T GetFirst(){
        return firstValue;
    }
    public B GetSecond(){
        return secondValue;
    }

    public String toString(){
        return (String) GetFirst() + (String) GetSecond();
    }
}
