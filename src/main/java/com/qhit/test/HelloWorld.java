package com.qhit.test;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Administrator on 2019/3/28 0028.
 */
public class HelloWorld {

    public static void main(String[] args) {
        System.out.println(4&7);
        long temp=(int)3.9;
        temp%=2;
        System.out.println(temp);
        int m[] = {1,2,3,4,6};
        System.out.println(m.length);

        int index=1;
        String[] test=new String[3];
        String foo=test[index];
        System.out.println(foo);

        String s = null;
        if( (s!=null) || (s.length()>0) )
        {
            System.out.println(s);
        }

    }

}
