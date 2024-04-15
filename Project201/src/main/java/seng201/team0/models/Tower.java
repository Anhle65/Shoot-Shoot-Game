package seng201.team0.models;

public class Tower {
    private String resourceType;
    private int level;
    private float cost;
    private boolean isWorking = true;
    private int bulletCapacity;
    private float recoveryTime;
    boolean inUse = false;
    public Tower(String resourceType, int level, float cost, int bulletCapacity, float recoveryTime, boolean isWorking, boolean inUse){
        this.resourceType = resourceType;
        this.level = level;
        this.cost = cost;
        this.bulletCapacity = bulletCapacity;
        this.recoveryTime = recoveryTime;
        this.isWorking = isWorking;
        this.inUse = inUse;
    }
    public int getCapacity(){ return bulletCapacity;}
    public String getType(){ return resourceType;}
    public int getLevel(){ return level;}
    public float getCost(){ return cost;}
    public boolean isWorkingStatus(){ return isWorking;}
    public boolean isInUse(){ return inUse;}
    public float getRecoveryTime(){ return recoveryTime;}
    public void upgradeCapacity(){ bulletCapacity += 1; }
    public void upgradeTime(){ recoveryTime *= 1.1;}
    public void changeTypeResource(String newType){ resourceType = newType;}
}
