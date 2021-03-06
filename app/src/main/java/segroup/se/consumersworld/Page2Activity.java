package segroup.se.consumersworld;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.io.FileNotFoundException;

public class Page2Activity extends Activity implements AdapterView.OnItemSelectedListener {

    Spinner fromCurrSpinner;
    Spinner toCurrSpinner;
    Button convert;
    EditText fromCurrInput;
    TextView convertedCurr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page2);
        // Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);

        //Attaching appropriate xml components to java and setting some attributes
        fromCurrSpinner = (Spinner) findViewById(R.id.fromCurrSpinner);
        toCurrSpinner = (Spinner) findViewById(R.id.toCurrSpinner);
        ArrayAdapter adapter = ArrayAdapter.createFromResource(this, R.array.Currencies, android.R.layout.simple_spinner_dropdown_item);
        fromCurrSpinner.setAdapter(adapter);
        fromCurrSpinner.setOnItemSelectedListener(this);
        toCurrSpinner.setAdapter(adapter);
        toCurrSpinner.setOnItemSelectedListener(this);
        //convert = (Button) findViewById(R.id.button3);
       // convert.setOnClickListener((View.OnClickListener) this);
        fromCurrInput = (EditText) findViewById(R.id.FromCurrTextInput);
        fromCurrInput.setTextColor(Color.parseColor("#FFFFFF"));
        convertedCurr = (TextView) findViewById(R.id.convertedCurrAutoUpdateText);

    }

    /**
     * assign functionality of buttons
     * @param v
     */
    protected void onClick(View v) throws FileNotFoundException {
        Snackbar.make(v, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show();

        switch(v.getId())
        {
            case R.id.button3:
                convert();
                break;
        }


    }


    /**
     * Create toast and set text color to white.
     * Toast is a little message that pops up when the user selects a coutry from the spinners
     * @param parent
     * @param view
     * @param position
     * @param id
     */
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        //create toast message that appears when user selects country from spinner.
        TextView myText = (TextView) view;
        ((TextView) parent.getChildAt(0)).setTextColor(Color.WHITE);
        Toast.makeText(this, "You Selected " + myText.getText(), Toast.LENGTH_SHORT).show();

    }

    /**
     *
     * @param parent
     */
    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    /**
     * Call the convert method in the calculator class so it can be returned to user.
     */
    public void convert() throws FileNotFoundException {

        Calculator converterOfCurrency = new Calculator();//get a calculator converter
        converterOfCurrency.convertCurrency();//run convertCurrency method from Calculator

        //print the converted currency as a string to TextView convertedCurrAutoUpdateText for user
        convertedCurr.setText(converterOfCurrency.toString());

    }

}