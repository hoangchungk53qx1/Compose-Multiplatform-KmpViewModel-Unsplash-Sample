package com.hoc081098.compose_multiplatform_kmpviewmodel_sample.search_photo.data

import io.ktor.client.HttpClient
import io.ktor.client.engine.okhttp.OkHttp
import kotlinx.serialization.json.Json
import org.koin.core.annotation.Singleton

@Singleton
internal actual fun createHttpClient(json: Json): HttpClient =
  createHttpClient(
    engineFactory = OkHttp,
    json = json,
  ) {}
