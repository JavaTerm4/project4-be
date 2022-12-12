package FPTHotel.Dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class RoomDto {
    private int maPhong;
    private Integer soPhong;
    private Integer tang;
    private String tienNghi;
    private RoomTypeDto loaiPhong;
    private String hinhAnh;
    private Double giaPhong;
    private Double giaPhongGioDau;
    private Double giaPhongGioSau;
    private String khuyenMai;
    private Integer trangThai;
}
