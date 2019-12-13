package pl.altkom.web.tomek;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class SessionCounter implements HttpSessionListener {

    private static int activeSessions = 0;

    @Override
    public void sessionCreated(HttpSessionEvent e) {
        activeSessions++; // np. mozna wypisac stan licznika
    }
    @Override
    public void sessionDestroyed(HttpSessionEvent e) {
        activeSessions--;
    }

    public static int getActiveSessions() {
        return activeSessions;
    }
}
