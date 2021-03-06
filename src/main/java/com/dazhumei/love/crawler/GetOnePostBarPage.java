package com.dazhumei.love.crawler;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.dazhumei.love.postbar.entity.Comment;
import com.dazhumei.love.postbar.entity.Post;
import com.dazhumei.love.postbar.entity.User;
import com.dazhumei.love.postbar.service.CommentService;
import com.dazhumei.love.postbar.service.PostBarService;
import com.dazhumei.love.postbar.service.PostService;
import com.dazhumei.love.postbar.service.UserService;
import com.dazhumei.love.utils.UUIDUtil;

public class GetOnePostBarPage extends Thread {

	private PostBarService postBarService;
	private PostService postService;
	private CommentService commentService;
	private UserService userService;
	private String postbarname;
	private String url;
	private String baseurl;
	private int sta; 
	private int end; 
	private String barid;
	

	
	public int getEnd() {
		return end;
	}

	public void setEnd(int end) {
		this.end = end;
	}

	public String getBarid() {
		return barid;
	}

	public void setBarid(String barid) {
		this.barid = barid;
	}

	public int getSta() {
		return sta;
	}

	public void setSta(int sta) {
		this.sta = sta;
	}

	public String getBaseurl() {
		return baseurl;
	}

	public void setBaseurl(String baseurl) {
		this.baseurl = baseurl;
	}

	public PostBarService getPostBarService() {
		return postBarService;
	}

	public void setPostBarService(PostBarService postBarService) {
		this.postBarService = postBarService;
	}

	public PostService getPostService() {
		return postService;
	}

	public void setPostService(PostService postService) {
		this.postService = postService;
	}

	public CommentService getCommentService() {
		return commentService;
	}

