package Objects;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;

/**
 * An abstract class which contains all the methods required for most of the other classes.
 * @author Samuel Menezes
 */
public abstract class Objects {
protected float x,y; // co-ordinates
protected float velX = 0,velY = 0; // vertical and horizontal velocity

//variables for characters in the game to jump/fall.
protected boolean falling = true; 
protected boolean jumping = false;

protected int direction = 1;// direction of the characters.
public static int score,noOfCoins,level = 1; // Score, coins and levels in the game.
protected ObjectId id; //an Id for Objects in the game.

public Objects(float x,float y,ObjectId id){
	this.x = x;
	this.y = y;
	this.id = id;
}

public abstract void tick(ArrayList<Objects> obj); // for characters/objects movement in the game.
public abstract void render(Graphics g); //for loading images for characters/objects in the game.
public abstract Rectangle getBounds(); //getting bounds for the characters/objects in the game.

/**
 * Getters and Setters.
 */
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

public float getVelX() {
	return velX;
}

public void setVelX(float velX) {
	this.velX = velX;
}

public float getVelY() {
	return velY;
}

public void setVelY(float velY) {
	this.velY = velY;
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

public ObjectId getId()
{
	return id;
}

public int getDirection() {
	return direction;
}

public void setDirection(int direction) {
	this.direction = direction;
}
}

