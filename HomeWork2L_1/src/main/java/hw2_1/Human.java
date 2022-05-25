package hw2_1;

public class Human implements Actions {

    private String name;
    private int runMax;
    private int jumpMax;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRunMax() {
        return runMax;
    }

    public void setRunMax(int runMax) {
        this.runMax = runMax;
    }

    public int getJumpMax() {
        return jumpMax;
    }

    public void setJumpMax(int jumpMax) {
        this.jumpMax = jumpMax;
    }

    public Human(String name, int runMax, int jumpMax) {
        this.name = name;
        this.runMax = runMax;
        this.jumpMax = jumpMax;
    }

    @Override
    public boolean run(Track t) {
        if (t.getLengthTrack()>runMax) {
            System.out.println("Человек столько не пробежит");
            return false;
        } else {
            System.out.println("Человек " + name + " пробежал " + t.getLengthTrack() + " м");
            return true;
        }

    }

    @Override
    public boolean jump(Wall w) {
        if (w.getHeightWall()>jumpMax) {
            System.out.println("Человек "+name+" не перепрыгнет "+w.getHeightWall()+" см");
            return false;
        } else {
            System.out.println("Человек "+name+" перепрыгнул "+w.getHeightWall()+" см");
            return true;
        }
    }
}
