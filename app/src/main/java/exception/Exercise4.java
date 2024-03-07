package exception;

public class Exercise4 {
    public static void main(String[] args) {
        String str = "abc";
        try {
            double num = Double.parseDouble(str);
            System.out.println("Số: " + num);
        } catch (NumberFormatException e) {
            System.out.println("Lỗi: Không thể ép kiểu chuỗi sang số.");
        }
    }
}
