/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author anhvu
 */
public class Country extends EastAsiaCountries implements Comparable<Country> {

    private String countryTerrain;

    public Country() {
    }

    public Country(String countryTerrain, String countryCode,
            String countryName, double countryArea) throws Exception {
        super(countryCode, countryName, countryArea);
        setCountryArea(countryArea);
        setCountryName(countryName);
        setCountryCode(countryCode);
        setCountryTerrain(countryTerrain);
    }

    @Override
    public void display() {
        System.out.printf("%-10s%-25s%-20.0f%-25s\n", this.countryCode,
                this.countryName, this.countryArea, this.countryTerrain);
    }

    public String getCountryTerrain() throws Exception{
          if (countryTerrain == null || countryTerrain.trim().isEmpty()) {
            throw new Exception("CountryTerrain name cannot be null or empty.");
        }
        return countryTerrain;
    }

    public void setCountryTerrain(String countryTerrain) {
        this.countryTerrain = countryTerrain;
    }

    @Override
    public int compareTo(Country t) {
        return this.getCountryName().compareTo(t.getCountryName());
    }

}
