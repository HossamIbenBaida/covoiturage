package voiturage.co.com.co_voiturage;

public class classAnnance {
     private int nbrPlace ;
     private String villeDepart ;
     private  String villeDarriver ;
     private String Date ;
     private String heur ;

    public classAnnance() {

    }

    private String addresseDapare ;

    public classAnnance(int nbrPlace, String villeDepart, String villeDarriver, String date, String heur, String addresseDapare) {
        this.nbrPlace = nbrPlace;
        this.villeDepart = villeDepart;
        this.villeDarriver = villeDarriver;
        Date = date;
        this.heur = heur;
        this.addresseDapare = addresseDapare;
    }

    public int getNbrPlace() {
        return nbrPlace;
    }

    public void setNbrPlace(int nbrPlace) {
        this.nbrPlace = nbrPlace;
    }

    public String getVilleDepart() {
        return villeDepart;
    }

    public void setVilleDepart(String villeDepart) {
        this.villeDepart = villeDepart;
    }

    public String getVilleDarriver() {
        return villeDarriver;
    }

    public void setVilleDarriver(String villeDarriver) {
        this.villeDarriver = villeDarriver;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }

    public String getHeur() {
        return heur;
    }

    public void setHeur(String heur) {
        this.heur = heur;
    }

    public String getAddresseDapare() {
        return addresseDapare;
    }

    public void setAddresseDapare(String addresseDapare) {
        this.addresseDapare = addresseDapare;
    }
}
