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

        int choice = -1;
        Scanner inputChoice = new Scanner(System.in);
        while (choice != 0) {
            System.out.println("Menu");
            System.out.println("1. Tổng giá sách: ");
            System.out.println("2. Đếm sách Programming theo ngôn ngữ");
            System.out.println("3. Đếm sách Fiction theo thể loại");
            System.out.println("4. Đếm sách Fiction trong khoảng giá");
            System.out.println("5. Tìm giá sách theo tên: ");
            System.out.println("6. Exit");
            System.out.println("Enter your choice: ");
            choice = inputChoice.nextInt();
            switch (choice) {
                case 1:
                    getTotalPrice(listBooks);
                    break;
                case 2:
                    Scanner inputName = new Scanner(System.in);
                    System.out.println("Nhập tên sách cần tìm: ");
                    String name = inputName.nextLine();
                    findPriceBook(listBooks, name);
                    break;
                case 3:
                    Scanner inputLanguage = new Scanner(System.in);
                    System.out.println("Nhập tên language cần đếm trong Programming Book: ");
                    String language = inputLanguage.nextLine();
                    countByLanguage(listBooks, language);
                    break;
                case 4:
                    Scanner inputCategory = new Scanner(System.in);
                    System.out.println("Nhập tên category cần đếm trong Fiction Book: ");
                    String category = inputCategory.nextLine();
                    countByCategory(listBooks, category);
                    break;
                case 5:
                    Scanner inputNumber = new Scanner(System.in);
                    System.out.println("Nhập giá trị sách cần đếm trong Fiction Book: ");
                    int number = inputNumber.nextInt();
                    countPriceLessThanValue(listBooks, number);
                    break;
                case 0:
                    System.exit(0 );
                default:
                    System.out.println("Không có lựa chọn này!");
            }
        }
    }

    public static void getTotalPrice(Book[] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i].getPrice();
        }
        System.out.println("Tổng giá của 10 cuốn sách là: " + sum);
    }

    public static void countByLanguage(Book[] arr, String language) {
        int count = 0;
        for (Book b : arr
        ) {
            if (b instanceof ProgrammingBook) {
                String check = ((ProgrammingBook) b).getLanguage();
                if (check.equals(language)) {
                    count++;
                }
            }
        }
        System.out.println("Số sách có language JAVA là: " + count);
    }

    public static void countByCategory(Book[] arr, String category) {
        int count = 0;
        for (Book b : arr
        ) {
            if (b instanceof FictionBook) {
                String check = ((FictionBook) b).getCategory();
                if (check.equals(category)) {
                    count++;
                }
            }
        }
        System.out.println("Số sách có category là 'Viễn tưởng' 1 là: " + count);
    }

    public static void countPriceLessThanValue(Book[] arr, int value) {
        int count = 0;
        for (Book b : arr
        ) {
            if (b instanceof FictionBook) {
                if (b.getPrice() < value) {
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
