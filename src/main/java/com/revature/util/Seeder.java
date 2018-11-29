package com.revature.util;

import com.revature.beans.Client;
import com.revature.beans.Shoe;
import com.revature.beans.ShoeRequest;
import com.revature.daos.ClientDao;
import com.revature.daos.ClientDaoImp;
import com.revature.daos.ShoeDaoImp;
import com.revature.daos.ShoeRequestDaoImp;

public class Seeder {
	/*
	public static void main(String[] args) {
		
		ShoeDaoImp sd = new ShoeDaoImp();
		ClientDaoImp cd = new ClientDaoImp();
		ShoeRequestDaoImp sr = new ShoeRequestDaoImp();
		
//		10 CLIENTS IN DB
		Client pam = new Client("Shaun", "Marsh", "smarsh@gmail.com", "smarsh", "213 cherry lane", 38383, "USA", "909-999-9999", false, false);
		Client jim = new Client("Steve", "Smith", "ssmith@gmail.com", "ssmith", "100 Bull Drive", 11111, "USA", "393-029-2948", false, false);
		Client stanley = new Client("Michael", "Jackson", "mjackson@gmail.com", "mjackson", "213 cherry lane", 22222, "USA", "223-098-2345", false, false);
		Client dwight = new Client("Dwight", "Schrute", "ds@gmail.com", "password", "213 cherry lane", 38383, "USA", "909-999-9999", false, false);
		Client kevin = new Client("Kevin", "Malone", "kmalone@gmail.com", "password", "213 cherry lane", 38383, "USA", "909-999-9999", false, false);
		Client angela = new Client("Angela", "Martin", "amartin@hotmail.com", "password", "213 cherry lane", 38383, "USA", "909-999-9999", false, false);
		Client merideth = new Client("Merideth", "Palmer", "mpalmer@yahoo.com", "password", "213 cherry lane", 38383, "USA", "909-999-9999", false, false);
		Client kelly = new Client("Kelly", "Kapoor", "kkapoor@yahoo.com", "password", "213 cherry lane", 38383, "USA", "909-999-9999", false, false);
		Client michael = new Client("Michael", "Scott", "mscott@aol.com", "password", "213 cherry lane", 38383, "USA", "909-999-9999", false, false);
		Client craig = new Client("Craig", "Robinson", "crobinson@gmail.com", "password", "213 cherry lane", 38383, "USA", "909-999-9999", false, false);
		Client ellie = new Client("Ellie", "Kemper", "ekemper@gmail.com", "password", "213 cherry lane", 38383, "USA", "909-999-9999", false, false);
		Client pawan = new Client("Pawandeep", "Singh", "ps@gmail.com", "psingh", "111 BULL DRIVE", 10000, "USA", "111-222-3333", true, false);
		
		Client[] clients = {pam, jim, stanley, dwight, kevin, angela, merideth, kelly, michael, craig, ellie, pawan};
		for (Client c : clients) {
			cd.create(c);
		}
		
		
		
//		10 SHOES IN DB
		sd.add(new Shoe(jim, "Classic", "Addidas", 12.5, 245.00, "Red", 0));
		sd.add(new Shoe(pam, "Downshifter", "Nike", 10.0, 50.00, "Green", 0));
		sd.add(new Shoe(stanley, "Air Max Infuriate", "Nike", 12.5, 57.00, "White", 0));
		sd.add(new Shoe(dwight, "Cloadfoam", "Addidas", 10.0, 210.05, "White", 0));
		sd.add(new Shoe(kevin, "Air Jordans", "Nike", 9.5, 1200.0, "Blue", 0));
		sd.add(new Shoe(kelly, "Men's Tanjun Sneakers", "Nike", 10.0, 200.00, "Black", 0));
		sd.add(new Shoe(michael, "Shox Gravity Running Shoes", "Nike", 8.5, 150.0, "Grey", 0));
		sd.add(new Shoe(ellie, "Men's Air Max 90", "Nike", 9.5, 59.00, "Blue", 0));
		sd.add(new Shoe(jim, "Air Force", "Nike", 13.0, 49.95, "Green", 0));
		sd.add(new Shoe(craig, "Men's Cour Borough", "Nike", 12.0, 39.94, "Black", 0));
		sd.add(new Shoe(craig, "Men's 574 V2", "New Balance", 8.5, 40.94, "Blue", 0));
		sd.add(new Shoe(michael, "Skylon 2", "Nike", 10.0, 640.00, "Yellow", 0));
		
		Shoe nikes = sd.getOneShoe(new Shoe(4));
		Shoe airJs = sd.getOneShoe(new Shoe(9));
		ShoeRequest shoreq = new ShoeRequest(jim, dwight, nikes, airJs, "I'd love to trade shoes with you Jim.");
//		ShoeRequest resolved = new ShoeRequest(1, pam, jim, nikes, airJs, "I'd love to trade shoes with you Jim.");
		sr.add(shoreq);
		
		sr.add(new ShoeRequest(jim, craig, sd.getOneShoe(new Shoe(10)), sd.getOneShoe(new Shoe(1)), "Let's swap homie."));
		sr.add(new ShoeRequest(pam, craig, sd.getOneShoe(new Shoe(11)), sd.getOneShoe(new Shoe(2)), "Yo dog, I like those kicks."));
		sr.add(new ShoeRequest(jim, stanley, sd.getOneShoe(new Shoe(3)), sd.getOneShoe(new Shoe(9)), "Gotta have them pumps, son."));
		sr.add(new ShoeRequest(stanley, michael, sd.getOneShoe(new Shoe(12)), sd.getOneShoe(new Shoe(3)), "These are so beautiful!"));
		sr.add(new ShoeRequest(michael, jim, sd.getOneShoe(new Shoe(1)), sd.getOneShoe(new Shoe(7)), "DM me bro."));
		sr.add(new ShoeRequest(michael, ellie, sd.getOneShoe(new Shoe(8)), sd.getOneShoe(new Shoe(12)), "Oh snap! The Skylons?  Yes please."));
		sr.add(new ShoeRequest(craig, kevin, sd.getOneShoe(new Shoe(5)), sd.getOneShoe(new Shoe(10)), "Air Jordans, aww yessss."));
		sr.add(new ShoeRequest(pam, jim, sd.getOneShoe(new Shoe(9)), sd.getOneShoe(new Shoe(2)), "Can we trade shoes?"));
		sr.add(new ShoeRequest(pam, craig, sd.getOneShoe(new Shoe(11)), sd.getOneShoe(new Shoe(2)), "Is that you, Craig?"));
	}
	*/
}
