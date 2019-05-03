package com.trubinov.shipperinfo.data

import io.reactivex.Single

abstract class BaseRepository<T> {
    abstract fun getRemote(): Single<T>
}