package com.voucher.manage2.utils;

import org.apache.commons.lang.StringUtils;

import javax.servlet.http.HttpSession;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class SessionUtils {
    private static final Long sessionMaxAge = 86400L;

    private SessionUtils() {

    }

    private static class SessionUtilsInner {
        private static final SessionUtils SESSION_UTIL = new SessionUtils();
    }

    public static SessionUtils getSessionUtils() {
        return SessionUtilsInner.SESSION_UTIL;
    }

    private static ConcurrentHashMap<String, HttpSession> sessionMap;
    static {
        sessionMap = new ConcurrentHashMap<>();
    }

    public static ConcurrentHashMap<String, HttpSession> getSessionMap() {
        sessionMap = cleanMap(sessionMap);
        return sessionMap;
    }

    private static synchronized ConcurrentHashMap<String, HttpSession> cleanMap(
            ConcurrentHashMap<String, HttpSession> map) {
        if (map.size() < 1) {
            return map;
        }

        Set<Map.Entry<String, HttpSession>> entrySet = map.entrySet();
        List<String> list = new ArrayList<>();
        for (Map.Entry<String, HttpSession> entry : entrySet) {
            // 如果session过期了，就清除掉这个session
            long max_age = sessionMaxAge * 1000L;
            long time = new Date().getTime();
            long creationTime = entry.getValue().getCreationTime();
            long sessionAge = time - creationTime;
            if (sessionAge > max_age) {
                list.add(entry.getKey());
                entry.getValue().setMaxInactiveInterval(1);
            }
        }

        if (list != null && list.size() > 0) {
            for (int i = 0; i < list.size(); i++) {
                map.remove(list.get(i));
            }
        }
        list = null;
        return map;
    }

    public static synchronized void cleanOldSession(String userInfo) {
        if (sessionMap != null && sessionMap.size() > 0) {
            Set<Map.Entry<String, HttpSession>> entrySet = sessionMap.entrySet();
            String sessionKey = "";
            for (Map.Entry<String, HttpSession> entry : entrySet) {
                if (StringUtils.isNotBlank(userInfo)
                        && userInfo.equals((String) entry.getValue().getAttribute("userInfo"))) {
                    sessionKey = entry.getKey();
                    entry.getValue().setMaxInactiveInterval(1);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    break;
                }
            }
            if (StringUtils.isNotBlank(sessionKey)) {
                sessionMap.remove(sessionKey);
            }
        }
    }

}
