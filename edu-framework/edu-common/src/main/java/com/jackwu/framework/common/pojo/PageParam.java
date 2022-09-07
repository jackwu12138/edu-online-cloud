package com.jackwu.framework.common.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import java.io.Serializable;

/**
 * 分页参数
 *
 * @author jackwu
 */
@ApiModel("分页参数")
@Data
public class PageParam implements Serializable {

    /**
     * 默认情况下查询第几页
     */
    private static final Integer DEFAULT_PAGE = 1;

    /**
     * 默认情况下每页的大小
     */
    private static final Integer DEFAULT_SIZE = 10;

    @ApiModelProperty(value = "页码，从 1 开始",example = "1")
    private Integer page = DEFAULT_PAGE;

    @ApiModelProperty(value = "每页条数，最大值为 100", example = "10")
    private Integer size = DEFAULT_SIZE;
}
