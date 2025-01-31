
public class MainClass {

    public static void main(String[] args) {

        MyArrayList<Integer> list = new MyArrayList<>();
//        list.add("yorest");
//        list.add("aore;lk;st");
//        list.add("borjukst");
//        list.add("korjkest");
//        list.add("corest");
        for (int i = 0; i < 100; i++){
            list.add((int) (Math.random() * 100));
        }
        list.sort(Integer::compareTo);
      //  MyQuickSort.quickSort(list, Comparator.naturalOrder());
       for (int i = 0; i < list.size(); i++){
           System.out.println(list.get(i));
       }

    }
}
