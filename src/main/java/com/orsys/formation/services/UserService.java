package com.orsys.formation.services;

import com.orsys.formation.models.Book;
import com.orsys.formation.models.User;
import org.springframework.stereotype.Service;

public interface UserService {

    User generateApikey(String username);

    Boolean isValidApikey(String apikey);
}
