package hw2_1;

public class Main {
    public static void main(String[] args) {

        Actions[] participants = new Actions[3];
        participants[0] = new Cat("Barsik", 100, 150);
        participants[1] = new Robot("r2d2",10000, 20);
        participants[2] = new Human("Vasya", 1500, 100);

        Hindrance[] hindrance = new Hindrance[4];
        hindrance[0] = new Track(50);
        hindrance[1] = new Wall(99);
        hindrance[2] = new Track(1000);
        hindrance[3] = new Wall(20);

        for (Actions par : participants) {
            for (Hindrance hin : hindrance) {
                if (hin.course(par)==false) {
                    break;
                }
            }
        }

    }
}
