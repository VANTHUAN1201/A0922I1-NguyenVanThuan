package list.array_list;

public class MyListTest {
    public static void main(String[] args) {
        MyList<Integer> integerMyList = new MyList<Integer>();
        integerMyList.add(0);
        integerMyList.add(1);
        integerMyList.add(2);
        integerMyList.add(3);
        integerMyList.add(4);
        integerMyList.add(5);
        System.out.println("Danh sách:");
        for (int i = 0; i < integerMyList.size(); i++) {
            System.out.print(integerMyList.get(i)+" ");
        }
        System.out.println("\nelement 4= " + integerMyList.get(3));

    }
}

