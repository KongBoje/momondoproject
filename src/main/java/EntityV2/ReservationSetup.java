/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EntityV2;

import Entity.FakeReservationResponse;
import Entity.ReservationRequest;

/**
 *
 * @author Lasse
 */
public class ReservationSetup {
    private final String url;
    private final ReservationRequest body;
    private final int userid;

    public ReservationSetup(String url, ReservationRequest body, int userid) {
        this.url = url;
        this.body = body;
        this.userid = userid;
    }

    public String getUrl() {
        return url;
    }

    public ReservationRequest getBody() {
        return body;
    }

    public int getUserid() {
        return userid;
    }

       

}
