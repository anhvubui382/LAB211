import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/**
 * Class BinarySearch
 */
public class BinarySearch {
    int[] array; // Mảng chứa các phần tử cần tìm kiếm

    // Constructor mặc định
    public BinarySearch() {
    }

    // Constructor nhận tham số 'n' để khởi tạo mảng với kích thước 'n'
    public BinarySearch(int n) {
        setArray(n); // Gọi phương thức setArray để khởi tạo mảng
    }

    // Getter để lấy giá trị của mảng
    public int[] getArray() {
        return array;
    }

    // Setter để khởi tạo mảng với kích thước 'n'
    public void setArray(int n) {
        if(n > 0){ // Kiểm tra n có lớn hơn 0 không
            array = new int[n]; // Khởi tạo mảng với kích thước 'n'
            random(); // Gọi phương thức để sinh các giá trị ngẫu nhiên cho mảng
        } else {
            throw new IllegalArgumentException("Must be number"); // Nếu 'n' <= 0 thì ném ra lỗi
        }
    }
    
    // Phương thức nhập kích thước mảng từ người dùng
    public void inputSize(Scanner sc){
        while(true){
            System.out.println("Input number of arrays: ");
            if(sc.hasNextInt()){ // Kiểm tra nếu đầu vào là số nguyên
                int n = sc.nextInt();
                if(n > 0){ // Nếu số nguyên lớn hơn 0
                    array = new int[n]; // Khởi tạo mảng với kích thước 'n'
                    random(); // Gọi phương thức để sinh giá trị ngẫu nhiên
                    break; // Thoát vòng lặp khi mảng được khởi tạo thành công
                } else {
                    System.out.println("Must be number greater than 0"); // Thông báo lỗi nếu số nhỏ hơn hoặc bằng 0
                }
            } else {
                System.out.println("Enter again: ");
                sc.next(); // Bỏ qua đầu vào không hợp lệ và yêu cầu nhập lại
            }
        }
    }
    
    // Phương thức để sinh các số ngẫu nhiên cho mảng
    public void random(){
        Random rd = new Random();
        for(int i = 0; i < array.length; i++){
            array[i] = rd.nextInt(array.length); // Sinh các số ngẫu nhiên từ 0 đến kích thước mảng
        }
    }
    
    // Phương thức hiển thị các phần tử trong mảng
    public void displayArray(){
        System.out.print("["); // In ký tự mở ngoặc vuông
        for(int i = 0; i < array.length; i++){
            System.out.print(array[i]); // In giá trị của phần tử thứ 'i'
            if(i < array.length - 1){ // Nếu chưa phải phần tử cuối cùng, in thêm dấu phẩy
                System.out.print(", ");
            }
        }
        System.out.println("]"); // Kết thúc mảng với dấu đóng ngoặc vuông
    }
    
    // Thuật toán tìm kiếm nhị phân
    public int binarySearch(int value){
        Arrays.sort(array); // Sắp xếp mảng theo thứ tự tăng dần (tìm kiếm nhị phân yêu cầu mảng đã sắp xếp)
        int left = 0; // Chỉ số bắt đầu
        int right = array.length - 1; // Chỉ số kết thúc
        while(left <= right){ // Tiếp tục lặp khi chỉ số trái nhỏ hơn hoặc bằng chỉ số phải
            int mid = left + (right - left) / 2; // Tính chỉ số giữa
            if(array[mid] == value){ // Nếu giá trị tại vị trí giữa bằng giá trị cần tìm
                return mid; // Trả về vị trí
            }
            if(array[mid] < value){ // Nếu giá trị giữa nhỏ hơn giá trị cần tìm
                left = mid + 1; // Di chuyển chỉ số trái sang bên phải
            } else { // Nếu giá trị giữa lớn hơn giá trị cần tìm
                right = mid - 1; // Di chuyển chỉ số phải sang bên trái
            }
        }
        return -1; // Trả về -1 nếu không tìm thấy
    }
}
