import java.util.Scanner;
import java.io.*;
class Main{
	void printWelcome(){
		System.out.println("�ڹ� �ؽ�ƮRPG�� ���Ű� ȯ���մϴ�.");
		System.out.println("����� ���Ϳ� �����ϰ� ��� ����ġ�� ������ �������� ������ �����ϸ� ���������� �巹���� ������ ������ ����˴ϴ�.");
		System.out.println("����� �̸��� ���Ͻʽÿ�");
		System.out.print("����� �̸�:");
		
	}
	void start(){
		System.out.println("1. �� ���� ����\n2. ����\n3. ����\n4.����");
	}
	void figth(){
		System.out.println("��� �� ���͸� �����ϼ���");
		System.out.println("1.���\n2.����\n3.��ũ\n4.������\n5.��\n6.�𵥵�\n7.�巹��(��������)\n8.���ư���");
	}
	void shop(){
		System.out.println("������ ���ϴ�");
		System.out.println("���� �� �������� �����ϼ���");
		System.out.println("1. ���� ����� 2.���� ����\n3.�� ����� 4.�� ����\n5.�� ����� 6.�� ����\n7.������ ����� 8.������ ����\n9.ȸ�� ����\n10.���ư���");
	}
}
class Player{
	static int maxHp, hp, exp, dmg, money, lv;
	String name;
	Player(){}
	Player(String a, int b, int c){
		name=a;
		maxHp=b;
		hp=maxHp;
		dmg=c;
		exp=0;
		lv=1;
		money=100;
	}
	String getName(){
		return name;
	}
	int getHp(){
		return hp;
	}
	int getDmg(){
		return dmg;
	}
	int getExp(){
		return exp;
	}
	int getMoney(){
		return money;
	}
	void printStatus(){
		System.out.println("==========���� "+name+"�� �ɷ�ġ �Դϴ�==========");
		System.out.println("ü��: "+hp);
		System.out.println("���ݷ�: "+dmg);
		System.out.println("��: "+money);
		System.out.println("����ġ: "+exp);
		System.out.println("����: "+lv);
		System.out.println("=====================================");
	}
	void lvUp(){
		System.out.println("==========���� ��!===========");
		++lv;
		dmg+=20;
		maxHp+=50;
		hp=maxHp;
		System.out.println("���ݷ��� 20 ��ŭ �ö����ϴ�");
		System.out.println("�ִ� ü���� 50��ŭ �ö����ϴ�");
		System.out.println("ü���� ȸ���˴ϴ�");
	}
	void gainExp(int a){
		System.out.println(a+"��ŭ�� ����ġ�� ������ϴ�");
		exp+=a;
		while(100<=exp){
			lvUp();
			exp-=100;
		}
	}
	void yourAttack(){
		System.out.println("-----------------------�����"+dmg+"��ŭ�� ���ظ� ����ϴ�");
	}
	void namePrint(){
		System.out.println("����� �̸���"+getName()+"�Դϴ�");
	}
}

