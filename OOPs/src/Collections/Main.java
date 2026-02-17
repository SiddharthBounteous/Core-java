package Collections;

public class Main {
    public static void main(){
        TrendingProductEngine engine = new TrendingProductEngine();
        long now = System.currentTimeMillis();

        engine.processOrder(new OrderEvent("1", "u1", "iPhone", "Electronics", "India", now));
        engine.processOrder(new OrderEvent("2", "u2", "iPhone", "Electronics", "India", now));
        engine.processOrder(new OrderEvent("3", "u3", "Shoes", "Fashion", "India", now));
        engine.processOrder(new OrderEvent("4", "u4", "Laptop", "Electronics", "US", now));

        System.out.println("Top Products: " + engine.getTopTrendingProducts(2));

        System.out.println("Top Categories in India: " + engine.getTopTrendingCategories("India", 2));
    }
}
