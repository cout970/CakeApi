package org.cakepowered.api.util;

public class Title {

	protected String title;
	protected String subTitle;
	protected int start;
	protected int show;
	protected int end;
	
	public Title(String title, String subTitle, int show, int start, int end){
		this.title = title;
		this.subTitle = subTitle;
		this.show = show;
		this.start = start;
		this.end = end;
	}
	
	public Title(String title, String subTitle, int end){
		this.title = title;
		this.subTitle = subTitle;
		this.end = end;
	}
	
	public Title(String title, int time) {
		this(title, null, time);
	}
	
	public Title(String title) {
		this(title, null, 20);
	}
	
	public Title(){
		this(null, null, 0);
	}
	
	public boolean isReset(){
		return title == null && subTitle == null;
	}

	public String getTitle() {
		return title;
	}

	public String getSubTitle() {
		return subTitle;
	}

	public int getStartTime() {
		return start;
	}

	public int getShowTime() {
		return show;
	}
	
	public int getEndTime() {
		return end;
	}
}
