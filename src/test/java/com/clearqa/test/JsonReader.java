package com.clearqa.test;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.io.FileReader;
import java.util.Iterator;
 
import org.json.*;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import com.sun.org.apache.xerces.internal.impl.xpath.regex.ParseException;

//import org.json.JSONArray;
import org.json.JSONException;
//import org.json.JSONObject;

public class JsonReader {

	private static String readAll(Reader rd) throws IOException {
		StringBuilder sb = new StringBuilder();
		int cp;
		while ((cp = rd.read()) != -1) {
			sb.append((char) cp);
		}
		return sb.toString();
	}

	public static String readJsonFromUrl(String imdb_url) throws IOException, JSONException {
		URL url = new URL(imdb_url);
		URLConnection uc = url.openConnection();
		uc.addRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.0)");
		uc.connect();
		InputStream is = uc.getInputStream();
		try {
			BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
			String jsonText = readAll(rd);
			//System.out.println(jsonText);
			//JSONArray json = new JSONArray();
			//System.out.println(json.get(0).toString());
			//return (String) json.get(0); //There can be more than 1 movies
		
			return jsonText;
			
		} finally {
			is.close();
		}
	}
	
	public static String readJsonFromFile(String json_file) throws IOException, JSONException {
		
		File filepath = new File("C:\\Users\\Dimo Ivanov\\workspace\\ULC_API_Calls\\src\\test\\json\\");
		//LIST ALL FILES FROM THE filepath
		File[] listOfFiles = filepath.listFiles();

	    for (int i = 0; i < listOfFiles.length; i++) {
	      if (listOfFiles[i].isFile()) {
	        System.out.println("File " + listOfFiles[i].getName());
	      } else if (listOfFiles[i].isDirectory()) {
	        System.out.println("Directory " + listOfFiles[i].getName());
	      }
	    }
		
		//end of list -- comment or delete if not used
		
		
		String result = "";
	    try {
	        BufferedReader br = new BufferedReader(new FileReader(filepath + "\\" + json_file));
	        StringBuilder sb = new StringBuilder();
	        String line = br.readLine();
	        while (line != null) {
	            sb.append(line);
	            line = br.readLine();
	        }
	        result = sb.toString();
	    } catch(Exception e) {
	        e.printStackTrace();
	    }
	    return result;

	}
}
