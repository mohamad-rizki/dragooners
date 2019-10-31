package com.dafian.android.dragooners.util

import com.dafian.android.dragooners.domain.model.*
import java.util.*

object TestDataFactory {

    fun makeDataArmorList(count: Int = 100): List<Armor> {
        val list = mutableListOf<Armor>()
        for (i in 1 until count) {
            list.add(makeDataArmor())
        }
        return list
    }

    fun makeDataCharmList(count: Int = 100): List<Charm> {
        val list = mutableListOf<Charm>()
        for (i in 1 until count) {
            list.add(makeDataCharm())
        }
        return list
    }

    fun makeDataItemList(count: Int = 100): List<Item> {
        val list = mutableListOf<Item>()
        for (i in 1 until count) {
            list.add(makeDataItem())
        }
        return list
    }

    fun makeDataSkillList(count: Int = 100): List<Skill> {
        val list = mutableListOf<Skill>()
        for (i in 1 until count) {
            list.add(makeDataSkill())
        }
        return list
    }

    fun makeDataWeaponList(count: Int = 100): List<Weapon> {
        val list = mutableListOf<Weapon>()
        for (i in 1 until count) {
            list.add(makeDataWeapon())
        }
        return list
    }

    private fun makeDataSlotList(count: Int = 100): List<Slot> {
        val list = mutableListOf<Slot>()
        for (i in 1 until count) {
            list.add(makeDataSlot())
        }
        return list
    }

    private fun makeDataCraftingCostList(count: Int = 100): List<CraftingCost> {
        val list = mutableListOf<CraftingCost>()
        for (i in 1 until count) {
            list.add(makeDataCraftingCost())
        }
        return list
    }

    private fun makeDataCharmRankList(count: Int = 100): List<CharmRank> {
        val list = mutableListOf<CharmRank>()
        for (i in 1 until count) {
            list.add(makeDataCharmRank())
        }
        return list
    }

    private fun makeDataItem(): Item {
        return Item(
            Math.random().toInt(),
            UUID.randomUUID().toString(),
            UUID.randomUUID().toString(),
            Math.random().toInt(),
            Math.random().toInt(),
            Math.random().toInt(),
            Math.random().toInt()
        )
    }

    private fun makeDataArmor(): Armor {
        return Armor(
            Math.random().toInt(),
            UUID.randomUUID().toString(),
            UUID.randomUUID().toString(),
            UUID.randomUUID().toString(),
            UUID.randomUUID().toString(),
            Math.random().toInt(),
            makeDataDefense(),
            makeDataResistance(),
            makeDataSlotList(),
            makeDataSkillList(),
            makeDataAsset(),
            makeDataCraftingInfo()
        )
    }

    private fun makeDataCharm(): Charm {
        return Charm(
            Math.random().toInt(),
            UUID.randomUUID().toString(),
            UUID.randomUUID().toString(),
            makeDataCharmRankList()
        )
    }

    private fun makeDataSkill(): Skill {
        return Skill(
            Math.random().toInt(),
            UUID.randomUUID().toString(),
            Math.random().toInt(),
            UUID.randomUUID().toString(),
            emptyList(),
            Math.random().toInt(),
            UUID.randomUUID().toString()
        )
    }

    private fun makeDataWeapon(): Weapon {
        return Weapon(
            Math.random().toInt(),
            UUID.randomUUID().toString(),
            UUID.randomUUID().toString(),
            UUID.randomUUID().toString(),
            Math.random().toInt(),
            Math.random().toInt(),
            makeDataSlotList(),
            emptyList(),
            UUID.randomUUID().toString(),
            makeDataWeaponAsset(),
            UUID.randomUUID().toString(),
            UUID.randomUUID().toString()
        )
    }

    private fun makeDataDefense(): Defense {
        return Defense(
            Math.random().toInt(),
            Math.random().toInt(),
            Math.random().toInt()
        )
    }

    private fun makeDataResistance(): Resistances {
        return Resistances(
            Math.random().toInt(),
            Math.random().toInt(),
            Math.random().toInt(),
            Math.random().toInt(),
            Math.random().toInt()
        )
    }

    private fun makeDataSlot(): Slot {
        return Slot(
            Math.random().toInt()
        )
    }

    private fun makeDataAsset(): ArmorAsset {
        return ArmorAsset(
            UUID.randomUUID().toString(),
            UUID.randomUUID().toString()
        )
    }

    private fun makeDataCraftingInfo(): CraftingInfo {
        return CraftingInfo(
            makeDataCraftingCostList()
        )
    }

    private fun makeDataCraftingCost(): CraftingCost {
        return CraftingCost(
            Math.random().toInt(),
            makeDataItem()
        )
    }

    private fun makeDataCharmRank(): CharmRank {
        return CharmRank(
            UUID.randomUUID().toString(),
            Math.random().toInt(),
            Math.random().toInt(),
            makeDataSkillList(),
            makeDataCharmRankCrafting()
        )
    }

    private fun makeDataCharmRankCrafting(): CharmRankCrafting {
        return CharmRankCrafting(
            true,
            makeDataCraftingCostList()
        )
    }

    private fun makeDataWeaponAsset(): WeaponAsset {
        return WeaponAsset(
            UUID.randomUUID().toString(),
            UUID.randomUUID().toString()
        )
    }
}