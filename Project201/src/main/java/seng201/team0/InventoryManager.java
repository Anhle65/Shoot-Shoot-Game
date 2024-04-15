package seng201.team0;

import seng201.team0.models.Tower;

import java.util.List;

public class InventoryManager {
    private int gold = 0;
    private int water = 0;
    private int food = 0;
    private int coal = 0;
    private int fire = 0;
    private int diamond = 6;
    private List<Tower> inUseTowers;
    private List<Tower> inReservedTowers;
    public InventoryManager(int gold, int water, int food, int coal, int fire, int diamond){
        this.gold = gold;
        this.water = water;
        this.food = food;
        this.coal = coal;
        this.fire = fire;
        this.diamond = diamond;
    }
    public List<Tower> getInUseTowers(){ return inUseTowers;}
    public List<Tower> getInReservedTowers(){ return inReservedTowers;}
    public void setInUseTowers(List<Tower> inUsed){ this.inUseTowers = inUsed;}
}
