import java.util.Calendar;
import java.util.Scanner;

/**
 *
 * @author THAYCACAC
 */
public class Candidate {

    Scanner sc = new Scanner(System.in);
    protected String id;
    protected String firstName;
    protected String lastName;
    protected int birthDate;
    protected String address;
    protected String phone;
    protected String email;
    protected int typeCandidate;

    public Candidate() {
    }

    public Candidate(String id, String firstName, String lastName, int birthDate, String address, String phone, String email, int typeCandidate) throws Exception {
        setId(id);
        setFirstName(firstName);
        setLastName(lastName);
        setAddress(address);
        setBirthDate(birthDate);
        setPhone(phone);
        setEmail(email);
        setTypeCandidate(typeCandidate); 
    }

    public String getId() {
        return id;
    }

    public void setId(String id) throws Exception {
        if (id.isEmpty()) {
            throw new Exception("Id cannot be null");
        }
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) throws Exception {
        if (firstName.isEmpty()) {
            throw new Exception("firstName cannot be null");
        }
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) throws Exception {
        if (lastName.isEmpty()) {
            throw new Exception("lastName cannot be null");
        }
        this.lastName = lastName;
    }

    public int getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(int birthDate) throws Exception {
        // Lấy năm hiện tại
        int currentYear = Calendar.getInstance().get(Calendar.YEAR);

        // Kiểm tra xem birthDate có đủ 4 chữ số không
        if (String.valueOf(birthDate).length() == 4 && birthDate >= 1900 && birthDate <= currentYear) {
            this.birthDate = birthDate;
        } else {
            throw new Exception("Birth date must be 4 character and from 1900 to " + currentYear);
        }
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) throws Exception {
        if (address.isEmpty()) {
            throw new Exception("address cannot be null");
        }
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) throws Exception {
        // Kiểm tra xem số điện thoại có rỗng không
        if (phone.isEmpty()) {
            throw new Exception("Phone cannot be null or empty.");
        }

        // Kiểm tra xem số điện thoại có đủ 10 chữ số không
        if (phone.length() != 10 || !phone.matches("\\d+")) {
            throw new Exception("Phone must be exactly 10 digits.");
        }

        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) throws Exception {
        // Kiểm tra xem email có rỗng không
        if (email.isEmpty()) {
            throw new Exception("Email cannot be null or empty.");
        }

        // Kiểm tra định dạng email bằng biểu thức chính quy
        String emailPattern = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
        if (!email.matches(emailPattern)) {
            throw new Exception("Email format is invalid.");
        }

        this.email = email;
    }

    public int getTypeCandidate() {
        return typeCandidate;
    }

    public void setTypeCandidate(int typeCandidate) throws Exception {
        if (typeCandidate < 0 || typeCandidate > 3) {
            throw new Exception("Type candidate must be in range [0, 3]");
        }
        this.typeCandidate = typeCandidate;
    }
//
//    @Override
//    public String toString() {
//        return this.firstName + " " + this.lastName + " | " + this.birthDate + " | "
//                + this.address + " | " + this.phone + " | " + this.email + " | "
//                + this.typeCandidate;
//    }
@Override
public String toString() {
    // Lấy 6 ký tự cuối của số điện thoại nếu nó dài hơn hoặc bằng 6 ký tự
    String shortPhone = this.phone.length() >= 6 ? this.phone.substring(this.phone.length() - 6) : this.phone;
    
    return this.firstName + " " + this.lastName + " | " 
            + this.birthDate + " | "
            + this.address + " | " 
            + shortPhone + " | " 
            + this.email + " | "
            + this.typeCandidate;
}
    public Candidate input() {
        // Nhập dữ liệu cho đối tượng Candidate
        while (true) {
            try {
                System.out.print("Enter id: ");
                String id = sc.nextLine().trim();
                setId(id);
                break;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        while (true) {
            try {
                System.out.print("Enter first name: ");
                String firstName = sc.nextLine().trim();
                setFirstName(firstName);
                break;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        while (true) {
            try {
                System.out.print("Enter last name: ");
                String lastName = sc.nextLine().trim();
                setLastName(lastName);
                break;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        while (true) {
            try {
                System.out.print("Enter birth date: ");
                int birthDate = Integer.parseInt(sc.nextLine());
                setBirthDate(birthDate);
                break;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        while (true) {
            try {
                System.out.print("Enter address: ");
                String address = sc.nextLine().trim();
                setAddress(address);
                break;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        while (true) {
            try {
                System.out.print("Enter phone: ");
                String p = sc.nextLine().trim();
                setPhone(p);
                break;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        while (true) {
            try {
                System.out.print("Enter email: ");
                String email = sc.nextLine().trim();
                setEmail(email);
                break;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        
        // Trả về chính đối tượng hiện tại
        return this; // Trả về đối tượng Candidate đã nhập
    }
}
