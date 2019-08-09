package com.bae.entity;

import java.util.Date;

public class SearchLog {

	private long id;

	private String name;

	private int memberNumber;

	private String searchTerm;
	private Date date;

	public SearchLog() {

	}

	public SearchLog(User user, String searchTerm, Date date) {
		this.id = user.getId();
		this.name = user.getName();
		this.memberNumber = user.getMemberNumber();
		this.searchTerm = searchTerm;
		this.date = date;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getMemberNumber() {
		return memberNumber;
	}

	public void setMemberNumber(int memberNumber) {
		this.memberNumber = memberNumber;
	}

	public String getSearchTerm() {
		return searchTerm;
	}

	public void setSearchResult(String searchTerm) {
		this.searchTerm = searchTerm;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

}
