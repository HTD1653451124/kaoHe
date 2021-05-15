package com.ccj.event.bean;

import com.ccj.event.entity.User;
import com.ccj.event.entity.Worker;

import javax.jws.soap.SOAPBinding;
import java.util.Iterator;
import java.util.Map;

public class UserBean {
    public User  regisUser(Map<String, String[]> map){
        User user = new User();
        Iterator iterator = map.keySet().iterator();
        while (iterator.hasNext()){
            String key = (String) iterator.next();
            String[] value = map.get(key);
            if (key.equals("virname")){
                user.setVirName(value[0]);
            }if (key.equals("account")){
                user.setAccount(value[0]);
            }if (key.equals("password")){
                user.setPassword(value[0]);
            }if (key.equals("gender")){
                user.setGender(value[0]);
            }

        }
        return user;

    }
    public Worker regisWorker(Map<String, String[]> map){
        Worker worker = new Worker();
        Iterator iterator = map.keySet().iterator();
        while (iterator.hasNext()){
            String key = (String) iterator.next();
            String[] value = map.get(key);
            if (key.equals("virname")){
                worker.setVirName(value[0]);
            }if (key.equals("account")){
                worker.setAccount(value[0]);
            }if (key.equals("password")){
                worker.setPassword(value[0]);
            }if (key.equals("gender")){
                worker.setGender(value[0]);
            }
        }
        return worker;
    }
}
