package FPTHotel.Services;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import FPTHotel.Model.ServiceMenu;

public interface Idv extends CrudRepository<ServiceMenu, Integer>{

	@Query(value = "select sum(total) from servicemenu where ma_dat_phong = ?1", nativeQuery = true)
	Double sumTotalByMaDatPhong(int maDatPhong);

	@Query("SELECT ddv FROM ServiceMenu ddv WHERE ddv.maDatPhong = ?1")
	List<ServiceMenu> datdichvu(int madatphong);
}
