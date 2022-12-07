package FPTHotel.Services;

import FPTHotel.Model.Booking;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.sql.Date;
import java.util.List;

public interface BookingServices extends CrudRepository<Booking, Integer> {
	List<Booking> findByOrderByMaDatPhongDesc();
	@Query("SELECT b FROM Booking b WHERE b.createdBy = ?1 ORDER BY b.maDatPhong DESC")
	List<Booking> findByCreatedBy(String createdBy);

	@Query("SELECT b from Booking b WHERE b.soPhong = ?1 AND b.trangThai IN (1,2) AND (b.checkinDuKien >= ?2 AND b.checkinDuKien <= ?3 OR b.checkoutDuKien >= ?2 AND b.checkoutDuKien <= ?3) ORDER BY b.checkinDuKien ASC ")
	public List<Booking> getAvailableForRoom(int soPhong, Date checkinDuKien, Date checkoutDuKien);

}
