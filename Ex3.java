    class Computer{
        double calculatePrice(double basePrice){
            return basePrice;
        }
        double calculatePrice(double basePrice, double tax){
            return basePrice+tax;
        }
        double calculatePrice(double basePrice, double tax, double discount){
            return basePrice+tax-discount;
        }
    }
    public class Ex103 {
        public static void main(String[] args){
            Computer computer=new Computer();
            System.out.printf("Method 1: %.2f\nMethod 2: %.2f\nMethod 3: %.2f",computer.calculatePrice(100)
            ,computer.calculatePrice(100,10),computer.calculatePrice(100,10,20));
        }
    }
