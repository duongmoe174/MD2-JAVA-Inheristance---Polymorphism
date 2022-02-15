import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        FictionBook f1 = new FictionBook("f1", "Vu tru ky dieu", 10, "Duong", "Vien Tuong 1");
        FictionBook f2 = new FictionBook("f2", "Cuoc song hanh tinh khac", 20, "Duong", "Vien Tuong 1");
        FictionBook f3 = new FictionBook("f3", "Hanh tinh khi", 4000000, "Hieu", "Vien Tuong 2");
        FictionBook f4 = new FictionBook("f4", "Interstellar", 5000000, "Duc", "Vien Tuong 2");
        FictionBook f5 = new FictionBook("f5", "Tenet", 900000, "Luna", "Vien Tuong 2");

        ProgrammingBook p1 = new ProgrammingBook("p1", "DayPHP", 1000000, "HVNH", "PHP", "Laravel");
        ProgrammingBook p2 = new ProgrammingBook("p2", "DayJava", 3000000, "CodeGym", "JAVA", "Spring");
        ProgrammingBook p3 = new ProgrammingBook("p3", "DayPython", 2000000, "HVNH", "Python", "Pandas");
        ProgrammingBook p4 = new ProgrammingBook("p4", "DayMachineLearning", 10000000, "HVNH", "Python", "Pandas");
        ProgrammingBook p5 = new ProgrammingBook("p5", "DayHTML", 10000000, "Codegym", "Javascript", "Angular");

        Book[] listBooks = {f1, f2, f3, f4, f5, p1, p2, p3, p4, p5};

        getTotalPrice(listBooks);
        countLangage(listBooks);
        countCategory(listBooks);
        countPriceLessThan100(listBooks);

        Scanner inputName = new Scanner(System.in);
        System.out.println("Nhập tên sách cần tìm: ");
        String name = inputName.nextLine();
        findPriceBook(listBooks, name);
    }

    public static void getTotalPrice(Book[] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i].getPrice();
        }
        System.out.println("Tổng giá của 10 cuốn sách là: " + sum);
    }

    public static void countLangage(Book[] arr) {
        int count = 0;
        for (Book b : arr
        ) {
            if (b instanceof ProgrammingBook) {
                if (((ProgrammingBook) b).getLanguage() == "JAVA") {
                    count++;
                }
            }
        }
        System.out.println("Số sách có language JAVA là: " + count);
    }

    public static void countCategory(Book[] arr) {
        int count = 0;
        for (Book b : arr
        ) {
            if (b instanceof FictionBook) {
                if (((FictionBook) b).getCategory() == "Vien Tuong 1") {
                    count++;
                }
            }
        }
        System.out.println("Số sách có category là 'Viễn tưởng' 1 là: " + count);
    }

    public static void countPriceLessThan100(Book[] arr) {
        int count = 0;
        for (Book b : arr
        ) {
            if (b instanceof FictionBook) {
                if (b.getPrice() < 100) {
                    count++;
                }
            }
        }
        System.out.println("Số sách Fiction có giá nhỏ hơn 10 là: " + count);
    }

    public static void findPriceBook(Book[] arr, String name) {
        for (int i = 0; i < arr.length; i++) {
            if (Objects.equals(name, arr[i].getName())) {
                System.out.println("Giá của cuốn sách là: " + arr[i].getPrice());
                break;
            }
            if (i == arr.length - 1) {
                System.out.println("Không tìm thấy sách");
            }
        }
    }
}
