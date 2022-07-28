public class Character {
    public Character() {
    }

    //attributes
    public String id;
    public int hp;
    public int ap;
    public int maxStep;

    //constructor

    public Character(String id, int hp, int ap, int maxStep) {
        this.id = id;
        this.hp = hp;
        this.ap = ap;
        this.maxStep = maxStep;
    }
}
