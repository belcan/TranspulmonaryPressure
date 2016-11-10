package com.pressure.nick.transpulmonarypressure;

import android.os.Bundle;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;


public class MainActivity extends AppCompatActivity {
public void calculateResults(View view){

    Toast.makeText(getApplicationContext(),"Hey U of A Hospital RTs, you rock!",Toast.LENGTH_LONG).show();

    final EditText Pplat = (EditText)findViewById(R.id.num1);
    final EditText PesIns = (EditText)findViewById(R.id.num2);
    final EditText PEEP = (EditText)findViewById(R.id.num3);
    final EditText PesExp = (EditText)findViewById(R.id.num4);

    Double PlatoPressValue = Double.parseDouble(Pplat.getText().toString());
    Double PesInsPressValue = Double.parseDouble(PesIns.getText().toString());
    Double PEEPPressValue = Double.parseDouble(PEEP.getText().toString());
    Double PesExpPressValue = Double.parseDouble(PesExp.getText().toString());

    Double PtpInspValue = PlatoPressValue - PesInsPressValue * 1.36;
    Double PtpExpValue = PEEPPressValue - PesExpPressValue * 1.36;
    Double DeltaPressValue = PtpInspValue - PtpExpValue;

    final TextView PtpInspDisplay = (TextView)findViewById(R.id.PtpInspID);
   final TextView PtpExpDisplay = (TextView)findViewById(R.id.PtpExpID);
    final TextView DeltaPressDisplay = (TextView)findViewById(R.id.DeltaPID);

    DecimalFormat percentageFormat = new DecimalFormat("00.0");
    String PtpInspValue1 = percentageFormat.format(PtpInspValue);
    PtpInspValue = Double.parseDouble(PtpInspValue1);

    String PtpExpValue1 = percentageFormat.format(PtpExpValue);
    PtpExpValue = Double.parseDouble(PtpExpValue1);

    String DeltaPressValue1 = percentageFormat.format(DeltaPressValue);
    DeltaPressValue = Double.parseDouble(DeltaPressValue1);


    PtpInspDisplay.setText(Double.toString(PtpInspValue));
    PtpExpDisplay.setText(Double.toString(PtpExpValue));
    DeltaPressDisplay.setText(Double.toString(DeltaPressValue));

    Button resetButton = (Button) findViewById(R.id.resetID);
    resetButton.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Pplat.setText(""); // reset the EditText
            PesIns.setText(""); // reset the EditText
            PtpInspDisplay.setText(""); // reset the Textview
            PEEP.setText(""); // reset the EditText
            PesExp.setText(""); // reset the EditText
            PtpExpDisplay.setText("");
            DeltaPressDisplay.setText("");
        }
    });

}
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);



            }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
