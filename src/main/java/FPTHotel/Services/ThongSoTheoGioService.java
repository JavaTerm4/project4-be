package FPTHotel.Services;

import org.springframework.data.repository.CrudRepository;

import FPTHotel.Model.HourlyParameters;

public interface ThongSoTheoGioService extends CrudRepository<HourlyParameters, Integer> {

}
