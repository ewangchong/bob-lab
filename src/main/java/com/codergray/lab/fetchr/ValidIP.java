package com.codergray.lab.fetchr;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

// 1. valid ip address
public class ValidIP {
    public static void main(String args[]) throws Exception {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT */
        String ip1 = "0.+0.0.0";
        System.out.println(isValidIPAddress(ip1) == false);
        String ip2 = "255.255.255.255";
        System.out.println(isValidIPAddress(ip2) == true);
        String ip3 = "255.255.255";
        System.out.println(isValidIPAddress(ip3) == false);
        String ip4 = "255.255.255.256";
        System.out.println(isValidIPAddress(ip4) == false);
        String ip5 = "255.255.255.255.255";
        System.out.println(isValidIPAddress(ip5) == false);
        String ip6 = "abc.abc.abc.abc";
        System.out.println(isValidIPAddress(ip6) == false);
    }

    private static boolean isValidIPAddress(String ipStr) {
        if (ipStr == null || ipStr.length() < 7) {
            return false;
        }

        if (ipStr.indexOf('.') == -1) {
            return false;
        }

        if (ipStr.indexOf('+') > 1) {
            return false;
        }

        String[] segments = ipStr.split("\\.");

        if (segments.length != 4) {
            return false;
        }

        for (String segment : segments) {
            try {
                int val = Integer.valueOf(segment);
                if (val < 0 || val > 255) {
                    return false;
                }
            } catch (Exception e) {
                return false;
            }
        }

        return true;
    }

    /**
     * IPv4地址转换为int类型数字
     */
    public static int ip2Integer(String ipv4Addr) {
        // 判断是否是ip格式的
        if (!isIPv4Address(ipv4Addr))
            throw new RuntimeException("Invalid ip address");

        // 匹配数字
        Pattern pattern = Pattern.compile("\\d+");
        Matcher matcher = pattern.matcher(ipv4Addr);
        int result = 0;
        int counter = 0;
        while (matcher.find()) {
            int value = Integer.parseInt(matcher.group());
            result = (value << 8 * (3 - counter++)) | result;
        }
        return result;
    }

    /**
     * 判断是否为ipv4地址
     */
    private static boolean isIPv4Address(String ipv4Addr) {
        String lower = "(\\d|[1-9]\\d|1\\d{2}|2[0-4]\\d|25[0-5])"; // 0-255的数字
        String regex = lower + "(\\." + lower + "){3}";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(ipv4Addr);
        return matcher.matches();
    }

    /**
     * 将int数字转换成ipv4地址
     */
    public static String integer2Ip(int ip) {
        StringBuilder sb = new StringBuilder();
        int num = 0;
        boolean needPoint = false; // 是否需要加入'.'
        for (int i = 0; i < 4; i++) {
            if (needPoint) {
                sb.append('.');
            }
            needPoint = true;
            int offset = 8 * (3 - i);
            num = (ip >> offset) & 0xff;
            sb.append(num);
        }
        return sb.toString();
    }
}


// "192.168.0.1" ipv4
// 
