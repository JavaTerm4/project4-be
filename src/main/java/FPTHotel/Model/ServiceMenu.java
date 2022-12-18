package FPTHotel.Model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "servicemenu")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ServiceMenu {
	@Id
	private int maDonDichVu;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "maDichVu")
	private Service dichVu;
	private Integer soLuong;
	private Double donGia;
	private Double total;
	private Integer trangThai;
	private int maDatPhong;

	@Temporal(TemporalType.DATE)
	private Date ngayDat;
	@DateTimeFormat(pattern="HH:mm")
	private java.util.Date gioDat;
	private String thongTinThem;
	private String tenDangNhap;
}
