/**
 * Copied from [com.freeletics.khonshu.navigation.compose.NavDestination.kt](https://github.com/freeletics/khonshu/blob/1e7732b44e1abf04e2e7468c99300dc140132da1/navigation-experimental/src/main/kotlin/com/freeletics/khonshu/navigation/compose/NavDestination.kt)
 */

package com.hoc081098.compose_multiplatform_kmpviewmodel_sample.navigation

import androidx.compose.runtime.Composable
import com.hoc081098.compose_multiplatform_kmpviewmodel_sample.navigation.internal.DestinationId
import com.hoc081098.compose_multiplatform_kmpviewmodel_sample.navigation.internal.InternalNavigationApi

/**
 * A destination that can be navigated to. See [NavHost] for how to configure a `NavGraph` with it.
 */
public sealed interface NavDestination

@OptIn(InternalNavigationApi::class)
internal sealed interface ContentDestination<T : BaseRoute> : NavDestination {
  val id: DestinationId<T>
  val extra: Any?
  val content: @Composable (T) -> Unit
}

/**
 * Creates a new [NavDestination] that represents a full screen. The class of [T] will be used
 * as a unique identifier. The given [content] will be shown when the screen is being
 * navigated to using an instance of [T].
 */
@OptIn(InternalNavigationApi::class)
@Suppress("FunctionName")
public inline fun <reified T : BaseRoute> ScreenDestination(
  noinline content: @Composable (T) -> Unit,
): NavDestination = ScreenDestination(DestinationId(T::class), null, content)

@InternalNavigationApi
@Suppress("FunctionName")
public inline fun <reified T : BaseRoute> ScreenDestination(
  extra: Any,
  noinline content: @Composable (T) -> Unit,
): NavDestination = ScreenDestination(DestinationId(T::class), extra, content)

@OptIn(InternalNavigationApi::class)
@PublishedApi
internal class ScreenDestination<T : BaseRoute>(
  override val id: DestinationId<T>,
  override val extra: Any?,
  override val content: @Composable (T) -> Unit,
) : ContentDestination<T>

/**
 * Creates a new [NavDestination] that is shown on top a [ScreenDestination], for example a dialog or bottom sheet. The
 * class of [T] will be used as a unique identifier. The given [content] will be shown inside the dialog window when
 * navigating to it by using an instance of [T].
 */
@OptIn(InternalNavigationApi::class)
@Suppress("FunctionName")
public inline fun <reified T : NavRoute> OverlayDestination(
  noinline content: @Composable (T) -> Unit,
): NavDestination = OverlayDestination(DestinationId(T::class), null, content)

@InternalNavigationApi
@Suppress("FunctionName")
public inline fun <reified T : NavRoute> OverlayDestination(
  extra: Any,
  noinline content: @Composable (T) -> Unit,
): NavDestination = OverlayDestination(DestinationId(T::class), extra, content)

@OptIn(InternalNavigationApi::class)
@PublishedApi
internal class OverlayDestination<T : NavRoute>(
  override val id: DestinationId<T>,
  override val extra: Any?,
  override val content: @Composable (T) -> Unit,
) : ContentDestination<T>
