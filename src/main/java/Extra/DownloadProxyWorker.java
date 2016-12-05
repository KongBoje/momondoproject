/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Extra;

import Exceptions.FlightException;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Lasse
 */
public class DownloadProxyWorker extends Thread {
    private final int myIndex;
    private final ArrayList<String> httpList;
    private final ArrayList<String> result;

    public DownloadProxyWorker(int myIndex, ArrayList<String> httpList, ArrayList<String> result) {
        this.myIndex = myIndex;
        this.httpList = httpList;
        this.result = result;
    }
    
    @Override
    public void run() {
        System.out.println("I am "  + Thread.currentThread() + " and my job is " + httpList.get(myIndex));
        DownloadProxy dp = new DownloadProxy();
        try {
            result.set(myIndex, dp.GetHttpRequest(httpList.get(myIndex)));
        } catch (FlightException ex) {
            System.out.println("Thread " + Thread.currentThread() + " couldn't get " + httpList.get(myIndex));
        }
    }
}
