/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Extra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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
    private final String link, method;
    
    public DownloadProxy(String link, String method) {
        this.link = link;
        this.method = method;
    }
    
    public String HttpRequest() throws MalformedURLException, IOException {
        URL url = new URL(link);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        
        con.setRequestMethod(method);
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
    }
}
