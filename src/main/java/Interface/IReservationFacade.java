/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import Entity.ReservationRequest;
import Entity.ReservationResponse;
import static java.util.Collections.list;
import java.util.List;

/**
 *
 * @author Martin
 */
public interface IReservationFacade {

    public ReservationResponse getReservationResponseById(int id);

    public boolean addReservationResponse(ReservationResponse rr);

    public boolean deleteReservationResponse(ReservationResponse rr);

    public List<ReservationResponse> getAllReservationResponses();
    
}
