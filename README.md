
'[아키텍처를 알아야 앱 개발이 보인다](http://www.yes24.com/Product/Goods/89958199)' 책을 보며 공부한 내용 입니다.

# Dagger2

## Dagger2란 무엇인가?


Dagger2는 [DI(Dependency Injection)](https://raindragonn.github.io/2021/01/22/TIL-Android-Dependency-Injection/) Framework Library 입니다.

**특징**

 1. 리플렉션을 사용하지 않으며, 런 타임에 바이트 코드도 생성하지 않습니다.
 
 2. 컴파일 타임에 어노테이션 프로세서에 의해 의존성 주입과 관련된 모든 코드를 분석하고 자바 소스 코드를 생성합니다.

**장점**

 1. 복잡한 의존성을 단순하게 설정합니다

 2. 유닛 테스트를 보다 쉽게 도와줍니다.

 3. 컴파일 타임에 DI코드를 생성해주며 생성된 코드 또한 디버깅이 가능합니다.

 4. 라이브러리 크기가 작습니다.

### 기본적인 의존성 주입 구현

프로젝트에 Dagger 설정하기

app 수준의 build.gradle

```gradle
plugins {
    id 'kotlin-kapt'
}

dependencies {
    implementation 'com.google.dagger:dagger:2.35.1'
    kapt 'com.google.dagger:dagger-compiler:2.35.1'
}
```

"Hello World" 문자열 주입 예제

1. MyModule 클래스에 `@Module` 어노테이션을 붙여 해당 클래스가 의존성을 제공함을 명시하고 

2. 해당 모듈에서 의존성을 제공하는 메서드`provideHelloWorld()`에`@Provides` 어노테이션을 붙입니다.

3. `@Component` 어노테이션이 붙은 `MyComponent` 인터페이스 내에서는 제공할 의존성들을 정의하여 `@Component`에 참조된 모듈 클래스로부터 의존성을 제공받습니다.

   - 컴포넌트 메서드의 반환형을 보고 모듈과 관계를 맺으므로 바인드된 모듈로부터 해당 반환형을 갖는 메서드를 찾지 못하거나 특정하지 못한다면 컴파일 타임에 에러가 발생합니다.

4. Dagger2는 컴파일 타임에 `@Component`를 구현한 클래스를 생성하는데 이때 클래스의 이름은 'Dagger'라는 접두어가 붙습니다. 예를들어 MyComponent라는 컴포넌트를 만들었다면 DaggerMyComponent가 됩니다.

MyModule.kt
```kotlin
@Module
class MyModule {
    @Provides
    fun provideHelloWorld() : String = "Hello World"

//    하나의 모듈 또는 서로 다른 모듈 내에 반환형이 같은 메서드가 두 개 이상 있으면 컴파일 타임에 에러가 발생합니다.
//    @Provides
//    fun provideString() : String = "haha"
}
```

MyComponent.kt
```kotlin
@Component(modules = [MyModule::class])
interface MyComponent {
    fun getString(): String
}
```

ExampleUnitTest.kt
```kotlin
class ExampleUnitTest {
    @Test
    fun testHelloWorld() {
        val myComponent = DaggerMyComponent.create()
        println("result = ${myComponent.getString()}")
    }
}
```

### `@Module` 과 `@Provides`

- `@Module`

  - 컴포넌트에 의존성을 제공하는 역할을 합니다.

  - 클래스에 `@Module` 어노테이션을 붙이는것으로 모듈 클래스를 만들 수 있습니다. 
  
  - 의존성 주입에 필요한 객체들을 `@Provides`어노테이션이 붙은 메소드를 통해 관리합니다.

  - 해당 모듈 클래스 하나만으로는 별도의 클래스 파일이 생성되지는 않습니다. 모듈을 참조하는 컴포넌트가 필요하기 때문 입니다.

- `@Provides`

    - 모듈 클래스 내에 선언되는 메서드에 `@Provides` 어노테이션을 붙이는 것으로 컴파일 타임에 의존성을 제공하는 프로바이더를 생성합니다.

    - 하나의 무듈 또는 서로 다른 모듈 내에 반환형이 같은 타입인 메서드가 두 개 이상 있으면 컴파일 타임에 에러가 발생합니다.





---

참고자료 
[찰스님 블로그](https://www.charlezz.com/?p=1259)
