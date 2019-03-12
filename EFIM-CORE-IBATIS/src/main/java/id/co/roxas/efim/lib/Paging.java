package id.co.roxas.efim.lib;

import java.io.Serializable;

public class Paging implements Serializable{
	private static final long serialVersionUID = 4389828490456129845L;

	private int page;
	private int composition;
	private String orderBy;
	private String direction;
	
	public Paging(int page, int composition, String orderBy, String direction) {
		this.page = page;
		this.composition = composition;
		this.orderBy = orderBy;
		this.direction = direction;
	}
	public int getPage() {
		return page;
	}
	public int getComposition() {
		return composition;
	}
	public String getOrderBy() {
		return orderBy;
	}
	public String getDirection() {
		return direction;
	}
	
	
	
}
