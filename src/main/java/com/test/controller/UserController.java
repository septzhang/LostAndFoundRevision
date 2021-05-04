package com.test.controller;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.test.pojo.Emailtable;
import com.test.pojo.Goodstable;
import com.test.pojo.Usertable;
import com.test.server.UserServer;

@Controller
public class UserController {
	Usertable myuser;
	
	@Autowired
	UserServer uServer = new UserServer();
	
	@RequestMapping(value = "")
	public String login1(Usertable user,Model model,HttpSession session) {
		return "login";
	}
	@RequestMapping(value = "/login.html")
	public String login(Usertable user,Model model,HttpSession session) {
		return "login";
	}
	@RequestMapping(value = "/loginTel.html")
	public String loginTel(Usertable user,Model model,HttpSession session) {
		return "loginTel";
	}
	@RequestMapping(value = "/recoverPsd.html")
	public String recoverPsd(Model model) {
		return "recoverPsd";
	}
	@PostMapping(value = "/recoverPsd.action")
	public String recoverPsd1(Long userid,String userpassword,String userEmail,Map<String, Object> map, Model model) {
		Usertable ruser = new Usertable();
		ruser.setUserEmail(userEmail);
		System.out.println(userEmail);
		ruser.setUserIdnum("123");
		ruser.setUserPassword("123");
		ruser.setUserName("123");
		ruser.setUserId(userid);
		ruser.setUserPassword(userpassword);
		int a =uServer.recoverPsd(ruser);
		if (a==1) {
			return "login";
		}else {
			model.addAttribute("error", "学号不存在,或者邮箱输入错误!!!!");
			return "recoverPsd";
		}
	}
	
