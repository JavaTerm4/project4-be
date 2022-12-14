package FPTHotel.Services;


import FPTHotel.Model.Account;
import FPTHotel.Model.Booking;
import FPTHotel.Model.Collect;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import javax.persistence.Id;
import java.util.List;


public interface MoneyCollectionServices extends CrudRepository<Collect, Id> {

    @Query("SELECT c FROM Collect c ORDER BY c.id DESC")
    List<Collect> findOrderById();
}
