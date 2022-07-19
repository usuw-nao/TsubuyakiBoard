package dao;

import java.util.List;

import model.Mutter;

public interface MutterDao {
	List<Mutter> findAll() throws Exception;

	Mutter findById(int id) throws Exception;

	void insert(Mutter mutter) throws Exception;

	void updated(Mutter mutter) throws Exception;

	void delete(Mutter mutter) throws Exception;

	boolean create(Mutter mutter) throws Exception;

}