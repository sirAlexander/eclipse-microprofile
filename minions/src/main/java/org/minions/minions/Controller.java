package org.minions.minions;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.InetAddress;
import java.net.UnknownHostException;

@RestController
public class Controller {

    public static final String HTML_LINE_BREAK = "<br />";

    private final String version = "0.1";

    private final MinionsLibrary minionsLibrary;

    @Value("${spring.application.name}")
    private String appName;

    public Controller(MinionsLibrary minionsLibrary) {
        this.minionsLibrary = minionsLibrary;
    }

    @GetMapping
    public String minion() throws UnknownHostException {

        InetAddress localHost = InetAddress.getLocalHost();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Host: ").append(localHost.getHostName()).append(HTML_LINE_BREAK);
        stringBuilder.append("Minion Type: ").append(appName).append(HTML_LINE_BREAK);
        stringBuilder.append("IP: ").append(localHost.getHostAddress()).append(HTML_LINE_BREAK);
        stringBuilder.append("Version: ").append(version).append(HTML_LINE_BREAK);
        stringBuilder.append(minionsLibrary.getMinion(appName));

        return stringBuilder.toString();
    }

}
