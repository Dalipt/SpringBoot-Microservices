package com.java.SpringMVCApp.model;

public class Employee
{
	private Integer id;
	private String name;
	private String departType;
	private Double publisher;
	private Long version;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getdepartType() {
		return departType;
	}
	public void setdeparType(String departType) {
		this.departType = departType;
	}
	public Double getPublisher() {
		return publisher;
	}
	public void setPublisher(Double publisher) {
		this.publisher = publisher;
	}
	public Long getVersion() {
		return version;
	}
	public void setVersion(Long version) {
		this.version = version;
	}
	public Employee(Integer id, String name, String departType, Double publisher, Long version) {
		super();
		this.id = id;
		this.name = name;
		this.departType = departType;
		this.publisher = publisher;
		this.version = version;
	}
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", deparType=" + departType + ", publisher=" + publisher
				+ ", version=" + version + "]";
	}
	
	
}
