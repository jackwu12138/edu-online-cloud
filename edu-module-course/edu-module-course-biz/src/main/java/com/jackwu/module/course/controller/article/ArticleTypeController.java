package com.jackwu.module.course.controller.article;

import com.jackwu.framework.common.pojo.CommonResult;
import com.jackwu.module.course.controller.article.vo.articletype.ArticleTypeCreateRequestVO;
import com.jackwu.module.course.controller.article.vo.articletype.ArticleTypeResponseVO;
import com.jackwu.module.course.controller.article.vo.articletype.ArticleTypeUpdateRequestVO;
import com.jackwu.module.course.service.article.ArticleTypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.jackwu.framework.common.pojo.CommonResult.success;

/**
 * 课程模块 - 文章分类
 *
 * @author jackwu
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/course/article-type")
public class ArticleTypeController {

    private final ArticleTypeService service;

    @PostMapping("/create")
    public CommonResult<Long> createArticleType(@RequestBody ArticleTypeCreateRequestVO requestVO) {
        Long id = service.createArticleType(requestVO);
        return success(id);
    }

    @DeleteMapping("/delete")
    public CommonResult<Boolean> deleteArticleType(@RequestParam("id") Long id) {
        service.deleteArticleTypeById(id);
        return success(true);
    }

    @PutMapping("/update")
    public CommonResult<Boolean> updateArticleType(@RequestBody ArticleTypeUpdateRequestVO requestVO) {
        service.updateArticleType(requestVO);
        return success(true);
    }

    @GetMapping("/get-simple-list")
    public CommonResult<List<String>> getSimpleArticleTypeList() {
        return success(service.getSimpleArticleTypeList());
    }

    @GetMapping("/get-list")
    public CommonResult<List<ArticleTypeResponseVO>> getArticleTypeList() {
        return success(service.getArticleTypeList());
    }
}
