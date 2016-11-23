/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Rest;

import Extra.DownloadProxy;
import java.io.IOException;

/**
 *
 * @author Lasse
 */
public class NotJunit {
    public static void main(String[] args) throws IOException {
        DownloadProxy dp = new DownloadProxy();
        
        String body = "{  \n" +
"  \"flightID\": \"3256-1513036800000\",\n" +
"  \"numberOfSeats\":1,\n" +
"  \"reserveeName\":\"Jan Hansen\",\n" +
"  \"reservePhone\":\"12345678\",\n" +
"  \"reserveeEmail\":\"jan@hansen.dk\",\n" +
"  \"passengers\":[  \n" +
"    {  \n" +
"      \"firstName\":\"Jan\",\n" +
"      \"lastName\":\"Hansen\"\n" +
"    }\n" +
"  ]\n" +
"}";
        
        System.out.println(dp.PostHttpRequest("http://airline-plaul.rhcloud.com/api/flightreservation", body));
    }
}
