package segroup.se.consumersworld;

import android.app.Activity;
import android.widget.EditText;
import android.widget.Spinner;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;
import java.util.Scanner;

/**
 * Calculates the rate
 * @author Kendall Free, Christiana Tucker, Kunle Akinfeleye, Amanda Ambrose, Thomas Morehead
 * on 12/5/2015.
 * @version 1.0
 */
public class Calculator extends Activity {
    private String userStartCurrency;
    private String userTargetCurrency;
    private Double userStartAmount;
    EditText rawTargetCurr;
    private HashMap<String, Double> currencyHashMap;

    /**
     * Constructor
     */
    public Calculator() throws FileNotFoundException {
        //link to xml components
        Spinner fromCurrSpinner = (Spinner) findViewById(R.id.fromCurrSpinner);
        Spinner toCurrSpinner = (Spinner) findViewById(R.id.toCurrSpinner);
        userStartCurrency = fromCurrSpinner.getSelectedItem().toString();
        userTargetCurrency = toCurrSpinner.getSelectedItem().toString();

        //turn the from currency input into a Double
        rawTargetCurr = (EditText) findViewById(R.id.FromCurrTextInput);
        String holder = rawTargetCurr.toString();
        userStartAmount = Double.valueOf(holder);

        altCurrencyValue();
    }

    /**
     *Creates a Hashmap from the text file
     * that is created using the Fetch class.
     */
        public void altCurrencyValue() throws FileNotFoundException {
            Scanner scan1 = new Scanner(new FileReader("exchangerates.txt"));
             currencyHashMap = new HashMap<String, Double>();
            while (scan1.hasNextLine()) {

                String[] columns = scan1.nextLine().split("\t\t");

                currencyHashMap.put(columns[0], Double.valueOf(columns[1]));

            }
        }

    /**
     * Retrieves a double value of world currency values
     * that are equal to 1 U.S. dollar from a Hashmap.
     * These values are to be used in the convertCurrency method.
     * @return double
     */
    public double getAltCurrencyValue()
    {
        return currencyHashMap.get(userTargetCurrency).doubleValue();
    }

    /**
     * Uses a mathematical equation along with a Switch Case
     * to convert the value of the  UserStartCurrency to an equal
     * value of the UserTargetCurrency .
     * @return double
     */
    public double convertCurrency()
    {
        double currency1;
        double currency2;
        double resultToUser;

        if(userStartCurrency=="USD")
        {
            resultToUser = userStartAmount*getAltCurrencyValue();
            return resultToUser;
        }
        else
        {
            currency1= currencyHashMap.get(userStartCurrency).doubleValue();
            currency1=currency1*userStartAmount;
            currency2=currencyHashMap.get(userTargetCurrency).doubleValue();
            resultToUser = currency1*currency2;
            return resultToUser;
        }
    }

    /**
     * Converts the double value of convertCurrency method
     * to a string type that will be displayed in the
     * UserTargetCurrency textbox.
     * @return String
     */

    public String toString()
    {
        return "" + convertCurrency();
    }


}
