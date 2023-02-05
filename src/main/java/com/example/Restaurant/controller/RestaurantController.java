package com.example.Restaurant.controller;

import com.example.Restaurant.model.ResturantModel;
import com.example.Restaurant.service.RestaurantService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/Restaurant-app")
public class RestaurantController {

    private final RestaurantService restaurantService;

    public RestaurantController(RestaurantService restaurantService){
        this.restaurantService=restaurantService;
    }

    @PostMapping("/add-Restaurant")
    public void addRestaurant(@RequestBody ResturantModel resturantModel){
        restaurantService.addRestaurant(resturantModel);
    }

    @GetMapping("/find-Restaurant/name/{name}")
    public ResturantModel findRestaurantByName(@PathVariable String name){
        return restaurantService.findRestaurantByName(name);
    }

    @GetMapping("/find-all")
    public List<ResturantModel> findAllRestaurants(){
        return restaurantService.findAll();
    }

    @PutMapping("update-Restaurant/name/{name}")
    public void updateRestaurant(@PathVariable String name,@RequestBody ResturantModel resturantModel){
        restaurantService.updateRestaurant(name, resturantModel);
    }

    @DeleteMapping("delete-Restaurant/name/{name}")
    public void deleteRestaurant(@PathVariable String name){
        restaurantService.deleteRestaurant(name);
    }
}