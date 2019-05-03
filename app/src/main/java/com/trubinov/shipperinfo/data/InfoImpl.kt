package com.trubinov.shipperinfo.data

import com.trubinov.shipperinfo.data.network.Api
import com.trubinov.shipperinfo.domain.InfoRepository
import com.trubinov.shipperinfo.domain.data.model.Info
import io.reactivex.Observable
import io.reactivex.Single

class InfoImpl(private val mApi: Api) : BaseRepository<Info>(), InfoRepository {
    override fun get(): Observable<Info> = getRemote().toObservable()

    override fun getRemote(): Single<Info> = mApi.info().map {
        Info(it.total_auctions, it.total_bets, it.today_auctions, it.today_bets)
    }
}