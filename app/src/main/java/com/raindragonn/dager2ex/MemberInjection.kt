package com.raindragonn.dager2ex

import dagger.Component
import dagger.MembersInjector
import dagger.Module
import dagger.Provides
import javax.inject.Inject

// Created by raindragonn on 2021/05/18.

@Module
object MemberInjectModule {
    @Provides
    fun getString(): String = "MemberInject"
}

@Component(modules = [MemberInjectModule::class])
interface MemberInjectComponent {
//    fun inject(myClass: MyClass) : MyClass
    fun inject(myClass: MyClass)
    fun memberInject() : MembersInjector<MyClass>
}

class MyClass {
    @Inject
    lateinit var str: String

    val nullOrStr: String?
        get() = if (::str.isInitialized.not())
            null
        else str
}
