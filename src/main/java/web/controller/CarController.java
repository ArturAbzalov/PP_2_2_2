package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.model.Car;
import web.service.CarService;
import web.service.CarServiceImpl;

import java.util.ArrayList;
import java.util.List;

@Controller
public class CarController {

    @GetMapping(value = "/cars")
    public String getCars(@RequestParam(value = "integer", required = false) Integer number, Model model, CarServiceImpl carService) {
        List<Car> listCar = new ArrayList<>();
        listCar.add(new Car("toyota", "red", 30));
        listCar.add(new Car("honda", "black", 320));
        listCar.add(new Car("kia", "orange", 900));
        listCar.add(new Car("bmw", "green", 310));
        listCar.add(new Car("dodge", "red", 390));
        if (number == null || number >= 5) {
            model.addAttribute("ListCar", listCar);
        } else {
            model.addAttribute("ListCar", carService.getCarNumber(listCar, number));
        }
        return "cars";
    }
}
