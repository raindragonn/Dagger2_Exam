package com.raindragonn.dager2ex

import dagger.Component
import dagger.Module
import dagger.Provides
import javax.inject.Inject

// Created by raindragonn on 2021/05/18.

@Module
class ModuleA {
    @Provides
    fun provideA() : A = A()
}

// 모듈의 상속 컴포넌트를 선언할 때 ModuleB를 참조하는 경우 ModuleA를 상속해 A타입의 객체 또한 바인딩 됩니다.
// 주의해야 할 점은 모듁 간 상속을 할 때 중복되는 타입이 존재하면 안된다는 것 입니다.

@Module(includes = [ModuleA::class])
class ModuleB {
    @Provides
    fun provideB() : B = B()
}

class A
class B