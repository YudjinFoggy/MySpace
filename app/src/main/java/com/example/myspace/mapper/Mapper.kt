package com.example.myspace.mapper

interface Mapper<F,T> {
    fun map(from: F) : T
}