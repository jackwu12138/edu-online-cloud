package com.jackwu.module.course.controller.article;

import com.jackwu.framework.common.pojo.CommonResult;
import com.jackwu.framework.common.pojo.PageParam;
import com.jackwu.framework.common.pojo.PageResult;
import com.jackwu.module.course.controller.article.vo.article.ArticleCreateRequestVO;
import com.jackwu.module.course.controller.article.vo.article.ArticleListResponseVO;
import com.jackwu.module.course.controller.article.vo.article.ArticleUpdateRequestVO;
import com.jackwu.module.course.controller.article.vo.article.ArticleUpdateResponseVO;
import com.jackwu.module.course.service.article.ArticleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * 课程模块 - 文章
 *
 * @author jackwu
 */
@Api(tags = "课程模块 - 文章")
@RestController
@RequiredArgsConstructor
@RequestMapping("/course/article")
public class ArticleController {

    private final ArticleService service;

    @ApiOperation("创建文章")
    @PostMapping("/delete")
    public CommonResult<Long> createArticle(@Valid @RequestBody ArticleCreateRequestVO vo) {
        return CommonResult.success(service.createArticle(vo));
    }

    @ApiOperation("删除文章")
    @DeleteMapping("/delete")
    public CommonResult<Boolean> deleteArticle(@RequestParam("id") Long id) {
        service.deleteArticle(id);
        return CommonResult.success(true);
    }

    @ApiOperation("更新文章")
    @PutMapping("/update")
    public CommonResult<Boolean> updateArticle(@Valid @RequestBody ArticleUpdateRequestVO vo) {
        service.updateArticle(vo);
        return CommonResult.success(true);
    }

    @ApiOperation("获取文章分页列表")
    @GetMapping("/page")
    public CommonResult<PageResult<ArticleListResponseVO>> getArticlePageList(@Valid PageParam param) {
        return CommonResult.success(service.getArticlePageList(param));
    }

    @ApiOperation("根据id获取文章内容")
    @GetMapping("/info/{id}")
    public CommonResult<ArticleUpdateResponseVO> getArticleInfo(@PathVariable("id") Long id) {
        return CommonResult.success(service.getArticleInfo(id));
    }
}

