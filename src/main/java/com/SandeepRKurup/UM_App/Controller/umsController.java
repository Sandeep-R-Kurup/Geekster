package com.SandeepRKurup.UM_App.Controller;

import com.SandeepRKurup.UM_App.Model.umsApp;
import com.SandeepRKurup.UM_App.Service.umsService;
import jakarta.annotation.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
public class umsController {
    @Autowired
    umsService umsService;
    @GetMapping("/user")
    public List<umsApp> findUser(@Nullable @RequestParam Integer userId){
        return umsService.findUser(userId);
    }

    @PutMapping("/user")
    public ResponseEntity<String> updateUser(@RequestParam Integer userId, @RequestParam umsApp ums){
        umsService.updateUser(userId,ums);
        return new ResponseEntity<>("User updated successfully", HttpStatus.OK);
    }

    @DeleteMapping("/user")
    public ResponseEntity<String> deleteUser(@RequestParam Integer userId){
        umsService.deleteUser(userId);
        return new ResponseEntity<>("User deleted successfully",HttpStatus.OK);
    }

    @PostMapping("/user")
    public ResponseEntity<String> addUser(@RequestBody String requestUser){
        JSONObject json=new JSONObject(requestUser);
        List<String> validated =validateUser(json);
        if(validated.isEmpty()){
            umsApp user=setUser(json);
            umsService.addUser(user);
            return new ResponseEntity<>("User saved", HttpStatus.CREATED);
        }
        else {
            String[] answer= Arrays.copyOf(validated.toArray(),validated.size(),String[].class);
            return new ResponseEntity<>("Please add these mandatory parameters "+Arrays.toString(answer), HttpStatus.BAD_REQUEST);
        }
    }

    public umsApp setUser(JSONObject json){
        umsApp user= new umsApp();

        int userId= json.getInt("userId");
        user.setUserId(userId);
        String userName= json.getString("userName");
        user.setUserName(userName);
        String dob= json.getString("dob");
        user.setDob(dob);
        String email= json.getString("email");
        user.setEmail(email);
        String phone= json.getString("phoneNumber");
        user.setPhoneNumber(phone);

        long millis=System.currentTimeMillis();
        java.sql.Date date = new java.sql.Date(millis);
        user.setDate(date);

        java.sql.Time time=new java.sql.Time(millis);
        user.setTime(time);

        return user;
    }
    public List<String> validateUser(JSONObject json){
        List<String> errorlist= new ArrayList<>();
        if(!json.has("userId")){
            errorlist.add("userId");
        }
        if(!json.has("userName")){
            errorlist.add("userName");
        }
        if(!json.has("dob")){
            errorlist.add("dob");
        }
        if(json.getString("dob").charAt(2)!='-' || json.getString("dob").charAt(5)!='-'){
            errorlist.add("dob format is wrong");
        }
        if(!json.has("email")){
            errorlist.add("email");
        }
        if(!json.has("phoneNumber")){
            errorlist.add("phoneNumber");
        }
        if( json.getString("phoneNumber").length()!=12){
            errorlist.add("phoneNumber format error");
        }
        return errorlist;
    }
}
