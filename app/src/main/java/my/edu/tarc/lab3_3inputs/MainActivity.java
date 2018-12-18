package my.edu.tarc.lab3_3inputs;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    private Spinner spinnerAge;
    private RadioGroup radiogGroupGender;
    private RadioButton radioButtonMale, radioButtonFemale;
    private CheckBox checkBoxSmoker;
    private TextView textViewPremium;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spinnerAge = findViewById(R.id.spinnerAge);
        radiogGroupGender = findViewById(R.id.radioGroupGender);
        radioButtonMale = findViewById(R.id.radioButtonMale);
        radioButtonFemale = findViewById(R.id.radioButtonFemale);
        checkBoxSmoker = findViewById((R.id.checkBoxSmoker));
        textViewPremium = findViewById(R.id.textViewPremium);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.age_group,android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinnerAge.setAdapter(adapter);

        spinnerAge.setOnItemSelectedListener(this);

        Button buttonOne = (Button) findViewById(R.id.button);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(this,"Position="+position, Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    public void calculatePremium(View view){
        float premium = 0;
        int ageGroup;
        ageGroup = spinnerAge.getSelectedItemPosition();
        if(ageGroup == 0){
            premium = 50;
        }else if(ageGroup == 1){
            premium = 55;
        }else if(ageGroup == 2){
            premium = 60;
        }else if(ageGroup == 3){
            premium = 70;
        }else if(ageGroup == 4){
            premium = 90;
        }else if(ageGroup == 5){
            premium = 120;
        }else if(ageGroup == 6){
            premium = 150;
        }else if(ageGroup == 7){
            premium = 150;
        }
        int gender = radiogGroupGender.getCheckedRadioButtonId();
        float extraMale = 0;
        if(gender == R.id.radioButtonMale){
            //TODO Calculate extra premium for male

            if(ageGroup == 3){
                extraMale = 50;
            }else if(ageGroup == 4){
                extraMale = 100;
            }else if(ageGroup == 5){
                extraMale = 150;
            }else if(ageGroup == 6){
                extraMale = 200;
            }else if(ageGroup == 7){
                extraMale = 200;
            }
        }
        float extraSmoker = 0;
        if(checkBoxSmoker.isChecked()){
            //TODO Calculate extra premium for smoker
            if(ageGroup == 3){
                extraSmoker = 100;
            }else if(ageGroup == 4){
                extraSmoker = 150;
            }else if(ageGroup == 5){
                extraSmoker = 200;
            }else if(ageGroup == 6){
                extraSmoker = 250;
            }else if(ageGroup == 7){
                extraSmoker = 300;
            }
        }
        float totalPremium = premium +extraMale+extraSmoker;

        textViewPremium.setText(getString(R.string.premium)+ "=" +totalPremium);
    }

    public void reset(View view){
        spinnerAge.setSelection(0);
        radiogGroupGender.clearCheck();
        checkBoxSmoker.setChecked(false);
        textViewPremium.setText(getString(R.string.premium));
    }
}















