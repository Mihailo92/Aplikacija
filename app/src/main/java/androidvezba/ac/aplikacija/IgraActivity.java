package androidvezba.ac.aplikacija;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.ViewCompat;



public class IgraActivity extends AppCompatActivity implements View.OnClickListener{
    TextView timJedanIgracPoeni;
    TextView timDvaIgracPoeni;
    TextView prikazTeksta;

    TextView timJedanPoeni;
    TextView timDvaPoeni;

    Igrac igrac;

    int brojIgraca;
    int trenutniCekiraniTim1;
    int trenutniCekiraniTim2;

    RadioGroup radioTim1;
    RadioGroup radioTim2;

    int trenutniTim = 0;
    int trenutniIgrac = 0;

    Button poeniZaDva;
    Button poeniZaDvaPokusaj;

    Button poeniZaTri;
    Button poeniZaTriPokusaj;

    Button poeniZaSlobodnoBacanje;
    Button slobodnoBacanjePokusaj;

    Button ofanzivniSkok;
    Button defanzivniSkok;

    Button ukradenaLopta;

    Button asistencija;

    Button faul;

    Button blokada;

    Igrac[] tim1 = null;
    Igrac[] tim2 = null;

    int index;
    RadioButton rdbtn1;
    RadioButton rdbtn2;

