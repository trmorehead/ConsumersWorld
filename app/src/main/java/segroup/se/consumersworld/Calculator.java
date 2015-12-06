package segroup.se.consumersworld;

import java.util.HashMap;

/**
 * Calculates the rate
 * Created by tmore on 12/5/2015.
 */
public class Calculator {
    private String userStartCurrency;
    private String userTargetCurrency;
    private double userStartAmount;
    private double resultToUser;
    private HashMap currencyHashMap;

    /**
     *
     */
    public Calculator(){

    }

    /**
     *Creates a Hashmap from the text file
     * that is created using the Fetch class.
     */
    public void altCurrencyValue(){
        public static void main(String[] args) throws FileNotFoundException {
            Scanner scan1 = new Scanner(new FileReader("exchangerates.txt"));
            HashMap<String code, double rate> currencyHashMap = new HashMap<String, double >();
            while (scanner.hasNextLine()) {

                String[] columns = scanner.nextLine().split("\t\t");
                currencyHashMap.put(columns[0], columns. double.parseDouble(). [1]);
                )


            }

    /**
     * Retrieves a double value of world currency values
     * that are equal to 1 U.S. dollar from a Hashmap.
     * These values are  to be used in the convertCurrency method
     * @return double
     */
    public double getStartCurrencyValue()
    {
        return .2;
    }

    /**
     * Retrieves a double value of world currency values
     * that are equal to 1 U.S. dollar from a Hashmap.
     * These values are to be used in the convertCurrency method.
     * @return double
     */
    public double getAltCurrencyValue()
    {
        return .2;
    }

    /**
     * Uses a mathematical equation along with a Switch Case
     * to convert the value of the  UserStartCurrency to an equal
     * value of the UserTargetCurrency .
     * @return double
     */
    public double convertCurrency()
    {
        return .2;
    }

    /**
     * Converts the double value of convertCurrency method
     * to a string type that will be displayed in the
     * UserTargetCurrency textbox.
     * @return String
     */
    public String toString()
    {
        return "to string";
    }


}
