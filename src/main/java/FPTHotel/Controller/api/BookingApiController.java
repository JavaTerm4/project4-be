package FPTHotel.Controller.api;

import FPTHotel.Dto.BookingDTO;
import FPTHotel.Dto.RoomDto;
import FPTHotel.Dto.RoomTypeDto;
import FPTHotel.Model.Booking;
import FPTHotel.Model.Room;
import FPTHotel.Services.BookingServices;
import FPTHotel.Services.QuanLyPhongService;
import java.sql.Timestamp;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.validation.annotation.Validated;

@RestController
@RequestMapping("/api/book")
@AllArgsConstructor
public class BookingApiController {

    @Autowired
    QuanLyPhongService quanLyPhongService;

    @Autowired
    BookingServices bookingServices;

    @GetMapping("/search-available")
    public ResponseEntity<?> searchAvailable(@RequestParam("checkin") String checkin,
                                             @RequestParam("checkout") String checkout,
                                             @RequestParam("typeRoom") String typeRoom,
                                             @RequestParam("maxPrice") double maxPrice) throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date checkinDate = formatter.parse(checkin);
        Date checkoutDate = formatter.parse(checkout);
        List<Room> rooms = quanLyPhongService.findValidRoom(checkinDate, checkoutDate, typeRoom, maxPrice);
        List<RoomDto> roomDtos = rooms.stream().map(room -> {
            RoomDto roomDto = new RoomDto();
            roomDto.setMaPhong(room.getMaPhong());
            roomDto.setGiaPhong(room.getGiaPhong());
            roomDto.setSoPhong(room.getSoPhong());
            roomDto.setTang(room.getTang());
            roomDto.setTrangThai(room.getTrangThai());

            RoomTypeDto roomTypeDto = new RoomTypeDto();
            roomTypeDto.setMaLoaiPhong(room.getLoaiPhong().getMaLoaiPhong());
            roomTypeDto.setTenLoaiPhong(room.getLoaiPhong().getTenLoaiPhong());
            roomTypeDto.setMoTa(room.getLoaiPhong().getMoTa());

            roomDto.setLoaiPhong(roomTypeDto);
            roomDto.setGiaPhongGioDau(room.getGiaPhongGioDau());
            roomDto.setHinhAnh(room.getHinhAnh());
            roomDto.setKhuyenMai(room.getKhuyenMai());
            roomDto.setTienNghi(room.getTienNghi());
            roomDto.setGiaPhongGioSau(room.getGiaPhongGioSau());
            return roomDto;
        }).collect(Collectors.toList());
        return ResponseEntity.ok(roomDtos);
    }

    @GetMapping( "/checkBooking")
    public ResponseEntity<?> checkBooking(@RequestParam("checkin") java.sql.Date checkin,
                                          @RequestParam("checkout") java.sql.Date checkout,
                                          @RequestParam("room") int room) {
        List<Booking> book = bookingServices.getAvailableForRoom(room, checkin, checkout);
        if(!book.isEmpty()){
            return ResponseEntity.ok(book);
        }
        return ResponseEntity.ok(null);
    }

    @GetMapping("/room")
    public ResponseEntity<?> roomList() throws ParseException{
        Calendar calendar = Calendar.getInstance();
        Date checkinDate = calendar.getTime();
        calendar.add(Calendar.DATE, +10);
        Date checkoutDate = calendar.getTime();
        List<Room> rooms = quanLyPhongService.findValidRoomDeafult(checkinDate, checkoutDate);
        List<RoomDto> roomDtos = rooms.stream().map(room -> {
            RoomDto roomDto = new RoomDto();
            roomDto.setMaPhong(room.getMaPhong());
            roomDto.setGiaPhong(room.getGiaPhong());
            roomDto.setSoPhong(room.getSoPhong());
            roomDto.setTang(room.getTang());
            roomDto.setTrangThai(room.getTrangThai());

            RoomTypeDto roomTypeDto = new RoomTypeDto();
            roomTypeDto.setMaLoaiPhong(room.getLoaiPhong().getMaLoaiPhong());
            roomTypeDto.setTenLoaiPhong(room.getLoaiPhong().getTenLoaiPhong());
            roomTypeDto.setMoTa(room.getLoaiPhong().getMoTa());

            roomDto.setLoaiPhong(roomTypeDto);
            roomDto.setGiaPhongGioDau(room.getGiaPhongGioDau());
            roomDto.setHinhAnh("/hinh/phong/"+room.getHinhAnh());
            roomDto.setKhuyenMai(room.getKhuyenMai());
            roomDto.setTienNghi(room.getTienNghi());
            roomDto.setGiaPhongGioSau(room.getGiaPhongGioSau());
            return roomDto;
        }).collect(Collectors.toList());
        return ResponseEntity.ok(roomDtos.subList(0,20));
    }
    @GetMapping("/room/{id}")
    public ResponseEntity<?> roomById(@PathVariable int id){
        List<Room> rooms = quanLyPhongService.getByRoomId(id);
        List<RoomDto> roomDtos = rooms.stream().map(room -> {
            RoomDto roomDto = new RoomDto();
            roomDto.setMaPhong(room.getMaPhong());
            roomDto.setGiaPhong(room.getGiaPhong());
            roomDto.setSoPhong(room.getSoPhong());
            roomDto.setTang(room.getTang());
            roomDto.setTrangThai(room.getTrangThai());

            RoomTypeDto roomTypeDto = new RoomTypeDto();
            roomTypeDto.setMaLoaiPhong(room.getLoaiPhong().getMaLoaiPhong());
            roomTypeDto.setTenLoaiPhong(room.getLoaiPhong().getTenLoaiPhong());
            roomTypeDto.setMoTa(room.getLoaiPhong().getMoTa());

            roomDto.setLoaiPhong(roomTypeDto);
            roomDto.setGiaPhongGioDau(room.getGiaPhongGioDau());
            roomDto.setHinhAnh("/hinh/phong/"+room.getHinhAnh());
            roomDto.setKhuyenMai(room.getKhuyenMai());
            roomDto.setTienNghi(room.getTienNghi());
            roomDto.setGiaPhongGioSau(room.getGiaPhongGioSau());
            return roomDto;
        }).collect(Collectors.toList());
        return ResponseEntity.ok(roomDtos);
    }

    @GetMapping("/booking-history")
    public ResponseEntity<?> history(@RequestParam("user") String user){
        List<Booking> history = bookingServices.findByCreatedBy(user);
        return ResponseEntity.ok(history);
    }

    @PostMapping("/booking")
    public ResponseEntity<?> booking(@Validated @RequestBody @ModelAttribute BookingDTO b,String user,
                                        java.sql.Date checkin,java.sql.Date checkout){
        LocalDateTime now = LocalDateTime.now();
        Calendar c1 = Calendar.getInstance();
        Calendar c2 = Calendar.getInstance();
        c1.setTime(checkin);
        c2.setTime(checkout);
        long noDay =  (c2.getTime().getTime() - c1.getTime().getTime()) / (24 * 3600 * 1000);
        if (checkin.compareTo(new Date()) < 0) {
            return ResponseEntity.ok(1);
        }if (checkout.compareTo(checkout) > 0) {
            return ResponseEntity.ok(2);
        }
        if(noDay > 7){
            return ResponseEntity.ok(3);
        }
        if(bookingServices.existsBookingByCheckinout(b.getRoomCode() ,checkin, checkout)){
            return ResponseEntity.ok(4);
        }        
        Double priceDay = b.getTotal() * noDay;

        Booking book = new Booking();
        book.setHoTen(b.getName());
//        book.setSodt(b.getPhoneNumber());
        book.setSoPhong(b.getRoomCode());
        book.setTrangThai(1);
        book.setCheckinDuKien(checkin);
        book.setCheckoutDuKien(checkout);
        book.setCreatedBy(user);
        book.setUpdatedBy(user);
        book.setTongTien(b.getTotal());
        book.setTienCoc(0.0);
        book.setTienDichVu(0.0);
        book.setTienThuePhong(b.getTotal());
        book.setRoomPrice(b.getTotal());
        book.setUpdatedDate(Timestamp.valueOf(now));
        book.setCreatedDate(Timestamp.valueOf(now));
        bookingServices.save(book);
        return ResponseEntity.ok(5);
    }

    @GetMapping("/room-type")
    public ResponseEntity<?> roomType(@RequestParam("type") String type){
        Calendar calendar = Calendar.getInstance();
        Date checkin = calendar.getTime();
        calendar.add(Calendar.DATE, +20);
        Date checkout = calendar.getTime();

        List<Room> rooms = quanLyPhongService.roomType(checkin, checkout,type);
        List<RoomDto> roomDtos = rooms.stream().map(room -> {
            RoomDto roomDto = new RoomDto();
            roomDto.setMaPhong(room.getMaPhong());
            roomDto.setGiaPhong(room.getGiaPhong());
            roomDto.setSoPhong(room.getSoPhong());
            roomDto.setTang(room.getTang());
            roomDto.setTrangThai(room.getTrangThai());

            RoomTypeDto roomTypeDto = new RoomTypeDto();
            roomTypeDto.setMaLoaiPhong(room.getLoaiPhong().getMaLoaiPhong());
            roomTypeDto.setTenLoaiPhong(room.getLoaiPhong().getTenLoaiPhong());
            roomTypeDto.setMoTa(room.getLoaiPhong().getMoTa());

            roomDto.setLoaiPhong(roomTypeDto);
            roomDto.setGiaPhongGioDau(room.getGiaPhongGioDau());
            roomDto.setHinhAnh("/hinh/phong/"+room.getHinhAnh());
            roomDto.setKhuyenMai(room.getKhuyenMai());
            roomDto.setTienNghi(room.getTienNghi());
            roomDto.setGiaPhongGioSau(room.getGiaPhongGioSau());
            return roomDto;
        }).collect(Collectors.toList());
        return ResponseEntity.ok(roomDtos.subList(0,10));
    }
}
