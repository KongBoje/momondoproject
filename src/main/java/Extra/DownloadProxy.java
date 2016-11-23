/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Extra;

import Exceptions.FlightException;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Lasse
 */
public class DownloadProxy {

    public String GetHttpRequest(String link) throws FlightException {
        try {
            URL url = new URL(link);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();

            con.setRequestMethod("GET");
            con.setRequestProperty("Accept", "application/json;charset=UTF-8");

            BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()));

            String jsonStr = "";

            StringBuilder everything = new StringBuilder();
            String line;
            while ((line = br.readLine()) != null) {
                everything.append(line);
            }

            jsonStr = everything.toString();

            return jsonStr;

        } catch (MalformedURLException ex) {
            throw new FlightException(400, 3, "Illegal Input: " + ex.getMessage());
        } catch (IOException ex) {
            throw new FlightException(400, 3, "Illegal Input: " + ex.getMessage());
        }
    }

    public String PostHttpRequest(String link, String body) throws FlightException {
        try {
            byte[] outputInBytes = body.getBytes("UTF-8");

            URL url = new URL(link);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();

            con.setRequestMethod("POST");

            con.setRequestProperty("Content-Type", "application/json");
            con.setRequestProperty("charset", "utf-8");
            con.setDoOutput(true);

            con.setRequestProperty("Content-Length", Integer.toString(outputInBytes.length));

            try (DataOutputStream dos = new DataOutputStream(con.getOutputStream())) {
                dos.write(outputInBytes);
            }

            BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()));

            String jsonStr = "";

            StringBuilder everything = new StringBuilder();
            String line;
            while ((line = br.readLine()) != null) {
                everything.append(line);
            }

            jsonStr = everything.toString();

            return jsonStr;
        } catch (MalformedURLException ex) {
            throw new FlightException(400, 3, "Illegal input:" + ex.getMessage());
        } catch (IOException ex) {
            throw new FlightException(400, 3, "Illegal input: " + ex.getMessage());
        }
    }
}
