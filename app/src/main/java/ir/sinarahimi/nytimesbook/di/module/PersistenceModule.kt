package ir.sinarahimi.nytimesbook.di.module

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import ir.sinarahimi.persistence.database.BookDataBase
import ir.sinarahimi.persistence.database.dao.BookDao
import javax.inject.Singleton

/**
 * Created by Sina Rahimi on 2/20/2021.
 */
@Module
class PersistenceModule {

    @Singleton
    @Provides
    fun provideBookDataBase(context: Context): BookDataBase =
        Room.databaseBuilder(context, BookDataBase::class.java, "database.db").build()

    @Singleton
    @Provides
    fun provideBookDao(bookDataBase: BookDataBase): BookDao =
        bookDataBase.bookDao()
}