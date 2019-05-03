package com.trubinov.shipperinfo.domain

import com.trubinov.shipperinfo.domain.data.model.Info
import io.reactivex.Observable

interface InfoRepository {
    fun get(): Observable<Info>
}