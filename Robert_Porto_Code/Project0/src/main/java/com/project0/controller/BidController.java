package com.project0.controller;

import java.util.List;

import com.project0.model.Bid;
import com.project0.service.BidService;
import com.project0.ui.CustomerMenu;

public class BidController {
	private static CustomerMenu cm = new CustomerMenu();
	private BidService bs;

	public BidController() {
		this(new BidService());
	}

	public BidController(BidService bs) {
		super();
		this.bs = bs;
	}

	public List<Bid> findAll() {
		return bs.findAll();
	}

	public String insert(Bid b) {
		try {
			Bid result = bs.create(b);

			return result.toString();

		} catch (Exception e) {

			return e.getMessage();
		}

	}

	public int delete(Bid b) {
		return bs.delete(b);
	}

	public int deleteAllForCar(Integer carId) {
		return bs.deleteAllForCar(carId);
	}

	public Bid findById(Integer id) {
		return bs.findById(id);
	}

}
