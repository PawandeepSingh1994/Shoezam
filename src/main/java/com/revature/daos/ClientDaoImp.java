package com.revature.daos;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import com.revature.beans.Client;
import com.revature.util.HibernateUtil;

@Repository
public class ClientDaoImp implements ClientDao {
	

	@Override
	public Client get(Client client) {
		Session s = HibernateUtil.getSession();
		Client user = (Client) s.get(Client.class, client.getEmail());
		return user;
	}

	@Override  
	public List<Client> getAll() {
		Session s = HibernateUtil.getSession();
		List<Client> clients = s.createQuery("from Client").list();
		s.close();
		return clients;
	}

	@Override
	public void remove(Client client) {
		Session s = HibernateUtil.getSession();
		Transaction tx = s.beginTransaction();
		s.delete(client);
		tx.commit();
		s.close();
	}

	@Override
	public int create(Client client) {
		System.out.println("In the client dao, the "
				+ "client object we want to persist--------->" + client);
		Session s = HibernateUtil.getSession();
		Transaction tx = s.beginTransaction();
//		Client c = new Client();
//		c.setAddress(client.getAddress());
//		c.setCountry(client.getCountry());
//		c.setEmail(client.getEmail());
//		c.setFirstName(client.getFirstName());
//		c.setIsAdmin(client.getIsAdmin());
//		c.setIsBlocked(client.getIsBlocked());
//		c.setLastName(client.getLastName());
//		c.setPass(client.getPass());
//		c.setPhoneNumber(client.getPhoneNumber());
//		c.setPostalCode(client.getPostalCode());
//		c.setId(0);
		s.save(client);
//		Query<Client> checkClient = s.createQuery("from Client c where c.email=:email")
//		.setParameter("name", client.getEmail())
//		.setResultTransformer(Transformers.aliasToBean(Client.class));
		tx.commit();
		s.close();
//		int success = checkClient.getSingleResult().getId();
//		if (success > 0) {
//			return success;
//		}
		return 0;
	}

	@Override
	public Client update(Client client) {
		Session s = HibernateUtil.getSession();
		Transaction tx = s.beginTransaction();
		s.update(client);
		tx.commit();
		s.close();
		return client;
	}
	@Override
	public Client login(Client client) {
		Session s = HibernateUtil.getSession();
		System.out.println("clients email for login: " + client.getEmail());
		System.out.println("clients password for login: " + client.getPass());
//		Client c = (Client) s.createCriteria(Client.class).add(Example.create(client));1
//		String hql = "from Client where email = :email and pass = :pass";
//		Client found = (Client) s.createQuery(hql).setParameter("email", client.getEmail()).setParameter("pass", client.getPass());
//		Client found = (Client) s.createNativeQuery("SELECT * FROM CLIENT C WHERE C.EMAIL = ? AND C.PASS = ?", Client.class)
//				.setParameter(1, client.getEmail())
//				.setParameter(2, client.getPass());
		Query q = s.createQuery("from Client c where c.email = :email and c.pass = :pass")
								.setParameter("email", client.getEmail())
								.setParameter("pass", client.getPass());
		Client c = (Client) q.getSingleResult();
		s.close();
		System.out.println(c.toString());
		return c;
//		Client c = s.get(Client.class, client.getEmail());
//		System.out.println(c);
//		Client cC = (Client) c;
//		if (c != null) {
//			return c;
//		}
//		if (c.getEmail() != null) {
//			if (c.getPass().equals(client.getPass())) {
//				return c;
//			}
//		}
//		if (client.getPass().equals(c.getPass())) {
//			System.out.println("Client: " + c);
//			return c;
//		}
//		return null;
	}

}
