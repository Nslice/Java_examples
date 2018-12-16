package nativedemo;

public class NativeDemo
{
    // находит наибольший общий делитель
    public native int gcd(int p, int q);

    // load DLL that contains static method
    static
    {
        System.loadLibrary("gcd");
    }


    public static void main(String[] args)
    {
        NativeDemo ob = new NativeDemo();

        System.out.println("Call native mehod. (lang C++)");

        // call a native method
        if (args.length < 2)
            System.out.println("NATIVE GCD : " + ob.gcd(5435332, 6546452));
        else
            System.out.println("NATIVE GCD : " + ob.gcd(Integer.parseInt(args[0]),
                    Integer.parseInt(args[1])));
    }

}