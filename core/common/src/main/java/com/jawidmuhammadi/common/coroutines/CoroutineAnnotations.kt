package com.jawidmuhammadi.common.coroutines

import javax.inject.Qualifier
import kotlin.annotation.AnnotationRetention.RUNTIME


@Qualifier
@Retention(RUNTIME)
annotation class MondlyIoDispatcher

@Qualifier
@Retention(RUNTIME)
annotation class MondlyDefaultDispatcher