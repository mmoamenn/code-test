package com.interview.codetest.core.bases

import com.interview.codetest.data.api.NetworkAPI
import com.interview.codetest.data.caching.Cache
import org.koin.core.KoinComponent
import org.koin.core.inject
import javax.security.auth.callback.CallbackHandler

open class BaseRepository : KoinComponent {

    val network: NetworkAPI by inject()

    val cache: Cache by inject()

}