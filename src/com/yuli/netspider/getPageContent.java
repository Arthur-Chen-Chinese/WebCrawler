package com.yuli.netspider;

import java.text.ParseException;

import org.htmlparser.Parser;
import org.htmlparser.beans.StringBean;
import org.htmlparser.filters.TagNameFilter;
import org.htmlparser.util.NodeList;
import org.htmlparser.util.ParserException;

public class getPageContent {

	public String getText(String url) throws ParseException {
		StringBean sb = new StringBean();
		//设置不需要得到的页面所包含的连接信息
		sb.setLinks(false);
		//设置将不间断的空格由正规空格替代
		sb.setReplaceNonBreakingSpaces(true);
		//设置将一系列空格由单一空格替代
		sb.setCollapse(true);
		//传入要解析的URL
		sb.setURL(url);
		//返回页面的纯文本信息
		return sb.getStrings();
	}
	
	public String getTitle(String url) throws ParserException {
		String tmp=null;
		Parser parser = new Parser(url);
		TagNameFilter filter = new TagNameFilter("title");
		NodeList nl =parser.extractAllNodesThatMatch(filter);
//		for(int i =0;i <nl.size();i++){
//		   tmp = nl.elementAt(i).toPlainTextString();
//		   System.out.println(tmp);
//		   }
//		System.out.println(nl.elementAt(0).toPlainTextString());
//		System.out.println(nl.size());
		return nl.elementAt(0).toPlainTextString();
	}
}
