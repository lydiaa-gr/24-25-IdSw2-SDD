import java.util.Random;

public class Gato implements Movil {

    private int x;
    private int y;
    private final Random random = new Random();

    public Gato() {
        this.x = random.nextInt(25);
        this.y = random.nextInt(10);
    }

    @Override
    public void mover() {
        int nuevaX = x + random.nextInt(3) - 1; // -1, 0 o +1
        int nuevaY = y + random.nextInt(3) - 1;

        if (nuevaX >= 0 && nuevaX < 25) x = nuevaX;
        if (nuevaY >= 0 && nuevaY < 10) y = nuevaY;
    }

    public void ensuciar(Superficie superficie) {
        superficie.obtenerZona(x, y).ensuciar();
    }
}
