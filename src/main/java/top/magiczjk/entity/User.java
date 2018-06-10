package top.magiczjk.entity;

import java.io.Serializable;

import org.mongodb.morphia.annotations.Entity;
/**
 * 
* @ClassName: User  
* @Description: TODO(这里用一句话描述这个类的作用)  
* @author zjk  
* @date 2018年6月10日  
*
 */
@Entity(noClassnameStored = true)
public class User extends BaseEntity{


	private static final long serialVersionUID = 2021651903142197974L;
	private String name;
	private String pass;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	
}
