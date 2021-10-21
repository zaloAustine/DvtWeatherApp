package com.zalocoders.dvtweatherapp.db

import androidx.room.*
import com.zalocoders.dvtweatherapp.data.CurrentWeather
import com.zalocoders.dvtweatherapp.data.ForeCast
import kotlinx.coroutines.flow.Flow

@Dao
interface WeatherForecastDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCurrentLocationWeather(CurrentWeather: CurrentWeather)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertForeCast(foreCast: ForeCast)

    @Query("SELECT * FROM forecasts ORDER by lastUpdated ASC")
    fun getAllForeCasts(): Flow<List<ForeCast>>

    @Query("SELECT * FROM current_weather ORDER by lastUpdated ASC")
    fun getCurrentWeather(): Flow<CurrentWeather>

    @Query("DELETE FROM forecasts")
    suspend fun deleteAllForecasts()

}