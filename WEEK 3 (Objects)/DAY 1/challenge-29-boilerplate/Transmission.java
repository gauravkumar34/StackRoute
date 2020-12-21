public abstract class Transmission {
    String modelNo;

    public Transmission(String modelNo) {
        this.modelNo = modelNo;
    }

    public abstract void showSpecs();
}
