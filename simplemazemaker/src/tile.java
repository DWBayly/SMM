import java.awt.*;
public class tile {
	tile u;
	tile d;
	tile l;
	tile r;
	int x;
	int y;
	public tile(int x, int y){
		this.x=x;
		this.y=y;
	}
	public void gen(Graphics g){
		if(Math.random()<smm.us && y<100){
			if(smm.l.containsKey(x+""+(y+1))){
				u=smm.l.get(x+""+(y+1));
				u.d=this;
			}else{
				u=new tile(x,y+1);
				u.d=this;
				smm.l.put(x+""+(y+1),u);
				u.gen(g);
			}
			g.drawLine(x*10, y*10+10, x*10+10,y*10+10 );
		}
		if(Math.random()<smm.ds && y>0){
			if(smm.l.containsKey(x+""+(y-1))){
				d=smm.l.get(x+""+(y-1));
				d.u=this;
			}else{
				d=new tile(x,y-1);
				d.u=this;
				smm.l.put(x+""+(y-1),d);
				d.gen(g);
			}
			g.drawLine(x*10, y*10, x*10+10,y*10 );
		}
		if(Math.random()<smm.ls && x>0){
			if(smm.l.containsKey((x-1)+""+(y))){
				l=smm.l.get((x-1)+""+y);
				l.r=this;
			}else{
				l=new tile(x-1,y);
				l.r=this;
				smm.l.put((x-1)+""+y,l);
				l.gen(g);
			}
			g.drawLine(x*10, y*10, x*10,y*10+10 );
		}
		if(Math.random()<smm.rs && x<100){
			if(smm.l.containsKey((x+1)+""+y)){
				r=smm.l.get((x+1)+""+y);
				r.l=this;
			}else{
				r=new tile(x+1,y);
				r.l=this;
				smm.l.put((x+1)+""+y,r);
				r.gen(g);
			}
			g.drawLine(x*10+10, y*10, x*10+10,y*10+10 );
		}
	}
}
