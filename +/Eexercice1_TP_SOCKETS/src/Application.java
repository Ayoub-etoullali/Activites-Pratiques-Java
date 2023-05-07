public class Application {
    public static void main(String[] args) {
        /*MonInterface m=new MonInterface() {
            @Override
            public int calcul(int a, int b) {
                return a+b;
            }
        };*/
        MonInterface m=(a,b)->{
            return a+b;
        };
        System.out.println(m.calcul(2,8));
    }
}
