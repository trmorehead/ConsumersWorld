package segroup.se.consumersworld;

import android.app.Activity;
import android.widget.EditText;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;
import java.util.Scanner;

/**
 * Calculates the rate
 * Created by tmore on 12/5/2015.
 */
public class Calculator extends Activity {
    private String userStartCurrency;
    private String userTargetCurrency;
    private Double userStartAmount;
    EditText rawTargetCurr;
    private double resultToUser;
    private HashMap<String, Double> currencyHashMap;

    /**
     *
     */
    public Calculator()
    {
        userStartCurrency = Page2Activity.fromCurrSpinner.getSelectedItem().toString();
        userTargetCurrency = Page2Activity.toCurrSpinner.getSelectedItem().toString();
        rawTargetCurr = (EditText) findViewById(R.id.FromCurrTextInput);
        String holder = rawTargetCurr.toString();
        userStartAmount = Double.valueOf(holder);
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
        double result;

        if(userStartCurrency=="USD")
        {
            result = userStartAmount*getAltCurrencyValue();
            return result;
        }
        else
        {
            currency1= currencyHashMap.get(userStartCurrency).doubleValue();
            currency1=currency1*userStartAmount;
            currency2=currencyHashMap.get(userTargetCurrency).doubleValue();
            resultToUser=currency1*currency2;
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
