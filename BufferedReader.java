import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;
import java.util.Scanner;

public class BufferedReader {
	static Scanner userInput = new Scanner(System.in);
	public static String userInputString;
	
			
	public static void main(String[] args) throws IOException {
		
		System.out.print("Enter the name: \n");        
        if(userInput.hasNextLine()) {      
        	userInputString = (userInput.nextLine());  // get user input from console
        }
		String completeUrl = ("https://www.ecs.soton.ac.uk/people/" + userInputString);  // create full URL
		Document document = Jsoup.connect(completeUrl).get();  // gets page source from URL
		String title = document.title();  // get string from <title>
		int position = title.indexOf("|");  // get index of "|" to separate name from details
		String name = title.substring(0, position);  // creates substring on title that only includes the name
		System.out.println(name);       
	}
}