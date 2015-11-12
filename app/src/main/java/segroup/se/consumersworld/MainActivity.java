package segroup.se.consumersworld;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
//testing from trmorehead0
//first commit the changes to git then push the file to github.
//then others can sync and update their files without even closing AS.

public class MainActivity extends Activity implements AdapterView.OnItemSelectedListener, View.OnClickListener {

    public Button btnClick;


    /**
     * calls the activiy.xml file to display the page.
     * defines the buttons.
     * @param savedInstanceState bundle
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnClick = (Button) findViewById(R.id.button);
        btnClick.setOnClickListener(this);



    }

    //@Override
    //public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
       // getMenuInflater().inflate(R.menu.menu_main, menu);
       // return true;
   // }

   // @Override
   // public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
      //  int id = item.getItemId();

        //noinspection SimplifiableIfStatement
       // if (id == R.id.action_settings) {
         //   return true;
       // }

       // return super.onOptionsItemSelected(item);
   // }


    /**
     * Displays message when an Item from either spinner is selected
     * @param parent not sure what this does
     * @param view also not sure
     * @param position positioning
     * @param id id
     */

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
     * For when the currency button is selected
     * Page2 is the main currency converter page
     */
    public void btnClick1()
    {
        startActivity(new Intent(getApplicationContext(), Page2Activity.class));
    }

    /**
     * For when the goods button is clicked
     * page3 is the goods conversion page
     */
    public void btnClick2()
    {

    }

    /**
     * action to be taken when a button is clicked
     * @param v view
     */
    @Override
    public void onClick(View v) {

        switch(v.getId())
        {
            case R.id.button:
                btnClick1();
                break;

            case R.id.button2:
                btnClick2();
                break;
        }
    }
}

