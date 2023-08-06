package com.example.reto3johanrojas.Controller;

import com.example.reto3johanrojas.Model.Car;
import com.example.reto3johanrojas.Service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*" , methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE })
@RestController
@RequestMapping("/api/Car")
public class CarController {
    @Autowired
    private CarService carService;

    @GetMapping("/all")     // ->>>>      localhost.../api/Car/all
    public List<Car> getAll(){
        return carService.getAll();
    }

    @GetMapping("/{id}")  // ->>>> localhost..../api/Car/12
    public Optional<Car> getCar(@PathVariable int id){
        return carService.getCar(id);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Car Save(@RequestBody Car car){
        return carService.save(car);
    }

}
