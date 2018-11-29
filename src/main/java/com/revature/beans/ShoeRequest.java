package com.revature.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(value="prototype")
@Entity
@Table
public class ShoeRequest {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="shoeRequestIdSequence")
	@SequenceGenerator(name="shoeRequestIdSequence", allocationSize=1, sequenceName="SEQ_SHOE_REQ_ID")
	private Integer shoe_req_id;
	
	@Autowired
	@ManyToOne
	@JoinColumn(name="client_requester_id")
	private Client client_requester;
	
	@Autowired
	@ManyToOne
	@JoinColumn(name="client_owner_id")
	private Client client_owner;
	
	@Autowired
	@ManyToOne
	@JoinColumn(name="shoe_requested_id")
	private Shoe shoe_requested;
	
	@Autowired
	@ManyToOne
	@JoinColumn(name="shoe_to_trade_id")
	private Shoe shoe_to_trade;
	
	@Column
	private Integer status;
	
	@Column
	private String info;
	
	
	
	public ShoeRequest() {
		super();
	}

	/** Constructor for client making new request*/

	public ShoeRequest(Client client_requester, Client client_owner, Shoe shoe_requested, Shoe shoe_to_trade,
			String info) {
		super();
		this.client_requester	= client_requester;
		this.client_owner		= client_owner;
		this.shoe_requested		= shoe_requested;
		this.shoe_to_trade		= shoe_to_trade;
		this.info				= info;
	}



	public ShoeRequest(Integer id, Client client_requester, Client client_owner, Shoe shoe_requested,
			Shoe shoe_to_trade, String comment) {
		super();
		this.shoe_req_id					= id;
		this.client_requester	= client_requester;
		this.client_owner		= client_owner;
		this.shoe_requested		= shoe_requested;
		this.shoe_to_trade		= shoe_to_trade;
		this.info			= comment;
	}





	public Integer getId() {
		return shoe_req_id;
	}



	public void setId(Integer id) {
		this.shoe_req_id = id;
	}



	public Client getClient_requester() {
		return client_requester;
	}



	public void setClient_requester(Client client_requester) {
		this.client_requester = client_requester;
	}



	public Client getClient_owner() {
		return client_owner;
	}



	public void setClient_owner(Client client_owner) {
		this.client_owner = client_owner;
	}



	public Shoe getShoe_requested() {
		return shoe_requested;
	}



	public void setShoe_requested(Shoe shoe_requested) {
		this.shoe_requested = shoe_requested;
	}



	public Shoe getShoe_to_trade() {
		return shoe_to_trade;
	}



	public void setShoe_to_trade(Shoe shoe_to_trade) {
		this.shoe_to_trade = shoe_to_trade;
	}



	public String getInfo() {
		return info;
	}



	public void setInfo(String comment) {
		this.info = comment;
	}


	public Integer getStatus() {
		return status;
	}


	public void setStatus(Integer status) {
		this.status = status;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result	= prime * result + ((client_owner == null) ? 0 : client_owner.hashCode());
		result	= prime * result + ((client_requester == null) ? 0 : client_requester.hashCode());
		result	= prime * result + ((info == null) ? 0 : info.hashCode());
		result	= prime * result + ((shoe_req_id == null) ? 0 : shoe_req_id.hashCode());
		result	= prime * result + ((shoe_requested == null) ? 0 : shoe_requested.hashCode());
		result	= prime * result + ((shoe_to_trade == null) ? 0 : shoe_to_trade.hashCode());
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
		ShoeRequest other = (ShoeRequest) obj;
		if (client_owner == null) {
			if (other.client_owner != null)
				return false;
		} else if (!client_owner.equals(other.client_owner))
			return false;
		if (client_requester == null) {
			if (other.client_requester != null)
				return false;
		} else if (!client_requester.equals(other.client_requester))
			return false;
		if (info == null) {
			if (other.info != null)
				return false;
		} else if (!info.equals(other.info))
			return false;
		if (shoe_req_id == null) {
			if (other.shoe_req_id != null)
				return false;
		} else if (!shoe_req_id.equals(other.shoe_req_id))
			return false;
		if (shoe_requested == null) {
			if (other.shoe_requested != null)
				return false;
		} else if (!shoe_requested.equals(other.shoe_requested))
			return false;
		if (shoe_to_trade == null) {
			if (other.shoe_to_trade != null)
				return false;
		} else if (!shoe_to_trade.equals(other.shoe_to_trade))
			return false;
		return true;
	}
	
	
	
}