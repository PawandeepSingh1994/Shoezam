package com.revature.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(value="prototype")
@Entity
public class Shoe {
	
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="shoeIdSequence")
	@SequenceGenerator(name="shoeIdSequence", allocationSize=1, sequenceName="SEQ_SHOE_ID")
	@Column(name="SHOE_ID")
	@Id
	private Integer id;
	
	/** Unidirectional association via foreign key*/
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "client_id", nullable = false)
	@Autowired
	private Client client;
	
	@Column
	private String title;
	@Column
	private String brand;
	@Column
	private Double shoeSize;
	@Column
	private Double price;
	@Column
	private String color;
	@Column
	private Integer shoeStatus;
	
	
	/** Constructor for returning failed queries*/
	
	public Shoe() {
		super();
	}
	
	/** Constructor for adding a new shoe from client side*/
	
	public Shoe(Client client, String title, String brand, Double size, Double price, String color, Integer shoeStatus) {
		super();
		this.title 	= title;
		this.client	= client;
		this.brand	= brand;
		this.shoeSize	= size;
		this.price	= price;
		this.color	= color;
		this.shoeStatus = shoeStatus;
	}
	/** Constructor for fetching a shoe by id*/
		
	public Shoe(Integer id) {
		super();
		this.id = id;
	}
	
	/** Constructor for making bean from database query*/
	public Shoe(Integer shoeid, Client client, String title, String brand, Double size, Double price, String color, Integer shoeStatus) {
		super();
		this.id	= shoeid;
		this.client	= client;
		this.title = title;
		this.brand	= brand;
		this.shoeSize	= size;
		this.price	= price;
		this.color	= color;
		this.shoeStatus = shoeStatus;
	}
	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Integer getShoeid() {
		return id;
	}
	public void setShoeid(Integer shoeid) {
		this.id = shoeid;
	}
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public Double getShoeSize() {
		return shoeSize;
	}
	public void setShoeSize(Double size) {
		this.shoeSize = size;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public Integer getShoeStatus() {
		return shoeStatus;
	}

	public void setShoeStatus(Integer shoeStatus) {
		this.shoeStatus = shoeStatus;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result	= prime * result + ((brand == null) ? 0 : brand.hashCode());
		result	= prime * result + ((color == null) ? 0 : color.hashCode());
		result	= prime * result + ((price == null) ? 0 : price.hashCode());
		result	= prime * result + ((id == null) ? 0 : id.hashCode());
		result	= prime * result + ((shoeSize == null) ? 0 : shoeSize.hashCode());
		result	= prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Shoe other = (Shoe) obj;
		if (brand == null) {
			if (other.brand != null)
				return false;
		} else if (!brand.equals(other.brand))
			return false;
		if (color == null) {
			if (other.color != null)
				return false;
		} else if (!color.equals(other.color))
			return false;
		if (price == null) {
			if (other.price != null)
				return false;
		} else if (!price.equals(other.price))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (shoeSize == null) {
			if (other.shoeSize != null)
				return false;
		} else if (!shoeSize.equals(other.shoeSize))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Shoe [id=" + id + ", client=" + client + ", title=" + title + ", brand=" + brand + ", shoeSize="
				+ shoeSize + ", price=" + price + ", color=" + color + ", shoeStatus=" + shoeStatus + "]";
	}

}
