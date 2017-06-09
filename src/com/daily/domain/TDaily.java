package com.daily.domain;

import java.sql.Timestamp;
import com.domain.TUser;

/**
 * TDaily entity. @author MyEclipse Persistence Tools
 */
public class TDaily extends AbstractTDaily implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public TDaily() {
	}

	/** minimal constructor */
	public TDaily(Timestamp dailyTime) {
		super(dailyTime);
	}

	/** full constructor */
	public TDaily(TUser TUser, Integer dlove, String mesg, String imgName, Timestamp dailyTime) {
		super(TUser, dlove, mesg, imgName, dailyTime);
	}

}
