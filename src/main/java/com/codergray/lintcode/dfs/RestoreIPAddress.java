package com.codergray.lintcode.dfs;

import java.util.ArrayList;
import java.util.List;

public class RestoreIPAddress {
    public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<>();
        List<String> list = new ArrayList<>();

        if(null == s || s.length() < 4 || s.length() > 12){
            return result;
        }

        dfs(result, list, s, 0);
        return result;
    }

    private void dfs(List<String> result, List<String> list, String s, int start){
        if(list.size() == 4){
            StringBuffer sb = new StringBuffer();
            for(String segment : list){
                sb.append(segment);
                sb.append(".");
            }
            sb.deleteCharAt(sb.length() - 1);
            result.add(sb.toString());
            return;
        }
        for(int i = start; i < s.length() && i < start + 3; i++){
            String tmp = s.substring(start, i + 1);
            if(valid(tmp)){
                list.add(tmp);
                dfs(result, list, s, start + 1);
                list.remove(list.size() - 1);
            }
        }
    }

    private boolean valid(String tmp){
        if(tmp.charAt(0) == '0'){
            return tmp.equals("0");
        }
        int val = Integer.valueOf(tmp);
        return val >= 0 && val <= 255;
    }
}