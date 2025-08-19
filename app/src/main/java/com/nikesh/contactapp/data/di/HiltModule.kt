package com.nikesh.contactapp.data.di

import android.app.Application
import androidx.room.Room
import com.nikesh.contactapp.data.database.ContactDataBase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object HiltModule {

    @Provides
    fun provideDatabase(application: Application): ContactDataBase {
        return Room.databaseBuilder(
                application.baseContext,
                ContactDataBase::class.java,
                "contacts_db"
            ).fallbackToDestructiveMigration().build()
    }
}
