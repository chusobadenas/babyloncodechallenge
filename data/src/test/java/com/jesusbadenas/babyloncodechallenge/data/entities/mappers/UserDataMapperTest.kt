package com.jesusbadenas.babyloncodechallenge.data.entities.mappers

import com.jesusbadenas.babyloncodechallenge.data.entities.CompanyData
import com.jesusbadenas.babyloncodechallenge.data.entities.UserData
import org.junit.Assert.*
import org.junit.Test

class UserDataMapperTest {

    companion object {
        private const val ID = 1
        private const val NAME = "John Doe"
    }

    private val userDataMapper = UserDataMapper()
    private val companyData = CompanyData("", "", "")
    private val userData = UserData(ID, NAME, "", "", "", "", companyData)

    @Test
    fun testTransformToUserEntity() {
        val userEntity = userDataMapper.transform(userData)

        assertEquals(userEntity.id, ID)
        assertEquals(userEntity.name, NAME)
    }

    @Test
    fun testTransformToUserEntityCollection() {
        val userDataList = arrayListOf(userData)

        val userEntities = userDataMapper.transform(userDataList)

        assertTrue(userEntities.isNotEmpty())
        assertSame(userEntities.size, 1)

        val userEntity = userEntities[0]
        assertEquals(userEntity.id, ID)
        assertEquals(userEntity.name, NAME)
    }
}
