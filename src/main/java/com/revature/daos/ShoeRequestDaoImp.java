package com.revature.daos;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import com.revature.beans.Client;
import com.revature.beans.Shoe;
import com.revature.beans.ShoeRequest;
import com.revature.util.HibernateUtil;

@Repository
public class ShoeRequestDaoImp implements ShoeRequestDao {

	@Override
	public boolean add(ShoeRequest shoereq) {
		Session s = HibernateUtil.getSession();
		Transaction tx = s.beginTransaction();
		int saved = (int) s.save(shoereq);
		tx.commit();
		s.close();
		if (saved > 0) {
			return true;
		}
		return false;
	}

	@Override
	public boolean resolve(ShoeRequest shoereq) {
		Session s = HibernateUtil.getSession();
		Transaction tx = s.beginTransaction();
		s.update(shoereq);
		Shoe request = shoereq.getShoe_requested();
		Shoe toTrade = shoereq.getShoe_to_trade();
		shoereq.setStatus(1);
		request.setClient(shoereq.getClient_requester());
		toTrade.setClient(shoereq.getClient_owner());
		request.setShoeStatus(1);
		toTrade.setShoeStatus(1);
		s.update(request);
		s.update(toTrade);
		tx.commit();
		ShoeRequest changed = (ShoeRequest) s.get(ShoeRequest.class, shoereq.getId());
		if (changed.getClient_owner().equals(shoereq.getClient_owner())) {
			return true;
		}
		return false;
	}

	@Override
	public boolean deny(ShoeRequest shoereq) {
		Session s = HibernateUtil.getSession();
		Transaction tx = s.beginTransaction();
		shoereq.setStatus(2);
		s.update(shoereq);
		tx.commit();
		ShoeRequest changed = (ShoeRequest) s.get(ShoeRequest.class, shoereq.getId());
		if (changed.getClient_owner().equals(shoereq.getClient_owner())) {
			return true;
		}
		return false;
	}

	@Override
	public List<ShoeRequest> getAllByShoe(Shoe shoe) {
		Session s = HibernateUtil.getSession();
		String hql = "from ShoeRequest where shoe_requested_id=:id";
		List<ShoeRequest> shoes = s.createQuery(hql).setParameter("id", shoe.getId()).list();
		s.close();
		return shoes;
	}

	@Override
	public List<ShoeRequest> getAllBelongingToClient(Client client) {
		Session s = HibernateUtil.getSession();
		String hql = "from ShoeRequest where client_owner_id=:id";
		List<ShoeRequest> shoes = s.createQuery(hql).setParameter("id", client.getId()).list();
		s.close();
		return shoes;
	}

	@Override
	public List<ShoeRequest> getAllMadeByClient(Client client) {
		Session s = HibernateUtil.getSession();
		String hql = "from ShoeRequest where client_requester_id=:id";
		List<ShoeRequest> shoes = s.createQuery(hql).setParameter("id", client.getId()).list();
		s.close();
		return shoes;
	}

	@Override
	public List<ShoeRequest> getAll() {
		Session s = HibernateUtil.getSession();
		String hql = "from ShoeRequest";
		List<ShoeRequest> shoes = s.createQuery(hql).list();
		s.close();
		return shoes;
	}

}