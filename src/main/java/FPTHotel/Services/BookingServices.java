package FPTHotel.Services;

import FPTHotel.Model.Booking;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.Modifying;
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

	List<Booking> findBookingBySoPhongAndTrangThai(int soPhong, int trangThai);

	Booking findTop1BySoPhongAndTrangThai(int soPhong, int trangThai);

	Booking findBookingByMaDatPhong(int maDatPhong);

	@Query("select case when count(b)> 0 then true else false end from Booking b where b.trangThai IN (2) AND b.soPhong = ?1")
	boolean existsCheckingByRoom(int soPhong);

	@Query("select case when count(b)> 0 then true else false end from Booking b " +
			"WHERE b.soPhong = ?1 AND b.trangThai IN (1,2) AND (b.checkinDuKien >= ?2 " +
			"AND b.checkinDuKien <= ?3 OR b.checkoutDuKien >= ?2 AND b.checkoutDuKien <= ?3) ")
	boolean existsBookingByCheckinout(int soPhong, Date checkin, Date Checkout);
	@Query(value = "select b from Booking b " +
			"inner join Room r on r.soPhong = b.soPhong " +
			"inner join RoomType tp on r.maLoaiPhong = tp.maLoaiPhong " +
			"where b.trangThai = 2")
	List<Booking> findRoomForService();

	@Modifying
	@Query("UPDATE Booking b SET b.trangThai = ?1 WHERE b.maDatPhong = ?2")
	void updateBooking(int trangThai, int maDatPhong);

	@Query(value = "SELECT dp FROM Booking dp ORDER BY dp.maDatPhong DESC")
	public List<Booking> findAllOrderByMaDesc(PageRequest pageRequest);

	@Query(value = "SELECT count(0) FROM Booking dp")
	public Double countFindAll();

}
