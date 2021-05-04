package com.test.server;

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.KeySpec;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.SecretKeySpec;

import org.apache.ibatis.annotations.Lang;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.mapper.EmailtableMapper;
import com.test.mapper.GoodstableMapper;
import com.test.mapper.UsertableMapper;
import com.test.pojo.Emailtable;
import com.test.pojo.EmailtableExample;
import com.test.pojo.Goodstable;
import com.test.pojo.GoodstableExample;
import com.test.pojo.Usertable;
import com.test.pojo.UsertableExample;

@Service
public class UserServer {
	//设置失误招领信息的有效期  单位小时
	int deadline =24;
	//密钥
	public String keyword = "12345678";
	@Autowired
	UsertableMapper uMapper;
	@Autowired
	GoodstableMapper gMapper;
	@Autowired
	EmailtableMapper eMapper;
	
	/**
	 * 登陆方法
	 * @param usertable
	 * @return 0 登录失败 1 登录成功--管理员	2 登录成功--用户
	 */
	public int loginCheck(Usertable usertable) {
		UsertableExample uExample = new UsertableExample();
		uExample.createCriteria().andUserIdEqualTo(usertable.getUserId());
		List<Usertable> list  = uMapper.selectByExample(uExample);
		System.out.println(usertable.getUserId()+"-------"+usertable.getUserPassword());
		if (list.size()>0) {
			System.out.println(list.get(0).getUserPassword());
			System.out.println(encryptHex(usertable.getUserPassword(), keyword));
			System.out.println(decryptHex(list.get(0).getUserPassword(),keyword));
			for (int i = 0; i < list.size(); i++) {
				if (decryptHex(list.get(i).getUserPassword(),keyword).equals(usertable.getUserPassword())&&list.get(0).getUserStatus()==0) {
					return 1;
				}	
			}
			
			System.out.println("密码错误");
			return 0;
		}else {
			System.out.println("账号不存在.或者被封!");
			return 0;
		}
	}
	public int loginCheck2(Usertable usertable) {
		UsertableExample uExample = new UsertableExample();
		uExample.createCriteria().andUserTelEqualTo(usertable.getUserTel().toString());
		List<Usertable> list  = uMapper.selectByExample(uExample);
		System.out.println(usertable.getUserId()+"-------"+usertable.getUserPassword());
		if (list.size()>0) {
			System.out.println(list.get(0).getUserPassword());
			System.out.println(encryptHex(usertable.getUserPassword(), keyword));
			System.out.println(decryptHex(list.get(0).getUserPassword(),keyword));
			for (int i = 0; i < list.size(); i++) {
				if (decryptHex(list.get(i).getUserPassword(),keyword).equals(usertable.getUserPassword())&&list.get(0).getUserStatus()==0) {
					return 1;
				}	
			}
			System.out.println("密码错误");
			return 0;
		}else {
			System.out.println("账号不存在.或者被封!");
			return 0;
		}
	}
	public Usertable seekUserId(String tel) {
		UsertableExample uExample = new UsertableExample();
		uExample.createCriteria().andUserTelEqualTo(tel);
		List<Usertable> users = new ArrayList<>();
		users = uMapper.selectByExample(uExample);
		Usertable user =new Usertable();
		if (users!=null) {
			
			user=users.get(0);
			user = decryptUser(user);
		}
		return user;
	}
	/**
	 * 查询用户
	 * @param userid
	 * @return usertable对象
	 */
	public Usertable seekUser(long userid) {
		UsertableExample uExample = new UsertableExample();
		uExample.createCriteria().andUserIdEqualTo(userid);
		Usertable user = new Usertable();
		user = uMapper.selectByPrimaryKey(userid);
		user=decryptUser(user);
		return user;
	}
	/**
	 * 删除用户
	 * @param userid
	 */
	public void deleteUser(Long userId) {
		uMapper.deleteByPrimaryKey(userId);
	}
	/**
	 * 添加用户信息
	 * @param newUser
	 */
	public void addUser(Usertable user) {
		user =encryptUser(user);
		uMapper.insert(user);
	}
	public List<Emailtable> listContact() {
		EmailtableExample e = new EmailtableExample();
		e.createCriteria().andEmailAddresseeEqualTo("all");
		List<Emailtable> clist = eMapper.selectByExample(e);
		return clist;
	}
	
