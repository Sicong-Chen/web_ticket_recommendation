package rpc;

import java.io.BufferedReader;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONObject;

import entity.Item;


// It’s similar to what we did in doGet but we move 
// all the codes to a separate class such that other Rpc can reuse them as well. 
public class RpcHelper {
	// Parses a JSONObject from http request.
	public static JSONObject readJsonObject(HttpServletRequest request) {
		StringBuilder sb = new StringBuilder();
		String line = null;
		try {
			BufferedReader reader = request.getReader();
			while ((line = reader.readLine()) != null) {
				sb.append(line);
			}
			reader.close();
			return new JSONObject(sb.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	// Writes a JSONObject to http response.
	public static void writeJsonObject(HttpServletResponse response, JSONObject obj) {
		try {
			response.setContentType("application/json");
			PrintWriter out = response.getWriter();
			out.print(obj);
			out.flush();
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// Writes a JSONArray to http response.
	public static void writeJsonArray(HttpServletResponse response, JSONArray array) {
		try {
			// Tells the browser that server is returning a response in a format of JSON 
			response.setContentType("application/json");
			// Create a PrintWriter from response such that we can add data to response. 
			PrintWriter out = response.getWriter();
			out.print(array);
			out.flush();
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	// Converts a list of Item objects to JSONArray.
	public static JSONArray getJSONArray(List<Item> items) {
		JSONArray result = new JSONArray();
		try {
			for (Item item : items) {
				result.put(item.toJSONObject());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}


}
