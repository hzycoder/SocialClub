package com.domain;

import java.sql.Timestamp;

/**
 * Notice entity. @author MyEclipse Persistence Tools
 */

public class Notice implements java.io.Serializable {

	// Fields

	private Integer noticeId;
	private TUser TUserByRecipientId;
	private TUser TUserBySenderId;
	private Integer noticeType;
	private String noticeContent;
	private Boolean noticeState;
	private Timestamp noticeTime;

	// Constructors

	/** default constructor */
	public Notice() {
	}

	/** full constructor */
	public Notice(TUser TUserByRecipientId, TUser TUserBySenderId, Integer noticeType, String noticeContent,
			Boolean noticeState, Timestamp noticeTime) {
		this.TUserByRecipientId = TUserByRecipientId;
		this.TUserBySenderId = TUserBySenderId;
		this.noticeType = noticeType;
		this.noticeContent = noticeContent;
		this.noticeState = noticeState;
		this.noticeTime = noticeTime;
	}

	// Property accessors

	public Integer getNoticeId() {
		return this.noticeId;
	}

	public void setNoticeId(Integer noticeId) {
		this.noticeId = noticeId;
	}

	public TUser getTUserByRecipientId() {
		return this.TUserByRecipientId;
	}

	public void setTUserByRecipientId(TUser TUserByRecipientId) {
		this.TUserByRecipientId = TUserByRecipientId;
	}

	public TUser getTUserBySenderId() {
		return this.TUserBySenderId;
	}

	public void setTUserBySenderId(TUser TUserBySenderId) {
		this.TUserBySenderId = TUserBySenderId;
	}

	public Integer getNoticeType() {
		return this.noticeType;
	}

	public void setNoticeType(Integer noticeType) {
		this.noticeType = noticeType;
	}

	public String getNoticeContent() {
		return this.noticeContent;
	}

	public void setNoticeContent(String noticeContent) {
		this.noticeContent = noticeContent;
	}

	public Boolean getNoticeState() {
		return this.noticeState;
	}

	public void setNoticeState(Boolean noticeState) {
		this.noticeState = noticeState;
	}

	public Timestamp getNoticeTime() {
		return this.noticeTime;
	}

	public void setNoticeTime(Timestamp noticeTime) {
		this.noticeTime = noticeTime;
	}

}