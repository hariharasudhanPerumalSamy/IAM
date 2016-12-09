package fr.tbr.iam.web.servlets;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.tbr.iam.log.IAMLogger;
import fr.tbr.iam.log.impl.IAMLogManager;
import fr.tbr.iamcore.datamodel.Identity;
import fr.tbr.iamcore.exception.DAODeleteException;
import fr.tbr.iamcore.service.dao.IdentityDAOInterface;

/**
 * Servlet implementation class EditIdentity
 */

@WebServlet(name = "EditIdentity", urlPatterns = "/EditIdentity")
public class EditIdentity extends GenericSpringServlet {
	private static final long serialVersionUID = 1L;

	private static final String PARAMETER = "selection";

	IAMLogger logger = IAMLogManager.getIAMLogger(EditIdentity.class);

	@Inject
	IdentityDAOInterface dao;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EditIdentity() {
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
		if ("modify".equals(request.getParameter("edit")) && request.getParameter(PARAMETER) != null) {
			///// Modify button process: set the single Identity record as an
			///// attribute and pass it to create.jsp
			Identity id = dao.getIdentity(Long.valueOf(request.getParameter(PARAMETER)));
			logger.info(id.toString());
			request.getSession().setAttribute("identity", id);
			request.getRequestDispatcher("create.jsp?msg=").forward(request, response);

		} else if ("delete".equals(request.getParameter("edit")) && request.getParameter(PARAMETER) != null) {
			// Delete is stright forward, pass the identity to dao.delete
			if (request.getParameter(PARAMETER) != null) {
				Identity id = dao.getIdentity(Long.valueOf(request.getParameter(PARAMETER)));
				logger.info(id.toString());
				try {

					dao.delete(id);
					response.sendRedirect("search.jsp?msg=deleteSuccessful");

				} catch (DAODeleteException e) {
					logger.info(e.getMessage());
					e.printStackTrace();
				}

			}
		} else {
			response.sendRedirect("search.jsp?msg=");
		}
	}

}
