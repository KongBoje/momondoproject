/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NotJUnit;

import Exceptions.FlightException;
import Extra.DownloadProxy;

/**
 *
 * @author Lasse
 */
public class TestFlightsAgain {
    public static void main(String[] args) throws FlightException {
        DownloadProxy dp = new DownloadProxy();
        String res = dp.GetHttpRequest("http://localhost:8084/Momondoproject/api/allflights/CPH/2017-01-20T00:00:00.000Z/1");
        
        System.out.println(res);
    }
}
