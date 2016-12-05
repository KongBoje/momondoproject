/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NotJUnit;

import Exceptions.FlightException;
import Extra.DownloadProxy;
import Extra.DownloadProxyScheduler;
import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author Lasse
 */
public class TestFlightsAgain {

    private static final Gson GSON = new Gson();

    public static void main(String[] args) throws FlightException {
        ArrayList<String> myHttp = new ArrayList<>();
        myHttp.add("http://stackoverflow.com/questions/11397008/does-a-list-object-get-passed-by-reference");
        myHttp.add("http://ordnet.dk/");

        DownloadProxyScheduler dps = new DownloadProxyScheduler();

        ArrayList<String> loaded = dps.getResults(myHttp);
        
    }
}
