package FPTHotel.Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "booking")
public class Booking{
	@Id
	private int maDatPhong;
	private String hoTen;
	private String sodt;
	private int trangThai;
	private int soPhong;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "soPhong", referencedColumnName = "soPhong", insertable = false, updatable = false)
	private Room room;
	private Date checkinDuKien;
	private Date checkoutDuKien;
	private Date checkinThuc;
	private Date checkoutThuc;
	private Double tienThuePhong;
	private Double tienCoc;
	private Double tienDichVu;
	private Timestamp createdDate;
	private String createdBy;
	private Timestamp updatedDate;
	private String updatedBy;
	private Double tongTien;

}
