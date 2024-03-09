package collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Exercise1 {
//Khai báo 2 mảng colors và colors2 và thêm các phần tử cho 2 mảng đó.
//Tạo mới 2 List list và list2 có các phần tử là phần tử của 2 mảng vừa
//khai báo. Thêm các phần tử có trong list2 vào trong list, sau đó
//đưa list2 trở về 1 danh sách rỗng (không có phần tử nào) và hiển thị list.
//Chuyển các phần tử có trong list thành ký tự in hoa và hiển thị lại list đó.
//Xóa các phần tử trong list từ phần tử thứ 4 đến phần tử thứ 6. Hiển thị
//lại list sau khi xóa. Đảo ngược list và hiển thị lại list sau khi đảo ngược.
    public static void main(String[] args) {
        String colors[] = new String[3];
        String colors2[] = new String[3];
        colors[0]="green";
        colors[1]="red";
        colors[2]="blue";
        colors2[0]="yellow";
        colors2[1]="black";
        colors2[2]="pink";
        List<String> list = new ArrayList<>();
        List<String> list2 = new ArrayList<>();
        Collections.addAll(list, colors);
        Collections.addAll(list2, colors2);
        list.addAll(list2);
        list2.clear();
        System.out.println("list= "+list);
        System.out.println("list2= "+list2);

        for (int i = 0; i < list.size(); i++) {
            list.set(i, list.get(i).toUpperCase());
        }
        System.out.println("uppercase list="+list);
        list.subList(3, 6).clear();
        System.out.println("delete 4->6 list="+list);
        Collections.reverse(list);
        System.out.println("reverse list="+list);
    }
}
