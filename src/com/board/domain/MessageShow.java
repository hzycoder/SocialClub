package com.board.domain;

import java.sql.Timestamp;
import com.domain.TUser;
/**
 * MessageShow entity. @author MyEclipse Persistence Tools
 */

public class MessageShow implements java.io.Serializable {

	// Fields

	private Integer messageId;
	private TUser TUser;
	private String UPicture;
	private String username;
	private String messageDetail;
	private Timestamp messageTime;

	// Constructors

	/** default constructor */
	public MessageShow() {
	}

	/** minimal constructor */
	public MessageShow(String username) {
		this.username = username;
	}

	/** full constructor */
	public MessageShow(TUser TUser, String UPicture, String username, String messageDetail, Timestamp messageTime) {
		this.TUser = TUser;
		this.UPicture = UPicture;
		this.username = username;
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

	public String getUPicture() {
		return this.UPicture;
	}

	public void setUPicture(String UPicture) {
		this.UPicture = UPicture;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
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
		return "MessageShow [messageId=" + messageId + ", TUser=" + TUser + ", UPicture=" + UPicture + ", username="
				+ username + ", messageDetail=" + messageDetail + ", messageTime=" + messageTime + "]";
	}
	
}