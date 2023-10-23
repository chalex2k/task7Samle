public class Interval {
    public int firstIndex;
    public int length;

    //Метод-конструктор. Создаёт объект Interval с переданными значениями
    public Interval(int firstIndex, int length) {
        this.firstIndex = firstIndex;
        this.length = length;
    }
    // Метод создаёт новый интервал со значениями по умолчанию
    public static Interval defaultInterval(){
        return new Interval(-1, -1);
    }
}