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
import fr.tbr.iamcore.exception.DAOSaveException;
import fr.tbr.iamcore.service.dao.UserDAOInterface;

/**
 * Servlet implementation class UserRegister
 */

@WebServlet(name = "UserRegister", urlPatterns = "/Register")
public class UserRegister extends GenericSpringServlet {
	private static final long serialVersionUID = 1L;

	@Inject
	UserDAOInterface dao;

	IAMLogger logger = IAMLogManager.getIAMLogger(UserRegister.class);

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UserRegister() {
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
		doGet(request, response);

		String userName = request.getParameter("userName");
		String password = request.getParameter("password");

		try {
			dao.saveUser(new User(userName, password));
			response.sendRedirect("registerUser.jsp?error=registrationSuccessful");
		} catch (DAOSaveException e) {
			logger.info(e.getMessage());
			e.printStackTrace();
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
