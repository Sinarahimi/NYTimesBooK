package ir.sinarahimi.data.datasource.base

import ir.sinarahimi.domain.ModelNYTimes

/**
 * Created by Sina Rahimi on 2/10/2021.
 */
interface RemoteDataSource<T : ModelNYTimes> : DataSource<T>