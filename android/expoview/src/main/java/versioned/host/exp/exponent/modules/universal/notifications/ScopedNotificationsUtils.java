package versioned.host.exp.exponent.modules.universal.notifications;

import android.util.Log;

import expo.modules.notifications.notifications.model.Notification;
import expo.modules.notifications.notifications.model.NotificationRequest;
import host.exp.exponent.kernel.ExperienceId;

class ScopedNotificationsUtils {
  static boolean shouldHandleNotification(Notification notification, ExperienceId experienceId) {
    NotificationRequest notificationRequest = notification.getNotificationRequest();
    if (notificationRequest instanceof ScopedNotificationRequest) {
      ScopedNotificationRequest scopedNotificationRequest = (ScopedNotificationRequest) notificationRequest;
      return scopedNotificationRequest.checkIfBelongsToExperience(experienceId);
    }

    Log.w("expo-notifications", "The notification's requester should be scoped.", null);
    return false;
  }
}
