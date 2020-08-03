package com.meifute.restructure.mmopenfeign.domain.search.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author lizz
 * @date 2020/4/8 11:33
 */
@TableName("search_demo")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SearchDemoEntity {

    @TableId
    private String id;

    private String searchName;
}
