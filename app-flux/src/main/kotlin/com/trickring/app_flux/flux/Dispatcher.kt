package com.trickring.app_flux.flux

import kotlinx.coroutines.channels.BroadcastChannel

/**
 * Dispatcher
 */
class Dispatcher {

    /**
     * Event to notify "store".
     */
    val event = BroadcastChannel<Action>(1)

    /**
     * Dispatch event.
     *
     * @param action T
     */
    suspend fun dispatch(action: Action) {
        event.send(action)
    }
}
