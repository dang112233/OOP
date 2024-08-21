package hus.oop.countryarraymanager;

import java.util.Arrays;
import java.util.Comparator;

public class CountryArrayManager {
    private Country[] countries;
    private int length;

    public CountryArrayManager() {
        countries = new Country[1];
        this.length = 0;
    }

    public CountryArrayManager(int maxLength) {
        countries = new Country[maxLength];
        this.length = 0;
    }

    public int getLength() {
        return this.length;
    }

    public Country[] getCountries() {
        return this.countries;
    }

    private void correct() {
        int nullFirstIndex = 0;
        for (int i = 0; i < this.countries.length; i++) {
            if (this.countries[i] == null) {
                nullFirstIndex = i;
                break;
            }
        }

        if (nullFirstIndex > 0) {
            this.length = nullFirstIndex;
            for (int i = nullFirstIndex; i < this.countries.length; i++) {
                this.countries[i] = null;
            }
        }
    }

    private void allocateMore() {
        Country[] newArray = new Country[2 * this.countries.length];
        System.arraycopy(this.countries, 0, newArray, 0, this.countries.length);
        this.countries = newArray;
    }

    public void append(Country country) {
        if (this.length >= this.countries.length) {
            allocateMore();
        }

        this.countries[this.length] = country;
        this.length++;
    }

    public boolean add(Country country, int index) {
        if ((index < 0) || (index > this.countries.length)) {
            return false;
        }

        if (this.length >= this.countries.length) {
            allocateMore();
        }

        for (int i = this.length; i > index; i--) {
            this.countries[i] = this.countries[i-1];
        }

        this.countries[index] = country;
        this.length++;
        return true;
    }

    public boolean remove(int index) {
        if ((index < 0) || (index >= countries.length)) {
            return false;
        }

        for (int i = index; i < length - 1; i++) {
            this.countries[i] = this.countries[i + 1];
        }

        this.countries[this.length - 1] = null;
        this.length--;
        return true;
    }

    public Country countryAt(int index) {
        if ((index < 0) || (index >= this.length)) {
            return null;
        }

        return this.countries[index];
    }

    /**
     * Sort the countries in order of increasing population
     *  using selection sort algorithm.
     * @return array of increasing population countries.
     */
    public Country[] sortByIncreasingPopulation() {
        Country[] newArray = new Country[this.length];
        System.arraycopy(this.countries, 0, newArray, 0, this.length);
        Arrays.sort(newArray, Comparator.comparingInt(Country::getPopulation));
        return newArray;
    }

    /**
     * Sort the countries in order of decreasing population
     *  using selection sort algorithm.
     * @return array of decreasing population countries.
     */
    public Country[] sortByDecreasingPopulation() {
        Country[] newArray = new Country[this.length];
        System.arraycopy(this.countries, 0, newArray, 0, this.length);
        Arrays.sort(newArray, Comparator.comparingInt(Country::getPopulation).reversed());
        return newArray;
    }

    /**
     * Sort the countries in order of increasing area
     *  using bubble sort algorithm.
     * @return array of increasing area countries.
     */
    public Country[] sortByIncreasingArea() {
        Country[] newArray = new Country[this.length];
        System.arraycopy(this.countries, 0, newArray, 0, this.length);
        Arrays.sort(newArray, Comparator.comparingDouble(Country::getArea));
        return newArray;
    }

    /**
     * Sort the countries in order of decreasing area
     *  using bubble sort algorithm.
     * @return array of increasing area countries.
     */
    public Country[] sortByDecreasingArea() {
        Country[] newArray = new Country[this.length];
        System.arraycopy(this.countries, 0, newArray, 0, this.length);
        Arrays.sort(newArray, Comparator.comparingDouble(Country::getArea).reversed());
        return newArray;
    }

    /**
     * Sort the countries in order of increasing GDP
     *  using insertion sort algorithm.
     * @return array of increasing GDP countries.
     */
    public Country[] sortByIncreasingGdp() {
        Country[] newArray = new Country[this.length];
        System.arraycopy(this.countries, 0, newArray, 0, this.length);
        Arrays.sort(newArray, Comparator.comparingDouble(Country::getGdp));
        return newArray;
    }

    /**
     * Sort the countries in order of increasing GDP
     *  sing insertion sort algorithm.
     * @return array of increasing insertion countries.
     */
    public Country[] sortByDecreasingGdp() {
        Country[] newArray = new Country[this.length];
        System.arraycopy(this.countries, 0, newArray, 0, this.length);
        Arrays.sort(newArray, Comparator.comparingDouble(Country::getGdp).reversed());
        return newArray;
    }

    public AfricaCountry[] filterAfricaCountry() {
        int count = 0;
        for (Country country : this.countries) {
            if (country instanceof AfricaCountry) {
                count++;
            }
        }
        AfricaCountry[] africaCountries = new AfricaCountry[count];
        int index = 0;
        for (Country country : this.countries) {
            if (country instanceof AfricaCountry) {
                africaCountries[index++] = (AfricaCountry) country;
            }
        }
        return africaCountries;
    }

