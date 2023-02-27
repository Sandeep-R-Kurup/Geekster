package com.SandeepRKurup.UM_App.Service;

import com.SandeepRKurup.UM_App.Deo.umsRepository;
import com.SandeepRKurup.UM_App.Model.umsApp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class umsService {

    @Autowired
    umsRepository umsRepository;

    public List<umsApp> findUser(Integer userId){
        List<umsApp> allUsers;
        List<umsApp> selecteduser;
        if(userId!=null){
            selecteduser=new ArrayList<>();
            selecteduser.add(umsRepository.getById(userId));
        }
        else{
            allUsers=umsRepository.findAll();
            return allUsers;
        }
        return selecteduser;
    }

    public umsApp addUser(umsApp ums){
        return umsRepository.save(ums);
    }

    public void updateUser(int userId, umsApp newums){
        umsApp ums=umsRepository.getReferenceById(userId);
        ums.setUserId(newums.getUserId());
        ums.setUserName(newums.getUserName());
        ums.setDob(newums.getDob());
        ums.setEmail(newums.getEmail());
        ums.setPhoneNumber(newums.getPhoneNumber());
        ums.setDate(newums.getDate());
        ums.setTime(newums.getTime());
        umsRepository.save(ums);
    }

    public void deleteUser(int userId){
        umsRepository.deleteById(userId);
    }


}
