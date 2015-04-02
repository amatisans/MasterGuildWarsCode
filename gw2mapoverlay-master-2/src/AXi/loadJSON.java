package AXi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.nio.charset.Charset;

import javax.swing.ImageIcon;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


public class loadJSON {
	public static WorldInfo ourWorld;
	
	private static int redId, greenId, blueId;
	private static String redName, greenName, blueName;

	public static WorldInfo load(String server) throws IOException, JSONException {
		ourWorld = queryMatchID(server);
		//ourWorld.printWorld();
		return ourWorld;
	}
	
	private static String readAll(Reader rd) throws IOException {
		StringBuilder sb = new StringBuilder();
		int cp;
		while ((cp = rd.read()) != -1) {
			sb.append((char) cp);
		}
		return sb.toString();
	}

	public static JSONObject readJsonFromUrl(String url) throws IOException,
			JSONException {
		InputStream is = new URL(url).openStream();
		try {
			BufferedReader rd = new BufferedReader(new InputStreamReader(is,
					Charset.forName("UTF-8")));
			String jsonText = readAll(rd);
			JSONObject json = new JSONObject(jsonText);
			return json;
		} finally {
			is.close();
		}
	}

	public static JSONArray readJsonArrayFromUrl(String url) throws IOException,JSONException {
		InputStream is = new URL(url).openStream();
		try {
			BufferedReader rd = new BufferedReader(new InputStreamReader(is,
					Charset.forName("UTF-8")));
			String jsonText = readAll(rd);
			JSONArray json = new JSONArray(jsonText);
			return json;
		} finally {
			is.close();
		}
	}
	
	public static void FillInNames() throws JSONException, IOException{
		JSONArray world_names = readJsonArrayFromUrl("https://api.guildwars2.com/v1/world_names.json?lang=en");
		for (int i=0; i<world_names.length(); i++){
			if (world_names.getJSONObject(i).getInt("id") == redId){
				redName = (String) world_names.getJSONObject(i).get("name");
			}
			else if (world_names.getJSONObject(i).getInt("id") == blueId){
				blueName = (String) world_names.getJSONObject(i).get("name");
			}
			else if (world_names.getJSONObject(i).getInt("id") == greenId){
				greenName = (String) world_names.getJSONObject(i).get("name");
			}
		}
		
	}
	
	public static WorldInfo queryMatchID(String guild) throws IOException, JSONException {
		int userWorldId = 0;
		
		JSONArray world_names = readJsonArrayFromUrl("https://api.guildwars2.com/v1/world_names.json?lang=en");
		for (int i=0; i<world_names.length(); i++){
			if (world_names.getJSONObject(i).get("name").equals(guild)){
				userWorldId = world_names.getJSONObject(i).getInt("id");
			}
		}
		if (userWorldId == 0){
			System.out.println("Guild name not recognized.");
			return null;
		}
		
		JSONObject matches = readJsonFromUrl("https://api.guildwars2.com/v1/wvw/matches.json");
		JSONArray wvw_matches = (JSONArray) matches.get("wvw_matches");
		for (int i = 0; i < wvw_matches.length(); i++) {			
			if ((wvw_matches.getJSONObject(i).getInt("red_world_id")) == (userWorldId)){
				redId = wvw_matches.getJSONObject(i).getInt("red_world_id");
				blueId = wvw_matches.getJSONObject(i).getInt("blue_world_id");
				greenId = wvw_matches.getJSONObject(i).getInt("green_world_id");
				FillInNames();
				return queryMap(wvw_matches.getJSONObject(i).getString("wvw_match_id"));
			}
			else if ((wvw_matches.getJSONObject(i).getInt("blue_world_id")) == (userWorldId)){
				redId = wvw_matches.getJSONObject(i).getInt("red_world_id");
				blueId = wvw_matches.getJSONObject(i).getInt("blue_world_id");
				greenId = wvw_matches.getJSONObject(i).getInt("green_world_id");
				FillInNames();
				return queryMap(wvw_matches.getJSONObject(i).getString("wvw_match_id"));
			}
			else if ((wvw_matches.getJSONObject(i).getInt("green_world_id")) == (userWorldId)){
				redId = wvw_matches.getJSONObject(i).getInt("red_world_id");
				blueId = wvw_matches.getJSONObject(i).getInt("blue_world_id");
				greenId = wvw_matches.getJSONObject(i).getInt("green_world_id");
				FillInNames();
				return queryMap(wvw_matches.getJSONObject(i).getString("wvw_match_id"));
			}
		}
		
		return null;
	}
	