class Monster{
	String name;
	int hp,giveExp,giveMoney,dmg,lv;
	Monster(){}
	Monster(String a, int b, int c, int d, int e, int f){
		name=a;
		hp=b;	
		giveExp=c;
		giveMoney=d;
		dmg=e;
		lv=f;
	}
	void attack(){
		System.out.println("���Ͱ� ��ſ���"+dmg+"��ŭ�� ���ظ� �������ϴ�");
	}
	int getHp(){
		return hp;
	}
	int getDmg(){
		return dmg;
	}
	int getGiveExp(){
		return giveExp;
	}
	int getGiveMoney(){
		return giveMoney;
	}
	int getLv(){
		return lv;
	}
	void mosterInfo(){
		System.out.println("������ �̸�:"+name);
		System.out.println("������ ü��:"+hp);
		System.out.println("������ ����:"+lv);
		System.out.println("������ ���ݷ�:"+dmg);
	}
	void printDead(){
		System.out.println("==========����� �¸��߽��ϴ�==========");
		System.out.println("���Ͱ� ���������ϴ�!");
		System.out.println("������ �޽��ϴ�");
		System.out.println("������ ��ȯ �մϴ�");
		System.out.println("ȹ���� ��:"+giveMoney);
		System.out.println("ȹ���� ����ġ:"+giveExp);
		System.out.println("=================================");
	}
}
class Shop{
	int price;
	String item;
	int giveHp;
	int giveDmg;
	Shop(){}
	Shop(String a, int b, int c, int d){
		item=a;
		giveHp=b;
		giveDmg=c;
		price=d;
	}
	int getPrice(){
		return price;
	}
	String getItem(){
		return item;
	}	
	void info(){
		System.out.println("������ �̸�:"+item);
		System.out.println("����:"+price);
		System.out.println("ü�� ������:"+giveHp);
		System.out.println("���ݷ� ������:"+giveDmg);
	}			
}
class Goblin extends Monster{
	Goblin(){}
	Goblin(String a, int b, int c, int d, int e, int f){
		super(a,b,c,d,e,f);
	}
	void printSkill(){
		System.out.println(name+"�� ����");
		System.out.println("---------------����� �����̷�"+dmg+"��ŭ�� ���ظ� �������ϴ�.");
		System.out.println(name+"�� ����ü��:"+hp);
	}
}
class Zombie extends Monster{
	Zombie(){}
	Zombie(String a, int b, int c, int d, int e, int f){
		super(a,b,c,d,e,f);
	}
	void printSkill(){
		System.out.println(name+"�� ����");	
		System.out.println("---------------���� ������"+dmg+"��ŭ�� ���ظ� �������ϴ�.");
		System.out.println(name+"�� ����ü��:"+hp);
	}
}
class Orc extends Monster{
	Orc(){}
	Orc(String a, int b, int c, int d, int e, int f){
		super(a,b,c,d,e,f);
	}
	void printSkill(){
		System.out.println(name+"�� ����");
		System.out.println("---------------��ũ�� �����"+dmg+"��ŭ�� ���ظ� �������ϴ�.");
		System.out.println(name+"�� ����ü��:"+hp);
	}
}
class Slime extends Monster{
	Slime(){}
	Slime(String a, int b, int c, int d, int e, int f){
		super(a,b,c,d,e,f);
	}
	void printSkill(){
		System.out.println(name+"�� ����");
		System.out.println("---------------�������� ���� ��ġ���"+dmg+"��ŭ�� ���ظ� �������ϴ�.");
		System.out.println(name+"�� ����ü��:"+hp);
	}
}
class Golem extends Monster{
	Golem(){}
	Golem(String a, int b, int c, int d, int e, int f){
		super(a,b,c,d,e,f);
	}
	void printSkill(){
		System.out.println(name+"�� ����");
		System.out.println("---------------���� �߷�"+dmg+"��ŭ�� ���ظ� �������ϴ�.");
		System.out.println(name+"�� ����ü��:"+hp);
	}
}
class Undead extends Monster{
	Undead(){}
	Undead(String a, int b, int c, int d, int e, int f){
		super(a,b,c,d,e,f);
	}
	void printSkill(){
		System.out.println(name+"�� ����");
		System.out.println("---------------�𵥵尡 ������"+dmg+"��ŭ�� ���ظ� �������ϴ�.");
		System.out.println(name+"�� ����ü��:"+hp);
	}
}
class Dragon extends Monster{
	Dragon(){}
	Dragon(String a, int b, int c, int d, int e, int f){
		super(a,b,c,d,e,f);
	}
	void printSkill(){
		System.out.println(name+"�� ����");
		System.out.println("---------------�巹���� ��������"+dmg+"��ŭ�� ���ظ� �������ϴ�.");
		System.out.println(name+"�� ����ü��:"+hp);
	}
}
class GameMain{
	public static void main(String args[]){
		Scanner scan=new Scanner(System.in);
		Main m=new Main();
		
		try{
			FileWriter out=new FileWriter("Welcome.txt");
			out.write("==============�ڹ� �ؽ�Ʈ RPG�� ���Ű��� ȯ���մϴ�==============\n");
			out.write("����� ���͸� ������ ��� ���� ����ġ�� �����Ͽ�\n���������� �巡���� ��ƾ� �մϴ�.\n");
			out.write("���� ����� ĳ������ �̸��� ����ʽÿ�\n");
			out.close();
			FileReader in=new FileReader("Welcome.txt");
			int cc;
			String ww="";
			while((cc=in.read())!=-1){
				ww+=(char)cc;
			}
			in.close();
			System.out.println(ww);
		}catch(Exception e){
			System.out.print("���ܹ߻�");
		}
		System.out.print("ĳ������ �̸�:");
		String a=scan.nextLine();
		Player gamer=new Player(a, 100, 30);
		gamer.namePrint();
		boolean se=true;
		while(true){
			System.out.println("���� ����� �ɷ�ġ �Դϴ�.");
			gamer.printStatus();
			m.start();
			int aa=scan.nextInt();
			if(aa==1){
				gamer.printStatus();
				m.start();
			}
			if(aa==2){
				m.figth();
				int c=scan.nextInt();
				if(c==1){
					Goblin g=new Goblin("���", 100, 10, 30, 15, 1);
					g.mosterInfo();
					System.out.println(g.name+"�� ���� �ϰڽ��ϱ�?\n1.���� 2.���ư���");
					int o=scan.nextInt();
					if(o==1){
						System.out.println(g.name+"�� �����մϴ�.");
						boolean t=true;
						while(t){
							System.out.println(gamer.name+"�� ����");
							gamer.yourAttack();
							g.hp-=gamer.dmg;
							if(g.hp<=0){
								System.out.println(g.name+"�� ���������ϴ�");
								System.out.println("==========�������� �¸��Ͽ����ϴ�==========");
								gamer.gainExp(g.giveExp);
								gamer.money+=g.giveMoney;
								break;
							}
							g.printSkill();
							gamer.hp-=g.dmg;
							if(gamer.hp<=0){
								System.out.println("����Ͽ����ϴ�.");
								System.out.println("������ �����մϴ�");
								System.exit(0);
							}
						}
					}
					if(o>=2){
					}
				}
				if(c==2){
					Zombie z=new Zombie("����",150,15,50,20,2);
					z.mosterInfo();
					System.out.println(z.name+"�� ���� �ϰڽ��ϱ�?\n1.���� 2.���ư���");
					int o=scan.nextInt();
					if(o==1){
						System.out.println(z.name+"�� �����մϴ�.");
						boolean t=true;
						while(t){
							System.out.println(gamer.name+"�� ����");
							gamer.yourAttack();
							z.hp-=gamer.dmg;
							if(z.hp<=0){
								System.out.println(z.name+"�� ���������ϴ�");
								System.out.println("==========�������� �¸��Ͽ����ϴ�==========");
								gamer.gainExp(z.giveExp);
								gamer.money+=z.giveMoney;
								break;
							}
							z.printSkill();
							gamer.hp-=z.dmg;
							if(gamer.hp<=0){
								System.out.println("����Ͽ����ϴ�.");
								System.out.println("������ �����մϴ�");
								System.exit(0);
							}		
						}
					}
					if(o>=2){
					}	
				}
				if(c==3){
					Orc or=new Orc("��ũ",200,20,70,30,3);
					or.mosterInfo();
					System.out.println(or.name+"�� ���� �ϰڽ��ϱ�?\n1.���� 2.���ư���");
					int o=scan.nextInt();
					if(o==1){
						System.out.println(or.name+"�� �����մϴ�.");
						boolean t=true;
						while(t){
							System.out.println(gamer.name+"�� ����");
							gamer.yourAttack();
							or.hp-=gamer.dmg;
							if(or.hp<=0){
								System.out.println(or.name+"�� ���������ϴ�");
								System.out.println("==========�������� �¸��Ͽ����ϴ�==========");
								gamer.gainExp(or.giveExp);
								gamer.money+=or.giveMoney;
								break;
							}
							or.printSkill();
							gamer.hp-=or.dmg;
							if(gamer.hp<=0){
								System.out.println("����Ͽ����ϴ�.");
								System.out.println("������ �����մϴ�");
								System.exit(0);
							}		
						}
					}
					if(o>=2){
					}
				}
				if(c==4){
					Slime s=new Slime("������",350,30,90,50,4);
					s.mosterInfo();
					System.out.println(s.name+"�� ���� �ϰڽ��ϱ�?\n1.���� 2.���ư���");
					int o=scan.nextInt();
					if(o==1){
						System.out.println(s.name+"�� �����մϴ�.");
						boolean t=true;
						while(t){
							System.out.println(gamer.name+"�� ����");
							gamer.yourAttack();
							s.hp-=gamer.dmg;
							if(s.hp<=0){
								System.out.println(s.name+"�� ���������ϴ�");
								System.out.println("==========�������� �¸��Ͽ����ϴ�==========");
								gamer.gainExp(s.giveExp);
								gamer.money+=s.giveMoney;
								break;
							}
							s.printSkill();
							gamer.hp-=s.dmg;
							if(gamer.hp<=0){
								System.out.println("����Ͽ����ϴ�.");
								System.out.println("������ �����մϴ�");
								System.exit(0);
							}
						}
					}
					if(o>=2){
					}		
				}
				if(c==5){
					Golem go=new Golem("��",500,35,100,20,5);
					go.mosterInfo();
					System.out.println(go.name+"�� ���� �ϰڽ��ϱ�?\n1.���� 2.���ư���");
					int o=scan.nextInt();
					if(o==1){
						System.out.println(go.name+"�� �����մϴ�.");
						boolean t=true;
						while(t){
							System.out.println(gamer.name+"�� ����");
							gamer.yourAttack();
							go.hp-=gamer.dmg;
							if(go.hp<=0){
								System.out.println(go.name+"�� ���������ϴ�");
								System.out.println("==========�������� �¸��Ͽ����ϴ�==========");
								gamer.gainExp(go.giveExp);
								gamer.money+=go.giveMoney;
								break;
							}
							go.printSkill();
							gamer.hp-=go.dmg;
							if(gamer.hp<=0){
								System.out.println("����Ͽ����ϴ�.");
								System.out.println("������ �����մϴ�");
								System.exit(0);
							}		
						}
					}
					if(o>=2){
						}
				}
				if(c==6){
					Undead u=new Undead("�𵥵�",550,35,130,100,6);
					u.mosterInfo();
					System.out.println(u.name+"�� ���� �ϰڽ��ϱ�?\n1.���� 2.���ư���");
					int o=scan.nextInt();
					if(o==1){
						System.out.println(u.name+"�� �����մϴ�.");
						boolean t=true;
						while(t){
							System.out.println(gamer.name+"�� ����");
							gamer.yourAttack();
							u.hp-=gamer.dmg;
							if(u.hp<=0){
								System.out.println(u.name+"�� ���������ϴ�");
								System.out.println("==========�������� �¸��Ͽ����ϴ�==========");
								gamer.gainExp(u.giveExp);
								gamer.money+=u.giveMoney;
								break;
							}
							u.printSkill();
							gamer.hp-=u.dmg;
							if(gamer.hp<=0){
								System.out.println("����Ͽ����ϴ�.");
								System.out.println("������ �����մϴ�");
								System.exit(0);
							}
						}
					}
					if(o>=2){
						}		
				}
				if(c==7){
					Dragon d=new Dragon("�巹��",1000,200,300,150,10);
					d.mosterInfo();
					System.out.println(d.name+"�� ���� �ϰڽ��ϱ�?\n1.���� 2.���ư���");
					int o=scan.nextInt();
					if(o==1){
						System.out.println(d.name+"�� �����մϴ�.");
						boolean t=true;
						while(t){
							System.out.println(gamer.name+"�� ����");
							gamer.yourAttack();
							d.hp-=gamer.dmg;
							if(d.hp<=0){
								System.out.println(d.name+"�� ���������ϴ�");
								System.out.println("==========�������� �¸��Ͽ����ϴ�==========");
								gamer.gainExp(d.giveExp);
								gamer.money+=d.giveMoney;
								System.out.println("===========����� ������ ���� ���� �Դϴ�===========");
								System.out.println("������ ���� �մϴ�.");
								System.exit(0);
								}
							d.printSkill();
							gamer.hp-=d.dmg;
							if(gamer.hp<=0){
								System.out.println("����Ͽ����ϴ�.");
								System.out.println("������ �����մϴ�");
								System.exit(0);
							}		
						}
					}
					if(o>=2){
					}
				}
				if(c<=8){
				}
			}
			if(aa==3){
				m.shop();
				int i=scan.nextInt();
				boolean ff=true;
				while(ff){
					if(i==1){
						Shop bn=new Shop("���� �����",50,10,100);
						bn.info();
						System.out.println(bn.item+"�� ���� �մϱ�?\n1.�� 2.���ư���");
						int ii=scan.nextInt();
						if(ii==1&&gamer.money>=bn.price){
							gamer.money-=bn.price;
							System.out.println(bn.item+"�� �����߽��ϴ�");
							gamer.hp+=bn.giveHp;
							gamer.dmg+=bn.giveDmg;
							break;
						}
						if(ii==1&&gamer.money<bn.price){
							System.out.println("����"+(bn.price-gamer.money)+"��ŭ �����մϴ�.");
							break;
						}
						if(ii>=2){
							break;
						}
					}
					if(i==2){
						Shop br=new Shop("��������",30,30,100);
						br.info();
						System.out.println(br.item+"�� ���� �մϱ�?\n1.�� 2.���ư���");
						int ii=scan.nextInt();
						if(ii==1&&gamer.money>=br.price){
							gamer.money-=br.price;
							System.out.println(br.item+"�� �����߽��ϴ�");
							gamer.hp+=br.giveHp;
							gamer.dmg+=br.giveDmg;
							break;
						}
						if(ii==1&&gamer.money<br.price){
							System.out.println("����"+(br.price-gamer.money)+"��ŭ �����մϴ�.");
							break;
						}
						if(ii>=2){
							break;
						}
					}
					if(i==3){
						Shop sn=new Shop("�� �����",100,30,200);
						sn.info();
						System.out.println(sn.item+"�� ���� �մϱ�?\n1.�� 2.���ư���");
						int ii=scan.nextInt();
						if(ii==1&&gamer.money>=sn.price){
							gamer.money-=sn.price;
							System.out.println(sn.item+"�� �����߽��ϴ�");
							gamer.hp+=sn.giveHp;
							gamer.dmg+=sn.giveDmg;
							break;
						}
						if(ii==1&&gamer.money<sn.price){
							System.out.println("����"+(sn.price-gamer.money)+"��ŭ �����մϴ�.");
							break;
						}
						if(ii>=2){
							break;
						}
					}
					if(i==4){
						Shop sr=new Shop("�� ����",50,80,200);
						sr.info();
						System.out.println(sr.item+"�� ���� �մϱ�?\n1.�� 2.���ư���");
						int ii=scan.nextInt();
						if(ii==1&&gamer.money>=sr.price){
							gamer.money-=sr.price;
							System.out.println(sr.item+"�� �����߽��ϴ�");
							gamer.hp+=sr.giveHp;
							gamer.dmg+=sr.giveDmg;
							break;
						}
						if(ii==1&&gamer.money<sr.price){
							System.out.println("����"+(sr.price-gamer.money)+"��ŭ �����մϴ�.");
							break;
						}
						if(ii>=2){
							break;
						}
					}
					if(i==5){
						Shop gn=new Shop("�� �����",150,50,300);
						gn.info();
						System.out.println(gn.item+"�� ���� �մϱ�?\n1.�� 2.���ư���");
						int ii=scan.nextInt();
						if(ii==1&&gamer.money>=gn.price){
							gamer.money-=gn.price;
							System.out.println(gn.item+"�� �����߽��ϴ�");
							gamer.hp+=gn.giveHp;
							gamer.dmg+=gn.giveDmg;
							break;
						}
						if(ii==1&&gamer.money<gn.price){
							System.out.println("����"+(gn.price-gamer.money)+"��ŭ �����մϴ�.");
							break;
						}
						if(ii>=2){
							break;
						}
					}
					if(i==6){
						Shop gr=new Shop("�� ����",80,120,300);
						gr.info();
						System.out.println(gr.item+"�� ���� �մϱ�?\n1.�� 2.���ư���");
						int ii=scan.nextInt();
						if(ii==1&&gamer.money>=gr.price){
							gamer.money-=gr.price;
							System.out.println(gr.item+"�� �����߽��ϴ�");
							gamer.hp+=gr.giveHp;
							gamer.dmg+=gr.giveDmg;
							break;
						}
						if(ii==1&&gamer.money<gr.price){
							System.out.println("����"+(gr.price-gamer.money)+"��ŭ �����մϴ�.");
							break;
						}
						if(ii>=2){
							break;
						}
					}
					if(i==7){
						Shop mn=new Shop("������ �����",300,50,1000);
						mn.info();
						System.out.println(mn.item+"�� ���� �մϱ�?\n1.�� 2.���ư���");
						int ii=scan.nextInt();
						if(ii==1&&gamer.money>=mn.price){
							gamer.money-=mn.price;
							System.out.println(mn.item+"�� �����߽��ϴ�");
							gamer.hp+=mn.giveHp;
							gamer.dmg+=mn.giveDmg;
							break;
						}
						if(ii==1&&gamer.money<mn.price){
							System.out.println("����"+(mn.price-gamer.money)+"��ŭ �����մϴ�.");
							break;
						}
						if(ii>=2){
							break;
						}
					}
					if(i==8){
						Shop mr=new Shop("������ ����",100,100,1000);
						mr.info();
						System.out.println(mr.item+"�� ���� �մϱ�?\n1.�� 2.���ư���");
						int ii=scan.nextInt();
						if(ii==1&&gamer.money>=mr.price){
							gamer.money-=mr.price;
							System.out.println(mr.item+"�� �����߽��ϴ�");
							gamer.hp+=mr.giveHp;
							gamer.dmg+=mr.giveDmg;
							break;
						}
						if(ii==1&&gamer.money<mr.price){
							System.out.println("����"+(mr.price-gamer.money)+"��ŭ �����մϴ�.");
							break;
						}
						if(ii>=2){
							break;
						}
					}
					if(i==9){
						Shop hp=new Shop("ȸ�� ����",50,0,40);
						hp.info();
						System.out.println(hp.item+"�� ���� �մϱ�?\n1.�� 2.���ư���");
						int ii=scan.nextInt();
						if(ii==1&&gamer.money>=hp.price){
							gamer.money-=hp.price;
							System.out.println(hp.item+"�� �����߽��ϴ�");
							gamer.hp+=hp.giveHp;
							break;
						}
						if(ii==1&&gamer.money<hp.price){
							System.out.println("����"+(hp.price-gamer.money)+"��ŭ �����մϴ�.");
							break;
						}
						if(ii>=2){
							break;
						}
					}
					if(i==10){
						break;
					}
				}
			}
				if(aa==4){
					System.out.println("������ �����մϴ�");
					System.exit(0);
				}
		}				
	}
}
