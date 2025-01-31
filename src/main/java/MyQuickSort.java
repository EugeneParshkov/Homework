import java.util.Comparator;

/**
 * Класс для сортировки коллекции MyArrayList
 */
public class MyQuickSort {

    /**
     * Сортировать коллекцию с помощью компаратора
     * @param list
     * @param comparator
     * @param <T>
     */
    public static <T> void quickSort(MyArrayList<T> list, Comparator<? super T> comparator) {
        quickSort(list, comparator, 0, list.size() - 1);
    }

    private static <T> void quickSort(MyArrayList<T> list, Comparator<? super T> comparator, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(list, comparator, low, high);
            quickSort(list, comparator, low, pivotIndex);
            quickSort(list, comparator, pivotIndex + 1, high);
        }
    }

    private static <T> int partition(MyArrayList<T> list, Comparator<? super T> comparator, int low, int high) {
        T pivot = list.get((low + high) / 2);
        int i = low - 1;
        int j = high + 1;

        while (true) {
            do {
                i++;
            } while (comparator.compare(list.get(i), pivot) < 0);

            do {
                j--;
            } while (comparator.compare(list.get(j), pivot) > 0);

            if (i >= j) {
                return j;
            }

            swap(list, i, j);
        }
    }

    private static <T> void swap(MyArrayList<T> list, int i, int j) {
        T temp = list.get(i);
        list.set(i,list.get(j));
        list.set(j, temp);
    }
}
