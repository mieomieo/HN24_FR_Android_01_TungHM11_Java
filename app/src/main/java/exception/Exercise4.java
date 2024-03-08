package exception;

public class Exercise4 {
    public static void main(String[] args) {
        String str = "abc";
        try {
            int intValue = Integer.parseInt(str);
            System.out.println("Số nguyên: " + intValue);
        } catch (NumberFormatException e) {
            System.out.println("Lỗi: Không thể ép kiểu chuỗi sang số nguyên.");
        }
        try {
            double doubleValue = Double.parseDouble(str);
            System.out.println("Số thực: " + doubleValue);
        } catch (NumberFormatException e) {
            System.out.println("Lỗi: Không thể ép kiểu chuỗi sang số thực.");
        }
        try {
            long longValue = Long.parseLong(str);
            System.out.println("Số long: " + longValue);
        } catch (NumberFormatException e) {
            System.out.println("Lỗi: Không thể ép kiểu chuỗi sang số long.");
        }

    }
}
