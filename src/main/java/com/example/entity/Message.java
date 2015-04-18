package com.example.entity;


public class Message {

	private Integer messageId;
	private String messageContent;
	private String messageTime;
	private SubMessage submessage;


	public Integer getMessageId() {
		return messageId;
	}


	public void setMessageId(Integer messageId) {
		this.messageId = messageId;
	}


	public String getMessageContent() {
		return messageContent;
	}


	public void setMessageContent(String messageContent) {
		this.messageContent = messageContent;
	}


	public String getMessageTime() {
		return messageTime;
	}


	public void setMessageTime(String messageTime) {
		this.messageTime = messageTime;
	}


	public SubMessage getSubmessage() {
		return submessage;
	}


	public void setSubmessage(SubMessage submessage) {
		this.submessage = submessage;
	}


	@Override
	public String toString() {
		return "Message [messageId=" + messageId + ", messageContent="
				+ messageContent + ", messageTime=" + messageTime
				+ ", submessage=" + submessage + "]";
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((messageContent == null) ? 0 : messageContent.hashCode());
		result = prime * result
				+ ((messageId == null) ? 0 : messageId.hashCode());
		result = prime * result
				+ ((messageTime == null) ? 0 : messageTime.hashCode());
		result = prime * result
				+ ((submessage == null) ? 0 : submessage.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Message other = (Message) obj;
		if (messageContent == null) {
			if (other.messageContent != null)
				return false;
		} else if (!messageContent.equals(other.messageContent))
			return false;
		if (messageId == null) {
			if (other.messageId != null)
				return false;
		} else if (!messageId.equals(other.messageId))
			return false;
		if (messageTime == null) {
			if (other.messageTime != null)
				return false;
		} else if (!messageTime.equals(other.messageTime))
			return false;
		if (submessage == null) {
			if (other.submessage != null)
				return false;
		} else if (!submessage.equals(other.submessage))
			return false;
		return true;
	}
}
