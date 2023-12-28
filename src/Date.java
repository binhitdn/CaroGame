import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
public class Date {
	String time;
 public Date() {
	 LocalDateTime current = LocalDateTime.now();
		
	 DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM HH:mm");
	
	 time = current.format(formatter);
	
	 
 }
 public String time() {
	 return time;
 }
}