	@RequestMapping("/index.html")
    public String index (String goal , Model model) throws Exception {
        List<Emailtable> elist= new ArrayList<Emailtable>();
	    elist.addAll(uServer.listEmail(myuser.getUserId().toString()));
	    for (Emailtable em : elist) {
	    	System.out.println(em.getEmailInfo()+"++++++1212=============");
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// 设置日期格式
			try {
				em.setEmailTime(sdf.parse(sdf.format(em.getEmailTime())));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	    model.addAttribute("elist", elist);
        model.addAttribute("user",myuser);
        return "index";
    }
	
	@PostMapping(value = "/logincheck.html")
	public String loginCheck(Long userid,String userpassword,Map<String, Object> map, Model model) {
		//登录验证
		Usertable user = new Usertable();
		user.setUserId(userid);
		user.setUserPassword(userpassword);
		System.out.println(user.getUserPassword()+"===========");
		
		int result = uServer.loginCheck(user);
		//goods  
		List<Goodstable> glist=new ArrayList<>();
		glist.addAll(uServer.listGoods());
		model.addAttribute("glist",glist);
		
		//公告
		List<String> bu = uServer.listBulletin();
		model.addAttribute("blist", bu);

		if (result == 1) {
			myuser = uServer.seekUser(userid);
			model.addAttribute("user",myuser);
			List<Emailtable> elist= new ArrayList<Emailtable>();
			System.out.println(myuser.getUserId().toString());
			elist.addAll(uServer.listEmail(myuser.getUserId().toString()));
			for (Emailtable em : elist) {
		    	System.out.println(em.getEmailInfo()+"++++++1212=============");
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// 设置日期格式
				try {
					em.setEmailTime(sdf.parse(sdf.format(em.getEmailTime())));
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			model.addAttribute("elist", elist);
			return "index";
		}else {
			
			System.out.println("登录失败!!==============="+userid+userpassword);
			return "login";
		}
	}
	@PostMapping(value = "/logincheck2.html")
	public String loginCheck2(Long userid,String userpassword,Map<String, Object> map, Model model) {
		//登录验证
		Usertable user = new Usertable();
		user.setUserTel(userid.toString());
		user.setUserPassword(userpassword);
		System.out.println(user.getUserPassword()+"===========");
		int result = uServer.loginCheck2(user);
		//goods  
		List<Goodstable> glist=new ArrayList<>();
		glist.addAll(uServer.listGoods());
		model.addAttribute("glist",glist);
		
		//公告
		List<String> bu = uServer.listBulletin();
		model.addAttribute("blist", bu);
		//
		if (result == 1) {
			myuser = uServer.seekUserId(userid.toString());
			model.addAttribute("user",myuser);
			List<Emailtable> elist= new ArrayList<Emailtable>();
			System.out.println(myuser.getUserId().toString());
			elist.addAll(uServer.listEmail(myuser.getUserId().toString()));
			for (Emailtable em : elist) {
		    	System.out.println(em.getEmailInfo()+"++++++1212=============");
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// 设置日期格式
				try {
					em.setEmailTime(sdf.parse(sdf.format(em.getEmailTime())));
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			model.addAttribute("elist", elist);
			return "index";
		}else {
			
			System.out.println("登录失败!!==============="+userid+userpassword);
			return "login";
		}
	}
	@RequestMapping("/logout.html")
    public String logout  () throws Exception {
        myuser =null;
        return "login";
    }

	@RequestMapping("/seekUser")
    public String seekUser  (Long seekId ,Usertable newUser , Model model) throws Exception {
        Usertable user = new Usertable();
        user = uServer.seekUser(seekId);
        model.addAttribute("users", user);
        return "listUser.html";
    }
    @RequestMapping("/deleteUser")
    public String deleteCategory(Long id ,Usertable deleteduser) throws Exception {
    	System.out.println("删除"+deleteduser.getUserName()+"===============");
        uServer.deleteUser(id);
        return "redirect:listUser.html";
    }
    @RequestMapping("/addBulletin.html")
    public String addBulletin(Long id ,Usertable deleteduser,Model model) throws Exception {
        return "addBulletin.html";
    }
    /**
     * 封号
     * @param id 
     * @param deleteduser	删除的user
     * @param model
     * @return
     * @throws Exception
     */
    @RequestMapping("/killUser")
    public String killCategory(Long id ,Usertable deleteduser,Model model) throws Exception {
    	System.out.println("封号/解封"+deleteduser.getUserName()+"===============");
    	Usertable user =uServer.seekUser(id);
        uServer.killUser(user);
        model.addAttribute("user",myuser);
        return "redirect:listUser.html";
    }
    /**
     * 跳转更改用户信息页面
     * @param id
     * @param model
     * @return
     * @throws Exception
     */
    @RequestMapping("/editUser")
    public String editUser(long id,Model model) throws Exception {
    	System.out.println(id+"----=-=-=--==========-");
    	Usertable user = uServer.seekUser(id);
    	System.out.println(user.getUserName()+"----=-=-=--==========-");
    	model.addAttribute("u", user);
    	model.addAttribute("user",myuser);
//        uServer.update(user);
        return "editUser";
    }
    /**
     * 更改用户信息
     * @param name
     * @param id
     * @param idNum
     * @param tel
     * @param email
     * @param position
     * @param status
     * @param model
     * @return
     * @throws Exception
     */
    @RequestMapping("/updateUser")
    public String updateUser(String name,long id,String password,String idNum,String tel,String email,int position,int status ,Model model) throws Exception {
    	System.out.println(name+"----=-=-=--==========-");
    	Usertable user =new Usertable();
    	user.setUserName(name);
    	user.setUserId(id);
    	user.setUserPassword(password);
    	user.setUserEmail(email);
    	user.setUserIdnum(idNum);
    	user.setUserTel(tel);
    	System.out.println(position+"--------------");
    	System.out.println(status+"=============");
    	user.setUserPosition((byte) position);
    	user.setUserStatus((byte) status);
    	System.out.println(user.getUserName()+"----=-=-=--==========-");
        uServer.update(user);
        return "redirect:listUser.html";
    }
    /**
     * 添加 user
     * @param m model
     * @return
     * @throws Exception
     */
    @RequestMapping("/addUser.html")
    public String addUser(Model m) throws Exception {
        return "addUser";
    }
    /**
     *  添加用户
     * @param passworld
     * @param password
     * @param name
     * @param id
     * @param idNum
     * @param tel
     * @param email
     * @param position
     * @param status
     * @param model
     * @return
     * @throws Exception
     */
    @RequestMapping("/addUser.action")
    public String addUser(String passworld,String password,String name,long id,String idNum,String tel,String email,Byte position,int status ,Model model) throws Exception {
    	Usertable user =new Usertable();
    	user.setUserName(name);
    	user.setUserId(id);
    	user.setUserPassword(password);
    	user.setUserEmail(email);
    	user.setUserIdnum(idNum);
    	user.setUserTel(tel);
    	user.setUserPosition(position);
    	user.setUserStatus((byte) status);
        uServer.addUser(user);
        return "redirect:listUser.html";
    }
    
    @RequestMapping("/listUser.html")
	    public String listCategory(Model m) throws Exception {
	        List<Usertable> ulist= new ArrayList<Usertable>();
	        ulist.addAll(uServer.listUser());
	        m.addAttribute("users", ulist); 
	        m.addAttribute("user",myuser);
	        return "listUser";
	    }
    @RequestMapping("/addGoods.html")
    public String addGoods( Model model) {
    	model.addAttribute("user",myuser);
        return "addGoods";
    }
    @RequestMapping("/addGoods.action")
    public String addGoods (Byte kinds,HttpServletRequest request,@RequestParam(value = "picture") MultipartFile picture ,String info,String site,String contact,Model model) throws Exception {
    	Goodstable goods = new Goodstable();
    	goods.setGoodsKinds(kinds);
    	goods.setGoodsInfo(info);
    	goods.setGoodsSite(site);
    	goods.setGoodsContact(contact);
    	goods.setGoodsMaster(myuser.getUserId().toString());
    	goods.setGoodsSuccess(0);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// 设置日期格式
		try {
			goods.setGoodsTime(sdf.parse(sdf.format(new Date())));
		} catch (Exception e) {
			e.printStackTrace();
		}
    	if (!picture.isEmpty()) {
			// 构建文件上传所要保存的"文件夹路径"--这里是相对路径，保存到项目根路径的文件夹下
			String realPath = new String("src/main/resources/static/asserts/goods/");
			String format = sdf.format(new Date());
			// 存放上传文件的文件夹
			File file = new File(realPath);
			if (!file.isDirectory()) {
				// 递归生成文件夹
				file.mkdirs();
			}
			// 获取原始的名字 original:最初的，起始的 方法是得到原来的文件名在客户机的文件系统名称
			String oldName = picture.getOriginalFilename();
			String newName = UUID.randomUUID().toString()
					+ oldName.substring(oldName.lastIndexOf("."), oldName.length());
			try {
				// 构建真实的文件路径
				File newFile = new File(file.getAbsolutePath() + File.separator + newName);
				// 转存文件到指定路径，如果文件名重复的话，将会覆盖掉之前的文件,这里是把文件上传到 “绝对路径”
				picture.transferTo(newFile);
				goods.setGoodsImg(newName);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
        uServer.addGoods(goods);
        if (kinds ==0) {
        	return "redirect:listA.html";
		}else {
			return "redirect:listB.html";
		}
    }

    @RequestMapping("/addEmail.action")
    public String addEmail(String info,String yourid) throws Exception {
    	Emailtable e = new Emailtable();
    	e.setEmailInfo(info);
    	e.setEmailAddressee(myuser.getUserId().toString());
    	e.setEmailSender(yourid);
    	uServer.addEmail(e);
        return "redirect:listEmail.html";
    }   
    @RequestMapping("/warnUser")
    public String warnUser(String id) throws Exception {
    	Emailtable e = new Emailtable();
    	e.setEmailInfo("您的账户因违章违规,特发警告!下次讲直接封号!");
    	e.setEmailAddressee(myuser.getUserId().toString());
    	e.setEmailSender(id);
    	uServer.addEmail(e);
        return "redirect:listUser.html";
    }
    @RequestMapping("/getit")
    public String getit(String id) throws Exception {
    	Emailtable e = new Emailtable();
    	e.setEmailInfo("用户"+myuser.getUserId()+"对您发布的信息"+id+"感兴趣,如有意向,请尽快联系!!");
    	e.setEmailAddressee(myuser.getUserId().toString());
    	e.setEmailSender(myuser.getUserId().toString());
    	uServer.addEmail(e);
        return "redirect:index.html";
    }
    
    @RequestMapping("/deleteEmail")
    public String deleteEmail(int id,Model model) throws Exception {
    	Emailtable e =new Emailtable();
    	System.out.println(e.getEmailInfo()+"----=-=-=--==========-");
        uServer.deleteBulletin(id);
        return "redirect:index.html";
    }
	@RequestMapping("/listData.html")
	public String listData(Model m) throws Exception {
	    m.addAttribute("a", uServer.listGoods2().size());
	    m.addAttribute("b", uServer.listSuc().size());
	    m.addAttribute("c", uServer.listGoods2().size()-uServer.listSuc().size());
	    m.addAttribute("d", uServer.listLose().size());
	    return "listData";
	}
	@RequestMapping("/listMyGoods.html")
	public String myGoods(Model m) throws Exception {
	    List<Goodstable> glist= new ArrayList<Goodstable>();
	    glist.addAll(uServer.listMyGoods(myuser.getUserId().toString()));
	    m.addAttribute("glist", glist);
	    return "listMyGoods";
	}	
	@RequestMapping("/finishGoods")
	public String finishGoods(Model m ,int id) throws Exception {
		uServer.finishGoods(id);
		List<Goodstable> glist= new ArrayList<Goodstable>();
	    glist.addAll(uServer.listMyGoods(myuser.getUserId().toString()));
	    m.addAttribute("glist", glist);
	    return "listMyGoods";
	}
	@RequestMapping("/addContact.html")
	public String addContact2(Model m ,String advice,String usertel) throws Exception {
	    return "addContact";
	}
	@RequestMapping("/addContact.action")
	public String addContact(Model m ,String advice,String usertel) throws Exception {
		Emailtable e = new Emailtable();
		e.setEmailInfo(advice);
		e.setEmailSender(usertel);
		e.setEmailTime(new Date());
		e.setEmailAddressee("all");
		uServer.addEmail(e);;
	    return "listContact";
	}
	@RequestMapping("/listContact.html")
	public String listContact(Model m ,String advice,String usertel) throws Exception {
		List<Emailtable> clist =  uServer.listContact();
		m.addAttribute("clist", clist);
	    return "listContact";
	}
	@RequestMapping("/listA.html")
	public String listA(Model m ,String advice,String usertel) throws Exception {
		List<Goodstable> glist =  uServer.listGoods();
		List<Goodstable> list = new ArrayList<>();
		
		for (Goodstable goodstable : glist) {
			if (goodstable.getGoodsKinds()==0) {
				list.add(goodstable);
			}
		}
		m.addAttribute("glist", list);
	    return "listA";
	}
	@RequestMapping("/listB.html")
	public String listB(Model m ,String advice,String usertel) throws Exception {
		List<Goodstable> glist =  uServer.listGoods();
		List<Goodstable> list = new ArrayList<>();
		
		for (Goodstable goodstable : glist) {
			if (goodstable.getGoodsKinds()==1) {
				list.add(goodstable);
			}
		}
		m.addAttribute("glist", list);
	    return "listB";
	}

	
	@RequestMapping("/updateSelfUser.html")
	public String updataSelfData(Model m) throws Exception {
	    m.addAttribute("user", myuser);
	    return "updateSelfUser";
	}
    @RequestMapping("/updateSelfUser.action")
    public String updateSelfUser(String password, String name,long id,String idNum,String tel,String email,Byte position,int status ,Model model) throws Exception {
    	System.out.println(name+"----=-=-=--==========-");
    	Usertable user =new Usertable();
    	user.setUserName(name);
    	user.setUserId(id);
    	user.setUserPassword(password);
    	user.setUserEmail(email);
    	user.setUserIdnum(idNum);
    	user.setUserTel(tel);
    	System.out.println(position+"========position=============");
		user.setUserPosition(position);
    	System.out.println(position+"--------------");
    	System.out.println(status+"=============");
    	user.setUserStatus((byte) status);
    	System.out.println(user.getUserName()+"----=-=-=--==========-");
        uServer.update(user);
        return "redirect:index.html";
    }
    @RequestMapping("/sendMessage")
    public String sendMessage(String advice,Model model) throws Exception {
    	Emailtable e =new Emailtable();
    	e.setEmailInfo(advice);
    	e.setEmailSender(myuser.getUserId().toString());
		e.setEmailAddressee("all");
		uServer.addEmail(e);
        return "redirect:index.html";
    }
    @RequestMapping("/reportToaAministrators")
    public String reportToaAministrators(int id, Model model) throws Exception {
    	Emailtable e =new Emailtable();
    	e.setEmailInfo("用户举报寻物招领(id:"+id+")存在违规违章行为,请管理员核实!!");
    	e.setEmailSender(myuser.getUserId().toString());
    	List<Usertable>aList = new ArrayList<>();
    	aList = uServer.listA();
    	for (Usertable u : aList) {
    		e.setEmailAddressee(u.getUserId().toString());
    		uServer.addEmail(e);
		}
        return "redirect:index.html";
    }
	@RequestMapping("/seekGoodsA")
    public String seekGoodsA (String goal , Model model) throws Exception {
        List<Goodstable> list = uServer.seekGoods("%"+goal+"%");
        List<Goodstable> glist = new ArrayList<>();
		for (Goodstable goodstable : list) {
			if (goodstable.getGoodsKinds()==0) {
				glist.add(goodstable);
			}
		}
        model.addAttribute("glist", glist);
        model.addAttribute("user",myuser);
        return "listA";
    }
	@RequestMapping("/seekGoodsB")
    public String seekGoodsB (String goal , Model model) throws Exception {
        List<Goodstable> list = uServer.seekGoods("%"+goal+"%");
        List<Goodstable> glist = new ArrayList<>();
		for (Goodstable goodstable : list) {
			if (goodstable.getGoodsKinds()==1) {
				glist.add(goodstable);
			}
		}
        model.addAttribute("glist", glist);
        model.addAttribute("user",myuser);
        return "listB";
    }
	

	


}