	public static WorldInfo queryMap(String mathchId) throws IOException, JSONException{
		String matchUrl = "https://api.guildwars2.com/v1/wvw/match_details.json?match_id=" + mathchId;
		
		WorldInfo wi = new WorldInfo(0, 0, 0, null, null, null, null);
		
		JSONObject match_details = readJsonFromUrl(matchUrl);
		JSONArray scores = (JSONArray) match_details.get("scores");
		
		
		wi.redScore = scores.getInt(0);
		wi.blueScore = scores.getInt(1);
		wi.greenScore = scores.getInt(2);
		
		JSONArray maps = (JSONArray) match_details.get("maps");
		JSONObject redMap = maps.getJSONObject(0);
		JSONObject greenMap = maps.getJSONObject(1);
		JSONObject blueMap = maps.getJSONObject(2);
		JSONObject center = maps.getJSONObject(3);
		
		wi.redHome = printMap(redMap);
		wi.greenHome = printMap(greenMap);
		wi.blueHome = printMap(blueMap);
		wi.center = printMap(center);
		
		return wi;
	}
	
	public static AreaInfo printMap (JSONObject map)throws IOException, JSONException{
		JSONArray objective_names = readJsonArrayFromUrl("https://api.guildwars2.com/v1/wvw/objective_names.json");
		
		AreaInfo ai = new AreaInfo(null, 0, 0, 0, null);
		
		//System.out.println(map.get("type"));
		if (map.getString("type").equals("BlueHome"))
			ai.map = blueName;
		else if (map.getString("type").equals("GreenHome"))
			ai.map = greenName;
		else if (map.getString("type").equals("RedHome"))
			ai.map = redName;
		else
			ai.map = "Eternal B.";
		
		JSONArray scores = (JSONArray) map.get("scores");
		//System.out.println("Red guild score for " + map.get("type") + ": " + scores.getInt(0));
		//System.out.println("Blue guild score for " + map.get("type") + ": " + scores.getInt(1));
		//System.out.println("Green guild score for " + map.get("type") + ": " + scores.getInt(2));
		
		ai.redScore = scores.getInt(0);	
		ai.blueScore = scores.getInt(1);
		ai.greenScore = scores.getInt(2);
		
		JSONArray objectives = (JSONArray) map.get("objectives");
		
		Node[] nodes;
		if (ai.map.equals("Eternal B."))
			nodes = new Node[22];
		else
			nodes = new Node[19];
		
		NodeNamer nn = new NodeNamer();
		for (int i=0; i<objectives.length(); i++){
			JSONObject node = objectives.getJSONObject(i);
			String nodeName = "";
			/*for (int k=0; k<objective_names.length(); k++){
				if (objective_names.getJSONObject(k).getInt("id") == node.getInt("id")){
					nodeName = objective_names.getJSONObject(k).getString("name");
				}
			}*/
			nodeName = nn.getName(node.getInt("id"));
			ImageIcon ii = new ImageIcon();
			ii = createImageIcon("./Icons/" + node.getString("owner") + "/" + nn.getIcon(node.getInt("id")));
			//System.out.println("Node " + nodeName + " belongs to " + node.get("owner"));
			nodes[i] = new Node(ii, nodeName, node.getString("owner"));
		}
		JSONArray bonuses = (JSONArray) map.get("bonuses");
		for (int i=0; i<bonuses.length(); i++){
			JSONObject node = bonuses.getJSONObject(i);
			//System.out.println("Bonuse node " + node.get("type") + " belongs to " + node.get("owner"));
			nodes[18] = new Node(null, node.getString("type"), node.getString("owner"));
		}
		//System.out.println();
		ai.nodes = nodes;
		return ai;
		
	}
	
	protected static ImageIcon createImageIcon(String path) {
		 java.net.URL imgURL = MainGUI.class.getResource(path);
		 if (imgURL != null) {
			 return new ImageIcon(imgURL);
		 } else {
			 System.err.println("Couldn't find file: " + path);
			 return null;
		 }
	 }
}
