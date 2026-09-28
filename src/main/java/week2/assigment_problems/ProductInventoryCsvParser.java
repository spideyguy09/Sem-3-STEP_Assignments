package week2.assigment_problems;

public class ProductInventoryCsvParser {
    public void parseInventoryRecord(String csvLine) {
        if (csvLine == null || csvLine.isEmpty()) {
            System.out.println("Invalid Record");
            return;
        }

        String[] fields = csvLine.split(",");

        if (fields.length != 3) {
            System.out.println("Invalid Record");
        } else {
            String productName = fields[0];
            String sku = fields[1];
            String quantity = fields[2];
            System.out.println("Product: " + productName + " | SKU: " + sku + " | Qty: " + quantity);
        }
    }

    public static void main(String[] args) {
        ProductInventoryCsvParser parser = new ProductInventoryCsvParser();
        parser.parseInventoryRecord("Wireless Mouse,WM-2201,150");
        parser.parseInventoryRecord("Wireless Mouse,150");
    }
}
