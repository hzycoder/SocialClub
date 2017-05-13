package com.domain;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;


/**
 * ActList entity. @author MyEclipse Persistence Tools
 */

public class ActList  implements java.io.Serializable {


    // Fields    

     private Integer actId;
     private TUser TUser;
     private Date actTime;
     private String url;
     private Set actComments = new HashSet(0);


    // Constructors

    /** default constructor */
    public ActList() {
    }

	/** minimal constructor */
    public ActList(Integer actId) {
        this.actId = actId;
    }
    
    /** full constructor */
    public ActList(Integer actId, TUser TUser, Date actTime, String url, Set actComments) {
        this.actId = actId;
        this.TUser = TUser;
        this.actTime = actTime;
        this.url = url;
        this.actComments = actComments;
    }

   
    // Property accessors

    public Integer getActId() {
        return this.actId;
    }
    
    public void setActId(Integer actId) {
        this.actId = actId;
    }

    public TUser getTUser() {
        return this.TUser;
    }
    
    public void setTUser(TUser TUser) {
        this.TUser = TUser;
    }

    public Date getActTime() {
        return this.actTime;
    }
    
    public void setActTime(Date actTime) {
        this.actTime = actTime;
    }

    public String getUrl() {
        return this.url;
    }
    
    public void setUrl(String url) {
        this.url = url;
    }

    public Set getActComments() {
        return this.actComments;
    }
    
    public void setActComments(Set actComments) {
        this.actComments = actComments;
    }
   








}