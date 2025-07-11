package com.orsys.formation.services;

import com.orsys.formation.dao.UserDAO;
import com.orsys.formation.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDAO userDAO;

    @Override
    public User generateApikey(String username) {
        return userDAO.save(new User(username));
    }

    @Override
    public Boolean isValidApikey(String apikey) {
        return userDAO.findByApikey(apikey).isPresent();
    }
}
