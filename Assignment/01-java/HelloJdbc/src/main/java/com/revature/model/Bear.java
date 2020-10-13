package com.revature.model;

public class Bear {
	
	private int tagId;
	private String color;
	private boolean hasFur;
	private Circus belongsTo;
	
	
	
	public Bear(int tagId, String color, boolean hasFur, Circus belongsTo) {
		super();
		this.tagId = tagId;
		this.color = color;
		this.hasFur = hasFur;
		this.belongsTo = belongsTo;
	}
	

	public int getTagId() {
		return tagId;
	}
	public String getColor() {
		return color;
	}
	public boolean isHasFur() {
		return hasFur;
	}
	public Circus getBelongsTo() {
		return belongsTo;
	}
	public void setTagId(int tagId) {
		this.tagId = tagId;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public void setHasFur(boolean hasFur) {
		this.hasFur = hasFur;
	}
	public void setBelongsTo(Circus belongsTo) {
		this.belongsTo = belongsTo;
	}


	@Override
	public String toString() {
		return "Bear [tagId=" + tagId + ", color=" + color + ", hasFur=" + hasFur + ", belongsTo=" + belongsTo + "]";
	}


	
	
	

}
