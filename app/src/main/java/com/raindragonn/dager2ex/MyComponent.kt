package com.raindragonn.dager2ex

import dagger.Component

// Created by raindragonn on 2021/05/18.

@Component(modules = [MyModule::class])
interface MyComponent {
    fun getName(): String
    fun getAge(): Int
    fun getPerson(): Person
}