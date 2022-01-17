package ma.dao;

import java.util.List;

import javax.ejb.Local;

import ma.entities.User;

@Local
public interface UserLocal {
	void create(User t);

	void delteById(User t);

	User update(User t);


	List<User> findAll();

	User findById(int i);
}
