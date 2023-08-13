package com.hoc081098.compose_multiplatform_kmpviewmodel_sample.photo_detail

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun SearchPhotoScreen(
  navigateToPhotoDetail: (id: String) -> Unit,
  modifier: Modifier = Modifier,
) {
  SearchPhotoScreenWithKoin(
    modifier = modifier,
    navigateToPhotoDetail = navigateToPhotoDetail,
  )
}

actual fun isDebug(): Boolean = true