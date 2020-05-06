#include <jni.h>
#include <stdio.h>
#include "Prompt.h"

JNIEXPORT jstring JNICALL Java_jni_Prompt_getLine
  (JNIEnv *env, jobject obj, jstring str){
         char buf[128];
          char* strTemp = JNI_GetString(env, promt);
          if (strTemp == NULL) return NULL;
          printf("%s", strTemp);
          scanf("%s", buf);
          return env->NewStringUTF(buf);
  }