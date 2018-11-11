mkdir classes
javac -d classes NativeDemo.java
javah -classpath classes -jni Native.NativeDemo
PAUSE