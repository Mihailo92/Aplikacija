package androidvezba.ac.aplikacija;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class PoeniIgraca extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_igracpoeni);

        Bundle extra = getIntent().getExtras();

        int brojIgracaZaPrikaz = extra.getInt("brojIgracaZaPrikaz");

        String PrikazPoeniZaTimJedan = "Prikaz poena za tim jedan: " + "\n";


        int [] z = new int[brojIgracaZaPrikaz];
        int e = 1;
        for(int i = 0; i<brojIgracaZaPrikaz; i++){
            String s = String.valueOf(i);

            z[i] = extra.getInt("timJedanIgrac" + s);

            PrikazPoeniZaTimJedan += "Igrac " + e + ": " + z[i] + "\n";

            e = e + 1;
        }


        String PrikazPoeniZaTimDva = "Prikaz poena za tim dva: " + "\n";
        int [] r = new int[brojIgracaZaPrikaz];
        int t = 1;
        for(int i = 0; i<brojIgracaZaPrikaz; i++){
            String s = String.valueOf(i);

            r[i] = extra.getInt("timDvaIgrac" + s);

            PrikazPoeniZaTimDva += "Igrac " + t + ": " + r[i] + "\n";

            t = t + 1;
        }

        ((TextView) findViewById(R.id.labelTimJedan)).setText(PrikazPoeniZaTimJedan);
        ((TextView) findViewById(R.id.labelTimDva)).setText(PrikazPoeniZaTimDva);
    }

}
