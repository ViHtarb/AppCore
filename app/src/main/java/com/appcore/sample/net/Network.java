package com.appcore.sample.net;

/**
 * Created by Viнt@rь on 18.08.2016
 */
public final class Network extends com.appcore.net.Network {

    private static Network sInstance;
    public static Network getInstance() {
        if (sInstance == null) {
            sInstance = new Network();
        }
        return sInstance;
    }

    public void test() {

    }
}
