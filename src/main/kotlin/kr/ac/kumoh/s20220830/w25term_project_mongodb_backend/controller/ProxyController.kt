package kr.ac.kumoh.s20220830.w25term_project_mongodb_backend.controller

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.net.URL
import java.util.concurrent.ConcurrentHashMap

@RestController
@RequestMapping("/api/proxy")
class ProxyController {

    // 이미지 캐시: URL → ByteArray
    private val imageCache = ConcurrentHashMap<String, ByteArray>()
    private val contentTypeCache = ConcurrentHashMap<String, String>()

    @GetMapping("/image")
    fun proxyImage(@RequestParam url: String): ResponseEntity<ByteArray> {

        // 1) 캐시 먼저 확인
        if (imageCache.containsKey(url)) {
            return ResponseEntity
                .ok()
                .header("Content-Type", contentTypeCache[url] ?: "image/jpeg")
                .body(imageCache[url])
        }

        // 2) 캐시에 없다면 외부에서 다운로드
        val connection = URL(url).openConnection()
        connection.connect()

        val contentType = connection.contentType ?: "image/jpeg"
        val bytes = connection.getInputStream().readAllBytes()

        // 3) 메모리에 캐싱
        imageCache[url] = bytes
        contentTypeCache[url] = contentType

        return ResponseEntity
            .ok()
            .header("Content-Type", contentType)
            .body(bytes)
    }
}