	/**
	 * 更改用户信息
	 * @param updateUser
	 */
	public void update(Usertable updateUser) {
		updateUser = encryptUser(updateUser);
		UsertableExample uExample = new UsertableExample();
		uExample.createCriteria().andUserIdEqualTo(updateUser.getUserId());
		uMapper.updateByExample(updateUser, uExample);
		System.out.println("修改成功++++++++++++++");
	}
	public void killUser(Usertable updateUser) {
		UsertableExample uExample = new UsertableExample();
		uExample.createCriteria().andUserIdEqualTo(updateUser.getUserId());
		if (updateUser.getUserStatus()==1) {
			updateUser.setUserStatus((byte) 0);
			System.out.println("修改成功++++++++++++++");
		}else if (updateUser.getUserStatus()==0) {
			updateUser.setUserStatus((byte) 1);
			System.out.println("修改成功++++++++++++++");
		}
//		uMapper.updateByExample(updateUser, uExample);
		System.out.println(updateUser.getUserEmail()+updateUser.getUserName());
		updateUser = encryptUser(updateUser);
		uMapper.updateByExampleSelective(updateUser, uExample);
		System.out.println("修改成功==="+updateUser.getUserPassword()+"=====================");
	}
	/**
	 * 查询所有的用户
	 * @return
	 */
	public List<Usertable> listUser() {
		List<Usertable> list = uMapper.selectByExample(null);
		for (Usertable user : list) {
			user = decryptUser(user);
			System.out.println(user.getUserName()+"-------1111111111111--------");
		}
		return list;
	}
	/**
	 * 查找所有管理员
	 * @return
	 */
	public List<Usertable> listA() {
		UsertableExample e =new UsertableExample();
		e.createCriteria().andUserPositionEqualTo((byte) 1);
		List<Usertable> list = uMapper.selectByExample(e);
		return list;
	}
	
	/**
	 * 列出所有的失物招领信息
	 * @param usertable
	 * @return 
	 */
	public List<Goodstable> listGoods() {
		List<Goodstable> glist = new ArrayList<>();
		List<Goodstable> list  = gMapper.selectByExample(null);
		for (Goodstable goods : list) {
			if (differentTime(goods.getGoodsTime())) {
				glist.add(goods);
			}
			System.out.println(list.size()+"======================================");
		}
		return glist;
	}
	public List<Goodstable> listGoods2() {
		List<Goodstable> list  = gMapper.selectByExample(null);
		return list;
	}
	//修改密码方法
	public int recoverPsd(Usertable user) {
		user = encryptUser(user);//加密
		UsertableExample e =new UsertableExample();
		e.createCriteria().andUserIdEqualTo(user.getUserId()).andUserEmailEqualTo(user.getUserEmail());
		List<Usertable> list  = uMapper.selectByExample(e);
		if (list.size()>0) {
			Usertable nuser = uMapper.selectByPrimaryKey(user.getUserId());
			nuser = decryptUser(nuser);//解密
			nuser =encryptUser(nuser);
			nuser.setUserPassword(user.getUserPassword());
			uMapper.updateByExample(nuser, e);
			System.out.println("修改密码成功!!!!!!!!!!");
			return 1;
		}else {
			System.out.println("学号不存在,或者邮箱输入错误!!!!");
			return 0;
		}
	}
	public List<Goodstable> listSuc() {
		GoodstableExample e =new GoodstableExample();
		e.createCriteria().andGoodsSuccessEqualTo(1);
		List<Goodstable> list  = gMapper.selectByExample(e);
		return list;
	}
	public List<Goodstable> listMyGoods(String id) {
		GoodstableExample e =new GoodstableExample();
		e.createCriteria().andGoodsMasterEqualTo(id);
		List<Goodstable> list  = gMapper.selectByExample(e);
		return list;
	}
	public List<Goodstable> listLose() {
		List<Goodstable> glist = new ArrayList<>();
		List<Goodstable> list  = gMapper.selectByExample(null);
		for (Goodstable goods : list) {
			if (!differentTime(goods.getGoodsTime())) {
				if (goods.getGoodsKinds()==0) {
					glist.add(goods);
				}
			}
			System.out.println(list.size()+"======================================");
		}
		return glist;
	}
	public void finishGoods(int id) {
		GoodstableExample e = new GoodstableExample();
		e.createCriteria().andGoodsIdEqualTo(id);
		Goodstable goods = gMapper.selectByPrimaryKey(id);
		goods.setGoodsSuccess(1);
		GoodstableExample e1 = new GoodstableExample();
		e1.createCriteria().andGoodsIdEqualTo(id);
		gMapper.updateByPrimaryKey(goods);
	}
	
