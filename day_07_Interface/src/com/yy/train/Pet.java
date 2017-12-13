package com.yy.train;

public abstract class Pet {
    public static String name;
    private int health;
    private int intimacy=0;
    
	public int getHealth() {
		return health;
	}
	public void setHealth(int health) {
		this.health = health;
	}
	public int getIntimacy() {
		return intimacy;
	}
	public void setIntimacy(int intimacy) {
		this.intimacy = intimacy;
	}
	public abstract void showPet();
	
}
