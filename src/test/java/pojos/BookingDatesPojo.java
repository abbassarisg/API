package pojos;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class BookingDatesPojo {

    // 1- Tum keyler icin private variableler olusturduk

    private String checkin;
    private  String checkout;


    // 2- Tum parametrelerle ve parametresiz constructor olusturuyoruz

    public BookingDatesPojo() {
    }

    public BookingDatesPojo(String checkin,String checkout) {
        this.checkin = checkin;
        this.checkout= checkout;
    }

    //public Getter ve Setter methodlari olusturuyoruz


    public String getCheckin() {
        return checkin;
    }

    public void setCheckin(String checkin) {
        this.checkin = checkin;
    }

    public String getCheckout() {
        return checkout;
    }

    public void setCheckout(String checkout) {
        this.checkout = checkout;
    }

    // toString(0 methodunu olusturmaliyiz


    @Override
    public String toString() {
        return "BookingDatesPojo{" +
                "checkin='" + checkin + '\'' +
                ", checkout='" + checkout + '\'' +
                '}';
    }
}
