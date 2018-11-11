#include "jni.h"
#include "Native_NativeDemo.h"
#include <stdio.h>
#include <iostream>

/*
  Находит наибольший общий делитель двух целых;
  первые 2 параметра для JNI
*/
JNIEXPORT jint JNICALL Java_Native_NativeDemo_gcd(JNIEnv *env, jobject obj, jint p, jint q)
{
	if (q == 0) return p;
	int remainder = p % q;
	return Java_Native_NativeDemo_gcd(env, obj, q, remainder);
}
