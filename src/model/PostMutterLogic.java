package model;

import dao.DaoFactory;
import dao.MutterDao;

public class PostMutterLogic {
	public void execute(Mutter mutter) throws Exception {
		MutterDao dao = DaoFactory.createMutterDao();
		dao.create(mutter);

	}

}