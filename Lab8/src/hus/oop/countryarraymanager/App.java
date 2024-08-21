package hus.oop.countryarraymanager;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;

public class App {
    private static final String COMMA_DELIMITER = ",";
    private static final CountryArrayManager countryManager = new CountryArrayManager();

    public static void main(String[] args) {
        init();

        testOriginalData();
        testSortIncreasingByPopulation();
        testSortDecreasingByPopulation();
        testSortIncreasingByArea();
        testSortDecreasingByArea();
        testSortIncreasingByGdp();
        testSortDecreasingByGdp();
        testFilterAfricaCountry();
        testFilterAsiaCountry();
        testFilterEuropeCountry();
        testFilterNorthAmericaCountry();
        testFilterOceaniaCountry();
        testFilterSouthAmericaCountry();
        testFilterMostPopulousCountries();
        testFilterLeastPopulousCountries();
        testFilterLargestAreaCountries();
        testFilterSmallestAreaCountries();
        testFilterHighestGdpCountries();
        testFilterLowestGdpCountries();
        /* TODO: write code to test program */
    }

    public static void readListData(String filePath) {
        BufferedReader dataReader = null;
        try {
            dataReader = new BufferedReader(new FileReader(filePath));

            // Read file in java line by line.
            String line;
            while ((line = dataReader.readLine()) != null) {
                List<String> dataList = parseDataLineToList(line);

                if (dataList.get(0).equals("code")) {
                    continue;
                }

                if (dataList.size() != 6) {
                    continue;
                }

                /*
                 * TODO: create Country and append countries into
                 * CountryArrayManager here.
                 */
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (dataReader != null) {
                    dataReader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static List<String> parseDataLineToList(String dataLine) {
        List<String> result = new ArrayList<>();
        if (dataLine != null) {
            String[] splitData = dataLine.split(COMMA_DELIMITER);
            for (int i = 0; i < splitData.length; i++) {
                result.add(splitData[i]);
            }
        }

        return result;
    }

    public static String[] parseDataLineToArray(String dataLine) {
        if (dataLine == null) {
            return null;
        }

        return dataLine.split(COMMA_DELIMITER);
    }

    public static void init() {
        String filePath = "data/countries.csv";
        readListData(filePath);
    }

    public static void testOriginalData() {
        String codesString = CountryArrayManager.codeOfCountriesToString(countryManager.getCountries());
        System.out.print(codesString);
    }

    public static void testSortIncreasingByPopulation() {
        Country[] countries = countryManager.sortByIncreasingPopulation();
        String codesString = CountryArrayManager.codeOfCountriesToString(countries);
        System.out.print(codesString);
    }

    public static void testSortDecreasingByPopulation() {
        Country[] countries = countryManager.sortByDecreasingPopulation();
        String codesString = CountryArrayManager.codeOfCountriesToString(countries);
        System.out.print(codesString);
    }

    public static void testSortIncreasingByArea() {
        Country[] countries = countryManager.sortByIncreasingArea();
        String codesString = CountryArrayManager.codeOfCountriesToString(countries);
        System.out.print(codesString);
    }

    public static void testSortDecreasingByArea() {
        Country[] countries = countryManager.sortByDecreasingArea();
        String codesString = CountryArrayManager.codeOfCountriesToString(countries);
        System.out.print(codesString);
    }

    public static void testSortIncreasingByGdp() {
        Country[] countries = countryManager.sortByIncreasingGdp();
        String codesString = CountryArrayManager.codeOfCountriesToString(countries);
        System.out.print(codesString);
    }

    public static void testSortDecreasingByGdp() {
        Country[] countries = countryManager.sortByDecreasingGdp();
        String codesString = CountryArrayManager.codeOfCountriesToString(countries);
        System.out.print(codesString);
    }

    public static void testFilterAfricaCountry() {
        AfricaCountry[] africaCountries = countryManager.filterAfricaCountry();
        String codesString = CountryArrayManager.codeOfCountriesToString(africaCountries);
        System.out.print(codesString);
    }

    public static void testFilterAsiaCountry() {
        AsiaCountry[] asiaCountries = countryManager.filterAsiaCountry();
        String codesString = CountryArrayManager.codeOfCountriesToString(asiaCountries);
        System.out.print(codesString);
    }

    public static void testFilterEuropeCountry() {
        EuropeCountry[] europeCountries = countryManager.filterEuropeCountry();
        String codesString = CountryArrayManager.codeOfCountriesToString(europeCountries);
        System.out.print(codesString);
    }

    public static void testFilterNorthAmericaCountry() {
        NorthAmericaCountry northAmericaCountry = countryManager.filterNorthAmericaCountry();
        if (northAmericaCountry != null) {
            System.out.print(northAmericaCountry.toString());
        }
    }

    public static void testFilterOceaniaCountry() {
        OceaniaCountry oceaniaCountry = countryManager.filterOceaniaCountry();
        if (oceaniaCountry != null) {
            System.out.print(oceaniaCountry.toString());
        }
    }

    public static void testFilterSouthAmericaCountry() {
        SouthAmericaCountry southAmericaCountry = countryManager.filterSouthAmericaCountry();
        if (southAmericaCountry != null) {
            System.out.print(southAmericaCountry.toString());
        }
    }

    public static void testFilterMostPopulousCountries() {
        int howMany = 5;
        Country[] mostPopulousCountries = countryManager.filterMostPopulousCountries(howMany);
        String codesString = CountryArrayManager.codeOfCountriesToString(mostPopulousCountries);
        System.out.print(codesString);
    }

    public static void testFilterLeastPopulousCountries() {
        int howMany = 5;
        Country[] leastPopulousCountries = countryManager.filterLeastPopulousCountries(howMany);
        String codesString = CountryArrayManager.codeOfCountriesToString(leastPopulousCountries);
        System.out.print(codesString);
    }

    public static void testFilterLargestAreaCountries() {
        int howMany = 5;
        Country[] largestAreaCountries = countryManager.filterLargestAreaCountries(howMany);
        String codesString = CountryArrayManager.codeOfCountriesToString(largestAreaCountries);
        System.out.print(codesString);
    }

    public static void testFilterSmallestAreaCountries() {
        int howMany = 5;
        Country[] smallestAreaCountries = countryManager.filterSmallestAreaCountries(howMany);
        String codesString = CountryArrayManager.codeOfCountriesToString(smallestAreaCountries);
        System.out.print(codesString);
    }

    public static void testFilterHighestGdpCountries() {
        int howMany = 5;
        Country[] highestGdpCountries = countryManager.filterHighestGdpCountries(howMany);
        String codesString = CountryArrayManager.codeOfCountriesToString(highestGdpCountries);
        System.out.print(codesString);
    }

    public static void testFilterLowestGdpCountries() {
        int howMany = 5;
        Country[] lowestGdpCountries = countryManager.filterLowestGdpCountries(howMany);
        String codesString = CountryArrayManager.codeOfCountriesToString(lowestGdpCountries);
        System.out.print(codesString);
    }
}
