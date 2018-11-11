package Native;

public class NativeDemo
{
    // находит наиобльший общий делитель
    public native int gcd(int p, int q);

    // load DLL that contains static method
    static
    {
        System.loadLibrary("gcd");
    }


    public static void main(String args[])
    {
        NativeDemo ob = new NativeDemo();

        System.out.println("\nCall one more native mehod. (lang C++)");
        System.out.println("NATIVE GCD : " + ob.gcd(Integer.parseInt(args[0]),
                    Integer.parseInt(args[1]))); // call a native method
    }




}