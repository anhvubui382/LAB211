public class Account {
    private String username;
    private String password;
    private String name;
    private String phone;
    private String email;
    private String address;
    private String dateOfBirth;

    public Account() {
    }

    public Account(String username, String password, String name, String phone, String email, String address, String dateOfBirth) throws Exception {
        setUsername(username);
        setPassword(password);
        setName(name);
        setPhone(phone);
        setEmail(email);
        setAddress(address);
        setDateOfBirth(dateOfBirth);
    }

    public String getUsername() throws Exception {
        if (username == null || username.trim().isEmpty()) {
            throw new Exception("Username cannot be null or empty.");
        }
        return username;
    }

    public void setUsername(String username) throws Exception {
        if (username == null || username.trim().isEmpty()) {
            throw new Exception("Username cannot be null or empty.");
        }
        this.username = username;
    }

    public String getPassword() throws Exception {
        if (password == null || password.trim().isEmpty()) {
            throw new Exception("Password cannot be null or empty.");
        }
        return password;
    }

    public void setPassword(String password) throws Exception {
        if (password == null || password.trim().isEmpty()) {
            throw new Exception("Password cannot be null or empty.");
        }
        this.password = password;
    }

    public String getName() throws Exception {
        if (name == null || name.trim().isEmpty()) {
            throw new Exception("Name cannot be null or empty.");
        }
        return name;
    }

    public void setName(String name) throws Exception {
        if (name == null || name.trim().isEmpty()) {
            throw new Exception("Name cannot be null or empty.");
        }
        this.name = name;
    }

    public String getPhone() throws Exception {
        if (phone == null || phone.trim().isEmpty()) {
            throw new Exception("Phone number cannot be null or empty.");
        }
        return phone;
    }

    public void setPhone(String phone) throws Exception {
        if (phone == null || phone.trim().isEmpty()) {
            throw new Exception("Phone number cannot be null or empty.");
        }
        this.phone = phone;
    }

    public String getEmail() throws Exception {
        if (email == null || email.trim().isEmpty()) {
            throw new Exception("Email cannot be null or empty.");
        }
        return email;
    }

    public void setEmail(String email) throws Exception {
        if (email == null || email.trim().isEmpty()) {
            throw new Exception("Email cannot be null or empty.");
        }
        this.email = email;
    }

    public String getAddress() throws Exception {
        if (address == null || address.trim().isEmpty()) {
            throw new Exception("Address cannot be null or empty.");
        }
        return address;
    }

    public void setAddress(String address) throws Exception {
        if (address == null || address.trim().isEmpty()) {
            throw new Exception("Address cannot be null or empty.");
        }
        this.address = address;
    }

    public String getDateOfBirth() throws Exception {
        if (dateOfBirth == null || dateOfBirth.trim().isEmpty()) {
            throw new Exception("Date of birth cannot be null or empty.");
        }
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) throws Exception {
        if (dateOfBirth == null || dateOfBirth.trim().isEmpty()) {
            throw new Exception("Date of birth cannot be null or empty.");
        }
        this.dateOfBirth = dateOfBirth;
    }
}
