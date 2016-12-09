package fr.tbr.iam.web.servlets;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import fr.tbr.iam.log.IAMLogger;
import fr.tbr.iam.log.impl.IAMLogManager;
import fr.tbr.iamcore.datamodel.User;
import fr.tbr.iamcore.exception.DAOSearchException;
import fr.tbr.iamcore.service.dao.UserDAOInterface;

/**
 * Servlet implementation class Login
 */

@WebServlet(name = "Login", urlPatterns = "/Login")
public class Login extends GenericSpringServlet {
	private static final long serialVersionUID = 1L;

	@Inject
	UserDAOInterface dao;

	IAMLogger logger = IAMLogManager.getIAMLogger(Login.class);

	/**
	 * Default constructor.
	 */
	public Login() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String login = request.getParameter("login");
		String password = request.getParameter("password");

		logger.debug(login);
		logger.debug(password);

		boolean bol = false;
		try {
			bol = dao.authenticate(new User(login, password));
		} catch (DAOSearchException e) {
			logger.info(e.getMessage());
			e.printStackTrace();
		}
		if (bol) {
			response.sendRedirect("welcome.jsp?msg=");
		} else {
			response.sendRedirect("index.jsp?error=error");
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.servlet.GenericServlet#init(javax.servlet.ServletConfig)
	 */
	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this, config.getServletContext());

	}

}
