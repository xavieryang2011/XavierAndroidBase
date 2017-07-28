[![License](https://img.shields.io/badge/license-Apache%202-green.svg)](https://www.apache.org/licenses/LICENSE-2.0)
[![](https://jitpack.io/v/xavieryang2011/XavierAndroidBase.svg)](https://jitpack.io/#xavieryang2011/XavierAndroidBase)
## 一、引入到项目
   ### 在最外层build.gradle添加以下代码
      	'''
        allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
       '''
   ### 所在项目build.gradle添加依赖
       '''
        	dependencies {
	        compile 'com.github.xavieryang2011:XavierAndroidBase:1.0.1'
	}
       '''
## 二、依赖库
* [RxJava 响应式编程框架](https://github.com/ReactiveX/RxJava)
* [Retrofit2.0 REST安卓客户端请求库](https://github.com/square/retrofit)
* [OkHttp3 网络请求](https://github.com/square/okhttp)
* [Glide 图片加载](https://github.com/bumptech/glide)
* [ButterKnife 依赖注入](https://github.com/JakeWharton/butterknife) 

感谢这些开源库的大神们
## 三、用到的知识点
Retrofit — Getting Started and Create an Android Client
<br>https://futurestud.io/blog/retrofit-getting-started-and-android-client</br>

给 Android 开发者的 RxJava 详解
<br>http://gank.io/post/560e15be2dca930e00da1083</br>

## 四、声明
应用中展示的所有内容均搜集自互联网，若内容有侵权请联系作者进行删除处理。本应用仅用作分享与学习。
## 五、未完待续
后期会封装其他一些优秀的开源库、以及工具类进来，方便快速开发，避免重复造轮子。
