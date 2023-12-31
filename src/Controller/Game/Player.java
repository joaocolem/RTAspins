package Controller.Game;

public class Player {
    private int stack;
    private int position;
    private int bigBlind;
    private String action;
    private String mao;


    public Player(int stack, int position, String action, String[] cartas, int bigBlind) {
        this.bigBlind = bigBlind;
        this.stack = stack;
        this.position = position;
        this.action = action;
        this.mao = gerarMao(cartas);
    }

    public void stackPlusAction(){
        if(action.contains("R")) this.stack =+ (2*bigBlind);
        if(action.contains("L")) this.stack =+ bigBlind;
        if(action.contains("C")) this.stack =+ (2*bigBlind);
    }

    public void stackInBB(){
        this.stack = this.stack/bigBlind;
    }

    public String gerarMao(String[] cartas) {
        if (cartas.length != 2) {
            return "";
        }

        String carta1 = cartas[0];
        String carta2 = cartas[1];

        String valor1 = carta1.substring(0, carta1.length() - 1);
        String valor2 = carta2.substring(0, carta2.length() - 1);
        String naipe1 = carta1.substring(carta1.length() - 1);
        String naipe2 = carta2.substring(carta2.length() - 1);

        if (valor1.equals(valor2)) {
            return valor1 + valor2;
        } else if (naipe1.equals(naipe2)) {
            return valor1 + valor2 + "s";
        } else {
            return valor1 + valor2 + "o";
        }
    }

    /**
     * @return int return the stack
     */
    public int getStack() {
        return stack;
    }

    /**
     * @param stack the stack to set
     */
    public void setStack(int stack) {
        this.stack = stack;
    }

    /**
     * @return int return the position
     */
    public int getPosition() {
        return position;
    }

    /**
     * @param position the position to set
     */
    public void setPosition(int position) {
        this.position = position;
    }

    /**
     * @return String[] return the action
     */
    public String getAction() {
        return action;
    }

    /**
     * @param action the action to set
     */
    public void setAction(String action) {
        this.action = action;
    }

    /**
     * @return String return the mao
     */
    public String getMao() {
        return mao;
    }

    /**
     * @param mao the mao to set
     */
    public void setMao(String mao) {
        this.mao = mao;
    }


    @Override
    public String toString() {
        return "Player{" + "stack=" + stack + ", position=" + position + ", action=" + action + ", mao=" + mao + '}';
    }


    /**
     * @return int return the bigBlind
     */
    public int getBigBlind() {
        return bigBlind;
    }

    /**
     * @param bigBlind the bigBlind to set
     */
    public void setBigBlind(int bigBlind) {
        this.bigBlind = bigBlind;
    }

}