package by.epam.training.service;

import by.epam.training.dao.impl.UserDaoImpl;
import by.epam.training.entity.User;
import by.epam.training.exception.DaoException;
import by.epam.training.exception.ServiceException;

public class UserService {
    private UserDaoImpl dao = new UserDaoImpl();

    public User loginUser(String login, String password) throws ServiceException {
        User user = new User(login, password);
        try {
            return dao.login(user);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }
}
