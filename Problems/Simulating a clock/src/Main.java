class Clock {

    int hours = 12;
    int minutes = 0;

    void next() {
        if (hours == 12 && minutes == 59) {
            minutes = 0;
            hours = 1;
        } else if (minutes == 59) {
            minutes = 0;
            hours++;
        } else {
            minutes++;
        }
    }
}