package dao;

import model.Users;

public interface UsersDao {
	Users findByNameAndPass(String name, String pass) throws Exception;

}
