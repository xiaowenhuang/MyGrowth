package sven.model;

import java.util.List;

import com.sven.bean.Car;
import com.sven.bean.Card;
import com.sven.bean.Family;
import com.sven.bean.Work;

/**
 * sven 模型
 * @author Sven
 *
 */
public class Sven {
	private int age;//年龄，每年递增
	private int height;//身高
	private int weight;//体重
	private String name;
	private List<String> sex;
	private String school;
	private String address;
	private String hobby;//业余爱好
	private String habit;//习惯
	private Card card;
	private Car car;
	private Work work;
	private Family family;
	private String img;//照片******用什么类型来代替String可以存放图片
	private boolean handsome;
	private List<String> mylove;//not my lover
}
