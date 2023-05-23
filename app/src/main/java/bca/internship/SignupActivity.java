package bca.internship;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class SignupActivity extends AppCompatActivity {

    EditText name,email,contact,password,confirmPassword,dateOfBirth;
    RadioGroup gender;
    RadioButton male,female;
    Spinner spinner;
    Button signup;
    String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";

    Calendar calendar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        //new CommonMethod(SignupActivity.this, "Login Successfully");

        name = findViewById(R.id.signup_name);
        email = findViewById(R.id.signup_email);
        contact = findViewById(R.id.signup_contact);
        password = findViewById(R.id.signup_password);
        confirmPassword = findViewById(R.id.signup_confirm_password);
        dateOfBirth = findViewById(R.id.signup_date_of_birth);

        calendar = Calendar.getInstance();

        DatePickerDialog.OnDateSetListener dateClick = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                calendar.set(Calendar.YEAR,i);
                calendar.set(Calendar.MONTH,i1);
                calendar.set(Calendar.DAY_OF_MONTH,i2);

                SimpleDateFormat simpleFormat = new SimpleDateFormat("dd-MM-yyyy", Locale.getDefault());
                dateOfBirth.setText(simpleFormat.format(calendar.getTime()));
            }
        };

        dateOfBirth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatePickerDialog pickerDialog = new DatePickerDialog(SignupActivity.this,dateClick,calendar.get(Calendar.YEAR),calendar.get(Calendar.MONTH),calendar.get(Calendar.DAY_OF_MONTH));
                pickerDialog.getDatePicker().setMaxDate(System.currentTimeMillis());
                pickerDialog.show();
            }
        });

        male = findViewById(R.id.signup_male);
        female = findViewById(R.id.signup_female);
        gender = findViewById(R.id.signup_gender);

        /*male.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new CommonMethod(SignupActivity.this,male.getText().toString());
            }
        });

        female.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new CommonMethod(SignupActivity.this,female.getText().toString());
            }
        });*/

        gender.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                RadioButton radioButton = findViewById(i);
                new CommonMethod(SignupActivity.this,radioButton.getText().toString());
            }
        });

        spinner = findViewById(R.id.signup_spinner);
        signup = findViewById(R.id.signup_button);

        name.setText("Test");
        email.setText("test@gmail.com");
        contact.setText("9090901231");
        password.setText("123123");
        confirmPassword.setText("123123");
        dateOfBirth.setText("23-05-2023");

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(name.getText().toString().trim().equals("")){
                    name.setError("Name Required");
                }
                else if(email.getText().toString().trim().equals("")){
                    email.setError("Email Id Required");
                }
                else if(!email.getText().toString().matches(emailPattern)){
                    email.setError("Valid Email Id Required");
                }
                else if(contact.getText().toString().trim().equals("")){
                    contact.setError("Contact No. Required");
                }
                else if(contact.getText().toString().length()<10){
                    contact.setError("Valid Contact No. Required");
                }
                else if(password.getText().toString().trim().equals("")){
                    password.setError("Password Required");
                }
                else if(password.getText().toString().length()<6){
                    password.setError("Min. 6 Character Password Required");
                }
                else if(confirmPassword.getText().toString().trim().equals("")){
                    confirmPassword.setError("Confirm Password Required");
                }
                else if(confirmPassword.getText().toString().length()<6){
                    confirmPassword.setError("Min. 6 Character Confirm Password Required");
                }
                else if(!confirmPassword.getText().toString().matches(password.getText().toString())){
                    confirmPassword.setError("Confirm Password Does Not Match");
                }
                else if(dateOfBirth.getText().toString().trim().equals("")){
                    //dateOfBirth.setError("Please Select Date Of Birth");
                    new CommonMethod(SignupActivity.this,"Please Select Date Of Birth");
                }
                else if(gender.getCheckedRadioButtonId() == -1){
                    new CommonMethod(SignupActivity.this,"Please Select Gender");
                }
                else{
                    new CommonMethod(SignupActivity.this,"Signup Successfully");
                }
            }
        });

    }
}