    int TimJedanPoeni;
    int TimDvaPoeni;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_igra);

        Bundle extra = getIntent().getExtras();

        Integer brojRadioButton = extra.getInt("brojIgracaZaRadioButton");
        brojIgraca = brojRadioButton;

        poeniZaDva = findViewById(R.id.dvaPoena);
        poeniZaDva.setOnClickListener(this);
        poeniZaDvaPokusaj = findViewById(R.id.dvaPoenaPokusaj);
        poeniZaDvaPokusaj.setOnClickListener(this);

        poeniZaTri = findViewById(R.id.triPoena);
        poeniZaTri.setOnClickListener(this);
        poeniZaTriPokusaj = findViewById(R.id.triPoenaPokusaj);
        poeniZaTriPokusaj.setOnClickListener(this);

        poeniZaSlobodnoBacanje = findViewById(R.id.slobodnoBacanje);
        poeniZaSlobodnoBacanje.setOnClickListener(this);
        slobodnoBacanjePokusaj = findViewById(R.id.slobodnoBacanjePokusaj);
        slobodnoBacanjePokusaj.setOnClickListener(this);

        ofanzivniSkok = findViewById(R.id.ofanzivniSkokovi);
        ofanzivniSkok.setOnClickListener(this);

        defanzivniSkok = findViewById(R.id.defanzivniSkokovi);
        defanzivniSkok.setOnClickListener(this);

        ukradenaLopta = findViewById(R.id.ukradene);
        ukradenaLopta.setOnClickListener(this);

        asistencija = findViewById(R.id.asistencije);
        asistencija.setOnClickListener(this);

        faul = findViewById(R.id.faulovi);
        faul.setOnClickListener(this);

        blokada = findViewById(R.id.blok);
        blokada.setOnClickListener(this);


        addRadioButtons(brojIgraca);

        init();
        Rad();
        sacuvajPodatke();


    }

    public void init(){
        tim1 = new Igrac[brojIgraca];
        for (int i = 0; i < brojIgraca; i++){
            tim1[i] = new Igrac();
        }

        tim2 = new Igrac[brojIgraca];
        for (int i = 0; i < brojIgraca; i++){
            tim2[i] = new Igrac();
        }


    }



    public void addRadioButtons(int number){
        for (int row = 0; row < 1; row++) {
            radioTim1 = new RadioGroup(this);
            radioTim1.setOrientation(LinearLayout.VERTICAL);

            for (int i = 1; i <= number; i++) {
                rdbtn1 = new RadioButton(this);

                rdbtn1.setId(ViewCompat.generateViewId());
                rdbtn1.setText("Radio" + rdbtn1.getId());
                radioTim1.addView(rdbtn1);
            }
            ((ViewGroup) findViewById(R.id.timJedan)).addView(radioTim1);
        }
        for (int row = 0; row < 1; row++) {
            radioTim2 = new RadioGroup(this);
            radioTim2.setOrientation(LinearLayout.VERTICAL);

            for (int i = 1; i <= number; i++) {
                rdbtn2 = new RadioButton(this);

                rdbtn2.setId(ViewCompat.generateViewId());
                rdbtn2.setText("Radio" + rdbtn2.getId());
                radioTim2.addView(rdbtn2);
            }
            ((ViewGroup) findViewById(R.id.timDva)).addView(radioTim2);

        }
    }

    public void Rad(){
        radioTim1.setOnCheckedChangeListener(
                new RadioGroup.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(RadioGroup group, int checkedId) {
                        //TextView prikazTeksta = findViewById(R.id.prikazTeksta);

                        timJedanIgracPoeni = findViewById(R.id.timJedanIgracPoeni);
                        timJedanPoeni = findViewById(R.id.timJedanPoeni);

                        prikazTeksta = findViewById(R.id.prikazTeksta);


                        trenutniTim = 1;

                        //prikazTeksta.setText(trenutniTim + "");

                        trenutniCekiraniTim1 = checkedId-1;

                        trenutniIgrac = trenutniCekiraniTim1;







                        //prikaz poena
                        timJedanIgracPoeni = findViewById(R.id.timJedanIgracPoeni);
                        timJedanIgracPoeni.setText( tim1[trenutniIgrac].getPoeni() + "");

                        prikazTeksta = findViewById(R.id.prikazTeksta);
                        prikazTeksta.setText(tim1[trenutniIgrac].getZaSlobodnoBacanjePokusaj() + "");
                        prikazTeksta.setText(tim1[trenutniIgrac].getPokusajZaDva() + "");
                        prikazTeksta.setText(tim1[trenutniIgrac].getPokusajZaTri() + "");

                        prikazTeksta.setText(tim1[trenutniIgrac].getOfanzivniSkok() + "");
                        prikazTeksta.setText(tim1[trenutniIgrac].getDefanzivniSkok() + "");
                        prikazTeksta.setText(tim1[trenutniIgrac].getUkradeneLopte() + "");
                        prikazTeksta.setText(tim1[trenutniIgrac].getAsistencije() + "");
                        prikazTeksta.setText(tim1[trenutniIgrac].getFaulovi() + "");
                        prikazTeksta.setText(tim1[trenutniIgrac].getBlokovi() + "");

                    }
                }
        );

        radioTim2.setOnCheckedChangeListener(
                new RadioGroup.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(RadioGroup group, int checkedId) {
                        //TextView prikazTeksta = findViewById(R.id.prikazTeksta);

                        timDvaIgracPoeni = findViewById(R.id.timDvaIgracPoeni);
                        timDvaPoeni = findViewById(R.id.timDvaPoeni);

                        prikazTeksta = findViewById(R.id.prikazTeksta);

                        trenutniTim = 2;

                        //prikazTeksta.setText(trenutniTim + "");

                        trenutniCekiraniTim2 = checkedId-(brojIgraca+1);
                        trenutniIgrac = trenutniCekiraniTim2;





                        timDvaPoeni.setText(TimDvaPoeni + "");

                        //prikaz poena
                        timDvaIgracPoeni = findViewById(R.id.timDvaIgracPoeni);
                        timDvaIgracPoeni.setText( tim2[trenutniIgrac].getPoeni() + "");

                        prikazTeksta = findViewById(R.id.prikazTeksta);
                        prikazTeksta.setText(tim2[trenutniIgrac].getZaSlobodnoBacanjePokusaj() + "");
                        prikazTeksta.setText(tim2[trenutniIgrac].getPokusajZaDva() + "");
                        prikazTeksta.setText(tim2[trenutniIgrac].getPokusajZaTri() + "");

                        prikazTeksta.setText(tim2[trenutniIgrac].getOfanzivniSkok() + "");
                        prikazTeksta.setText(tim2[trenutniIgrac].getDefanzivniSkok() + "");
                        prikazTeksta.setText(tim2[trenutniIgrac].getUkradeneLopte() + "");
                        prikazTeksta.setText(tim2[trenutniIgrac].getAsistencije() + "");
                        prikazTeksta.setText(tim2[trenutniIgrac].getFaulovi() + "");
                        prikazTeksta.setText(tim2[trenutniIgrac].getBlokovi() + "");


                    }
                }
        );



    }

    @Override
    public void onClick(View v) {

        switch(v.getId()){
            case R.id.dvaPoena:
                // azurirati pokusaj za dva
                //ovako treba za svako dugme


                if (trenutniTim == 1){
                    tim1[trenutniIgrac].setPoeniZaDva();
                    timJedanIgracPoeni = findViewById(R.id.timJedanIgracPoeni);
                    timJedanIgracPoeni.setText( tim1[trenutniIgrac].getPoeni() + "");
                    TimJedanPoeni = TimJedanPoeni + 2;
                    timJedanPoeni.setText(TimJedanPoeni + "");


                }else if (trenutniTim == 2){
                    tim2[trenutniIgrac].setPoeniZaDva();
                    timDvaIgracPoeni = findViewById(R.id.timDvaIgracPoeni);
                    timDvaIgracPoeni.setText( tim2[trenutniIgrac].getPoeni() + "");
                    TimDvaPoeni = TimDvaPoeni + 2;
                    timDvaPoeni.setText(TimDvaPoeni + "");
                }
                break;

            case R.id.dvaPoenaPokusaj:
                if (trenutniTim == 1){
                    tim1[trenutniIgrac].setPokusajZaDva();
                    prikazTeksta = findViewById(R.id.prikazTeksta);
                    prikazTeksta.setText(tim1[trenutniIgrac].getPokusajZaDva() + "");

                }else if(trenutniTim == 2){
                    tim2[trenutniIgrac].setPokusajZaDva();
                    prikazTeksta = findViewById(R.id.prikazTeksta);
                    prikazTeksta.setText(tim2[trenutniIgrac].getPokusajZaDva() + "");
                }
                break;


            case R.id.triPoena:
                // azurirati pokusaj za dva
                //ovako treba za svako dugme

                if (trenutniTim == 1){
                    tim1[trenutniIgrac].setPoeniZaTri();
                    timJedanIgracPoeni = findViewById(R.id.timJedanIgracPoeni);
                    timJedanIgracPoeni.setText( tim1[trenutniIgrac].getPoeni() + "");
                    TimJedanPoeni = TimJedanPoeni + 3;
                    timJedanPoeni.setText(TimJedanPoeni + "");
                }else if (trenutniTim == 2){
                    tim2[trenutniIgrac].setPoeniZaTri();
                    timDvaIgracPoeni = findViewById(R.id.timDvaIgracPoeni);
                    timDvaIgracPoeni.setText( tim2[trenutniIgrac].getPoeni() + "");
                    TimDvaPoeni = TimDvaPoeni + 3;
                    timDvaPoeni.setText(TimDvaPoeni + "");
                }
                break;

            case R.id.triPoenaPokusaj:
                if(trenutniTim == 1){
                    tim1[trenutniIgrac].setPokusajZaTri();
                    prikazTeksta = findViewById(R.id.prikazTeksta);
                    prikazTeksta.setText(tim1[trenutniIgrac].getPokusajZaTri() + "");
                }else if(trenutniTim == 2){
                    tim2[trenutniIgrac].setPokusajZaTri();
                    prikazTeksta = findViewById(R.id.prikazTeksta);
                    prikazTeksta.setText(tim2[trenutniIgrac].getPokusajZaTri() + "");
                }

                break;

            case R.id.slobodnoBacanje:

                if (trenutniTim == 1){
                    tim1[trenutniIgrac].setPoeniZaSlobodnoBacanje();
                    timJedanIgracPoeni = findViewById(R.id.timJedanIgracPoeni);
                    timJedanIgracPoeni.setText(tim1[trenutniIgrac].getPoeni() + "");
                    TimJedanPoeni = TimJedanPoeni + 1;
                    timJedanPoeni.setText(TimJedanPoeni + "");
                }else if (trenutniTim == 2){
                    tim2[trenutniIgrac].setPoeniZaSlobodnoBacanje();
                    timJedanIgracPoeni = findViewById(R.id.timDvaIgracPoeni);
                    timJedanIgracPoeni.setText(tim2[trenutniIgrac].getPoeni() + "");
                    TimDvaPoeni = TimDvaPoeni + 1;
                    timDvaPoeni.setText(TimDvaPoeni + "");
                }
                break;

            case R.id.slobodnoBacanjePokusaj:
                if(trenutniTim == 1){
                    tim1[trenutniIgrac].setZaSlobodnoBacanjePokusaj();
                    prikazTeksta = findViewById(R.id.prikazTeksta);
                    prikazTeksta.setText(tim1[trenutniIgrac].getZaSlobodnoBacanjePokusaj() + "");

                }
                else if(trenutniTim == 2){
                    tim2[trenutniIgrac].setZaSlobodnoBacanjePokusaj();
                    prikazTeksta = findViewById(R.id.prikazTeksta);
                    prikazTeksta.setText(tim2[trenutniIgrac].getZaSlobodnoBacanjePokusaj() + "");
                }
                break;

            case R.id.ofanzivniSkokovi:
                if(trenutniTim == 1){

                    tim1[trenutniIgrac].setOfanzivniSkok();
                    prikazTeksta = findViewById(R.id.prikazTeksta);
                    prikazTeksta.setText(tim1[trenutniIgrac].getOfanzivniSkok() + "");

                }else if(trenutniTim == 2) {
                    tim2[trenutniIgrac].setOfanzivniSkok();
                    prikazTeksta = findViewById(R.id.prikazTeksta);
                    prikazTeksta.setText(tim2[trenutniIgrac].getOfanzivniSkok() + "");
                }
                break;
            case R.id.defanzivniSkokovi:
                if(trenutniTim == 1){
                    tim1[trenutniIgrac].setDefanzivniSkok();
                    prikazTeksta = findViewById(R.id.prikazTeksta);
                    prikazTeksta.setText(tim1[trenutniIgrac].getDefanzivniSkok() + "");

                }else if(trenutniTim == 2) {
                    tim2[trenutniIgrac].setDefanzivniSkok();
                    prikazTeksta = findViewById(R.id.prikazTeksta);
                    prikazTeksta.setText(tim2[trenutniIgrac].getDefanzivniSkok() + "");
                }
                break;
            case R.id.ukradene:
                if(trenutniTim == 1){
                    tim1[trenutniIgrac].setUkradeneLopte();
                    prikazTeksta = findViewById(R.id.prikazTeksta);
                    prikazTeksta.setText(tim1[trenutniIgrac].getUkradeneLopte() + "");
                }else if(trenutniTim == 2) {
                    tim2[trenutniIgrac].setUkradeneLopte();
                    prikazTeksta = findViewById(R.id.prikazTeksta);
                    prikazTeksta.setText(tim2[trenutniIgrac].getUkradeneLopte() + "");
                }
                break;
            case R.id.asistencije:
                if(trenutniTim == 1){
                    tim1[trenutniIgrac].setAsistencije();
                    prikazTeksta = findViewById(R.id.prikazTeksta);
                    prikazTeksta.setText(tim1[trenutniIgrac].getAsistencije() + "");
                }else if(trenutniTim == 2) {
                    tim2[trenutniIgrac].setAsistencije();
                    prikazTeksta = findViewById(R.id.prikazTeksta);
                    prikazTeksta.setText(tim2[trenutniIgrac].getAsistencije() + "");
                }
                break;
            case R.id.faulovi:
                if(trenutniTim == 1){
                    tim1[trenutniIgrac].setFaulovi();
                    prikazTeksta = findViewById(R.id.prikazTeksta);
                    prikazTeksta.setText(tim1[trenutniIgrac].getFaulovi() + "");
                }else if(trenutniTim == 2) {
                    tim2[trenutniIgrac].setFaulovi();
                    prikazTeksta = findViewById(R.id.prikazTeksta);
                    prikazTeksta.setText(tim2[trenutniIgrac].getFaulovi() + "");
                }
                break;
            case R.id.blok:
                if(trenutniTim == 1){
                    tim1[trenutniIgrac].setBlokovi();
                    prikazTeksta = findViewById(R.id.prikazTeksta);
                    prikazTeksta.setText(tim1[trenutniIgrac].getBlokovi() + "");
                }else if(trenutniTim == 2) {
                    tim2[trenutniIgrac].setBlokovi();
                    prikazTeksta = findViewById(R.id.prikazTeksta);
                    prikazTeksta.setText(tim2[trenutniIgrac].getBlokovi() + "");
                }
                break;

            default:
                timJedanIgracPoeni.setText("Greska");
                //nastaviti sa caseovima za svaki button
        }
    }

    private void sacuvajPodatke(){



        findViewById(R.id.buttonSacuvaj).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i2 = new Intent(IgraActivity.this, PoeniIgraca.class);
                System.out.println(brojIgraca);


                Bundle extra = new Bundle();

                String s;

                for(int i = 0; i<brojIgraca; i++){
                    s = String.valueOf(i);
                    extra.putInt("timJedanIgrac" + s, tim1[i].getPoeni());
                    extra.putInt("timDvaIgrac" + s, tim2[i].getPoeni());
                }


                extra.putInt("brojIgracaZaPrikaz", brojIgraca);

                i2.putExtras(extra);
                startActivity(i2);

            }
        });


    }

}