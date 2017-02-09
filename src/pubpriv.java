/**
 * Created by v.grebnev on 03.02.2017.
 */
class MyClass {
    private int alpha;
    public int beta;
    int gamma;
    void setAlpha(int a){
        alpha = a;
    }
    int getAlpha()
    {
        return alpha;
    }
}
class pubpriv{
    public static void main(String args[]){
        MyClass ob = new MyClass();
        ob.setAlpha(-99);
        System.out.println("ob.Alpha " + ob.getAlpha());
        ob.beta = 88;
        ob.gamma = 99;

    }
}
