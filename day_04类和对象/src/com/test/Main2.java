package com.test;
public class Main2 {
	
	//main��������������
	//��Java��������ʱ
	//�ͻ��ȴ����￪ʼִ��
    public static void main(String[] args){
    	/*
    	 * ���㴴�������
    	 * ��Ҫ�ȴ��������󣬲ſ���ʹ��
    	 */
  
    	Father father=new Father();
    	//ʹ�ö��󣬵������ķ���ȥ��һЩ����
    	//������.������();
    	father.ShowInfo();
    	
    	//������.����	
    	System.out.println(father.name);
    	
    	Student zhangSan=new Student();	
    	//������.������=����ֵ
		//����һ����ֵ�Ĺ���			
        zhangSan.name="������";
        zhangSan.school="��Ÿ�Ƽ���ӭ��";
        System.out.println(zhangSan.name);
        
        //���������÷���
        //ʹ��zhangSan�������
        //����play�������
        zhangSan.play();
        
        //���շ�:SuperStudent
        //����
        
        //С�շ�:superStudent
        //��������������
        zhangSan.buyFood(100);
        
        zhangSan.add(200, 345);
        //����������з���ֵ��
        //����ֵ������ΪString
        //�������ǿ��Զ���һ��String����
        //�ı���ȥ������������ķ���ֵ
        
        String f=zhangSan.hot("����");
        System.out.println(f);
     }
}
