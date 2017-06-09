package com.daily.domain;

import java.sql.Timestamp;
import com.domain.TUser;

/**
 * AbstractTDaily entity provides the base persistence definition of the TDaily
 * entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractTDaily implements java.io.Serializable {

	// Fields

	private Integer dailyId;
	private TUser TUser;
	private Integer dlove;
	private String mesg;
	private String imgName;
	private Timestamp dailyTime;

	// Constructors

	/** default constructor */
	public AbstractTDaily() {
	}

	/** minimal constructor */
	public AbstractTDaily(Timestamp dailyTime) {
		this.dailyTime = dailyTime;
	}

	/** full constructor */
	public AbstractTDaily(TUser TUser, Integer dlove, String mesg, String imgName, Timestamp dailyTime) {
		this.TUser = TUser;
		this.dlove = dlove;
		this.mesg = mesg;
		this.imgName = imgName;
		this.dailyTime = dailyTime;
	}

	// Property accessors

	public Integer getDailyId() {
		return this.dailyId;
	}

	public void setDailyId(Integer dailyId) {
		this.dailyId = dailyId;
	}

	public TUser getTUser() {
		return this.TUser;
	}

	public void setTUser(TUser TUser) {
		this.TUser = TUser;
	}

	public Integer getDlove() {
		return this.dlove;
	}

	public void setDlove(Integer dlove) {
		this.dlove = dlove;
	}

	public String getMesg() {
		return this.mesg;
	}

	public void setMesg(String mesg) {
		this.mesg = mesg;
	}

	public String getImgName() {
		return this.imgName;
	}

	public void setImgName(String imgName) {
		this.imgName = imgName;
	}

	public Timestamp getDailyTime() {
		return this.dailyTime;
	}

	public void setDailyTime(Timestamp dailyTime) {
		this.dailyTime = dailyTime;
	}

}