package random;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Test {

	
	  public static String formatDate(Date date, String format) {
	        if (date == null || format == null) {
	            return null;
	        }
	        SimpleDateFormat formatter;
	        formatter = new SimpleDateFormat(format);
	        String formatted = null;
	        try {
	            formatted = formatter.format(date);
	        } catch (Exception e) {
//	            LOGGER.error("Error in formatDate", e);
	        }
	        return formatted;
	    }
	
	public static void main(String[] args) {

//		double d = 777.98;
		
		System.out.println(formatDate(new Date(), "yymmddhhmmss"));
		
		
		
		
	}

}
