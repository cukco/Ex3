public class Ex73 {
    private static double rate;
    static void setRate(double r){
        rate=r;
    }
    static double getRate(){
        return rate;
    }
    static double toUSD(int vnd){
        return vnd*rate;
    }
    public static void main(String[] args){
        setRate((double)1/27000);
        System.out.printf("Tỷ giá hiện tại: 1 VND/ %f USD\n",rate);
        System.out.printf("Đổi tiền: %d VND -> %.3f USD",5000000,toUSD(5000000));
    }
}
