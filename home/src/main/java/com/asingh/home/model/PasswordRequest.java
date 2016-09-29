package com.asingh.home.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class PasswordRequest {
	
	private String string1;
	private String string2;
	private String string3;
	
	public PasswordRequest(){
		
	}
	
	public String getString1() {
		return string1;
	}
	public void setString1(String string1) {
		this.string1 = string1;
	}
	public String getString2() {
		return string2;
	}
	public void setString2(String string2) {
		this.string2 = string2;
	}
	public String getString3() {
		return string3;
	}
	public void setString3(String string3) {
		this.string3 = string3;
	}
	
	@Override
    public String toString()
    {
        return "PasswordRequest [string1=" + string1 + ", string2=" + string2 + ", string3=" + string3 + "]";
    }
	
}
