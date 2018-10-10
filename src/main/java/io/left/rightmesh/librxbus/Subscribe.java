package io.left.rightmesh.librxbus;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import io.reactivex.functions.Predicate;

@Documented

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
public @interface Subscribe {

    Predicate alwaysTrue = (o) -> true;

    /**
     * The channels on which the event is subscribed.
     *
     * <p>example:
     * <pre>
     *     \@Subscribe
     *     public void onEvent(Event e) {
     *         // work
     *     }
     *
     *     \@Subscribe( thread = RxThread.IO )
     *     public void onEvent(Event e) {
     *         // work will be done in a different thread
     *     }
     *  </pre>
     *
     * @return the list of channel ids.
     */
    RxThread thread() default RxThread.POSTING;
}
