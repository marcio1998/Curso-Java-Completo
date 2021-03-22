package course;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Calendar;
import java.util.Date;

public class Calendario {

	public static void main(String[] args) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		
		Date d = Date.from(Instant.parse("2018-06-25T15:42:07Z"));
		System.out.println(sdf.format(d));
		
		//Adionar mais 4 horas.
		Calendar cal = Calendar.getInstance();
		cal.setTime(d);
		cal.add(Calendar.HOUR_OF_DAY,4);
		d = cal.getTime();
		System.out.println(d);
		 int minutes = cal.get(Calendar.MINUTE);
		 int month = cal.get(Calendar.MONTH);
		 System.out.println(minutes +" "+ month);
	}

}
