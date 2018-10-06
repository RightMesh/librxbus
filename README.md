# RxBus

RxBus is a small and simple Event Bus using RxJava. You can use this library
in your project with gradle using jitpack:

```java
repositories {
    maven { url 'https://jitpack.io' }
}
```

```java
dependencies {
   implementation 'com.github.RightMesh:RxBus:v1.0'
}
```

# Features

* Simple class registration and post using static RxBus method 
* **Subscribe** annotation for method to receive event
* Thread selection for event handling

# Posting an event

Posting an event is as simple as calling RxBus.post:

```java
RxBus.post(new MyOwnEvent());
```

# Processing an event

## Declare and Annotate your subscriber

An event can be of any class that you want. To process any event of a specific class, you must declare and annotate a subscribing method.
The method can have any name but the signature must be correct:
* public method
* returns void 
* single parameter.

```java
@Subscribe
public void onEvent(MyOwnEvent e) {
    // process event
}
```

You can also specify the thread on which you want to process the even with the **thread** keyword:
```java
@Subscribe( thread = RxThread.IO )
public void onEvent(MyOwnEvent e) {
    // process event
}
```

The followings are the available threads:

| RxThread.POSTING | same thread as the one posting the event (default) |
| RxThread.MAIN | todo |
| RxThread.IO | RxJava Schedulers.io() |
| RxThread.NEW | RxJava Schedulers.new() |
| RxThread.COMPUTATION | RxJava Schedulers.computation() |
| RxThread.TRAMPOLINE | RxJava Schedulers.trampoline() |

## Register your subscriber at runtime

You can then register or unregister your subscriber at runtime. For instance in the constructor or during initialization:

```java
public void onStart() {
    RxBus.register(this);
}

public void onStop() {
    RxBus.unregister(this);
}
```

## License

    Copyright 2018 Lucien Loiseau

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

        http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.





