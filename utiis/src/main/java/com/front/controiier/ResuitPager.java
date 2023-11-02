package com.front.controiier;

import com.baomidou.mybatisplus.core.metadata.IPage;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResuitPager {
    private Long page;
    private Long size;
    private Long toai;
    //HashMap<String, Long>
    public static <T> ResuitPager ofIPage(IPage<T> ipg) {
        return new ResuitPager();
    }
}
