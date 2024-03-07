package exception;

import java.util.List;

public class Exercise5 {
    public static void main(String[] args) {
        try {
            List<String> list = null;
            System.out.println(list.size());
        }catch (NullPointerException e){
            System.out.println("Error");
        }
    }

}
