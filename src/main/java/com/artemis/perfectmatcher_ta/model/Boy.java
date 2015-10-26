/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.artemis.perfectmatcher_ta.model;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "boy")
public class Boy {

	
	private String name;
        private int code;
	private String mate;
	

	// Must have no-argument constructor
	public Boy() {

	}

	public Boy(String name, int code, String mate) {
		this.name = name;
		this.code = code;
		this.mate = mate;
	}

        @XmlElement
	public void setName(String name) {
		this.name = name;
	}
        
	public String getName() {
		return this.name;
	}

	public void setMate(String mate) {
		this.mate = mate;
	}
        
        @XmlElement
	public String getmate() {
		return this.mate;
	}

	public void setCode(int code) {
		this.code = code;
	}

        @XmlAttribute
	public int getCode() {
		return this.code;
	}

	@Override
	public String toString() {
		return "Boy [name=" + name + ", girl=" + mate + "]";
	}

}