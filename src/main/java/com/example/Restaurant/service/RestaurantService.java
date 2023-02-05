package com.example.Restaurant.service;

import com.example.Restaurant.model.ResturantModel;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

@Service
public class RestaurantService {

    private static List<ResturantModel> resturantModels =new ArrayList<>();
    private static int restaurantCount=0;

    static {
        resturantModels.add(new ResturantModel(++restaurantCount,"Malabar Hotel","Parumala jn,,Kerala",906479112,"Arabian"));
        resturantModels.add(new ResturantModel(++restaurantCount,"Aaryas Restaurant","Parumala jn,Kerala",805408712,"Vegetarian"));
        resturantModels.add(new ResturantModel(++restaurantCount,"Arabian Grills","Mannar,Kerala",99735990,"Arabian"));
        resturantModels.add(new ResturantModel(++restaurantCount,"Pillechante Thattukada","Parumala,Kerala",908262812,"Street"));
    }

    public List<ResturantModel> findAll(){
        return resturantModels;
    }

    public ResturantModel findRestaurantByName(String name){
        Predicate<? super ResturantModel> predicate= resturantModel -> resturantModel.getName()==name;
        ResturantModel resturantModel = resturantModels.stream().filter(predicate).findFirst().get();
        return resturantModel;
    }

    public void addRestaurant(ResturantModel resturantModel){
        resturantModels.add(resturantModel);
    }

    public void deleteRestaurant(String name){
        Predicate<? super ResturantModel> predicate= resturantModel -> resturantModel.getName()==name;
        resturantModels.removeIf(predicate);
    }

    public void updateRestaurant(String name, ResturantModel newrestaurant){
        ResturantModel resturantModel =findRestaurantByName(name);
        resturantModel.setId(newrestaurant.getId());
        resturantModel.setAddress(resturantModel.getAddress());
        resturantModel.setName(resturantModel.getName());
        resturantModel.setNumber(resturantModel.getNumber());
        resturantModel.setSpeciality(resturantModel.getSpeciality());
    }
}