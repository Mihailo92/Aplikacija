package androidvezba.ac.aplikacija;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;



public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText unesiBrIgraca = (EditText)findViewById(R.id.unesiBrojIgraca);

        findViewById(R.id.buttonUnos).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //
                Intent i = new Intent(MainActivity.this, IgraActivity.class);

                Bundle extra = new Bundle();

                int brojIgraca = Integer.parseInt(unesiBrIgraca.getText().toString());

                extra.putInt("brojIgracaZaRadioButton", brojIgraca);

                i.putExtras(extra);
                startActivity(i);

            }
        });
    }
}
