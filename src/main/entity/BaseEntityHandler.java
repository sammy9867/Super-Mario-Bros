package main.entity;

import java.awt.Graphics;
import java.util.ArrayList;

public class BaseEntityHandler {

	private BaseEntity tempBaseEntity;
	public ArrayList<BaseEntity> baseEntities = new ArrayList<>();
	
	public void render(Graphics g) {
		for(int i = 0; i < baseEntities.size(); i++) {
			tempBaseEntity = baseEntities.get(i); 
			tempBaseEntity.render(g);
		}
	}
	
	public void movement() {
		for(int i = 0; i < baseEntities.size(); i++) {
			tempBaseEntity =  baseEntities.get(i); 
			tempBaseEntity.movement(baseEntities);
		}
	}
	
	public void addEntity(BaseEntity baseEntity) {
		this.baseEntities.add(baseEntity);
	}
	
	public void removeEntity(BaseEntity baseEntity) {
		this.baseEntities.remove(baseEntity);
	}
	
	public void clearEntities() {
		this.baseEntities.clear();
	}
	
	public ArrayList<BaseEntity> getBaseEntities() {
		return this.baseEntities;
	}
	
}
