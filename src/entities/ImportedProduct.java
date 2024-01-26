package entities;

public class ImportedProduct extends Product {
    private Double customsFee;

    public ImportedProduct(String name, double price, Double customsFee) {
        super(name, price);
        this.customsFee = customsFee;
    }

    public ImportedProduct() {

    }

    public Double getCustomsFee() {
        return customsFee;
    }

    public void setCustomsFee(Double customsFee) {
        this.customsFee = customsFee;
    }

    public Double totalprice() {
        return price + customsFee;
    }

    @Override
    public String priceTag(){
        return name + " $" +
                String.format("%.2f",totalprice())
                + " (Customs fee: $ "
                + String.format("%.2f",customsFee)
                + ")";
    }
}
