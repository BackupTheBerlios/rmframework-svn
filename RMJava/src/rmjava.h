#ifndef _RMJAVA_H_
#define _RMJAVA_H_

#include "jni.h"

#define PATH_SEPARATOR ':'

/*
 * Report an error message to stderr or a window as appropriate.  The
 * flag always is set to JNI_TRUE if message is to be reported to both
 * strerr and windows and set to JNI_FALSE if the message should only
 * be sent to a window.
 */
void ReportErrorMessage(char * message, jboolean always);


/*
 * Pointers to the needed JNI invocation API, initialized by LoadJavaVM.
 * <CreateJavaVM_t> is a pointer to a function
 */
typedef jint (JNICALL *CreateJavaVM_t)(JavaVM **pvm, void **env, void *args);
typedef jint (JNICALL *GetDefaultJavaVMInitArgs_t)(void *args);

typedef struct {
    CreateJavaVM_t CreateJavaVM;
    GetDefaultJavaVMInitArgs_t GetDefaultJavaVMInitArgs;
} InvocationFunctions;




#endif
