package week7.assigment_problems;

public class Character {
    private final int maxHealth;
    private int health;

    public Character(int maxHealth) {
        this.maxHealth = maxHealth;
        this.health = maxHealth;
    }

    public void takeDamage(int amount) {
        if (amount > 0) {
            this.health -= amount;
            if (this.health < 0) {
                this.health = 0;
            }
        }
    }

    public void heal(int amount) {
        if (amount > 0) {
            this.health += amount;
            if (this.health > this.maxHealth) {
                this.health = this.maxHealth;
            }
        }
    }

    public int getHealth() {
        return this.health;
    }
}
