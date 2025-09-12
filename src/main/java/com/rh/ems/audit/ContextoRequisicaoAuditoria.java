package com.rh.ems.audit;

public class ContextoRequisicaoAuditoria {
    private static final ThreadLocal<String> ipHolder = new ThreadLocal<>();
    private static final ThreadLocal<String> methodHolder = new ThreadLocal<>();

    public static void setIp(String ip) {
        ipHolder.set(ip);
    }

    public static String getIp() {
        return ipHolder.get();
    }

    public static void setMethod(String method) {
        methodHolder.set(method);
    }

    public static String getMethod() {
        return methodHolder.get();
    }

    public static void clear() {
        ipHolder.remove();
        methodHolder.remove();
    }

}
