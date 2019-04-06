package myTddProject.tddproject.controller;

import myTddProject.tddproject.model.Car;
import myTddProject.tddproject.service.CarService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Maincontroller {

    private CarService carService;

    @GetMapping("/car/{name}")
    public Car getCar(@PathVariable  String name){
       return (new Car("camry", "white"));
    }
}