	public void setCommentService(CommentService commentService) {
		this.commentService = commentService;
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public String getPostbarname() {
		return postbarname;
	}

	public void setPostbarname(String postbarname) {
		this.postbarname = postbarname;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public GetOnePostBarPage(PostBarService postBarService, PostService postService, CommentService commentService,
			UserService userService, String postbarname, String url, String baseurl,int sta,int end,String barid) {
		super();
		this.postBarService = postBarService;
		this.postService = postService;
		this.commentService = commentService;
		this.userService = userService;
		this.postbarname = postbarname;
		this.url = url;
		this.baseurl = baseurl;
		this.sta = sta;
		this.end = end;
		this.barid = barid;
	}

	public GetOnePostBarPage() {
		super();
	}

	public void run() {
		GetAllPagePost(barid,sta,end,baseurl, url, "/html/" + postbarname + ".html", postbarname, postBarService, postService,
				commentService, userService);
	}

	// 将抓取的网页变成html文件，保存在本地
	public static void SaveHtml(String url, String path) {
		try {
			File dest = new File(path);
			// 接收字节输入流
			InputStream is;
			// 字节输出流
			FileOutputStream fos = new FileOutputStream(dest);

			URL temp = new URL(url);
			URLConnection uc = temp.openConnection();
			uc.setConnectTimeout(100000);
			uc.setReadTimeout(100000);
			uc.addRequestProperty("User-Agent",
					"Mozilla/5.0 (iPad; U; CPU OS 4_3_3 like Mac OS X; en-us) AppleWebKit/533.17.9 (KHTML, like Gecko) Version/5.0.2 Mobile/8J2 Safari/6533.18.5");
			is = temp.openStream();

			// 为字节输入流加缓冲
			BufferedInputStream bis = new BufferedInputStream(is);
			// 为字节输出流加缓冲
			BufferedOutputStream bos = new BufferedOutputStream(fos);

			int length;

			byte[] bytes = new byte[1024 * 20];
			while ((length = bis.read(bytes, 0, bytes.length)) != -1) {
				fos.write(bytes, 0, length);
			}

			bos.close();
			fos.close();
			bis.close();
			is.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// 保存贴吧所以页面，然后解析，然后删除
	public static void GetAllPagePost(String barid,int sta,int end,String baseurl, String url, String path, String name,
			PostBarService postBarService, PostService postService, CommentService commentService,
			UserService userService) {

		for (int i = sta; i <= end; i++) {
			int page = i + 1;
			System.out.println("开始下载" + name + "贴吧的第" + page + "页");
			SaveHtml(url + "&pn=" + i * 50, "/html/" + name + "_" + page + ".html");
			System.out.println(name + "贴吧的第" + page + "页下载成功");

			File filep = new File("/html/" + name + "_" + page + ".html");
			// 下面开始解析本地的html
			Document docp = null;
			try {
				docp = Jsoup.parse(filep, "UTF-8");
			} catch (IOException e) {
				System.out.println("解析出错");
				e.printStackTrace();
				continue;
			}

			// 读取一个页面所有帖子简介和所有评论
			GetOnePagePost(baseurl, docp, name, barid, postService, commentService, userService);

			// 删除
			if (filep != null) {
				filep.delete();
			}
		}
	}

	// 得到一页的所以帖子
	public static void GetOnePagePost(String baseurl, Document doc, String name, String barid, PostService postService,
			CommentService commentService, UserService userService) {
		// 读取一个页面所有帖子简介和所有评论
		Elements posts = doc.getElementsByClass("t_con cleafix");
		List<Post> listp = new ArrayList<Post>();
		List<Comment> listc = new ArrayList<Comment>();
		List<User> listu = new ArrayList<User>();
		for (Element element : posts) {

			Post p = new Post();
			String repnum = element.getElementsByClass("threadlist_rep_num center_text").first().text();
			System.out.println("回复数为：" + repnum);
			String post = element.getElementsByClass("threadlist_lz clearfix").first().getElementsByTag("a").first()
					.text();
			System.out.println("帖子标题为：" + post);

			String auth = element.getElementsByClass("tb_icon_author").first().toString();
			String author = auth.substring(auth.indexOf("title=\"主题作者: ") + 13, auth.indexOf("\" data-field"));
			System.out.println("作者：" + author);
			User user = new User();
			user.setId(UUIDUtil.getUUID());
			user.setUname(author);
			user.setCreatTime(new Date());
			listu.add(user);

			String creatTime = element.getElementsByClass("pull-right is_show_create_time").first().text();
			System.out.println("创建时间：" + creatTime);

			if (element.getElementsByClass("icon-top").first() == null) {
				String content=null;
				
				if(element.getElementsByClass("threadlist_abs threadlist_abs_onlyline ")==null){
					if(element.getElementsByClass("threadlist_abs threadlist_abs_onlyline  th_bakan").size()==0){
						content="";
					}else{
						content = element.getElementsByClass("threadlist_abs threadlist_abs_onlyline  th_bakan").first().text();
						if (content == null || "".equals(content)) {
							content = element.getElementsByClass("threadlist_abs threadlist_abs_onlyline  th_bakan").first().toString();
						}
					}
				}else{
					if(element.getElementsByClass("threadlist_abs threadlist_abs_onlyline ").size()==0){
						content="";
					}else{
						content = element.getElementsByClass("threadlist_abs threadlist_abs_onlyline ").first().text();
						if (content == null || "".equals(content)) {
							content = element.getElementsByClass("threadlist_abs threadlist_abs_onlyline ").first().toString();
						}
					}
					
				}

				System.out.println("帖子内容简介为：" + content);

				String last = element.getElementsByClass("threadlist_author pull_right").last().toString();
				String lastpeople = last.substring(last.indexOf("title=\"最后回复人: ") + 14,
						last.indexOf("\"> <i class=\"icon_replyer\">"));
				System.out.println("最后回复人: " + lastpeople);

				String lastTime = element.getElementsByClass("threadlist_reply_date pull_right j_reply_data").first()
						.text();
				System.out.println("最后回复时间：" + lastTime);

				p.setContent(content);
				p.setLastpeople(lastpeople);
				p.setLastTime(lastTime);
				User user1 = new User();
				user1.setId(UUIDUtil.getUUID());
				user1.setUname(lastpeople);
				user1.setCreatTime(new Date());
				listu.add(user1);
			}

			String urlstr = element.getElementsByClass("threadlist_lz clearfix").first().getElementsByTag("a").first()
					.toString();
			String urlp = urlstr.substring(urlstr.indexOf("href=\"") + 6, urlstr.indexOf("\" title"));
			System.out.println("帖子的网址为：" + urlp);

			String pid = UUIDUtil.getUUID();
			p.setId(pid);
			p.setPostbarid(barid);
			p.setRepnum(repnum);
			p.setPosttitle(post);
			p.setPauthor(author);
			p.setCreatTime(creatTime);
			p.setPosturl("http://tieba.baidu.com" + urlp);
			// postService.insertPost(p);
			listp.add(p);
			System.out.println("开始下载帖子...");
			// 读取帖子的所以评论
			SaveHtml(baseurl + urlp, "/html/" + name + urlp.replace("/", "_") + ".html");
			System.out.println("开始解析帖子的评论...");
			File filec = new File("/html/" + name + urlp.replace("/", "_") + ".html");

			// 读取评论
			Document docc;
			try {
				docc = Jsoup.parse(filec, "UTF-8");
			} catch (IOException e) {
				System.out.println("第" + name + urlp.replace("/", "_") + ".html页面出错");
				e.printStackTrace();
				continue;
			}

			String htmlc = docc.toString();

			// 如果帖子有评论就读
			if (docc.getElementsByClass("l_post l_post_bright j_l_post clearfix  ").size() > 0) {
				// 读取第一页评论
				Elements commonts = docc.getElementsByClass("l_post l_post_bright j_l_post clearfix  ");
				System.out.println(commonts.size());
				for (Element element2 : commonts) {
					Comment c = new Comment();
					Element link = element2.getElementsByTag("cc").first();
					String comment = link.getElementsByTag("div").first().text();

					if (comment == null || "".equals(comment)) {
						comment = link.getElementsByTag("div").first().toString();
					}

					String cauthor = element2.getElementsByClass("d_name").first().getElementsByTag("a").first().text();
					String crank = element2.getElementsByClass("d_badge_lv").first().text();
					System.out.println("作者名字：" + cauthor);
					System.out.println("作者等级：" + crank);
					System.out.println("评论为：" + comment);
					User user2 = new User();
					user2.setId(UUIDUtil.getUUID());
					user2.setUname(cauthor);
					user2.setUrank(crank);
					user2.setCreatTime(new Date());
					listu.add(user2);

					c.setId(UUIDUtil.getUUID());
					c.setPostid(pid);
					c.setCauthor(cauthor);
					c.setCarank(crank);
					c.setCreatTime(new Date());
					c.setComment(comment);
					listc.add(c);
				}

				String pagenum = htmlc.substring(htmlc.indexOf("</span>回复贴，共<span class=\"red\">") + 30,
						htmlc.indexOf("</span>页</li>"));
				System.out.println("第" + name + urlp.replace("/", "_") + ".html页面有" + pagenum + "页");
				int pages = Integer.valueOf(pagenum);
				// 读取其它评论
				for (int num = 2; num <= pages; num++) {
					System.out.println("开始读取" + "第" + name + urlp.replace("/", "_") + ".html页面的第" + num + "页");
					SaveHtml(baseurl + urlp + "?pn=" + num,
							"/html/" + name + urlp.replace("/", "_") + "_" + num + ".html");
					File filecc = new File("/html/" + name + urlp.replace("/", "_") + "_" + num + ".html");
					// 读取评论
					Document doccc = null;
					try {
						doccc = Jsoup.parse(filecc, "UTF-8");
					} catch (IOException e) {
						System.out.println("第" + name + urlp.replace("/", "_") + "_" + num + ".html页面出错");
						e.printStackTrace();
						continue;
					}

					Elements commontss = doccc.getElementsByClass("l_post j_l_post l_post_bright  ");
					for (Element element3 : commontss) {
						Comment c = new Comment();
						Element link = element3.getElementsByTag("cc").first();
						String comment = link.getElementsByTag("div").first().text();

						if (comment == null || "".equals(comment)) {
							comment = link.getElementsByTag("div").first().toString();
						}

						String cauthor = element3.getElementsByClass("d_name").first().getElementsByTag("a").first()
								.text();
						String crank = element3.getElementsByClass("d_badge_lv").first().text();
						System.out.println("作者名字：" + cauthor);
						System.out.println("作者等级：" + crank);
						System.out.println("评论为：" + comment);
						User user3 = new User();
						user3.setId(UUIDUtil.getUUID());
						user3.setUname(cauthor);
						user3.setUrank(crank);
						user3.setCreatTime(new Date());
						listu.add(user3);

						c.setId(UUIDUtil.getUUID());
						c.setPostid(pid);
						c.setCauthor(cauthor);
						c.setCarank(crank);
						c.setCreatTime(new Date());
						c.setComment(comment);
						listc.add(c);
					}

					// 删除
					if (filecc != null) {
						filecc.delete();
					}
				}
			}else if(docc.getElementsByClass("ag_head").size() > 0){
				//图册,目前解析不了
				
			}else if (docc.getElementById("j_p_postlist") != null) {
				// 读取第一条评论
				Element commontf = docc.getElementById("j_p_postlist");
				Element flink = commontf.getElementsByTag("cc").first();
				String fcomment = flink.getElementsByTag("div").first().text();

				if (fcomment == null || "".equals(fcomment)) {
					fcomment = flink.getElementsByTag("div").first().toString();
				}

				String fcauthor = commontf.getElementsByClass("d_name").first().getElementsByTag("a").first().text();
				String fcrank = commontf.getElementsByClass("d_badge_lv").first().text();
				Comment cf = new Comment();
				cf.setId(UUIDUtil.getUUID());
				cf.setPostid(pid);
				cf.setCauthor(fcauthor);
				cf.setCarank(fcrank);
				cf.setCreatTime(new Date());
				cf.setComment(fcomment);
				listc.add(cf);

				// 读取第一页评论
				Elements commonts = docc.getElementsByClass("l_post j_l_post l_post_bright  ");
				System.out.println(commonts.size());
				for (Element element2 : commonts) {
					Comment c = new Comment();
					Element link = element2.getElementsByTag("cc").first();
					String comment = link.getElementsByTag("div").first().text();

					if (comment == null || "".equals(comment)) {
						comment = link.getElementsByTag("div").first().toString();
					}
					String cauthor = element2.getElementsByClass("d_name").first().getElementsByTag("a").first().text();
					String crank = element2.getElementsByClass("d_badge_lv").first().text();
					System.out.println("作者名字：" + cauthor);
					System.out.println("作者等级：" + crank);
					System.out.println("评论为：" + comment);
					User user2 = new User();
					user2.setId(UUIDUtil.getUUID());
					user2.setUname(cauthor);
					user2.setUrank(crank);
					user2.setCreatTime(new Date());
					listu.add(user2);

					c.setId(UUIDUtil.getUUID());
					c.setPostid(pid);
					c.setCauthor(cauthor);
					c.setCarank(crank);
					c.setCreatTime(new Date());
					c.setComment(comment);
					listc.add(c);
				}

				String pagenum = htmlc.substring(htmlc.indexOf("</span>回复贴，共<span class=\"red\">") + 30,
						htmlc.indexOf("</span>页</li>"));
				System.out.println("第" + name + urlp.replace("/", "_") + ".html页面有" + pagenum + "页");
				int pages = Integer.valueOf(pagenum);
				// 读取其它评论
				for (int num = 2; num <= pages; num++) {
					System.out.println("开始读取" + "第" + name + urlp.replace("/", "_") + ".html页面的第" + num + "页");
					SaveHtml(baseurl + urlp + "?pn=" + num,
							"/html/" + name + urlp.replace("/", "_") + "_" + num + ".html");
					File filecc = new File("/html/" + name + urlp.replace("/", "_") + "_" + num + ".html");
					// 读取评论
					Document doccc;
					try {
						doccc = Jsoup.parse(filecc, "UTF-8");
					} catch (IOException e) {
						System.out.println("第" + name + urlp.replace("/", "_") + "_" + num + ".html页面出错");
						e.printStackTrace();
						continue;
					}

					Elements commontss = doccc.getElementsByClass("l_post j_l_post l_post_bright  ");
					for (Element element3 : commontss) {
						Comment c = new Comment();
						Element link = element3.getElementsByTag("cc").first();
						String comment = link.getElementsByTag("div").first().text();

						if (comment == null || "".equals(comment)) {
							comment = link.getElementsByTag("div").first().toString();
						}

						String cauthor = element3.getElementsByClass("d_name").first().getElementsByTag("a").first()
								.text();
						String crank = element3.getElementsByClass("d_badge_lv").first().text();
						System.out.println("作者名字：" + cauthor);
						System.out.println("作者等级：" + crank);
						System.out.println("评论为：" + comment);
						User user3 = new User();
						user3.setId(UUIDUtil.getUUID());
						user3.setUname(cauthor);
						user3.setUrank(crank);
						user3.setCreatTime(new Date());
						listu.add(user3);

						c.setId(UUIDUtil.getUUID());
						c.setPostid(pid);
						c.setCauthor(cauthor);
						c.setCarank(crank);
						c.setCreatTime(new Date());
						c.setComment(comment);
						listc.add(c);
					}

					// 删除
					if (filecc != null) {
						filecc.delete();
					}
				}

			}

			// 删除
			if (filec != null) {
				filec.delete();
			}

		}
		// 批量添加
		if (listp.size() > 0) {
			postService.insertPostList(listp);
		}
		if (listc.size() > 0) {
			commentService.insertCommentList(listc);
		}
		if (listu.size() > 0) {
			userService.insertUserList(listu);
		}
	}

}
