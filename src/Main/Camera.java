package Main;

import Objects.*;

/**
 * This class represents the Camera angle of the game.
 * As Mario moves forward, so does the Camera.
 * @author Samuel Menezes
 */
public class Camera {
private float x,y;
public Camera(float x,float y){
	this.x = x;
	this.y = y;
}

//Changes the position of the camera as Mario moves forward.
public void tick(Objects mario){
	x = -mario.getX() + Main.WIDTH/2;
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
