package fr.eni.coursvisio;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;

public class ConfigurationActivity extends AppCompatActivity {

    public static final String FILE = "config";
    public static final String CLE_TRI = "tri";
    public static final String CLE_PRIX = "prix";

    private Switch switchTri;
    private EditText edPrix;

    SharedPreferences shPref;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_configuration);

        shPref  = getSharedPreferences(FILE, MODE_PRIVATE);

        switchTri = findViewById(R.id.switchTri);
        edPrix = findViewById(R.id.etPrix);

        Boolean tri = shPref.getBoolean(CLE_TRI, false);
        String prixDef = shPref.getString(CLE_PRIX, "1");

        edPrix.setText(prixDef);
        switchTri.setChecked(tri);

        switchTri.setOnClickListener(new onClickTri());
        edPrix.setOnKeyListener(new onClickPrix());

        //ou
//        switchTri.setOnClickListener(v -> {
//            SharedPreferences.Editor editor = shPref.edit();
//            editor.putBoolean(CLE_TRI, switchTri.isChecked());
//            editor.apply();
//        });
    }

    public class onClickTri implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            SharedPreferences.Editor editor = shPref.edit();
            editor.putBoolean(CLE_TRI, switchTri.isChecked());
            editor.apply();
        }
    }

    public class onClickPrix implements View.OnKeyListener {
        @Override
        public boolean onKey(View v, int keyCode, android.view.KeyEvent event) {
            SharedPreferences.Editor editor = shPref.edit();
            editor.putString(CLE_PRIX, edPrix.getText().toString());
            editor.apply();
            return false;
        }
    }
}