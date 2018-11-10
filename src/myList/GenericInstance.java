package myList;


/**
 * ЛЯМБДЫ, ссылки на конструкторы:
 *
 * как в Java сделать что-то похожее на
 *      1) T[] ar = new T[5];
 *      2) ar[0] = new T();
 * второе как С++ не получится сделать, потому что
 * невозможно предусмотреть интерфейсы для всех конструкторов.
 */


interface Creator<R, T>
{
    R apply(T n);
}


class Clazz<T>
{
    private T val = null;

    Clazz(T v)
    {
        val = v;
    }

    T getVal()
    {
        return val;
    }
}


class Clazz2
{
    private String str = null;

    Clazz2(String s)
    {
        str = s;
    }

    String getVal()
    {
        return str;
    }

}


public class GenericInstance
{

    static <R, T> R myClassFactory(Creator<R, T> cons, T v)
    {
        return cons.apply(v);
    }


    public static void main(String[] args)
    {
        List<String> list = new List<>();
        list.show();
        System.out.println(list.size);
        list.push_back("Tool", "Pantera", "Lamb of God");
        list.show();

        String[] strings = list.toArray(String[]::new);
        System.out.println("\n\ntoArrays():");
        for (String s : strings)
            System.out.println(s);

        //-------------------------------------------------------------------------------
        System.out.println("\n\n");


        Creator<Clazz<Double>, Double> myClassCons = Clazz<Double>::new;
        Clazz<Double> mc = myClassFactory(myClassCons, 100.1);
        System.out.println("val in mc is: " + mc.getVal());


        Creator<Clazz2, String> myClassCons2 = Clazz2::new;
        Clazz2 mc2 = myClassFactory(myClassCons2, "Lambda");
        System.out.println("str in mc2 is: " + mc2.getVal());



    }

}
