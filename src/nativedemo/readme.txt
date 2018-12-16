В файле .java объявить метод с ключевым словом native, без определения, только прототип.
И в static-блоке класса с этим методом написать:
            static
            {
                System.loadLibrary("gcd"); //имя моей DLL
            }

Скомпилировать .java файл, потом выполнить к файлу .class команду
    > javah -classpath classes -jni nativedemo.NativeDemo
Сгенерируется хедер, в нем в include поменять <jni.h> на "jni.h".
В папке с JDK найти 2 хедера: jni.h и jni_md.h. 
Скопировать их в текущую папку.

Создать .cpp файл:
            #include "jni.h"
            #include "nativedemo_NativeDemo.h" //имя хедера сгенерированнго javah

            //добавить перед каждым методом, который попадает в DLL (необязательно)
            __declspec( dllexport ) 
            JNIEXPORT jint JNICALL Java_nativedemo_NativeDemo_gcd(JNIEnv* env, jobject obj, jint p, jint q)
            {
                 //такой прототип берется из хедера, "nativedemo_NativeDemo.h";
                 //в имене указан пакет и java класс в котором нативный метод и сам метод;
                 //тут например такой метод: int gcd(int p, int q);
            }

После, надо создать DLL из .cpp файла.
Есть два варианта:
1) используя mingw32:
    > g++ -shared -o MyLibb.dll myCprog.cpp
  но тогда нужно JVM 32-bit

2) используя VisualC (64 bit):
   запустить командную строку разработчика VC(x64)(или nativedemo Tools(x64) для VS) и создать DLL командой:
    > Cl /LD myCprog.cpp
  это подходит для JVM 64-bit 

// Можно попробывать с mingw64. Как менять версии JVM без удаления хз.

теперь как обычно запускается класс(с нативным методом):
    > java -classpath classes nativedemo.NativeDemo