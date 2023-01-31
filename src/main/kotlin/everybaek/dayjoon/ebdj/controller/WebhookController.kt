package everybaek.dayjoon.ebdj.controller

import everybaek.dayjoon.ebdj.domain.dto.GithubWebhookPushPayload
import everybaek.dayjoon.ebdj.service.WebhookService
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class WebhookController(
    val webhookService: WebhookService,
) {
    @PostMapping("/api/webhook/push")
    fun push(@RequestBody payload: GithubWebhookPushPayload) {
        println(payload)
        this.webhookService.push(payload)
    }
}