package mt.com.vn.modell;

import java.io.Serializable;

/**
 * Created by ManhHung on 12/3/2016.
 */

public class MyContact implements Serializable{
    private String name;
    private String numberPhone;

    public MyContact(String name, String numberPhone) {
        this.name = name;
        this.numberPhone = numberPhone;
    }

    public MyContact() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumberPhone() {
        return numberPhone;
    }

    public void setNumberPhone(String numberPhone) {
        this.numberPhone = numberPhone;
    }
}
