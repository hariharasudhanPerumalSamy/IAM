package fr.tbr.iam.web.servlets;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

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
import fr.tbr.iamcore.datamodel.Identity;
import fr.tbr.iamcore.exception.DAOSaveException;
import fr.tbr.iamcore.exception.DAOUpdateException;
import fr.tbr.iamcore.service.dao.IdentityDAOInterface;

/**
 * Servlet implementation class Login
 */

@WebServlet(name = "IdentityServlet", urlPatterns = "/IdAction")
public class IdentityServlet extends GenericSpringServlet {
	private static final long serialVersionUID = 1L;
	private static final String ATTRIBUTE = "identity";

	
	@Inject
	IdentityDAOInterface dao;
	
	IAMLogger logger = IAMLogManager.getIAMLogger(IdentityServlet.class);

	/**
	 * Default constructor.
	 */
	public IdentityServlet() {
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
		
		//getting identity from the session for the purpose of update
		Identity id = (Identity)request.getSession().getAttribute(ATTRIBUTE);
		request.getSession().removeAttribute(ATTRIBUTE);
		
		String displayName = request.getParameter("displayName");
		String email = request.getParameter("email");
		String birthDate = request.getParameter("birthDate");
		DateFormat df = new SimpleDateFormat("MM/dd/yyyy",Locale.ENGLISH);
		Date bDate = null;
		try {
			bDate = new java.sql.Date(df.parse(birthDate).getTime());
		} catch (ParseException e1) {
			logger.info(e1.getMessage());
			e1.printStackTrace();
		}
		String uid = request.getParameter("uid");
		if(id != null && id.getId() != 0){
			id.setDisplayName(displayName);
			id.setEmail(email);
			id.setBirthDate(bDate);
			id.setUid(uid);

		}
		
		try {
			if(id != null && id.getId() != 0){
				dao.update(id);
				response.sendRedirect("search.jsp?msg=updateSuccessful");
			}else{
				if(!"".equals(email)){
					
					dao.save(new Identity(displayName, email, uid, bDate));
					response.sendRedirect("welcome.jsp?msg=saveSuccessful");
				}else{
					Identity identity = new Identity(displayName, email, uid, bDate);
					request.getSession().setAttribute(ATTRIBUTE, identity);
					response.sendRedirect("create.jsp?msg=saveUnSuccessful");
				}
				
			}
		} catch (DAOSaveException | DAOUpdateException e) {
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
