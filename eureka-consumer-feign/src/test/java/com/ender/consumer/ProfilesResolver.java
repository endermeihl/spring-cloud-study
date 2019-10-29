package com.ender.consumer;

import org.springframework.test.context.ActiveProfilesResolver;

/**
 * @author jiyq
 * 2019/3/12
 */
public class ProfilesResolver implements ActiveProfilesResolver {
    static String profile = "dev";

    @Override
    public String[] resolve(Class<?> aClass) {
        return new String[]{profile,"common","mix"};
    }


}
