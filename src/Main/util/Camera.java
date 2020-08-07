package main.util;

import main.entity.BaseEntity;

public class Camera {

	private float x, y;
	
	public Camera(float x, float y) {
		this.x = x;
		this.y = y;
	}
	
	public void movement(BaseEntity baseEntity) {
		x = -baseEntity.getX() + 50;
	}
	
	public float getX() {
		return x;
	}

	public void setX(float x) {
		this.x = x;
	}

	public float getY() {
		return y;
	}

	public void setY(float y) {
		this.y = y;
	}

}
