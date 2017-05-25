package com.board.domain;

import java.sql.Timestamp;
import com.domain.TUser;

/**
 * Board entity. @author MyEclipse Persistence Tools
 */

public class Board implements java.io.Serializable {

	// Fields

	private Integer messageId;
	private TUser TUser;
	private Integer speakId;
	private String messageDetail;
	private Timestamp messageTime;

	// Constructors

	/** default constructor */
	public Board() {
	}

	/** full constructor */
	public Board(TUser TUser, Integer speakId, String messageDetail, Timestamp messageTime) {
		this.TUser = TUser;
		this.speakId = speakId;
		this.messageDetail = messageDetail;
		this.messageTime = messageTime;
	}

	// Property accessors

	public Integer getMessageId() {
		return this.messageId;
	}

	public void setMessageId(Integer messageId) {
		this.messageId = messageId;
	}

	public TUser getTUser() {
		return this.TUser;
	}

	public void setTUser(TUser TUser) {
		this.TUser = TUser;
	}

	public Integer getSpeakId() {
		return this.speakId;
	}

	public void setSpeakId(Integer speakId) {
		this.speakId = speakId;
	}

	public String getMessageDetail() {
		return this.messageDetail;
	}

	public void setMessageDetail(String messageDetail) {
		this.messageDetail = messageDetail;
	}

	public Timestamp getMessageTime() {
		return this.messageTime;
	}

	public void setMessageTime(Timestamp messageTime) {
		this.messageTime = messageTime;
	}

	@Override
	public String toString() {
		return "Board [messageId=" + messageId + ", TUser=" + TUser + ", speakId=" + speakId + ", messageDetail="
				+ messageDetail + ", messageTime=" + messageTime + "]";
	}
	
	

}