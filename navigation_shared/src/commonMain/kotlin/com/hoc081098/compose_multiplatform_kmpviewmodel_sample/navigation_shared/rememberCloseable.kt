package com.hoc081098.compose_multiplatform_kmpviewmodel_sample.navigation_shared

import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisallowComposableCalls
import com.hoc081098.kmp.viewmodel.Closeable

@Composable
expect inline fun <reified T : Closeable> rememberCloseable(
  route: BaseRoute,
  crossinline factory: @DisallowComposableCalls () -> T,
): T
