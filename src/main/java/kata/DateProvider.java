package kata;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateProvider {

    public String getDate() {
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");

        return formatter.format(new Date());
    }
}
