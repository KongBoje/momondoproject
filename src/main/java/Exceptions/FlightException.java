/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exceptions;

/**
 *
 * @author Lasse
 */
public class FlightException extends Exception {

    public final int httpError;
    public final int errorCode; 
    public final String message;
    
    //Constructer for vores FlightExcepion
    public FlightException(int httpError, int errorCode, String message) {
        this.httpError = httpError;
        this.errorCode = errorCode;
        this.message = message;
    }
}
