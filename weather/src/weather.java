import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;




public class weather {
	public static void main(String[] args) throws IOException, JSONException {
		URL url = new URL("https://api.openweathermap.org/data/2.5/forecast?q=Santa Cruz,us&APPID=c2bceef9dbcb4349fda0fba154f01e73");
		HttpURLConnection con = (HttpURLConnection) url.openConnection();
		con.setRequestMethod("GET");
		
		Map<String, String> parameters = new HashMap<>();
		parameters.put("param1", "val");
		 
		con.setDoOutput(true);
		DataOutputStream out = new DataOutputStream(con.getOutputStream());
		out.writeBytes(ParameterStringBuilder.getParamsString(parameters));
		out.flush();
		out.close();
		
	    //con.setRequestProperty("Content-Type", "application/json");
		
		String contentType = con.getHeaderField("Content-Type");
		
		con.setConnectTimeout(5000);
		con.setReadTimeout(5000);
		
		
		int status = con.getResponseCode();
		
		BufferedReader in = new BufferedReader(
		new InputStreamReader(con.getInputStream()));
		String inputLine;
		StringBuffer content = new StringBuffer();
		while ((inputLine = in.readLine()) != null) {
			content.append(inputLine);
		}
		in.close();
		con.disconnect();
		
		System.out.println(content);
		
		String h = content.toString();
		
		JSONObject root = new JSONObject(h);
		JSONArray firstArray = root.getJSONArray("list");
		// now get the first element:
		//JSONArray secondArray = firstArray.getJSONArray(0); // weather
		boolean rain = true;
		for (int i = 0; i < 9; i++) {
			JSONObject item = firstArray.getJSONObject(0);
			// and so on
			JSONArray weatherArray = item.getJSONArray("weather"); // basketball
			JSONObject weather = weatherArray.getJSONObject(0);
			String w = weather.getString("main");
			//int id = firstSport.getInt("lon"); // 40
			//JSONArray leaguesArray = firstSport.getJSONArray("leagues");
			System.out.println(w);
			if (!w.equals("Rain")) {
				rain = false;
			}
		}
		if (rain = true) {
			System.out.println("Let's run naked");
		}
	}
}
