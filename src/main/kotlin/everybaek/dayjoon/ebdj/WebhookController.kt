package everybaek.dayjoon.ebdj

import everybaek.dayjoon.ebdj.dto.GithubWebhookPushPayload
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class WebhookController(
    val webhookService: WebhookService,
) {
    @PostMapping("/api/webhook/push")
    fun push(@RequestBody payload: GithubWebhookPushPayload) {
        this.webhookService.push(payload)
    }
}