package com.example.entity;

public class SubMessage {

	private Integer submessageId;
	private String submessageContent;

	public Integer getSubmessageId() {
		return submessageId;
	}
	public void setSubmessageId(Integer submessageId) {
		this.submessageId = submessageId;
	}
	public String getSubmessageContent() {
		return submessageContent;
	}
	public void setSubmessageContent(String submessageContent) {
		this.submessageContent = submessageContent;
	}

	@Override
	public String toString() {
		return "SubMessage [submessageId=" + submessageId
				+ ", submessageContent=" + submessageContent + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime
				* result
				+ ((submessageContent == null) ? 0 : submessageContent
						.hashCode());
		result = prime * result
				+ ((submessageId == null) ? 0 : submessageId.hashCode());
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
		SubMessage other = (SubMessage) obj;
		if (submessageContent == null) {
			if (other.submessageContent != null)
				return false;
		} else if (!submessageContent.equals(other.submessageContent))
			return false;
		if (submessageId == null) {
			if (other.submessageId != null)
				return false;
		} else if (!submessageId.equals(other.submessageId))
			return false;
		return true;
	}
}
