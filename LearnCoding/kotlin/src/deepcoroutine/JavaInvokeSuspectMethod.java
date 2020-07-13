package deepcoroutine;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import org.jetbrains.annotations.NotNull;

public class JavaInvokeSuspectMethod {
    public static void main(String[] args){
        _1_SuspectContinuationKt.bitmapSuspendable("...", new Continuation<String>() {
            @NotNull
            @Override
            public CoroutineContext getContext() {
                return EmptyCoroutineContext.INSTANCE;
            }

            @Override
            public void resumeWith(@NotNull Object o) {
                System.out.println("java resumeWith");
            }
        });
    }
    static {

    }
}