	public void addGoods(Goodstable goods) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
			goods.setGoodsTime(sdf.parse(sdf.format(new Date())));
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		gMapper.insert(goods);
		System.out.println("添加信息成功==========="+goods.getGoodsInfo());
	}
	
	public List<Emailtable> listEmail(String id) {
		EmailtableExample e = new EmailtableExample();
		e.createCriteria().andEmailSenderEqualTo(id);
		List<Emailtable> list  = eMapper.selectByExample(e);
		for (Emailtable email : list) {
			System.out.println(email.getEmailInfo()+"====0000000000000000008797");
		}
		System.out.println(list.size()+"========0000000000000000==============================");
		return list;
	}
	public void addEmail(Emailtable e) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
			e.setEmailTime(sdf.parse(sdf.format(new Date())));
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		eMapper.insert(e);
		System.out.println("添加信息成功==========="+e.getEmailInfo());
	}
	public List<String> listBulletin() {
		List<String> nlist = new ArrayList<>();
		int a =0;
		int b =0;
		int c =0;
		List<Goodstable> list  = gMapper.selectByExample(null);
		for (Goodstable g : list) {
			if (g.getGoodsKinds()==0) {
			if (g.getGoodsSuccess()==1) {
				a++;
			}
			}else {
				if (g.getGoodsSuccess()==1) {
					b++;
				}else {
					if (!differentTime(g.getGoodsTime())) {
						c++;
					}
				}
			}
		}
		nlist.add("已完成失物:"+a);
		nlist.add("已完成招领:"+b);
		nlist.add("超期未处理的招领:"+c);
		
		System.out.println("失物成功"+a+"======================================"+"招领成功"+b);
		return nlist;
	}
	public void deleteEmail(int id) {
		eMapper.deleteByPrimaryKey(id);
	}
	public void deleteBulletin(int id) {
		eMapper.deleteByPrimaryKey(id);
		System.out.println("删除邮件"+id);
	}
	//招领个数
	public int add1() {
		GoodstableExample g = new GoodstableExample();
		g.createCriteria().andGoodsKindsEqualTo((byte) 1);
		List<Goodstable> list  = gMapper.selectByExample(g);
		System.out.println(list.size()+"======================================");
		int m=list.size();
		return m;
	}
	public int add0() {
		GoodstableExample g = new GoodstableExample();
		g.createCriteria().andGoodsKindsEqualTo((byte) 0);
		List<Goodstable> list  = gMapper.selectByExample(g);
		System.out.println(list.size()+"======================================");
		int m=list.size();
		return m;
	}
	public List<Goodstable> seekGoods(String goal) {
		GoodstableExample e =new GoodstableExample();
		e.createCriteria().andGoodsInfoLike(goal);
		List<Goodstable> list = gMapper.selectByExample(e);
		System.out.println(goal);
		List<Goodstable> glist=new ArrayList<>();
		for (Goodstable goods : list) {
			if (differentTime(goods.getGoodsTime())) {
				glist.add(goods);
			}
			System.out.println(list.size()+"======================================");
		}
		for (Goodstable g : list) {
			System.out.println(g.getGoodsInfo()+"=================================");
		}
		return glist;
	}
	public boolean differentTime(Date time) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		int hours =0;
		try {
			long from = sdf.parse(sdf.format(new Date()).toString()).getTime();
			long to = sdf.parse(sdf.format(time).toString()).getTime();
			hours = (int) ((from - to)/(1000 * 60 * 60));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		if (hours < deadline) {
			return true;
		}else {
			return false;
		}
	}
    /**
     * 加密算法
     */
    private static final String ENCRY_ALGORITHM = "AES";

    /**
     * 加密算法/加密模式/填充类型
     * 本例采用AES加密，ECB加密模式，PKCS5Padding填充
     */
    private static final String CIPHER_MODE = "AES/ECB/PKCS5Padding";

    /**
     * 设置iv偏移量
     * 本例采用ECB加密模式，不需要设置iv偏移量
     */
    private static final String IV_ = null;

    /**
     * 设置加密字符集
     * 本例采用 UTF-8 字符集
     */
    private static final String CHARACTER = "UTF-8";

    /**
     * 设置加密密码处理长度。
     * 不足此长度补0；
     */
    private static final int PWD_SIZE = 16;

    /**
     * 密码处理方法
     * 如果加解密出问题，
     * 请先查看本方法，排除密码长度不足填充0字节,导致密码不一致
     * @param password 待处理的密码
     * @return
     * @throws UnsupportedEncodingException
     */
    private static byte[] pwdHandler(String password) throws UnsupportedEncodingException {
        byte[] data = null;
        if (password != null) {
            byte[] bytes = password.getBytes(CHARACTER);
            if (password.length() < PWD_SIZE) {
                System.arraycopy(bytes, 0, data = new byte[PWD_SIZE], 0, bytes.length);
            } else {
                data = bytes;
            }
        }
        return data;
    }

    //======================>原始加密<======================

    /**
     * 原始加密
     * @param clearTextBytes 明文字节数组，待加密的字节数组
     * @param pwdBytes 加密密码字节数组
     * @return 返回加密后的密文字节数组，加密错误返回null
     */
    public static byte[] encrypt(byte[] clearTextBytes, byte[] pwdBytes) {
        try {
            SecretKeySpec keySpec = new SecretKeySpec(pwdBytes, ENCRY_ALGORITHM);
            Cipher cipher = Cipher.getInstance(CIPHER_MODE);
            cipher.init(Cipher.ENCRYPT_MODE, keySpec);
            byte[] cipherTextBytes = cipher.doFinal(clearTextBytes);
            return cipherTextBytes;
        } catch (NoSuchPaddingException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (BadPaddingException e) {
            e.printStackTrace();
        } catch (IllegalBlockSizeException e) {
            e.printStackTrace();
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    /**
     * 原始解密
     * @param cipherTextBytes 密文字节数组，待解密的字节数组
     * @param pwdBytes 解密密码字节数组
     * @return 返回解密后的明文字节数组，解密错误返回null
     */
    public static byte[] decrypt(byte[] cipherTextBytes, byte[] pwdBytes) {
        try {
            SecretKeySpec keySpec = new SecretKeySpec(pwdBytes, ENCRY_ALGORITHM);
            Cipher cipher = Cipher.getInstance(CIPHER_MODE);
            cipher.init(Cipher.DECRYPT_MODE, keySpec);
            byte[] clearTextBytes = cipher.doFinal(cipherTextBytes);
            return clearTextBytes;
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        } catch (NoSuchPaddingException e) {
            e.printStackTrace();
        } catch (BadPaddingException e) {
            e.printStackTrace();
        } catch (IllegalBlockSizeException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    //======================>HEX<======================

    /**
     * HEX加密
     * @param clearText 明文，待加密的内容
     * @param password 密码，加密的密码
     * @return 返回密文，加密后得到的内容。加密错误返回null
     */
    public static String encryptHex(String clearText, String password) {
        try {
            byte[] cipherTextBytes = encrypt(clearText.getBytes(CHARACTER), pwdHandler(password));
            String cipherText = byte2hex(cipherTextBytes);
            return cipherText;
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * HEX解密
     * @param cipherText 密文，带解密的内容
     * @param password 密码，解密的密码
     * @return 返回明文，解密后得到的内容。解密错误返回null
     */
    public static String decryptHex(String cipherText, String password) {
        try {
            byte[] cipherTextBytes = hex2byte(cipherText);
            byte[] clearTextBytes = decrypt(cipherTextBytes, pwdHandler(password));
            return new String(clearTextBytes, CHARACTER);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /*字节数组转成16进制字符串  */
    public static String byte2hex(byte[] bytes) { // 一个字节的数，
        StringBuffer sb = new StringBuffer(bytes.length * 2);
        String tmp = "";
        for (int n = 0; n < bytes.length; n++) {
            // 整数转成十六进制表示
            tmp = (java.lang.Integer.toHexString(bytes[n] & 0XFF));
            if (tmp.length() == 1) {
                sb.append("0");
            }
            sb.append(tmp);
        }
        return sb.toString().toUpperCase(); // 转成大写
    }

    /*将hex字符串转换成字节数组 */
    private static byte[] hex2byte(String str) {
        if (str == null || str.length() < 2) {
            return new byte[0];
        }
        str = str.toLowerCase();
        int l = str.length() / 2;
        byte[] result = new byte[l];
        for (int i = 0; i < l; ++i) {
            String tmp = str.substring(2 * i, 2 * i + 2);
            result[i] = (byte) (Integer.parseInt(tmp, 16) & 0xFF);
        }
        return result;
    }
    public Usertable encryptUser(Usertable user) {
    	user.setUserName(encryptHex(user.getUserName(), keyword));
    	user.setUserPassword(encryptHex(user.getUserPassword(), keyword));
    	user.setUserEmail(encryptHex(user.getUserEmail(), keyword));
    	user.setUserIdnum(encryptHex(user.getUserIdnum(), keyword));
		return user;
	}    
    public Usertable decryptUser (Usertable user) {
    	user.setUserName(decryptHex(user.getUserName(), keyword));
    	user.setUserPassword(decryptHex(user.getUserPassword(), keyword));
    	user.setUserEmail(decryptHex(user.getUserEmail(), keyword));
    	user.setUserIdnum(decryptHex(user.getUserIdnum(), keyword));
		return user;
	}

	
}
