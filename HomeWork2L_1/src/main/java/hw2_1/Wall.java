package hw2_1;

public class Wall extends Hindrance{

    private int heightWall;

    public int getHeightWall() {
        return heightWall;
    }

    public void setHeightWall(int heightWall) {
        this.heightWall = heightWall;
    }

    public Wall(int heightWall) {
        this.heightWall = heightWall;
    }
}
