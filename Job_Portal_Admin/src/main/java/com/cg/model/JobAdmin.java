package com.cg.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

//model class or Java Bean or POJO 
@Document(collection="JobPortal")

//@SpringBootApplication(exclude= {DataSourceAutoConfiguration.class})

public class JobAdmin {
@Id	
	//Attribute
	private int admid;
	private String admname;
	private String title;
	private String category;
	private String loc;
	private String companyname;
	private String pdate;
	private String resume;
	private String education;
	private String gender;
	
//default constructor
	public JobAdmin() {
		super();
		// TODO Auto-generated constructor stub
	}

//parameterized constructor
	public JobAdmin(int admid, String admname, String title, String category, String loc, String companyname,
			String pdate, String resume, String education, String gender) {
		super();
		this.admid = admid;
		this.admname = admname;
		this.title = title;
		this.category = category;
		this.loc = loc;
		this.companyname = companyname;
		this.pdate = pdate;
		this.resume = resume;
		this.education = education;
		this.gender = gender;
	}

//getters and setters
	public int getAdmid() {
		return admid;
	}

	public void setAdmid(int admid) {
		this.admid = admid;
	}

	public String getAdmname() {
		return admname;
	}

	public void setAdmname(String admname) {
		this.admname = admname;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getLoc() {
		return loc;
	}

	public void setLoc(String loc) {
		this.loc = loc;
	}

	public String getCompanyname() {
		return companyname;
	}

	public void setCompanyname(String companyname) {
		this.companyname = companyname;
	}

	public String getPdate() {
		return pdate;
	}

	public void setPdate(String pdate) {
		this.pdate = pdate;
	}

	public String getResume() {
		return resume;
	}

	public void setResume(String resume) {
		this.resume = resume;
	}

	public String getEducation() {
		return education;
	}

	public void setEducation(String education) {
		this.education = education;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}
	
//toString
	@Override
	public String toString() {
		return "JobAdmin [admid=" + admid + ", admname=" + admname + ", title=" + title + ", category=" + category
				+ ", loc=" + loc + ", companyname=" + companyname + ", pdate=" + pdate + ", resume=" + resume
				+ ", education=" + education + ", gender=" + gender + "]";
	}

}
