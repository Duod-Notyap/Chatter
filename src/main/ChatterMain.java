package main;
import main.ChatterBot;
import java.util.*;
import java.io.*;
public class ChatterMain {
	public static void main(String[] args) {
		while(true) {	
			ChatterBot sys = new ChatterBot();
			Scanner inp = new Scanner(System.in);
			ArrayList<String> words = new ArrayList<String>();
			String[] arrwords;
			System.out.print(">:");
			String userSpoken = inp.nextLine();
			arrwords = userSpoken.split(" ", 0);
			words = transferArrs(words, arrwords);
			sys.runResponse(userSpoken,  words);
		}
	}
	
	public static ArrayList<String> transferArrs(ArrayList<String> a, String[] b) {
		for(String x : b) {
			a.add(x);
		}
		return a;
	}
}
