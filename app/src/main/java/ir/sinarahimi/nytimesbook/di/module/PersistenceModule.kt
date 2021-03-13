package ir.sinarahimi.nytimesbook.di.module

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import ir.sinarahimi.persistence.database.BookDataBase
import ir.sinarahimi.persistence.database.dao.BookDao
import javax.inject.Singleton

/**
 * Created by Sina Rahimi on 2/20/2021.
 */
@Module
@InstallIn(SingletonComponent::class)
class PersistenceModule {

    @Singleton
    @Provides
    fun provideBookDataBase(@ApplicationContext context: Context): BookDataBase =
        Room.databaseBuilder(context, BookDataBase::class.java, "database.db").build()

    @Singleton
    @Provides
    fun provideBookDao(bookDataBase: BookDataBase): BookDao =
        bookDataBase.bookDao()
}