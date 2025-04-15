public class Aspiradora implements Movil {
    private int posX;
    private int posY;
    private Bateria bateria;
    private VistaConsola vista;

    public Aspiradora(Bateria bateria, VistaConsola vista) {
        this.bateria = bateria;
        this.vista = vista;
        this.posX = 0;
        this.posY = 0;
    }

    @Override
    public void mover() {
        // Movimiento aleatorio simple (puedes mejorar esto)
        int nuevaX = posX + (int)(Math.random() * 3) - 1; // -1, 0 o +1
        int nuevaY = posY + (int)(Math.random() * 3) - 1;

        if (nuevaX >= 0 && nuevaX < 25) posX = nuevaX;
        if (nuevaY >= 0 && nuevaY < 10) posY = nuevaY;
    }

    public void actuar(Superficie superficie) {
        if (bateria.estaAgotada()) {
            vista.mostrarMensaje("La batería está agotada.");
            return;
        }

        Zona zonaActual = superficie.obtenerZona(posX, posY);

        if (zonaActual instanceof ZonaRecarga) {
            ((ZonaRecarga) zonaActual).recargar(this);
        } else {
            zonaActual.limpiar();
            bateria.consumir();
            mover();
        }
    }

    public void recargarBateria() {
        bateria.recargar();
    }

    public int getPosX() {
        return posX;
    }

    public int getPosY() {
        return posY;
    }
}
