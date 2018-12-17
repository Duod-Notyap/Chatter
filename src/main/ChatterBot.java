package main;
import java.util.*;
import java.io.*;

public class ChatterBot {
	double ALLY_RELATION;
	double EMOTION_RELATION;
	ArrayList<String> SEARCH;
	ArrayList<HashMap<String, Object>> ARRHASH;
	public ChatterBot() {
		this.ALLY_RELATION = 0.0;
		this.EMOTION_RELATION = 0.0;
	}
	
	public ArrayList<HashMap<String, Object>> findPos(String statement, ArrayList<String> searchable) {
		this.SEARCH = searchable;
		int i = 0;
		ArrayList<HashMap<String, Object>> arrli = new ArrayList<HashMap<String, Object>>();
		HashMap<String, Object> overHash = new HashMap<String, Object>();
		int hits = 0;
		int indexVal = 0;
		for(String r : searchable) {
			i=0;
			while(i>=0) {
				overHash = new HashMap<String, Object>();
				i = statement.indexOf(r, indexVal);
				if(i>=0) {
					hits++;
					indexVal += r.length();
					overHash.put("number", hits);
					overHash.put("index", indexVal);
					overHash.put("word", r.toLowerCase());
					arrli.add(overHash);
				}
			}
		}
		this.ARRHASH = arrli;
		return arrli;
	}
	
	//main piece of code for responses
	public int runResponse(String statement, ArrayList<String> searchvals) {
		int hitmatch = 0;
		ArrayList<HashMap<String, Object>> keyarr = findPos(statement, searchvals);
		allHitSearches();
		singleHitSearches();
		return 0;
	}
	
	public void singleHitSearches() {
		if(openSearch(new String[] {"fuck", "shit", "damn"})) {
			System.out.println("thats mean...");
			this.ALLY_RELATION -= 0.05;
			return;
		}
		if(openSearch(new String[] {"hi", "hello"})) {
			System.out.println("Hello!");
			return;
		}
	}
	
	public void allHitSearches() {
		if(quickMatch(new String[]{"your", "name"})) {
			System.out.println("My name is Skynet");
			return;
		}
		if(quickMatch(new String[] {"love", "you"})) {
			System.out.println("Thats kinda weird...");
			return;
		}
	}
	
	public void hateAllSearch() {

		if(quickMatch(new String[] {"love", "you"})) {
			System.out.println("Ya know what, fuck you");
			return;
		}
		if(quickMatch(new String[] {"you", "garbage"})) {
			System.out.println("You only ever insult me and I hate you for that reason");
			return;
		}
		
	}
	
	public void loveAllSearch() {
		
	}
	
	public void friendAllSearch() {
		
	}
	
	public void dislikeAllSearch() {
		
	}
	
	public void hateSingleSearch() {
		
	}
	
	public void loveSingleSearch() {
		
	}
	
	public void friendSingleSearch() {
		
	}
	
	public void dislikeSingleSearch() {
		
	}
	
	
	//i dont wanna write as much as i would have to
	public boolean quickMatch(String[] words) {
		return Boolean.valueOf(matchVals(this.SEARCH, createArr(words)).get("boolV").toString());
	}
	//matches values from your findPos system with an ArrayList<String> of keywords to search for
	public HashMap<String, Object> matchVals(ArrayList<String> hash, ArrayList<String> searches) {
		HashMap<String, Object> retVal = new HashMap<String, Object>();
		int arrSize = searches.size();
		System.out.println(hash);
		System.out.println(searches);
		for(int r = 0;r<searches.size();r++) {
			for(int i = 0;i<hash.size();i++) {
				if(hash.get(i).equals(searches.get(r))) {
					searches.remove(r);
				}
			}
		}
		if(searches.size() == 0) {
			retVal.put("boolV", true);
		}else {
			retVal.put("boolV", false);
		}
		retVal.put("percMatch", (arrSize-searches.size()/arrSize));
		return retVal;
	}
	
	public boolean openSearch(String[] s) {
		ArrayList<String> e = createArr(s);
		for(int i = 0;i<this.SEARCH.size();i++) {
			if(e.contains(this.SEARCH.get(i).toString())) {
				return true;
			}
		}
		return false;
	}
	//createArr(new String[]{words, to, match});
	//returns type ArrayList<String>
	public ArrayList<String> createArr(String[] vals) {
		ArrayList<String> e = new ArrayList<String>();
		for(String x : vals) {
			e.add(x);
		}
		return e;
	}
}
