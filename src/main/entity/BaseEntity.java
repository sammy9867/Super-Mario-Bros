package main.entity;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;

// An abstract base entity class for all characters and objects.
public abstract class BaseEntity {

	private BaseEntityId id;
	protected float x, y;
	protected float velocityX, velocityY;
	
	protected boolean falling = true, jumping = false;
	
	protected int direction = 1; // forward direction
	
	public BaseEntity(BaseEntityId id, float x, float y) {
		this.id = id;
		this.x = x;
		this.y = y;
	}
	
	public abstract void render(Graphics g); // load and draw animation
	public abstract void movement(ArrayList<BaseEntity> baseEntities); // movement of enemies
	public abstract Rectangle getBounds(); // get bounds of the entity
	
	public BaseEntityId getId() {
		return id;
	}

	public void setId(BaseEntityId id) {
		this.id = id;
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

	public float getVelocityX() {
		return velocityX;
	}

	public void setVelocityX(float velocityX) {
		this.velocityX = velocityX;
	}

	public float getVelocityY() {
		return velocityY;
	}

	public void setVelocityY(float velocityY) {
		this.velocityY = velocityY;
	}
	
	public boolean isFalling() {
		return falling;
	}

	public void setFalling(boolean falling) {
		this.falling = falling;
	}

	public boolean isJumping() {
		return jumping;
	}

	public void setJumping(boolean jumping) {
		this.jumping = jumping;
	}

	public int getDirection() {
		return direction;
	}

	public void setDirection(int direction) {
		this.direction = direction;
	}
}
