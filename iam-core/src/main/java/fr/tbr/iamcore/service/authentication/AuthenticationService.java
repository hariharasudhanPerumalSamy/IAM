package fr.tbr.iamcore.service.authentication;

import java.util.Collection;

import javax.inject.Inject;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import fr.tbr.iam.log.IAMLogger;
import fr.tbr.iam.log.impl.IAMLogManager;
import fr.tbr.iamcore.datamodel.User;
import fr.tbr.iamcore.exception.DAOSaveException;
import fr.tbr.iamcore.exception.DAOSearchException;
import fr.tbr.iamcore.service.dao.UserDAOInterface;

public class AuthenticationService implements UserDAOInterface {

	@Inject
	SessionFactory sf;

	private static final IAMLogger logger = IAMLogManager.getIAMLogger(AuthenticationService.class);

	public void setSessionFactory(SessionFactory sf) {
		this.sf = sf;
	}

	public SessionFactory getSessionFactory() {
		return this.sf;
	}

	@Override
	public void saveUser(User user) throws DAOSaveException {
		logger.info("=> save this user : " + user);
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		session.saveOrUpdate(user);
		tx.commit();
		logger.info("<= save ok" );
	}
	
	@Override
	public Collection<User> search(User criteria) throws DAOSearchException {
		String hqlString = "from User as user where user.login = :uName";
		Session session = sf.openSession();
		Query query = session.createQuery(hqlString);
		query.setParameter("uName", criteria.getLogin());
		return (Collection<User>) query.list();
	}

	@Override
	public boolean authenticate(User user) throws DAOSearchException {	
		
		Collection<User> list =  search(user);
		for(User nUser : list){
			if(user.getLogin().equals(nUser.getLogin()) && user.getPassWord().equals(nUser.getPassWord())){
				return true;
			}
		}
		return false;
	}

}
