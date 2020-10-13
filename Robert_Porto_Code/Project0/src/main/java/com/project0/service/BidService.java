package com.project0.service;

import java.util.List;

import com.project0.model.Bid;
import com.project0.repo.BidDao;

public class BidService {
	private BidDao bd;

	public BidService() {
		this(new BidDao());
	}

	public BidService(BidDao bd) {
		super();
		this.bd = bd;
	}

	public List<Bid> findAll() {
		return bd.findAll();
	}

	public Bid create(Bid b) throws Exception {
		Bid result = bd.create(b);
		if (result == null) {
			throw new Exception("the bid was not created");
		} else {
			System.out.println("Bid created!");
		}
		return result;
	}

	public int delete(Bid b) {
		return bd.delete(b);
	}

	public int deleteAllForCar(Integer carId) {
		return bd.deleteAllForCar(carId);
	}

	public Bid findById(Integer id) {
		return bd.findById(id);
	}

}
