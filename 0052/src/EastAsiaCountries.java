public class EastAsiaCountries {
    protected String countryCode;
    protected String countryName;
    protected double countryArea;

    public EastAsiaCountries() {
    }

    public EastAsiaCountries(String countryCode, String countryName, double countryArea) throws Exception {
        setCountryCode(countryCode);
        setCountryName(countryName);
        setCountryArea(countryArea);
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) throws Exception{
        if (countryCode == null || countryCode.trim().isEmpty()) {
            throw new Exception("Country code cannot be null or empty.");
        }
        this.countryCode = countryCode;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName)  throws Exception{
        if (countryName == null || countryName.trim().isEmpty()) {
            throw new Exception("Country name cannot be null or empty.");
        }
        this.countryName = countryName;
    }

    public double getCountryArea() {
        return countryArea;
    }

    public void setCountryArea(double countryArea)  throws Exception{
        if (countryArea <= 0) {
            throw new Exception("Country area must be greater than 0.");
        }
        this.countryArea = countryArea;
    }

    // Example display method - you can customize this as needed
    public void display() {
        System.out.println("Country Code: " + countryCode);
        System.out.println("Country Name: " + countryName);
        System.out.println("Country Area: " + countryArea + " km²");
    }
}
