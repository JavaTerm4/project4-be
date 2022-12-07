package FPTHotel.Services;

import FPTHotel.Model.Booking;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BookingServices extends CrudRepository<Booking, Integer> {
	List<Booking> findByOrderByMaDatPhongDesc();
	@Query("SELECT b FROM Booking b WHERE b.createdBy = ?1 ORDER BY b.maDatPhong DESC")
	List<Booking> findByCreatedBy(String createdBy);
}
