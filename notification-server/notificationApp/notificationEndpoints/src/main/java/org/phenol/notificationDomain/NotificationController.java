package org.phenol.notificationDomain;

import jakarta.ws.rs.Path;
import org.phenol.notificationService.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/notif")
public class NotificationController {

    @Autowired
    private NotificationService notificationService;

    @GetMapping("/test")
    public String test() {
        return "Hello Notification Test!";
    }

    @PostMapping("/create/{bookId}/{userId}/{type}")
    public ResponseEntity<?> createNotification(@PathVariable Long userId, @PathVariable Long bookId, @PathVariable Type type) {
        NotificationDTO dto = notificationService.createNotificationWithFields(userId, bookId, type);
        return ResponseEntity.ok(dto);
    }

    @PostMapping("/create/{userId}/{bookId}/{date}/{type}")
    public ResponseEntity<?> createWithField(@PathVariable Long userId,
                                     @PathVariable Long bookId,
                                     @PathVariable String date,
                                     @PathVariable String type) {

        NotificationDTO dto = notificationService.createWithFields(userId, bookId, date, type);
        return ResponseEntity.ok(dto);
    }
}

