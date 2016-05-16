#RxViewStub
[![](https://jitpack.io/v/SmartDengg/RxViewStub.svg)](https://jitpack.io/#SmartDengg/RxViewStub)

![](./images/icon.png)

Sketch
--------

Sometimes your layout might require complex views that are rarely used. "Gone" or "Invisible" is not a good idea fot that, because these properties can't prevent view add to the view hierarchy and also hurt performance. But the [ViewStub](http://developer.android.com/intl/zh-cn/reference/android/view/ViewStub.html) is an invisible and zero-sized view that can be used to lazy loading on demand. Similarly, with reduce memory usage, use ViewStub can also speed up rendering by loading the views only when they are real needed.


RxViewStub is similar to [RxBinding](https://github.com/JakeWharton/RxBinding), wrapped an inflate listener into an  Observable. It's very simply and lightweight :)

Usage
--------

- Gradle:

**Step 1.** Add the JitPack repository to your build file. Add it in your root build.gradle at the end of repositories:

```java
allprojects {
		repositories {
			...
			maven { url "https://jitpack.io" }
		}
	}
```

**Step 2.** Add the dependency

```java
dependencies {
    compile 'com.github.SmartDengg:RxViewStub:1.0.0' 
}
```

- Java

```java
RxViewStub.inflateEvent(viewStub)
          .subscribe(new Action1<ViewStubEvent>() {
              @Override
              public void call(ViewStubEvent viewStubEvent) {
                  //After inflation, you can get the inflated view
                  View inflated = viewStubEvent.getInflated();
              }
          });
```

Preview
--------

![](./images/RxViewStub.gif)


Developed By
--------
- SmartDengg - Hi4Joker@gmail.com

[SmartDengg's blog](http://www.jianshu.com/users/df40282480b4/latest_articles)
 
[SmartDengg's imooc community](http://www.imooc.com/myclub/article/uid/2536335)

<a href="http://weibo.com/5367097592/profile?rightmod=1&wvr=6&mod=personinfo">
  <img alt="Follow me on Weibo" src="http://upload-images.jianshu.io/upload_images/268450-50e41e15ac29b776.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240" />
</a>

License
--------

	Copyright (c) 2016 小鄧子

	Permission is hereby granted, free of charge, to any person obtaining a copy
	of this software and associated documentation files (the "Software"), to deal
	in the Software without restriction, including without limitation the rights
	to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
	copies of the Software, and to permit persons to whom the Software is
	furnished to do so, subject to the following conditions:

	The above copyright notice and this permission notice shall be included in all
	copies or substantial portions of the Software.

	THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
	IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
	FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
	AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
	LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
	OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
	SOFTWARE.

    














