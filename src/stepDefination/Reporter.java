package stepDefination;

import java.awt.Color;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class Reporter {
	
	private static List<Result> details;
	private static final String resultPlaceholder = "<!-- INSERT_RESULTS -->";
	private static final String templatePath = "C:\\Users\\buntu\\Desktop\\nw.html";

	public Reporter() {
			
	}
	
	public static void initialize() {
		details = new ArrayList<Result>();
	}
	
	public static void report(String TestCaseName,String TestCaseResult,long time) {
		if(TestCaseResult.equals("passed")) {
			Result r = new Result("Pass",TestCaseName,time);
			details.add(r);
		} else {
			Result r = new Result("Pass",TestCaseName,time);
			details.add(r);
		}
	}
	
	public static void showResults() {
		for (int i = 0;i < details.size();i++) {
			System.out.println("Result " + Integer.toString(i) + ": " + details.get(i).getResult());
		}
	}
	
	public static void writeResults() {
		try {
			String reportIn = new String(Files.readAllBytes(Paths.get(templatePath)));
			for (int i = 0; i < details.size();i++) {
				if (details.get(i).getResult().equals("Pass")){
				reportIn = reportIn.replaceFirst(resultPlaceholder,"<tr><td style='background-color:powderblue'>" + Integer.toString(i+1) + "</td><td style='background-color:lime'>" +details.get(i).getResult() + "</td><td style='background-color:powderblue'>" + details.get(i).getResultText()+"</td><td style='background-color:powderblue'>" + details.get(i).getTime() + "</td></tr>" + resultPlaceholder);
			}
			
			else{
				reportIn = reportIn.replaceFirst(resultPlaceholder,"<tr><td style='background-color:powderblue'>" + Integer.toString(i+1) + "</td><td style='background-color:red'>" +details.get(i).getResult() + "</td><td style='background-color:powderblue'>" + details.get(i).getResultText() + "</td></tr>" + resultPlaceholder);

			}
			}
			String currentDate = new SimpleDateFormat("dd-MM-yyyy").format(new Date());
			String reportPath = "C:\\Users\\buntu\\Desktop\\report_" + currentDate + ".html";
			Files.write(Paths.get(reportPath),reportIn.getBytes(),StandardOpenOption.CREATE);
			
		} catch (Exception e) {
			System.out.println("Error when writing report file:\n" + e.toString());
		}
	}
	
}