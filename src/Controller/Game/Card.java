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
        valorCarta.put(136, "A");
        valorCarta.put(125, "2");
        valorCarta.put(128, "3");
        valorCarta.put(112, "4");
        valorCarta.put(131, "5");
        valorCarta.put(132, "6");
        valorCarta.put(94, "7");
        valorCarta.put(152, "8");
        valorCarta.put(134, "9");
        valorCarta.put(222, "T");
        valorCarta.put(92, "J");
        valorCarta.put(174, "Q");
        valorCarta.put(143, "K");
        
        

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


    /**
     * @return String return the naipe
     */
    public String getNaipe() {
        return naipe;
    }

    /**
     * @param naipe the naipe to set
     */
    public void setNaipe(String naipe) {
        this.naipe = naipe;
    }

    /**
     * @return String return the valor
     */
    public String getValor() {
        return valor;
    }

    /**
     * @param valor the valor to set
     */
    public void setValor(String valor) {
        this.valor = valor;
    }

}