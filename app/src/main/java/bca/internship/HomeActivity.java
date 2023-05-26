package bca.internship;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class HomeActivity extends AppCompatActivity {

    TextView name;
    SharedPreferences sp;

    Button logout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        sp = getSharedPreferences(ConstantData.PREF,MODE_PRIVATE);

        name = findViewById(R.id.home_name);

        //Bundle bundle = getIntent().getExtras();
        //name.setText("Welcome "+bundle.getString("NAME"));
        name.setText("Welcome "+sp.getString(ConstantData.NAME,""));

        logout = findViewById(R.id.home_logout);
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //sp.edit().remove(ConstantData.NAME).commit();
                sp.edit().clear().commit();
                new CommonMethod(HomeActivity.this,MainActivity.class);
            }
        });

    }

    @Override
    public void onBackPressed() {
        //super.onBackPressed();
        finishAffinity();
    }
}