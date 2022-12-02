package FPTHotel.Services;

import FPTHotel.Model.Booking;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BookingServices extends CrudRepository<Booking, Integer> {
	List<Booking> findByOrderByMaDatPhongDesc();
}
