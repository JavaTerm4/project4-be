package FPTHotel.Model;

import java.util.Date;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.util.ObjectUtils;


@Entity
@Table(name = "account")
public class Account {
	@Id
	@NotBlank(message = "- Username cannot be empty")
	private String username;
	@NotBlank(message = "- Password cannot be empty")
	@Length(min = 8, message = "- Password must be 8 characters or more")
	private String password;
	@NotBlank(message = "- Full name cannot be empty")
	private String fullName;
	@NotBlank(message = "- Gender cannot be empty")
	private String gender;
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@NotNull(message = "- The date of birth cannot be empty")
	@Past(message = "- Birth date must be in the past")
	private Date birthday;
//	@NotBlank(message = "- Identification number cannot be empty")
	private String identityCard;
	@Length(min = 9, max = 15, message = "- invalid phone number")
	@NotBlank(message = "- Phone number cannot be empty")
	private String phoneNumber;
	@NotBlank(message = "- Email cannot be empty")
	private String email;
	@Temporal(TemporalType.DATE)
	private Date dateSet;
	@DateTimeFormat(pattern = "HH:mm")
	private java.util.Date timeSet;

	private Date createdDate;
	private String createdBy;
	private Date updatedDate;
	private String updatedBy;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "position_id ")
	private Position position ;


	public Date getNgayTao() {
		return dateSet;
	}

	public void setNgayTao(Date ngayTao) {
		this.dateSet = ngayTao;
	}

	public java.util.Date getGioTao() {
		return timeSet;
	}

	public void setGioTao(java.util.Date gioTao) {
		this.timeSet = gioTao;
	}

	public String getTenDangNhap() {
		return username;
	}

	public void setTenDangNhap(String tenDangNhap) {
		this.username = tenDangNhap;
	}

	public String getMatKhau() {
		return password;
	}

	public void setMatKhau(String matKhau) {
		this.password = matKhau;
	}

	public String getHoTen() {
		return fullName;
	}

	public void setHoTen(String hoTen) {
		this.fullName = hoTen;
	}

	public String getGioiTinh() {
		return gender;
	}

	public void setGioiTinh(String gioiTinh) {
		this.gender = gioiTinh;
	}

	public Date getNgaySinh() {
		return birthday;
	}

	public void setNgaySinh(Date ngaySinh) {
		this.birthday = ngaySinh;
	}

	public String getCmnd() {
		return identityCard;
	}

	public void setCmnd(String cmnd) {
		this.identityCard = cmnd;
	}

	public String getSoDT() {
		return phoneNumber;
	}

	public void setSoDT(String soDT) {
		this.phoneNumber = soDT;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Position getChucVu() {
		return position;
	}

	public void setChucVu(Position chucVu) {
		this.position = chucVu;
	}

	@PrePersist
	public void onCreate() {
		if(ObjectUtils.isEmpty(dateSet)) {
			dateSet = new Date();
		}
		timeSet = new java.util.Date();
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Date getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

}