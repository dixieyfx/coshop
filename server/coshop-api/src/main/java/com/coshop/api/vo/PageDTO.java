package com.coshop.api.vo;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author dixiey
 * @version 1.0
 * @description: TODO
 * @date 2023/12/13 0:00
 */
@ApiModel("查询的分页信息")
@Data
public class PageDTO {

    @ApiModelProperty("当前页数")
    @JSONField(name = "currentPage")
    @JsonProperty("currentPage")
    private Integer currentPage = 1;

    @ApiModelProperty("每页多少条数据,默认20")
    @JSONField(name = "pageSize")
    @JsonProperty("pageSize")
    private Integer pageSize = 20;

    @ApiModelProperty("总行数")
    @JSONField(name = "total")
    @JsonProperty("total")
    private Integer total = 0;
}
