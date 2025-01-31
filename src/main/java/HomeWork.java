import java.util.Arrays;

public class HomeWork {


        // Перевернуть строку и вывести на консоль
        //  String string = "I love Java";
        public static void turnString(String string) {
            StringBuilder sb = new StringBuilder(string);
            sb.reverse();
            System.out.println(sb.toString());
        }

        // int[] ints = {1, 2, 2, 3, 4, 5, 5, 6, 7, 8, 8, 9};
        // Удалить дубликаты из массива и вывести в консоль
        public static void getDistinctNumbers(int[] ints) {
            Arrays.stream(ints).distinct().forEach(System.out::println);
        }

        // Дан массив, заполненный уникальными значениями типа int.
        // int[] arr = {10, 15, 23, 11, 44, 13, 66, 1, 6, 47};
        // Необходимо найти элемент, который меньше максимума, но больше всех остальных.
        public static Integer findSecondMaxElement(int[] arr) {
            int element = arr[0];
            int max = Arrays.stream(arr).max().orElseThrow();
            for (int i = 1; i < arr.length; i++) {
                if (element < arr[i] && arr[i] != max) {
                    element = arr[i];
                }
            }
            return element;
        }

    }
