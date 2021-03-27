package androidvezba.ac.aplikacija;

public class Igrac {

    private int Poeni;

    private int poeniZaDva;
    private int pokusajZaDva;

    private int poeniZaTri;
    private int pokusajZaTri;

    private int poeniZaSlobodnoBacanje;
    private int pokusajZaSlobodnoBacanje;

    private int ofanzivniSkok;
    private int defanzivniSkok;
    private int ukradeneLopte;
    private int asistencije;
    private int faulovi;
    private int blokovi;




    public Igrac (){

    }

    public Igrac (int poeni){
        this.Poeni = poeni;
    }


    public int getPoeni() {
        return Poeni;
    }

    public void setPoeni(int poeni) {
        Poeni = poeni;
    }

    public void setPoeniZaDva() {
        poeniZaDva = poeniZaDva + 2;
        Poeni = Poeni + 2;

    }



    public int getPoeniZaDva() {
        return poeniZaDva;
    }



    public int getPokusajZaDva() {
        return pokusajZaDva;
    }

    public void setPokusajZaDva() {

        pokusajZaDva += 1;
    }

    public void setPoeniZaTri() {
        poeniZaTri = poeniZaTri + 3;
        Poeni = Poeni + 3;
    }

    public int getPoeniZaTri() {

        return poeniZaTri;
    }



    public int getPokusajZaTri() {

        return pokusajZaTri;
    }

    public void setPokusajZaTri() {

        pokusajZaTri += 1;
    }

    public int getPoeniZaSlobodnoBacanje() {
        return poeniZaSlobodnoBacanje;

    }

    public void setPoeniZaSlobodnoBacanje() {
        poeniZaSlobodnoBacanje +=  1;
        Poeni = Poeni + 1;
    }

    public int getZaSlobodnoBacanjePokusaj() {
        return pokusajZaSlobodnoBacanje;
    }


    public void setZaSlobodnoBacanjePokusaj() {
        pokusajZaSlobodnoBacanje = pokusajZaSlobodnoBacanje + 1;

    }


    public int getOfanzivniSkok() {
        return ofanzivniSkok;
    }

    public void setOfanzivniSkok() {
        ofanzivniSkok = ofanzivniSkok + 1;
    }

    public int getDefanzivniSkok() {
        return defanzivniSkok;
    }

    public void setDefanzivniSkok() {
        defanzivniSkok = defanzivniSkok + 1;
    }

    public int getUkradeneLopte() {
        return ukradeneLopte;
    }

    public void setUkradeneLopte() {
        ukradeneLopte = ukradeneLopte + 1;
    }

    public int getAsistencije() {
        return asistencije;
    }

    public void setAsistencije() {
        asistencije = asistencije + 1;
    }

    public int getFaulovi() {
        return faulovi;
    }

    public void setFaulovi() {
        faulovi = faulovi + 1;
    }

    public int getBlokovi() {
        return blokovi;
    }

    public void setBlokovi() {
        blokovi = blokovi + 1;
    }


}
