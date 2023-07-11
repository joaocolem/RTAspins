package Controller.Game;
import java.util.HashMap;
import java.util.Map;

public class Card {
    private String naipe;
    private String valor;

    public Card(int pixels, String naipe) {
        this.naipe = naipe;
        this.valor = determinarValor(pixels);
    }

    private String determinarValor(int pixels) {
        Map<Integer, String> valorCarta = new HashMap<>();
        valorCarta.put(95, "A");
        valorCarta.put(87, "2");
        valorCarta.put(93, "3");
        valorCarta.put(85, "4");
        valorCarta.put(88, "5");
        valorCarta.put(100, "6");
        valorCarta.put(63, "7");
        valorCarta.put(104, "8");
        valorCarta.put(90, "9");
        valorCarta.put(162, "T");
        valorCarta.put(68, "J");
        valorCarta.put(123, "Q");
        valorCarta.put(103, "K");
        
        

        for (int valorPixel : valorCarta.keySet()) {
            if (pixels == valorPixel) {
                return valorCarta.get(valorPixel);
            }
        }

        return "";
    }

    @Override
    public String toString() {
        return valor + naipe;
    }

}