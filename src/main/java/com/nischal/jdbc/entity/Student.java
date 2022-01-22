package com.nischal.jdbc.entity;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@ToString
public class Student implements Serializable {

	private long id;
	private String name;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-mm-dd")
	private Date dob;
	private String address;
	private String contactNo;
	private Date createdDate;
	private  boolean status;
	
	public Student(long id, String name, Date dob, String address, String contactNo) {
		super();
		this.id = id;
		this.name = name;
		this.dob = dob;
		this.address = address;
		this.contactNo = contactNo;
	}

	@Override
	public String toString() {
		return "Student{" +
				"id=" + id +
				", name='" + name + '\'' +
				", dob=" + dob +
				", address='" + address + '\'' +
				", phoneNo='" + contactNo + '\'' +
				'}';
	}
}
