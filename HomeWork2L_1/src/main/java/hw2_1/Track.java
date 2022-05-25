package hw2_1;

public class Track extends Hindrance{

    private int lengthTrack;

    public int getLengthTrack() {
        return lengthTrack;
    }

    public void setLengthTrack(int lengthTrack) {
        this.lengthTrack = lengthTrack;
    }

    public Track(int lengthTrack) {
        this.lengthTrack = lengthTrack;
    }
}
