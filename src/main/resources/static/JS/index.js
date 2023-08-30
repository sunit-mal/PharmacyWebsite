function notificationPanel() {
    var notificationElement = document.getElementById("notification");
    var containsElement = document.getElementById("contains");
    if (notificationElement.classList.contains("changePanel")) {
        notificationElement.classList.remove("changePanel");
        containsElement.classList.remove("containChange");
    } else {
        notificationElement.classList.add("changePanel");
        containsElement.classList.add("containChange");
    }
}
