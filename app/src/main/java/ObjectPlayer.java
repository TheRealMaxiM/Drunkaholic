/**
 * This Object saves all necessary Metadata for players
 * Those include:
 * - Name
 * - Weight
 * - Alcohol they are consuming
 * - Gender
 * - How many times they had to drink
 * - Their current alcohol level
 * - How many times they participated in Events
 * -- Duels
 * -- Games
 * -- Tasks
 */
public class ObjectPlayer
{
    private String name;
    private double weight;
    private double alcoholPercentage;
    private boolean isWoman;
    private double currentAlcoholLevel;
    private int drinkCounter;
    private int eventCounter;
    private int taskCounter;
    private int gameCounter;
    private int duelCounter;

    public ObjectPlayer(String name, double weight, double alcoholPercentage, boolean isWoman)
    {
        this.name = name;
        this.weight = weight;
        this.alcoholPercentage = alcoholPercentage;
        this.isWoman = isWoman;
    }

    /**
     * This function calculates the current alcohol level of the player.
     * Source to the used formular:
     * http://www.perfectdrinks.de/alcohol level.html
     *
     * @param alcoholPercentage percentage of alcohol in the players drink
     * @param weight the players weight
     * @param isWoman gender of the player
     * @param drinkCounter amount of shots/sips the player already drank
     * @return current alcohol level of the player
     */
    private double calculateCurrentAlcoholLevel(double alcoholPercentage, double weight, boolean isWoman, int drinkCounter)
    {
        // We assume that a shot or sip of the drink is 2cl
        double alcoholInGram = alcoholPercentage * (2 * drinkCounter) * 0.08;
        double percentageOfWater;

        if (isWoman) 
        {
            percentageOfWater = 0.6;
        }
        else 
        {
            percentageOfWater = 0.7;
        }
        
        return alcoholInGram * (weight * percentageOfWater);
    }

    /**
     * Calculates the current alcohol level first before returning it.
     * @return current alcohol level
     */
    public double getCurrentAlcoholLevel()
    {
        return calculateCurrentAlcoholLevel(this.alcoholPercentage, this.weight, this.isWoman, this.drinkCounter);
    }

    public String getName() 
    {
        return name;
    }

    public void setName(String name) 
    {
        this.name = name;
    }

    public double getWeight() 
    {
        return weight;
    }

    public void setWeight(double weight) 
    {
        this.weight = weight;
    }

    public double getAlcoholPercentage() 
    {
        return alcoholPercentage;
    }

    public void setAlcoholPercentage(double alcoholPercentage) 
    {
        this.alcoholPercentage = alcoholPercentage;
    }

    public boolean isWoman() 
    {
        return isWoman;
    }

    public void setWoman(boolean woman) 
    {
        isWoman = woman;
    }

    public int getDrinkCounter() 
    {
        return drinkCounter;
    }

    public void setDrinkCounter(int drinkCounter) 
    {
        this.drinkCounter = drinkCounter;
    }

    public int getEventCounter() 
    {
        return eventCounter;
    }

    /**
     * setEventCounter will never be called outside the playerObject.
     * when Task/Game/Duel counters are raised they raise the eventCounter automatically.
     */
    private void setEventCounter(int eventCounter) 
    {
        this.eventCounter = eventCounter;
    }

    public int getTaskCounter() 
    {
        return taskCounter;
    }

    public void setTaskCounter(int taskCounter) 
    {
        setEventCounter(getEventCounter() + 1);
        this.taskCounter = taskCounter;
    }

    public int getGameCounter() 
    {
        return gameCounter;
    }

    public void setGameCounter(int gameCounter) 
    {
        setEventCounter(getEventCounter() + 1);
        this.gameCounter = gameCounter;
    }

    public int getDuelCounter() 
    {
        return duelCounter;
    }

    public void setDuelCounter(int duelCounter) 
    {
        setEventCounter(getEventCounter() + 1);
        this.duelCounter = duelCounter;
    }
}