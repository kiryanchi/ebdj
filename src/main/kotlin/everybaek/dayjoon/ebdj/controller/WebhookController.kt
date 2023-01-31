package everybaek.dayjoon.ebdj.controller

import everybaek.dayjoon.ebdj.domain.dto.GithubWebhookPushPayload
import everybaek.dayjoon.ebdj.service.WebhookService
import org.slf4j.LoggerFactory
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class WebhookController(
    val webhookService: WebhookService,
) {
    private val log = LoggerFactory.getLogger(javaClass)

    @PostMapping("/api/webhook/push")
    fun push(@RequestBody payload: GithubWebhookPushPayload) {
        log.debug("새로운 payload push API 요청 들어옴")
        log.debug("payload: $payload")
        this.webhookService.push(payload)
    }
}