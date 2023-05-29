package Healthy.Healthy.app.service;


import Healthy.Healthy.app.entity.User;

import java.util.List;

public interface UserService {
        void signIn(User user);
        void signUp(User user);
        List<String> getGenderOptions();


}