    public AsiaCountry[] filterAsiaCountry() {
        int count = 0;
        for (Country country : this.countries) {
            if (country instanceof AsiaCountry) {
                count++;
            }
        }
        AsiaCountry[] asiaCountries = new AsiaCountry[count];
        int index = 0;
        for (Country country : this.countries) {
            if (country instanceof AsiaCountry) {
                asiaCountries[index++] = (AsiaCountry) country;
            }
        }
        return asiaCountries;
    }

    public EuropeCountry[] filterEuropeCountry() {
        int count = 0;
        for (Country country : this.countries) {
            if (country instanceof EuropeCountry) {
                count++;
            }
        }
        EuropeCountry[] europeCountries = new EuropeCountry[count];
        int index = 0;
        for (Country country : this.countries) {
            if (country instanceof EuropeCountry) {
                europeCountries[index++] = (EuropeCountry) country;
            }
        }
        return europeCountries;
    }

    public NorthAmericaCountry filterNorthAmericaCountry() {
        for (Country country : this.countries) {
            if (country instanceof NorthAmericaCountry) {
                return (NorthAmericaCountry) country;
            }
        }
        return null;
    }

    public OceaniaCountry filterOceaniaCountry() {
        for (Country country : this.countries) {
            if (country instanceof OceaniaCountry) {
                return (OceaniaCountry) country;
            }
        }
        return null;
    }

    public SouthAmericaCountry filterSouthAmericaCountry() {
        for (Country country : this.countries) {
            if (country instanceof SouthAmericaCountry) {
                return (SouthAmericaCountry) country;
            }
        }
        return null;
    }

    public Country[] filterMostPopulousCountries(int howMany) {
        if (howMany <= 0) {
            return new Country[0];
        }

        Country[] sortedCountries = Arrays.copyOf(this.countries, this.length);
        Arrays.sort(sortedCountries, Comparator.comparingInt(Country::getPopulation).reversed());

        return Arrays.copyOf(sortedCountries, Math.min(howMany, this.length));
    }

    public Country[] filterLeastPopulousCountries(int howMany) {
        if (howMany <= 0) {
            return new Country[0];
        }

        Country[] sortedCountries = Arrays.copyOf(this.countries, this.length);
        Arrays.sort(sortedCountries, Comparator.comparingInt(Country::getPopulation));

        return Arrays.copyOf(sortedCountries, Math.min(howMany, this.length));
    }

    public Country[] filterLargestAreaCountries(int howMany) {
        if (howMany <= 0) {
            return new Country[0];
        }

        Country[] sortedCountries = Arrays.copyOf(this.countries, this.length);
        Arrays.sort(sortedCountries, Comparator.comparingDouble(Country::getArea).reversed());

        return Arrays.copyOf(sortedCountries, Math.min(howMany, this.length));
    }

    public Country[] filterSmallestAreaCountries(int howMany) {
        if (howMany <= 0) {
            return new Country[0];
        }

        Country[] sortedCountries = Arrays.copyOf(this.countries, this.length);
        Arrays.sort(sortedCountries, Comparator.comparingDouble(Country::getArea));

        return Arrays.copyOf(sortedCountries, Math.min(howMany, this.length));
    }

    public Country[] filterHighestGdpCountries(int howMany) {
        if (howMany <= 0) {
            return new Country[0];
        }

        Country[] sortedCountries = Arrays.copyOf(this.countries, this.length);
        Arrays.sort(sortedCountries, Comparator.comparingDouble(Country::getGdp).reversed());

        return Arrays.copyOf(sortedCountries, Math.min(howMany, this.length));

    }

    public Country[] filterLowestGdpCountries(int howMany) {
        if (howMany <= 0) {
            return new Country[0];
        }

        Country[] sortedCountries = Arrays.copyOf(this.countries, this.length);
        Arrays.sort(sortedCountries, Comparator.comparingDouble(Country::getGdp));

        return Arrays.copyOf(sortedCountries, Math.min(howMany, this.length));
    }

    public static String codeOfCountriesToString(Country[] countries) {
        StringBuilder codeOfCountries = new StringBuilder();
        codeOfCountries.append("[");
        for (int i = 0; i < countries.length; i++) {
            Country country = countries[i];
            if (country != null) {
                codeOfCountries.append(country.getCode())
                        .append(" ");
            }
        }

        return codeOfCountries.toString().trim() + "]";
    }

    public static void print(Country[] countries) {
        StringBuilder countriesString = new StringBuilder();
        countriesString.append("[");
        for (int i = 0; i < countries.length; i++) {
            Country country = countries[i];
            if (country != null) {
                countriesString.append(country.toString()).append("\n");
            }
        }
        System.out.print(countriesString.toString().trim() + "]");
    }
}
