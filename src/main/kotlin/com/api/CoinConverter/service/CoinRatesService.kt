package com.api.CoinConverter.service

import com.api.CoinConverter.domain.ResponseConversionRate
import org.springframework.beans.factory.annotation.Value
import org.springframework.core.ParameterizedTypeReference
import org.springframework.http.HttpEntity
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpMethod
import org.springframework.http.MediaType
import org.springframework.stereotype.Service
import org.springframework.web.client.RestTemplate
import org.springframework.web.util.UriComponentsBuilder


interface CoinRatesService {
    fun getConversionRate(access_key: String, base: String): ResponseConversionRate?
}

@Service
class CoinRatesServiceImpl(@Value("\${external.coin.converter.endpoint.url}") val coinEndpoint: String,
                           val restTemplate: RestTemplate
): CoinRatesService {

    override fun getConversionRate(access_key: String, base: String): ResponseConversionRate? {
        val headers = HttpHeaders()
        headers.contentType = MediaType.APPLICATION_JSON

        val respBody = restTemplate.exchange(
            UriComponentsBuilder.fromUriString(this.coinEndpoint)
                .queryParam("access_key", access_key)
                .queryParam("base", base)
                .toUriString(),
            HttpMethod.GET,
            HttpEntity("", headers),
            object : ParameterizedTypeReference<ResponseConversionRate>() {})
        return respBody.body

    }
}
