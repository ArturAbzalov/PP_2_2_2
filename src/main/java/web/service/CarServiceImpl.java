package web.service;

import org.springframework.stereotype.Service;
import web.model.Car;

import java.util.List;

@Service
public class CarServiceImpl implements CarService {
    @Override
    public List<Car> getCarNumber(List<Car> list, int number) {
        return list.subList(0, number);
    }
}
