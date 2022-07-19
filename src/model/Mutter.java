package model;

public class Mutter {
	private int id;//id
	private String userName;//呟いた時の名前
	private String text;//呟いた時の内容

	public Mutter() {
	}

	public Mutter(int id, String userName, String text) {
		this.id = id;
		this.userName = userName;
		this.text = text;
	}

	public int getId() {
		return id;
	}

	public String getUserName() {
		return userName;
	}

	public String getText() {
		return text;
	}

}