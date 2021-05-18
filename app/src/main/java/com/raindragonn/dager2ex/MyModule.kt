package com.raindragonn.dager2ex

import dagger.Module
import dagger.Provides

// Created by raindragonn on 2021/05/18.

@Module
class MyModule {
//    @Provides
//    fun provideHelloWorld(): String = "Hello World"

    @Provides
    fun provideName(): String = "raindragonn"

    @Provides
    fun provideAge(): Int = 100

    @Provides
    fun providesPerson(name: String, age: Int): Person = Person(name, age)

//    하나의 모듈 또는 서로 다른 모듈 내에 반환형이 같은 메서드가 두 개 이상 있으면 컴파일 타임에 에러가 발생합니다.
//    @Provides
//    fun provideString() : String = "haha"
}