import java.util.Scanner;
import java.io.*;
class Main{
	void printWelcome(){
		System.out.println("자바 텍스트RPG에 오신걸 환영합니다.");
		System.out.println("당신은 몬스터와 전투하고 얻는 경험치와 돈으로 아이템을 구매해 성장하며 최종보스인 드레곤을 잡으면 게임이 종료됩니다.");
		System.out.println("당신의 이름을 정하십시오");
		System.out.print("당신의 이름:");
		
	}
	void start(){
		System.out.println("1. 내 정보 보기\n2. 전투\n3. 상점\n4.종료");
	}
	void figth(){
		System.out.println("사냥 할 몬스터를 선택하세요");
		System.out.println("1.고블린\n2.좀비\n3.오크\n4.슬라임\n5.골렘\n6.언데드\n7.드레곤(최종보스)\n8.돌아가기");
	}
	void shop(){
		System.out.println("상점에 갑니다");
		System.out.println("구매 할 아이템을 선택하세요");
		System.out.println("1. 낡은 목걸이 2.낡은 반지\n3.은 목걸이 4.은 반지\n5.금 목걸이 6.금 반지\n7.마법의 목걸이 8.마법의 반지\n9.회복 포션\n10.돌아가기");
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
		System.out.println("==========현재 "+name+"의 능력치 입니다==========");
		System.out.println("체력: "+hp);
		System.out.println("공격력: "+dmg);
		System.out.println("돈: "+money);
		System.out.println("경험치: "+exp);
		System.out.println("레벨: "+lv);
		System.out.println("=====================================");
	}
	void lvUp(){
		System.out.println("==========레벨 업!===========");
		++lv;
		dmg+=20;
		maxHp+=50;
		hp=maxHp;
		System.out.println("공격력이 20 만큼 올랐습니다");
		System.out.println("최대 체력이 50만큼 올랐습니다");
		System.out.println("체력이 회복됩니다");
	}
	void gainExp(int a){
		System.out.println(a+"만큼의 경험치를 얻었습니다");
		exp+=a;
		while(100<=exp){
			lvUp();
			exp-=100;
		}
	}
	void yourAttack(){
		System.out.println("-----------------------당신은"+dmg+"만큼의 피해를 줬습니다");
	}
	void namePrint(){
		System.out.println("당신의 이름은"+getName()+"입니다");
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
		System.out.println("몬스터가 당신에게"+dmg+"만큼의 피해를 입혔습니다");
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
		System.out.println("몬스터의 이름:"+name);
		System.out.println("몬스터의 체력:"+hp);
		System.out.println("몬스터의 레벨:"+lv);
		System.out.println("몬스터의 공격력:"+dmg);
	}
	void printDead(){
		System.out.println("==========당신은 승리했습니다==========");
		System.out.println("몬스터가 쓰러졌습니다!");
		System.out.println("보상을 받습니다");
		System.out.println("마을로 귀환 합니다");
		System.out.println("획득한 돈:"+giveMoney);
		System.out.println("획득한 경험치:"+giveExp);
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
		System.out.println("아이템 이름:"+item);
		System.out.println("가격:"+price);
		System.out.println("체력 증가량:"+giveHp);
		System.out.println("공격력 증가량:"+giveDmg);
	}			
}
class Goblin extends Monster{
	Goblin(){}
	Goblin(String a, int b, int c, int d, int e, int f){
		super(a,b,c,d,e,f);
	}
	void printSkill(){
		System.out.println(name+"의 공격");
		System.out.println("---------------고블린이 몽둥이로"+dmg+"만큼의 피해를 입혔습니다.");
		System.out.println(name+"의 남은체력:"+hp);
	}
}
class Zombie extends Monster{
	Zombie(){}
	Zombie(String a, int b, int c, int d, int e, int f){
		super(a,b,c,d,e,f);
	}
	void printSkill(){
		System.out.println(name+"의 공격");	
		System.out.println("---------------좀비가 손으로"+dmg+"만큼의 피해를 입혔습니다.");
		System.out.println(name+"의 남은체력:"+hp);
	}
}
class Orc extends Monster{
	Orc(){}
	Orc(String a, int b, int c, int d, int e, int f){
		super(a,b,c,d,e,f);
	}
	void printSkill(){
		System.out.println(name+"의 공격");
		System.out.println("---------------오크가 무기로"+dmg+"만큼의 피해를 입혔습니다.");
		System.out.println(name+"의 남은체력:"+hp);
	}
}
class Slime extends Monster{
	Slime(){}
	Slime(String a, int b, int c, int d, int e, int f){
		super(a,b,c,d,e,f);
	}
	void printSkill(){
		System.out.println(name+"의 공격");
		System.out.println("---------------슬라임이 몸통 박치기로"+dmg+"만큼의 피해를 입혔습니다.");
		System.out.println(name+"의 남은체력:"+hp);
	}
}
class Golem extends Monster{
	Golem(){}
	Golem(String a, int b, int c, int d, int e, int f){
		super(a,b,c,d,e,f);
	}
	void printSkill(){
		System.out.println(name+"의 공격");
		System.out.println("---------------골렘이 발로"+dmg+"만큼의 피해를 입혔습니다.");
		System.out.println(name+"의 남은체력:"+hp);
	}
}
class Undead extends Monster{
	Undead(){}
	Undead(String a, int b, int c, int d, int e, int f){
		super(a,b,c,d,e,f);
	}
	void printSkill(){
		System.out.println(name+"의 공격");
		System.out.println("---------------언데드가 손으로"+dmg+"만큼의 피해를 입혔습니다.");
		System.out.println(name+"의 남은체력:"+hp);
	}
}
class Dragon extends Monster{
	Dragon(){}
	Dragon(String a, int b, int c, int d, int e, int f){
		super(a,b,c,d,e,f);
	}
	void printSkill(){
		System.out.println(name+"의 공격");
		System.out.println("---------------드레곤이 마법으로"+dmg+"만큼의 피해를 입혔습니다.");
		System.out.println(name+"의 남은체력:"+hp);
	}
}
class GameMain{
	public static void main(String args[]){
		Scanner scan=new Scanner(System.in);
		Main m=new Main();
		
		try{
			FileWriter out=new FileWriter("Welcome.txt");
			out.write("==============자바 텍스트 RPG에 오신것을 환영합니다==============\n");
			out.write("당신은 몬스터를 잡으며 얻는 돈과 경험치로 성장하여\n최종보스인 드래곤을 잡아야 합니다.\n");
			out.write("이제 당신의 캐릭터의 이름을 만드십시오\n");
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
			System.out.print("예외발생");
		}
		System.out.print("캐릭터의 이름:");
		String a=scan.nextLine();
		Player gamer=new Player(a, 100, 30);
		gamer.namePrint();
		boolean se=true;
		while(true){
			System.out.println("현재 당신의 능력치 입니다.");
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
					Goblin g=new Goblin("고블린", 100, 10, 30, 15, 1);
					g.mosterInfo();
					System.out.println(g.name+"과 전투 하겠습니까?\n1.전투 2.돌아가기");
					int o=scan.nextInt();
					if(o==1){
						System.out.println(g.name+"와 전투합니다.");
						boolean t=true;
						while(t){
							System.out.println(gamer.name+"의 공격");
							gamer.yourAttack();
							g.hp-=gamer.dmg;
							if(g.hp<=0){
								System.out.println(g.name+"이 쓰러졌습니다");
								System.out.println("==========전투에서 승리하였습니다==========");
								gamer.gainExp(g.giveExp);
								gamer.money+=g.giveMoney;
								break;
							}
							g.printSkill();
							gamer.hp-=g.dmg;
							if(gamer.hp<=0){
								System.out.println("사망하였습니다.");
								System.out.println("게임을 종료합니다");
								System.exit(0);
							}
						}
					}
					if(o>=2){
					}
				}
				if(c==2){
					Zombie z=new Zombie("좀비",150,15,50,20,2);
					z.mosterInfo();
					System.out.println(z.name+"과 전투 하겠습니까?\n1.전투 2.돌아가기");
					int o=scan.nextInt();
					if(o==1){
						System.out.println(z.name+"와 전투합니다.");
						boolean t=true;
						while(t){
							System.out.println(gamer.name+"의 공격");
							gamer.yourAttack();
							z.hp-=gamer.dmg;
							if(z.hp<=0){
								System.out.println(z.name+"이 쓰러졌습니다");
								System.out.println("==========전투에서 승리하였습니다==========");
								gamer.gainExp(z.giveExp);
								gamer.money+=z.giveMoney;
								break;
							}
							z.printSkill();
							gamer.hp-=z.dmg;
							if(gamer.hp<=0){
								System.out.println("사망하였습니다.");
								System.out.println("게임을 종료합니다");
								System.exit(0);
							}		
						}
					}
					if(o>=2){
					}	
				}
				if(c==3){
					Orc or=new Orc("오크",200,20,70,30,3);
					or.mosterInfo();
					System.out.println(or.name+"과 전투 하겠습니까?\n1.전투 2.돌아가기");
					int o=scan.nextInt();
					if(o==1){
						System.out.println(or.name+"와 전투합니다.");
						boolean t=true;
						while(t){
							System.out.println(gamer.name+"의 공격");
							gamer.yourAttack();
							or.hp-=gamer.dmg;
							if(or.hp<=0){
								System.out.println(or.name+"이 쓰러졌습니다");
								System.out.println("==========전투에서 승리하였습니다==========");
								gamer.gainExp(or.giveExp);
								gamer.money+=or.giveMoney;
								break;
							}
							or.printSkill();
							gamer.hp-=or.dmg;
							if(gamer.hp<=0){
								System.out.println("사망하였습니다.");
								System.out.println("게임을 종료합니다");
								System.exit(0);
							}		
						}
					}
					if(o>=2){
					}
				}
				if(c==4){
					Slime s=new Slime("슬라임",350,30,90,50,4);
					s.mosterInfo();
					System.out.println(s.name+"과 전투 하겠습니까?\n1.전투 2.돌아가기");
					int o=scan.nextInt();
					if(o==1){
						System.out.println(s.name+"와 전투합니다.");
						boolean t=true;
						while(t){
							System.out.println(gamer.name+"의 공격");
							gamer.yourAttack();
							s.hp-=gamer.dmg;
							if(s.hp<=0){
								System.out.println(s.name+"이 쓰러졌습니다");
								System.out.println("==========전투에서 승리하였습니다==========");
								gamer.gainExp(s.giveExp);
								gamer.money+=s.giveMoney;
								break;
							}
							s.printSkill();
							gamer.hp-=s.dmg;
							if(gamer.hp<=0){
								System.out.println("사망하였습니다.");
								System.out.println("게임을 종료합니다");
								System.exit(0);
							}
						}
					}
					if(o>=2){
					}		
				}
				if(c==5){
					Golem go=new Golem("골렘",500,35,100,20,5);
					go.mosterInfo();
					System.out.println(go.name+"과 전투 하겠습니까?\n1.전투 2.돌아가기");
					int o=scan.nextInt();
					if(o==1){
						System.out.println(go.name+"와 전투합니다.");
						boolean t=true;
						while(t){
							System.out.println(gamer.name+"의 공격");
							gamer.yourAttack();
							go.hp-=gamer.dmg;
							if(go.hp<=0){
								System.out.println(go.name+"이 쓰러졌습니다");
								System.out.println("==========전투에서 승리하였습니다==========");
								gamer.gainExp(go.giveExp);
								gamer.money+=go.giveMoney;
								break;
							}
							go.printSkill();
							gamer.hp-=go.dmg;
							if(gamer.hp<=0){
								System.out.println("사망하였습니다.");
								System.out.println("게임을 종료합니다");
								System.exit(0);
							}		
						}
					}
					if(o>=2){
						}
				}
				if(c==6){
					Undead u=new Undead("언데드",550,35,130,100,6);
					u.mosterInfo();
					System.out.println(u.name+"과 전투 하겠습니까?\n1.전투 2.돌아가기");
					int o=scan.nextInt();
					if(o==1){
						System.out.println(u.name+"와 전투합니다.");
						boolean t=true;
						while(t){
							System.out.println(gamer.name+"의 공격");
							gamer.yourAttack();
							u.hp-=gamer.dmg;
							if(u.hp<=0){
								System.out.println(u.name+"이 쓰러졌습니다");
								System.out.println("==========전투에서 승리하였습니다==========");
								gamer.gainExp(u.giveExp);
								gamer.money+=u.giveMoney;
								break;
							}
							u.printSkill();
							gamer.hp-=u.dmg;
							if(gamer.hp<=0){
								System.out.println("사망하였습니다.");
								System.out.println("게임을 종료합니다");
								System.exit(0);
							}
						}
					}
					if(o>=2){
						}		
				}
				if(c==7){
					Dragon d=new Dragon("드레곤",1000,200,300,150,10);
					d.mosterInfo();
					System.out.println(d.name+"과 전투 하겠습니까?\n1.전투 2.돌아가기");
					int o=scan.nextInt();
					if(o==1){
						System.out.println(d.name+"와 전투합니다.");
						boolean t=true;
						while(t){
							System.out.println(gamer.name+"의 공격");
							gamer.yourAttack();
							d.hp-=gamer.dmg;
							if(d.hp<=0){
								System.out.println(d.name+"이 쓰러졌습니다");
								System.out.println("==========전투에서 승리하였습니다==========");
								gamer.gainExp(d.giveExp);
								gamer.money+=d.giveMoney;
								System.out.println("===========당신은 세상을 구한 영웅 입니다===========");
								System.out.println("게임을 종료 합니다.");
								System.exit(0);
								}
							d.printSkill();
							gamer.hp-=d.dmg;
							if(gamer.hp<=0){
								System.out.println("사망하였습니다.");
								System.out.println("게임을 종료합니다");
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
						Shop bn=new Shop("낡은 목걸이",50,10,100);
						bn.info();
						System.out.println(bn.item+"을 구매 합니까?\n1.예 2.돌아가기");
						int ii=scan.nextInt();
						if(ii==1&&gamer.money>=bn.price){
							gamer.money-=bn.price;
							System.out.println(bn.item+"를 구매했습니다");
							gamer.hp+=bn.giveHp;
							gamer.dmg+=bn.giveDmg;
							break;
						}
						if(ii==1&&gamer.money<bn.price){
							System.out.println("돈이"+(bn.price-gamer.money)+"만큼 부족합니다.");
							break;
						}
						if(ii>=2){
							break;
						}
					}
					if(i==2){
						Shop br=new Shop("낡은반지",30,30,100);
						br.info();
						System.out.println(br.item+"을 구매 합니까?\n1.예 2.돌아가기");
						int ii=scan.nextInt();
						if(ii==1&&gamer.money>=br.price){
							gamer.money-=br.price;
							System.out.println(br.item+"를 구매했습니다");
							gamer.hp+=br.giveHp;
							gamer.dmg+=br.giveDmg;
							break;
						}
						if(ii==1&&gamer.money<br.price){
							System.out.println("돈이"+(br.price-gamer.money)+"만큼 부족합니다.");
							break;
						}
						if(ii>=2){
							break;
						}
					}
					if(i==3){
						Shop sn=new Shop("은 목걸이",100,30,200);
						sn.info();
						System.out.println(sn.item+"을 구매 합니까?\n1.예 2.돌아가기");
						int ii=scan.nextInt();
						if(ii==1&&gamer.money>=sn.price){
							gamer.money-=sn.price;
							System.out.println(sn.item+"를 구매했습니다");
							gamer.hp+=sn.giveHp;
							gamer.dmg+=sn.giveDmg;
							break;
						}
						if(ii==1&&gamer.money<sn.price){
							System.out.println("돈이"+(sn.price-gamer.money)+"만큼 부족합니다.");
							break;
						}
						if(ii>=2){
							break;
						}
					}
					if(i==4){
						Shop sr=new Shop("은 반지",50,80,200);
						sr.info();
						System.out.println(sr.item+"을 구매 합니까?\n1.예 2.돌아가기");
						int ii=scan.nextInt();
						if(ii==1&&gamer.money>=sr.price){
							gamer.money-=sr.price;
							System.out.println(sr.item+"를 구매했습니다");
							gamer.hp+=sr.giveHp;
							gamer.dmg+=sr.giveDmg;
							break;
						}
						if(ii==1&&gamer.money<sr.price){
							System.out.println("돈이"+(sr.price-gamer.money)+"만큼 부족합니다.");
							break;
						}
						if(ii>=2){
							break;
						}
					}
					if(i==5){
						Shop gn=new Shop("금 목걸이",150,50,300);
						gn.info();
						System.out.println(gn.item+"을 구매 합니까?\n1.예 2.돌아가기");
						int ii=scan.nextInt();
						if(ii==1&&gamer.money>=gn.price){
							gamer.money-=gn.price;
							System.out.println(gn.item+"를 구매했습니다");
							gamer.hp+=gn.giveHp;
							gamer.dmg+=gn.giveDmg;
							break;
						}
						if(ii==1&&gamer.money<gn.price){
							System.out.println("돈이"+(gn.price-gamer.money)+"만큼 부족합니다.");
							break;
						}
						if(ii>=2){
							break;
						}
					}
					if(i==6){
						Shop gr=new Shop("금 반지",80,120,300);
						gr.info();
						System.out.println(gr.item+"을 구매 합니까?\n1.예 2.돌아가기");
						int ii=scan.nextInt();
						if(ii==1&&gamer.money>=gr.price){
							gamer.money-=gr.price;
							System.out.println(gr.item+"를 구매했습니다");
							gamer.hp+=gr.giveHp;
							gamer.dmg+=gr.giveDmg;
							break;
						}
						if(ii==1&&gamer.money<gr.price){
							System.out.println("돈이"+(gr.price-gamer.money)+"만큼 부족합니다.");
							break;
						}
						if(ii>=2){
							break;
						}
					}
					if(i==7){
						Shop mn=new Shop("마법의 목걸이",300,50,1000);
						mn.info();
						System.out.println(mn.item+"을 구매 합니까?\n1.예 2.돌아가기");
						int ii=scan.nextInt();
						if(ii==1&&gamer.money>=mn.price){
							gamer.money-=mn.price;
							System.out.println(mn.item+"를 구매했습니다");
							gamer.hp+=mn.giveHp;
							gamer.dmg+=mn.giveDmg;
							break;
						}
						if(ii==1&&gamer.money<mn.price){
							System.out.println("돈이"+(mn.price-gamer.money)+"만큼 부족합니다.");
							break;
						}
						if(ii>=2){
							break;
						}
					}
					if(i==8){
						Shop mr=new Shop("마법의 반지",100,100,1000);
						mr.info();
						System.out.println(mr.item+"을 구매 합니까?\n1.예 2.돌아가기");
						int ii=scan.nextInt();
						if(ii==1&&gamer.money>=mr.price){
							gamer.money-=mr.price;
							System.out.println(mr.item+"를 구매했습니다");
							gamer.hp+=mr.giveHp;
							gamer.dmg+=mr.giveDmg;
							break;
						}
						if(ii==1&&gamer.money<mr.price){
							System.out.println("돈이"+(mr.price-gamer.money)+"만큼 부족합니다.");
							break;
						}
						if(ii>=2){
							break;
						}
					}
					if(i==9){
						Shop hp=new Shop("회복 포션",50,0,40);
						hp.info();
						System.out.println(hp.item+"을 구매 합니까?\n1.예 2.돌아가기");
						int ii=scan.nextInt();
						if(ii==1&&gamer.money>=hp.price){
							gamer.money-=hp.price;
							System.out.println(hp.item+"를 구매했습니다");
							gamer.hp+=hp.giveHp;
							break;
						}
						if(ii==1&&gamer.money<hp.price){
							System.out.println("돈이"+(hp.price-gamer.money)+"만큼 부족합니다.");
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
					System.out.println("게임을 종료합니다");
					System.exit(0);
				}
		}				
	}
}
