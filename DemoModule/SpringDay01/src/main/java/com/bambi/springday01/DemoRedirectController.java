package com.bambi.springday01;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

/**
 * 描述： 测试Spring重定向
 *
 * <pre>
 * HISTORY
 * ****************************************************************************
 *  ID     DATE          PERSON          REASON
 *  1      2021/9/3 0:47    Bambi        Create
 * ****************************************************************************
 * </pre>
 *
 * @author Bambi
 * @since 1.0
 */
@Controller
@RequestMapping("/")
public class DemoRedirectController {

    @GetMapping("/redirect")
    public RedirectView redirectView(RedirectAttributes redirectAttributes){
        redirectAttributes.addFlashAttribute("flashAttribute","redirect");
        redirectAttributes.addAttribute("attribute","redirect");
        return new RedirectView("/gotU");
    }

    @GetMapping("/gotU")
    @ResponseBody
    public String gotU(String attribute){
        return attribute;
    }

    //JT809 加密解密算法
    public static byte[] encrypt(int M1,int IA1,int IC1,int key,byte [] data) {
        if(data == null) return null;

        byte[] array = data;//使用原对象，返回原对象

        //byte[] array = new byte[data.length]; //数组复制 返回新的对象
        //System.arraycopy(data, 0, array, 0, data.length);

        int idx=0;
        if(key==0){
            key=1;
        }
        int mkey = M1;
        if (0 == mkey )
        {
            mkey = 1;
        }
        while(idx<array.length){
            key = IA1 * ( key % mkey ) + IC1;
            array[idx]^=((key>>20)&0xFF);
            idx++;
        }
        return array;
    }
}
