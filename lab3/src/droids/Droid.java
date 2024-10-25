package droids;

public abstract class Droid {
    protected String name;
    protected int health;
    protected int attackPower;

    public Droid(String name, int health, int attackPower) {
        this.name = name;
        this.health = health;
        this.attackPower = attackPower;
    }

    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    public boolean isAlive() {
        return health > 0;
    }

    public void attack(Droid opponent) {
        if (this.isAlive()) {
            opponent.health -= this.attackPower;
            System.out.println(name + " атакує " + opponent.name + " на " + attackPower + " пошкоджень!");
        }
    }

    @Override
    public String toString() {
        return name + " (Здоров'я: " + health + ")";
    }
}

