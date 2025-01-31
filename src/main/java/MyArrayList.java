import java.util.*;

/**
 *Класс коллекция-контейнер на основе массива. Управляет элементами типа T. Может добавлять, удалять,
 * вставлять по индексу элементы, а также сортировать элементы. Урезанный аналог ArrayList.
 * @param <T> Тип элемента в контейнере
 */
public class MyArrayList<T>{

    private final int SIZE = 16;
    private final int CUT_RATE = 4;
    private Object[] array = new Object[SIZE];
    private int index = 0;

    /**
    Добавляет новый элемент в список.
    **/
    public void add(T item) {
        if (index == array.length - 1)
            resize(array.length * 2); // увеличу в 2 раза, если достигли границ
        array[index++] = item;
    }

    /**
    Возвращает элемент списка по индексу.
    **/
    public T get(int index) {
        return (T) array[index];
    }

    /**
    Удаляет элемент списка по индексу.
    **/
    public void remove(int index) {
        for (int i = index; i < this.index; i++)
            array[i] = array[i + 1];
        array[this.index] = null;
        this.index--;
        if (array.length > SIZE && this.index < array.length / CUT_RATE)
            resize(array.length / 2); // если элементов в CUT_RATE раз меньше чем
        // длина массива, то уменьшу в два раза
    }

    /**Возвращает количество элементов в списке**/
    public int size() {
        return index;
    }

    /**
     * Очистить всю коллекцию.
     */
    public void clear(){
        Object[] newArray = new Object[SIZE];
        index = 0;
        array = newArray;
    }

    /**
     * отсортировать коллекцию
     * @param comparator
     */
    public void sort(Comparator<T> comparator){
        Arrays.sort((T[])array,0, index,comparator);
    }


    /**
     * заменяет элемент списка по указанному индексу на новый
     * @param index
     * @param element
     * @return
     */
    public T set(int index, T element) {
        T oldValue = (T) array[index];
        array[index] = element;
        return oldValue;
    }


    /**Вспомогательный метод для масштабирования.**/
    private void resize(int newLength) {
        Object[] newArray = new Object[newLength];
        System.arraycopy(array, 0, newArray, 0, index);
        array = newArray;
    }

}
