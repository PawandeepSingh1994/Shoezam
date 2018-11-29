package com.revature.util;

import java.util.Arrays;
import java.util.List;

import org.hibernate.Session;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.revature.beans.Client;
import com.revature.beans.Shoe;
import com.revature.beans.ShoeRequest;
import com.revature.daos.ClientDaoImp;
import com.revature.daos.ShoeDaoImp;
import com.revature.daos.ShoeRequestDaoImp;

public class Driver {

	public static void main(String[] args) {
		Session session = HibernateUtil.getSession();
		session.close();
//		
		//ClientDaoImp cd = ClientDaoImp.getInstance();
//		ShoeDaoImp sd = new ShoeDaoImp();
//		ShoeRequestDaoImp sr = new ShoeRequestDaoImp();
//		
//		Client client = new Client("jh@dundermifflin.biz", "password");
//		Client c = cd.get(client);
//		System.out.println(c);
//		testing create client
//		Client pam = new Client("Pam", "Beasely", "pamb@pratinstitutde.edu", "password", "213 cherry lane", 38383, "USA", "909-999-9999");
//		Client jim = new Client("Jim", "Halpern", "jh@dundermifflin.biz", "password", "213 cherry lane", 38383, "USA", "909-999-9999");
//		ClientDaoImp.getInstance().create(jim);
//		cd.create(pam);
//		List<Client> clients = cd.getAll();
//		System.out.println("Clients fetched from DB: " + clients);
//		System.out.println("Client fetched from DB:  "+ gotten);
//		Give jim some shoes
//		sd.add(new Shoe(jim, "Air Jordans", "Nike", 8.5, 300.70, "Yellow", 0));
//		List<Shoe> shoes = sd.getAll();
//		System.out.println("Shoes fetched from db: " + shoes);
//		sd.add(new Shoe(jim, "Classic", "Addidas", 12.5, 245.00, "Red", 0));
//		sd.add(new Shoe(jim, "Downshifter", "Nike", 10.0, 50.00, "Green", 1));
//		sd.add(new Shoe(jim, "Air Max Infuriate", "Nike", 12.5, 57.00, "White", 0));
//		sd.add(new Shoe(jim, "Cloadfoam", "Addidas", 10.0, 210.05, "White", 0));
//		sd.add(new Shoe(pam, "Air Jordans", "Nike", 9.5, 1200.0, "Blue", 0));
//		List<Shoe> testShoes = new ArrayList<>();
	
//		get one shoe SUCCESS!
//		Shoe fetched = sd.getOneShoe(new Shoe(3));
//		System.out.println("Fetched on shoe from DB: " + fetched);
//		edit shoe SUCCESS!
//		sd.update(new Shoe(3, jim, "Air Max Infuriate", "Nike", 12.5, 4000.00, "Maroon"));
//		Shoe edited = sd.getOneShoe(new Shoe(3));
//		System.out.println("Edited shoe: " + edited);
//		testShoes = sd.getAll();
//		remove a shoe SUCCESS
//		sd.remove(new Shoe(3));
		
		
//		System.out.println(sd.getAll());
//		get shoes by color: SUCCESS!
//		System.out.println(sd.getByColor("white"));
//		get shoes by brand: SUCCESS!
//		System.out.println(sd.getByBrand("Nike"));
//		get shoes in price range: SUCCESS!
//		System.out.println(sd.getByPricerange(49.00, 250.00));
//		get shoes in size range:
//		System.out.println(sd.getBySizerange(8.0, 11.0));
		
//		********* Shoe requests *********
//		make a new request for a shoe: SUCCESS!
//		Shoe nikes = sd.getOneShoe(new Shoe(1));
//		Shoe airJs = sd.getOneShoe(new Shoe(6));
//		ShoeRequest shoreq = new ShoeRequest(jim, pam, nikes, airJs, "I'd love to trade shoes with you Jim.");
//		ShoeRequest resolved = new ShoeRequest(1, pam, jim, nikes, airJs, "I'd love to trade shoes with you Jim.");
//		sr.add(shoreq);
//		approve a request: SUCCESS!
//		boolean success = sr.resolve(resolved);
//		System.out.println(success);
//		deny a request: SUCCESS!
//		ShoeRequest denied = new ShoeRequest(1, pam, jim, nikes, airJs, "I'd love to trade shoes with you Jim.");
//		boolean success = sr.deny(denied);
		
//		testing spring IOC container/
//		ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
//		System.out.println("Bean names: " +
//		Arrays.toString(ac.getBeanNamesForType(Client.class)));
//		Client c = (Client) ac.getBean("client");
//		c.methodInClientToTestAutomagic();
//		ApplicationContext ac = new ClassPathXmlApplicationContext("src/main/webapp/WEB-INF/beans.xml");
//		System.out.println("Bean names: " +
//				Arrays.toString(ac.getBeanDefinitionNames()));
		
//		Object toLogin = ClientDaoImp.getInstance().login(new Client("jh@dundermifflin.biz", "password"));
//		System.out.println(toLogin);
		
		//cd.update(new Client("Pam", "Beasely", "pamb@pratinstitutde.edu", "password", "213 potato lane", 38383, "USA", "909-999-9999"));
	}
}
