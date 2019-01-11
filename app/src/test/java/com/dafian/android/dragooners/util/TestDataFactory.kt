package com.dafian.android.dragooners.util

import com.dafian.android.dragooners.domain.entity.*
import java.util.*

object TestDataFactory {

    fun makeDataArmorList(count: Int = 100): List<Armor> {
        val list = mutableListOf<Armor>()
        for (i in 1 until count) {
            list.add(makeDataArmor())
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

    private fun makeDataSlotList(count: Int = 100): List<Slot> {
        val list = mutableListOf<Slot>()
        for (i in 1 until count) {
            list.add(makeDataSlot())
        }
        return list
    }

    private fun makeDataSkillList(count: Int = 100): List<Skill> {
        val list = mutableListOf<Skill>()
        for (i in 1 until count) {
            list.add(makeDataSkill())
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
}