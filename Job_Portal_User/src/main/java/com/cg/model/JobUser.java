package com.cg.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

//POJO class

@Document(collection="JobUse")

public class JobUser {

@Id

//Attribute
	private int admid;
	private String admname;
	private String tittle;
	private String category;
	private String loc;
	private String companyname;
	private String pdate;
	private String resume;
	private String education;
	private String gender;
	
	
	//default constructor
	public JobUser() {
		super();
		// TODO Auto-generated constructor stub
	}


	//parameterized constructor
	public JobUser(int admid, String admname, String tittle, String category, String loc, String companyname,
			String pdate, String resume, String education, String gender) {
		super();
		this.admid = admid;
		this.admname = admname;
		this.tittle = tittle;
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


	public String getTittle() {
		return tittle;
	}


	public void setTittle(String tittle) {
		this.tittle = tittle;
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
		return "JobUser [admid=" + admid + ", admname=" + admname + ", tittle=" + tittle + ", category=" + category
				+ ", loc=" + loc + ", companyname=" + companyname + ", pdate=" + pdate + ", resume=" + resume
				+ ", education=" + education + ", gender=" + gender + "]";
	}

	

	


	
	
	

	
	
	

}
