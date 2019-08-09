package com.bae.entity;

public class SearchLog {

	private long id;

	private String name;

	private int memberNumber;

	private String searchResult;

	public SearchLog() {

	}

	public SearchLog(User user, String searchResult) {
		this.id = user.getId();
		this.name = user.getName();
		this.memberNumber = user.getMemberNumber();
		this.searchResult = searchResult;
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

	public String getSearchResult() {
		return searchResult;
	}

	public void setSearchResult(String searchResult) {
		this.searchResult = searchResult;
	}

}
