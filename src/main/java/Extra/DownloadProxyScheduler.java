/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Extra;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Lasse
 */
public class DownloadProxyScheduler {    
    public DownloadProxyScheduler() {
        
    }
    
    public ArrayList<String> getResults(ArrayList<String> httpList) {
        ArrayList<DownloadProxyWorker> slaves = new ArrayList<>();
        
        ArrayList<String> result = new ArrayList<>();
        
        for(int i = 0; i != httpList.size(); i++) {
            result.add(null);
        }
        
        for(int i = 0; i != httpList.size(); i++) {
            // System.out.println("create a thread with " + httpList.get(i));
            DownloadProxyWorker tmp = new DownloadProxyWorker(i, httpList, result);
            slaves.add(tmp);
            slaves.get(i).start();
        }
        
        for(int i = 0; i != httpList.size(); i++) {
            try {
                slaves.get(i).join();
            } catch (InterruptedException ex) {
                System.out.println("Could not join thread " + i);
            }
        }
        
        return result;
    }
}
