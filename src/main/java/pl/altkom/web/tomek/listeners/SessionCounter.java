package pl.altkom.web.tomek.listeners;

import javax.faces.event.ListenerFor;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

@WebListener
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
