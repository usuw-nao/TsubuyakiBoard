package model;

import java.util.List;

import dao.DaoFactory;
import dao.MutterDao;

public class GetMutterListLogic {
	public List<Mutter> execute() throws Exception {
		MutterDao dao = DaoFactory.createMutterDao();
		List<Mutter> mutterList = dao.findAll();

		return mutterList;
	}

}