package com.raindragonn.dager2ex

import dagger.Component
import dagger.Module
import dagger.Provides
import org.junit.Test
import javax.inject.Inject
import org.junit.Assert.*

// Created by raindragonn on 2021/05/18.


class MemberInjectionTest {
    @Test
    fun test() {
        val myClass = MyClass()
        var str = myClass.nullOrStr
        val component = DaggerMemberInjectComponent.create()
//        component.inject(myClass)
        val injector = component.memberInject()
        injector.injectMembers(myClass)
        str = myClass.nullOrStr
        assertEquals("MemberInject",str)
    }
}

