package com.revature.daos;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
//import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import com.revature.beans.Client;
import com.revature.beans.Shoe;
import com.revature.util.HibernateUtil;

@Repository
public class ShoeDaoImp implements ShoeDao {


	@Override
	public List<Shoe> getAll() {
		Session s = HibernateUtil.getSession();
//		Query<Shoe> query = s.createQuery("from Shoe");
		List<Shoe> shoes = s.createQuery("from Shoe").list();
		s.close();
		return shoes;
	}

	@Override
	public List<Shoe> getByColor(String color) {
		color = color.toUpperCase();
		Session s = HibernateUtil.getSession();
		List<Shoe> shoesOfColor = s.createQuery("from Shoe where color like '%"+ color + "'").list();
		s.close();
		return shoesOfColor;
	}

//	@Override
//	public List<Shoe> getByType(String type) {
//		Session s = HibernateUtil.getSession();
//		List<Shoe> shoesofType = s.createQuery("from Shoes where color="+ type).list();
//		s.close();
//		return shoesofType;
//	}

	@Override
	public List<Shoe> getBySize(Double size) {
		Session s = HibernateUtil.getSession();
		List<Shoe> shoesOfSize = s.createQuery("from Shoe where size like '%"+ size + "'").list();
		s.close();
		return shoesOfSize;
	}
	
	

	@Override
	public List<Shoe> getByBrand(String brand) {
		brand = brand.toUpperCase();
		Session s = HibernateUtil.getSession();
		List<Shoe> shoesOfBrand = s.createQuery("from Shoe where brand like '%"+ brand + "'").list();
		s.close();
		return shoesOfBrand;
	}

//	@Override
//	public List<Shoe> getByPricerange(Integer lower_bound, Integer upper_bound) {
//		Session s = HibernateUtil.getSession();
//		CriteriaBuilder cb = s.getCriteriaBuilder();
//		CriteriaQuery<Shoe> cq = cb.createQuery(Shoe.class);
//		Root<Shoe> root = cq.from(Shoe.class);
//		cq.select(root);
//		cq.where(cb.)
//		List<Shoe> shoes = new ArrayList<>();
//		List<Shoe> shoesInPriceRange = s.createCriteria(Shoe.class)
//										.add(Restrictions.ge("price", lower_bound))
//										.add(Restrictions.le("price", upper_bound))
//										.setProjection(Property.forName("price"))
//										.uniqueResult()
//										.list()
//		return shoes;									
//	}

	@Override
	public Shoe getOneShoe(Shoe shoe) {
		Session s = HibernateUtil.getSession();
//		Shoe the_shoe = (Shoe) s.get(Shoe.class, shoe.getId());
//		s.close();
//		System.out.println(the_shoe);
//		return the_shoe;
		Shoe result = (Shoe) s.createQuery("from Shoe WHERE SHOE_ID=:shoe_id")
				.setParameter("shoe_id", shoe.getId()).uniqueResult();
		return result;
	}

	@Override
	public void update(Shoe shoe) {
		Session s = HibernateUtil.getSession();
		Transaction tx = s.beginTransaction();
		Shoe temp = getOneShoe(shoe);
		temp.setShoeStatus(1);
		System.out.println("UPDATED---------------------------------------------UPDATED");
		s.update(temp);
		tx.commit();
		s.close();
		
	}

	@Override
	public void remove(Shoe shoe) {
		Session s = HibernateUtil.getSession();
		Transaction tx = s.beginTransaction();
		s.delete(shoe);
		tx.commit();
		s.close();
	}

	@Override
	public Integer add(Shoe shoe) {
		shoe.setColor(shoe.getColor().toUpperCase());
		shoe.setBrand(shoe.getBrand().toUpperCase());
		
		Session s = HibernateUtil.getSession();
		Transaction tx = s.beginTransaction();
		System.out.println("shoe to add at dao layer? " + shoe);
		Integer id = (Integer) s.save(shoe);
		tx.commit();
		s.close();
		return id;
	}

	@Override
	public List<Shoe> getByPricerange(Double lower_bound, Double upper_bound) {
		Session s = HibernateUtil.getSession();
		String hql = "from Shoe where price between :a and :b";
		List<Shoe> shoesInPriceRange = s.createQuery(hql)
										.setParameter("a", lower_bound)
										.setParameter("b", upper_bound)
										.list();
		s.close();
		return shoesInPriceRange;
	}

	@Override
	public List<Shoe> getBySizerange(Double lower_bound, Double upper_bound) {
		Session s = HibernateUtil.getSession();
		String hql = "from Shoe where shoesize between :a and :b";
		List<Shoe> shoesInRange = s.createQuery(hql)
										.setParameter("a", lower_bound)
										.setParameter("b", upper_bound)
										.list();
		s.close();
		return shoesInRange;
	}
	@Override
	public List<Shoe> getByType(String type) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public List<Shoe> getShoesByClientId(Client client) {
		Session s = HibernateUtil.getSession();
		String hql = "from Shoe where client_id = :id";
		List<Shoe> shoesOfClient = s.createQuery(hql).setParameter("id", client.getId()).list();
		s.close();
		return shoesOfClient;
	}

	@Override
	public List<Shoe> getShoesForSale(Client client) {
		Session s = HibernateUtil.getSession();
		String hql = "from Shoe where client_id <> :id";
		List<Shoe> shoesOfClient = s.createQuery(hql).setParameter("id", client.getId()).list();
		s.close();
		return shoesOfClient;
	}


}
