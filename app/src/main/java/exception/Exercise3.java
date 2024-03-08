package exception;

public class Exercise3 {
    public static void main(String[] args) {
        int arr[]= new int[5];
        try {
            System.out.println(arr[6]);
        }catch (ArrayIndexOutOfBoundsException  e){
            System.out.println("Lỗi: Phần tử không tồn tại trong mảng.");
        }

    }
}
