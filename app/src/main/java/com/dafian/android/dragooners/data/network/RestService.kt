package com.dafian.android.dragooners.data.network

import com.dafian.android.dragooners.domain.entity.*
import kotlinx.coroutines.Deferred
import retrofit2.http.GET

interface RestService {

    @GET("/weapons")
    fun getWeaponAll(): Deferred<List<Weapon>>

    @GET("/armor")
    fun getArmorAll(): Deferred<List<Armor>>

    @GET("/charms")
    fun getCharmAll(): Deferred<List<Charm>>

    @GET("/items")
    fun getItemAll(): Deferred<List<Item>>

    @GET("/skills")
    fun getSkillAll(): Deferred<List<Skill>>
}