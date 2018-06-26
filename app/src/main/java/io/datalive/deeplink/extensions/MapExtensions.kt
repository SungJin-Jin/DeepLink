package io.datalive.deeplink.extensions


fun String.queryToMap(): Map<String, String> = split("&")
        .map { it.split("=") }
        .map { it[0] to it[1] }
        .toMap()