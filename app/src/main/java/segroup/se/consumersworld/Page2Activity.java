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

public class Page2Activity extends Activity implements AdapterView.OnItemSelectedListener {

    Spinner fromCurrSpinner;
    Spinner toCurrSpinner;
    Button convert;
    EditText fromCurrInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page2);
        // Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);

        fromCurrSpinner = (Spinner) findViewById(R.id.fromCurrSpinner);//define spinner from content_page2.xml
        toCurrSpinner = (Spinner) findViewById(R.id.toCurrSpinner);
        ArrayAdapter adapter = ArrayAdapter.createFromResource(this, R.array.Currencies, android.R.layout.simple_spinner_dropdown_item);
        fromCurrSpinner.setAdapter(adapter);
        fromCurrSpinner.setOnItemSelectedListener(this);
        toCurrSpinner.setAdapter(adapter);
        toCurrSpinner.setOnItemSelectedListener(this);
        convert = (Button) findViewById(R.id.button3);
        fromCurrInput = (EditText) findViewById(R.id.FromCurrTextInput);
        fromCurrInput.setTextColor(Color.parseColor("#FFFFFF"));

    }

    protected void onClick(View v) {
        Snackbar.make(v, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show();

    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

        TextView myText = (TextView) view;
        ((TextView) parent.getChildAt(0)).setTextColor(Color.WHITE);
        Toast.makeText(this, "You Selected " + myText.getText(), Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    /**
     *
     */
    public String getFromCurrSpinner()
    {
        return fromCurrSpinner.getSelectedItem().toString();
    }

}