package hw2_1;

public abstract class Hindrance {

    public boolean course(Actions p) {
        if (getClass()==Track.class) {
            return p.run((Track) this);
        } else if (getClass()==Wall.class) {
            return p.jump((Wall) this);
        } else {
            System.out.println("Неизвестное препятствие");
            return false;
        }

    }
}
