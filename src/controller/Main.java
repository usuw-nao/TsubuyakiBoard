package controller;

import java.io.IOException;


import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.DaoFactory;
import dao.MutterDao;

import model.Mutter;

import model.User;

/**
 * Servlet implementation class Main
 */
@WebServlet("/main")
public class Main extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//GetMutterListLogic getMutterListLogic = new GetMutterListLogic();
		try {
			//List<Mutter> mutterList = getMutterListLogic.execute();
			MutterDao mutterDao=DaoFactory.createMutterDao();
			List<Mutter> mutterList=mutterDao.findAll();
			request.setAttribute("mutterList", mutterList);

			HttpSession session = request.getSession();
			User loginUser = (User) session.getAttribute("loginUser");
			if (loginUser == null) {
				response.sendRedirect("/docoTsubu/");
			} else {
				request.getRequestDispatcher("/WEB-INF/view/main.jsp").forward(request, response);
			}
		} catch (

		Exception e) {

			throw new ServletException(e);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");		

		try {
			String text = request.getParameter("text");
			MutterDao mutterDao=DaoFactory.createMutterDao();
		List<Mutter> mutterList=mutterDao.findAll();
		request.setAttribute("mutterList", mutterList);

			if (text != null && text.length() != 0) {
				HttpSession session = request.getSession();
				User loginUser = (User) session.getAttribute("loginUser");

				//Mutter mutter = new Mutter(0, loginUser.getName(), text);
				//PostMutterLogic postmutterlogic = new PostMutterLogic();
				//postmutterlogic.execute(mutter);

			} else {
				request.setAttribute("errorMsg", "つぶやきが入力されていません");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			//GetMutterListLogic getMutterListLogic = new GetMutterListLogic();
			//List<Mutter> mutterList;
			//mutterList = getMutterListLogic.execute();

			MutterDao mutterDao=DaoFactory.createMutterDao();
			List<Mutter> mutterList=mutterDao.findAll();
			request.setAttribute("mutterList", mutterList);
			request.getRequestDispatcher("/WEB-INF/view/main.jsp").forward(request, response);
		} catch (Exception e) {

			e.printStackTrace();
		}
	}

}