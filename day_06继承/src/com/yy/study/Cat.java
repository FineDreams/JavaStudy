package com.yy.study;

public class Cat {
    private String name;
    private Person onwer;
    
    /*
     * ���췽��:
     *     1����������������ͬ
     *     2��û�з���ֵ��һ����
     * ���˹��췽������Ҫset/get��ʲô��
     * ���ȵ�һ�㣬get��һ��Ҫ�еģ�����������������޷����˽�����Ե�
     * 
     * ����set��
     *     ��Щ���ԣ�������ÿ������Ҫ���еģ�
     *����cat���ܻ���һ�����£����ǲ�����ÿ��
     *cat�ڳ�ʼ����ʱ�򣬶����Ͼ���һ��������
     *���Կ����ں�����ʹ���У�ͨ��set����
     *��������һ��
     *   ���ڳ�ʼ�����е����onwer���ԣ�
     *�ܿ������è֮�����ˣ��Ǿ���Ҫ��һ��
     *���ˣ���ʱ��Ҳ����ʹ��set������ȥ�޸�����
     */
    
    public Cat(Person onwer){
    	//�������еĲ���onwer��ֵ
    	//��ֵ��������onwer
    	this.onwer=onwer;
    }
    
    public void setName(String name){
    	this.name=name;
    }
	public String getName() {
		return name;
	}
	public Person getOnwer() {
		return onwer;
	}
	public void setOnwer(Person onwer) {
		this.onwer = onwer;
	}
}
