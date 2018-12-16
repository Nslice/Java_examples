#include "jni.h"
#include "nativedemo_NativeDemo.h"
#include <stdio.h>
#include <iostream>

/*
  Находит наибольший общий делитель двух целых;
  первые 2 параметра для JNI
*/
JNIEXPORT jint JNICALL Java_nativedemo_NativeDemo_gcd(JNIEnv *env, jobject obj, jint p, jint q)
{
	if (q == 0) return p;
	int remainder = p % q;
	return Java_nativedemo_NativeDemo_gcd(env, obj, q, remainder);
}
