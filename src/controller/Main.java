package controller;

import java.io.IOException;

import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.GetMutterListLogic;
import model.Mutter;
import model.PostMutterLogic;
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

		GetMutterListLogic getMutterListLogic = new GetMutterListLogic();
		try {
			List<Mutter> mutterList = getMutterListLogic.execute();

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
		String text = request.getParameter("text");
		try {

			if (text != null && text.length() != 0) {
				HttpSession session = request.getSession();
				User loginUser = (User) session.getAttribute("loginUser");

				Mutter mutter = new Mutter(0, loginUser.getName(), text);
				PostMutterLogic postmutterlogic = new PostMutterLogic();

				postmutterlogic.execute(mutter);

			} else {
				request.setAttribute("errorMsg", "つぶやきが入力されていません");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			GetMutterListLogic getMutterListLogic = new GetMutterListLogic();
			List<Mutter> mutterList;
			mutterList = getMutterListLogic.execute();

			request.setAttribute("mutterList", mutterList);
			request.getRequestDispatcher("/WEB-INF/view/main.jsp").forward(request, response);
		} catch (Exception e) {

			e.printStackTrace();
		}
	}

}