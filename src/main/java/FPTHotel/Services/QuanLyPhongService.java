package FPTHotel.Services;

import java.util.Date;
import java.util.List;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import FPTHotel.Model.Room;




public interface QuanLyPhongService extends CrudRepository<Room, Integer> {

	@Query("select p " +
			"from Room p " +
			"         inner join RoomType r " +
			"                    on p.maLoaiPhong = r.maLoaiPhong " +
			"where r.tenLoaiPhong = :typeRoom " +
			"  and p.giaPhong <= :maxPrice " +
			"  and p.soPhong not in (select b.soPhong " +
			"                         from Booking b " +
			"                         where ((b.checkinDuKien between :checkin and :checkout) " +
			"                             or (b.checkoutDuKien between :checkin and :checkout))" +
			"						  group by b.soPhong)")
	List<Room> findValidRoom(Date checkin, Date checkout, String typeRoom, double maxPrice);

	@Query("SELECT p FROM Room p WHERE p.soPhong = ?1 or p.tang = ?1")
	public List<Room> TimMaPhong(int id, PageRequest pageRequest);
	
	@Query("SELECT p FROM Room p WHERE p.soPhong = ?1 or p.tang = ?1")
	public List<Room> TimMaPhong(int id);
	
	@Query("SELECT count(0) FROM Room p WHERE p.soPhong = ?1 or p.tang = ?1")
	public Double countTimMaPhong(int id);
	
	@Query("SELECT p FROM Room p ORDER BY p.maPhong DESC")
	public List<Room> findAllOrderByMaDesc();

	public List<Room> findAll();

	public List<Room> findAllByGiaPhongLessThanAndLoaiPhongTenLoaiPhong(double maxPrice, String typeRoom);

	@Query("select p from Room p where p.trangThai = 1")
	public List<Room> findAllByTrangThai();

	public List<Room> findAllByLoaiPhongTenLoaiPhong(String roomType);

	@Query("select p from Room p where p.trangThai = 1 and p.maPhong = ?1")
	public List<Room> findAllByTrangThaiAndMaPhong(int maPhong);

	public Room getByMaPhong(int maPhong);

	public Room getBySoPhong(int soPhong);

	public Room getByGiaPhong(double giaPhong);

}
