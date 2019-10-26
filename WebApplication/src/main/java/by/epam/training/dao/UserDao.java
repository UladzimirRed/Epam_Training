package by.epam.training.dao;

import by.epam.training.entity.User;
import by.epam.training.exception.DaoException;

import java.util.List;

public interface UserDao extends BaseDao<Long, User> {
    List<User> findUserByLastName(String namePatten) throws DaoException;

}
