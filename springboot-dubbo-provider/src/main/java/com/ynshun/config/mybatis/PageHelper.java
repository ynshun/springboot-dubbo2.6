package com.ynshun.config.mybatis;

import com.github.pagehelper.PageInfo;
import com.ynshun.common.data.result.DatatableResult;

public class PageHelper {

	public static void page(int start, int pagesize) {
		int page = start / pagesize + 1;
		pagesize = (pagesize <= 0) ? 10 : pagesize;

		com.github.pagehelper.PageHelper.startPage(page, pagesize);
	}

	public static DatatableResult buildResult(PageInfo<?> pageInfo) {
		DatatableResult result = new DatatableResult();
		result.setRecordsTotal(pageInfo.getTotal());
		result.setRecordsFiltered(pageInfo.getTotal());
		result.setData(pageInfo.getList());

		result.setPageNum(pageInfo.getPageNum());
		result.setPageSize(pageInfo.getPageSize());
		result.setTotal(pageInfo.getTotal());
		result.setPages(pageInfo.getPages());
		result.setSize(pageInfo.getSize());
		result.setStartRow(pageInfo.getStartRow());
		result.setEndRow(pageInfo.getEndRow());
		result.setNavigatePages(pageInfo.getNavigatePages());
		result.setNavigatepageNums(pageInfo.getNavigatepageNums());
		result.setFirstPage(pageInfo.getNavigateFirstPage());
		result.setLastPage(pageInfo.getNavigateLastPage());
		result.setPrePage(pageInfo.getPrePage());
		result.setNextPage(pageInfo.getNextPage());
		result.setFirstPage(pageInfo.isIsFirstPage());
		result.setLastPage(pageInfo.isIsLastPage());
		result.setHasPreviousPage(pageInfo.isHasPreviousPage());
		result.setHasNextPage(pageInfo.isHasNextPage());
		return result;
	}
}