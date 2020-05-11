package com.example.dynamic.util;

import com.baomidou.dynamic.datasource.toolkit.CryptoUtils;

/**
 * 如果你有使用Druid可使用其加密方法,详细请参考Druid集成章节.
 * 本程序从V2.5.5开始内置加密方法,其核心也是直接拷贝Druid的核心加密源码.
 * 支持url , username, password 的加密.
 * ENC(xxx) 中包裹的xxx即为使用加密方法后生成的字符串.
 */
public class ConnectionEncryptionUtils {
    public static void main(String[] args) throws Exception {
        String password = "";

        String encodePassword = CryptoUtils.encrypt(password);
        System.out.println(encodePassword);

        //自定义publicKey
        String[] arr = CryptoUtils.genKeyPair(512);
        System.out.println("privateKey:" + arr[0]);
        System.out.println("publicKey:" + arr[1]);
        System.out.println("password:" + CryptoUtils.encrypt(arr[0], password));
    }
}
