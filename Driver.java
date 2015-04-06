package AXi;

import java.io.IOException;

import org.json.JSONException;

public class Driver {

	/*
	 * Standared Main method that just initiates code
	 */
	public static void main(String[] args) throws IOException, JSONException {
		Handler handler = new Handler();
		handler.start();

	}

}
