package com.bae.entity;

public class SearchLog {

	private long id;

	private String name;

	private int memberNumber;

	private String searchTerm;

	public SearchLog() {

	}

	public SearchLog(User user, String searchTerm) {
		this.id = user.getId();
		this.name = user.getName();
		this.memberNumber = user.getMemberNumber();
		this.searchTerm = searchTerm;
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

}
