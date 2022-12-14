package com.jackwu.module.course.controller.admin.article;

import com.jackwu.framework.common.pojo.CommonResult;
import com.jackwu.module.course.controller.admin.article.vo.articletype.ArticleTypeResponseVO;
import com.jackwu.module.course.controller.admin.article.vo.articletype.ArticleTypeSimpleResponseVO;
import com.jackwu.module.course.controller.admin.article.vo.articletype.ArticleTypeUpdateRequestVO;
import com.jackwu.module.course.controller.admin.article.vo.articletype.ArticleTypeCreateRequestVO;
import com.jackwu.module.course.service.article.ArticleTypeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

import static com.jackwu.framework.common.pojo.CommonResult.success;

/**
 * 课程模块 - admin-api - 文章分类
 *
 * @author jackwu
 */
@Api(tags = "课程模块 - admin-api - 文章类型")
@RestController
@RequiredArgsConstructor
@RequestMapping("/course/article-type")
public class ArticleTypeController {

    private final ArticleTypeService service;

    @ApiOperation("创建文章类型")
    @PostMapping("/create")
    public CommonResult<Long> createArticleType(@Valid @RequestBody ArticleTypeCreateRequestVO requestVO) {
        Long id = service.createArticleType(requestVO);
        return success(id);
    }

    @ApiOperation("删除文章类型")
    @DeleteMapping("/delete")
    public CommonResult<Boolean> deleteArticleType(@RequestParam("id") Long id) {
        service.deleteArticleTypeById(id);
        return success(true);
    }

    @ApiOperation("更新文章类型")
    @PutMapping("/update")
    public CommonResult<Boolean> updateArticleType(@Valid @RequestBody ArticleTypeUpdateRequestVO requestVO) {
        service.updateArticleType(requestVO);
        return success(true);
    }

    @ApiOperation("获取文章类型精简列表")
    @GetMapping("/simple-list")
    public CommonResult<List<ArticleTypeSimpleResponseVO>> getSimpleArticleTypeList() {
        return success(service.getSimpleArticleTypeList());
    }

    @ApiOperation("获取文章类型信息列表")
    @GetMapping("/list")
    public CommonResult<List<ArticleTypeResponseVO>> getArticleTypeList() {
        return success(service.getArticleTypeList());
    }
}
