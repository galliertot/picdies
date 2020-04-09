package com.example.rahsa;

import android.app.Application;
import com.example.rahsa.entities.User;

public class GlobalVariable {

    private static GlobalVariable instance = new GlobalVariable();

    public static GlobalVariable getInstance() {
        return instance;
    }

    public static void setInstance(GlobalVariable instance) {
        GlobalVariable.instance = instance;
    }

    public GlobalVariable(){}

    public User userConnected = null;

    public User getUserConnected(){
        return userConnected;
    }

    public void setUserConnected(User user)
    {
        this.userConnected = user;
    }


}
